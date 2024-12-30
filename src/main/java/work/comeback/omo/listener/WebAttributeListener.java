package work.comeback.omo.listener;

import jakarta.servlet.ServletContextAttributeEvent;
import jakarta.servlet.ServletContextAttributeListener;
import jakarta.servlet.ServletRequestAttributeEvent;
import jakarta.servlet.ServletRequestAttributeListener;
import jakarta.servlet.http.HttpSessionAttributeListener;
import jakarta.servlet.http.HttpSessionBindingEvent;

public class WebAttributeListener implements ServletContextAttributeListener, ServletRequestAttributeListener, HttpSessionAttributeListener {

    // 上下文
    @Override
    public void attributeAdded(ServletContextAttributeEvent scae) {
        ServletContextAttributeListener.super.attributeAdded(scae);
    }

    @Override
    public void attributeRemoved(ServletContextAttributeEvent scae) {
        ServletContextAttributeListener.super.attributeRemoved(scae);
    }

    @Override
    public void attributeReplaced(ServletContextAttributeEvent scae) {
        ServletContextAttributeListener.super.attributeReplaced(scae);
    }

    // 请求
    @Override
    public void attributeAdded(ServletRequestAttributeEvent srae) {
        ServletRequestAttributeListener.super.attributeAdded(srae);
    }

    @Override
    public void attributeRemoved(ServletRequestAttributeEvent srae) {
        ServletRequestAttributeListener.super.attributeRemoved(srae);
    }

    @Override
    public void attributeReplaced(ServletRequestAttributeEvent srae) {
        ServletRequestAttributeListener.super.attributeReplaced(srae);
    }

    // Session
    @Override
    public void attributeAdded(HttpSessionBindingEvent se) {
        HttpSessionAttributeListener.super.attributeAdded(se);
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent se) {
        HttpSessionAttributeListener.super.attributeRemoved(se);
    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent se) {
        HttpSessionAttributeListener.super.attributeReplaced(se);
    }
}
