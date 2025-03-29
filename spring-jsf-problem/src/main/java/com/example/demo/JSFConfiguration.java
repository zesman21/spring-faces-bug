package com.example.demo;

import org.apache.myfaces.webapp.StartupServletContextListener;
import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import jakarta.faces.webapp.FacesServlet;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;

@Configuration
public class JSFConfiguration implements ServletContextInitializer {
	
	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		servletContext.addListener(new StartupServletContextListener());
		
		servletContext.setAttribute("org.apache.myfaces.DYNAMICALLY_ADDED_FACES_SERVLET", true);
		servletContext.setAttribute("jakarta.faces.FACELETS_SUFFIX", ".xhtml");
	}
	
	
	@Bean
	public ServletRegistrationBean<FacesServlet> facesServlet() {
		ServletRegistrationBean<FacesServlet> registration = new ServletRegistrationBean<FacesServlet>(new FacesServlet(), "/faces/*", "*.xhtml");
		registration.setName("FacesServlet");
		registration.setLoadOnStartup(1);
		return registration;
	}

}
