package com.example.demo;

import java.util.Collections;

import org.springframework.boot.autoconfigure.web.servlet.DispatcherServletAutoConfiguration;
import org.springframework.boot.autoconfigure.web.servlet.DispatcherServletPath;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.faces.config.AbstractFacesFlowConfiguration;
import org.springframework.faces.webflow.FlowFacesContextLifecycleListener;
import org.springframework.faces.webflow.JsfFlowHandlerAdapter;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.webflow.config.FlowDefinitionRegistryBuilder;
import org.springframework.webflow.config.FlowExecutorBuilder;
import org.springframework.webflow.definition.registry.FlowDefinitionRegistry;
import org.springframework.webflow.engine.builder.ViewFactoryCreator;
import org.springframework.webflow.executor.FlowExecutor;
import org.springframework.webflow.mvc.builder.MvcViewFactoryCreator;
import org.springframework.webflow.mvc.servlet.FlowHandlerAdapter;
import org.springframework.webflow.mvc.servlet.FlowHandlerMapping;

@Configuration
@EnableWebMvc
@ImportResource(locations = {"/spring/webflow.xml"})
public class WebflowConfig {

	@Bean
	public DispatcherServlet dispatchterServlet() {
		return new DispatcherServlet();
	}
	
	@Bean
	public DispatcherServletPath dispatcherServletPath() {
		return new DispatcherServletPath() {
			
			@Override
			public String getPath() {
				return "/";
			}
		};
	}
	
	@Bean
	public ServletRegistrationBean<DispatcherServlet> dispatcherServletRegistration() {
		ServletRegistrationBean<DispatcherServlet> registration = new ServletRegistrationBean<DispatcherServlet>(dispatchterServlet(), "/");
		registration.setName(DispatcherServletAutoConfiguration.DEFAULT_DISPATCHER_SERVLET_REGISTRATION_BEAN_NAME);
		registration.setLoadOnStartup(1);
		return registration;
	}
   
}
