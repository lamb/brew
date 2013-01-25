package org.mynah.brew.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class ContextListener implements ServletContextListener {

    /** Logger available to subclasses */
    protected final Log logger = LogFactory.getLog(getClass());

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
