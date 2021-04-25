package com.knt.nextinnovation.configs;

import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.servlet.DispatcherServlet;

public class AppInitializer implements WebApplicationInitializer {
    
    public void onStartup(ServletContext container) throws ServletException {
        
        AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
        ctx.register(AppConfig.class);
        ctx.register(HibernateConfig.class);
        ctx.register(SecurityConfig.class);
        ctx.setServletContext(container);
        
        ServletRegistration.Dynamic servlet = container.addServlet("dispatcher", new DispatcherServlet(ctx));
        FilterRegistration.Dynamic filterRegistration = container.addFilter("characterEncodingFilter", new CharacterEncodingFilter("UTF-8", true, true));
        filterRegistration.addMappingForUrlPatterns(null, false, "/*");
        
        filterRegistration = container.addFilter("hiddenHttpMethodFilter", new HiddenHttpMethodFilter());
        filterRegistration.addMappingForUrlPatterns(null, false, "/*");
        
        servlet.setLoadOnStartup(1);
        servlet.addMapping("/");
    }
    
}
