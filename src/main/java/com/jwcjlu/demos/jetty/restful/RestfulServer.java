/*
package com.jwcjlu.demos.jetty.restful;

import java.util.EnumSet;

import javax.servlet.DispatcherType;
import javax.servlet.Filter;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.HandlerList;
import org.eclipse.jetty.servlet.DefaultServlet;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.eclipse.jetty.util.resource.Resource;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.XmlWebApplicationContext;


import com.google.common.base.Joiner;
import com.google.common.base.Optional;
import com.sun.jersey.api.core.PackagesResourceConfig;
import com.sun.jersey.spi.spring.container.servlet.SpringServlet;

*/
/**
 * <pre>
 * 
 *  File: RestfulServer.java
 * 
 *  Copyright (c) 2017, globalegrow.com All Rights Reserved.
 * 
 *  Description:
 *  TODO
 * 
 *  Revision History
 *  Date,					Who,					What;
 *  2017年11月17日				jinwei				Initial.
 *
 * </pre>
 *//*

public class RestfulServer
{
    
    private final Server server;
    
    private final ServletContextHandler servletContextHandler;
    
    public RestfulServer(final int port) {
        server = new Server(port);
        servletContextHandler = buildServletContextHandler();
    }
    
    */
/**
     * 启动内嵌的RESTful服务器.
     * 
     * @param packages RESTful实现类所在包
     * @param resourcePath 资源路径
     * @throws Exception 启动服务器异常
     *//*

    public void start(final String packages, final Optional<String> resourcePath) throws Exception {
        start(packages, resourcePath, Optional.of("/api"));
    }
    
    */
/**
     * 启动内嵌的RESTful服务器.
     *
     * @param packages RESTful实现类所在包
     * @param resourcePath 资源路径
     * @param servletPath servlet路径
     * @throws Exception 启动服务器异常
     *//*

    public void start(final String packages, final Optional<String> resourcePath, final Optional<String> servletPath) throws Exception {
  
        HandlerList handlers = new HandlerList();
        if (resourcePath.isPresent()) {
            servletContextHandler.setBaseResource(Resource.newClassPathResource(resourcePath.get()));
            servletContextHandler.addServlet(new ServletHolder(DefaultServlet.class), "/*");
        }
        String servletPathStr = (servletPath.isPresent() ? servletPath.get() : "") + "/*";
        servletContextHandler.addServlet(getServletHolder(packages), servletPathStr);
        handlers.addHandler(servletContextHandler);
        server.setHandler(handlers);
        server.start();
    }
    
    public void addApplicationContext(ApplicationContext context){
        servletContextHandler.setClassLoader(context.getClassLoader());  
        XmlWebApplicationContext xmlWebAppContext = new XmlWebApplicationContext();  
        xmlWebAppContext.setParent(context);  
        xmlWebAppContext.setConfigLocation("");  
        xmlWebAppContext.setServletContext(servletContextHandler.getServletContext());  
        xmlWebAppContext.refresh();  
        servletContextHandler.setAttribute(WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE,xmlWebAppContext); 
      
        }
    
    */
/**
     * 添加Filter.
     *
     * @param filterClass filter实现类
     * @param urlPattern 过滤的路径
     * @return RESTful服务器
     *//*

    public RestfulServer addFilter(final Class<? extends Filter> filterClass, final String urlPattern) {
        servletContextHandler.addFilter(filterClass, urlPattern, EnumSet.of(DispatcherType.REQUEST));
        return this;
    }
    
    private ServletContextHandler buildServletContextHandler() {
        ServletContextHandler servletContextHandler = new ServletContextHandler(ServletContextHandler.SESSIONS);
        servletContextHandler.setContextPath("/");
        return servletContextHandler;
    }
    
    private ServletHolder getServletHolder(final String packages) {
        ServletHolder result = new ServletHolder(SpringServlet.class);
        result.setInitParameter(PackagesResourceConfig.PROPERTY_PACKAGES, Joiner.on(",").join(RestfulServer.class.getPackage().getName(), packages));
        result.setInitParameter("com.sun.jersey.config.property.resourceConfigClass", PackagesResourceConfig.class.getName());
        result.setInitParameter("com.sun.jersey.api.json.POJOMappingFeature", Boolean.TRUE.toString());
        result.setInitParameter("resteasy.scan.providers", Boolean.TRUE.toString());
        result.setInitParameter("resteasy.use.builtin.providers", Boolean.FALSE.toString());
        return result;
    }
    
    */
/**
     *  停止内嵌的RESTful服务器.
     * 
     *//*

    public void stop() {
  
        try {
            server.stop();
            // CHECKSTYLE:OFF
        } catch (final Exception e) {
            // CHECKSTYLE:ON
         
        }
    }
}

*/
