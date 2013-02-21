package org.mynah.brew.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ContextListener implements ServletContextListener {

    /** Logger available to subclasses */
    protected final Logger logger = LoggerFactory.getLogger(getClass());

    private ServletContext context;

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        context = sce.getServletContext();
        setWebProperty();
    }

    private void setWebProperty() {
        setAttribute("contextPath", context.getContextPath());
    }

    private void setAttribute(String key, Object value) {
        context.setAttribute(key, value);
        logger.info("ServletContext add " + key + ":" + value);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        // TODO Auto-generated method stub
    }
}
