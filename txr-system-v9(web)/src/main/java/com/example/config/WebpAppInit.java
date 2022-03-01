package com.example.config;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

// web.xml
public class WebpAppInit implements WebApplicationInitializer {

    @Override
    public void onStartup(javax.servlet.ServletContext servletContext) throws ServletException {

        System.out.println("onStartup");
        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
        context.register(TxrSystemConfiguration.class);

        // Register and map the dispatcher servlet
        ServletRegistration.Dynamic dispatcher = servletContext.addServlet("dispatcher",new DispatcherServlet(context));
        dispatcher.setLoadOnStartup(0);
        dispatcher.addMapping("*.htm");

    }
}
