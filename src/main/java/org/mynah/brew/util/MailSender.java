package org.mynah.brew.util;

import java.io.IOException;
import java.util.Map;
import java.util.Properties;
import javax.annotation.Resource;
import javax.mail.internet.MimeMessage;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.task.TaskExecutor;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;
import freemarker.template.Template;
import freemarker.template.TemplateException;

public class MailSender {

    private Logger log = Logger.getLogger(MailSender.class);

    private static final String HOST = "smtp.163.com";
    private static final String USERNAME = "bambooservice@163.com";
    private static final String PASSWORD = "bamboo";
    private static final String EMAIL = "bambooservice@163.com";

    private JavaMailSenderImpl javaMailSender;

    @Autowired
    private FreeMarkerConfigurer freemarkerConfig;
    @Resource(name = "taskExecutor")
    private TaskExecutor taskExecutor;

    public MailSender() {
        javaMailSender = new JavaMailSenderImpl();
        javaMailSender.setHost(HOST);
        javaMailSender.setUsername(USERNAME);
        javaMailSender.setPassword(PASSWORD);
        Properties p = new Properties();
        p.setProperty("mail.smtp.auth", "true");
        javaMailSender.setJavaMailProperties(p);
    }

    public void send(final String to, final String subject, final String text) {
        javaMailSender.send(new MimeMessagePreparator() {
            @Override
            public void prepare(MimeMessage mimeMessage) throws Exception {
                MimeMessageHelper message = new MimeMessageHelper(mimeMessage, true, "UTF-8");
                message.setTo(to);
                message.setFrom(EMAIL);
                message.setSubject(subject);
                message.setText(text, true);
            }
        });
    }

    public void send(final String to, String subject, String contentTemplateName, Map<String, Object> model) {
        String text = null;
        try {
            Template template = freemarkerConfig.getConfiguration().getTemplate(contentTemplateName);
            text = FreeMarkerTemplateUtils.processTemplateIntoString(template, model);
        } catch (IOException e) {
            log.error("找不到模版" + contentTemplateName, e);
            throw new RuntimeException("找不到模版" + contentTemplateName, e);
        } catch (TemplateException e) {
            log.error("模版处理失败" + contentTemplateName, e);
            throw new RuntimeException("模版处理失败" + contentTemplateName, e);
        }
        send(to, subject, text);
    }

    public void asynSend(final String to, final String subject, final String text) {
        taskExecutor.execute(new Runnable() {
            @Override
            public void run() {
                send(to, subject, text);
            }
        });
    }

    public void asynSend(final String to, final String subject, final String contentTemplateName, final Map<String, Object> model) throws IOException, TemplateException {
        taskExecutor.execute(new Runnable() {
            @Override
            public void run() {
                send(to, subject, contentTemplateName, model);
            }
        });
    }
}
