

package com.jwcjlu.demos.jetty.restful;


import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.jersey.core.util.Base64;
/**
 * 
 * <pre>
 * 
 *  File: WwwAuthFilter.java
 * 
 *  Copyright (c) 2017, globalegrow.com All Rights Reserved.
 * 
 *  Description:
 *  TODO
 * 
 *  Revision History
 *  Date,					    Who,					What;
 *  2017年11月17日				jinwei				Initial.
 *
 * </pre>
 */

public final class WwwAuthFilter implements Filter {
    
    private static final String AUTH_PREFIX = "Basic ";
    
    private String username = "ejob";
    
    
    private String password = "ejob2017";
    
    @Override
    public void init(final FilterConfig filterConfig) throws ServletException {
       
        username = ConfigUtil.getProperty("console.username", username);
        password = ConfigUtil.getProperty("console.password", password);
    }
    
    @Override
    public void doFilter(final ServletRequest request, final ServletResponse response, final FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        String authorization = httpRequest.getHeader("authorization");
        if (null != authorization && authorization.length() > AUTH_PREFIX.length()) {
            authorization = authorization.substring(AUTH_PREFIX.length(), authorization.length());
            if ((username + ":" + password).equals(new String(Base64.decode(authorization)))) {
                authenticateSuccess(httpResponse);
                chain.doFilter(httpRequest, httpResponse);
            } else {
                needAuthenticate(httpRequest, httpResponse);
            }
        } else {
            needAuthenticate(httpRequest, httpResponse);
        }
    }
    
    private void authenticateSuccess(final HttpServletResponse response) {
        response.setStatus(200);
        response.setHeader("Pragma", "No-cache");
        response.setHeader("Cache-Control", "no-store");
        response.setDateHeader("Expires", 0);
    }
    
    private void needAuthenticate(final HttpServletRequest request, final HttpServletResponse response) {
        response.setStatus(401);
        response.setHeader("Cache-Control", "no-store");
        response.setDateHeader("Expires", 0);
        response.setHeader("WWW-authenticate", AUTH_PREFIX + "Realm=\"EJob Console Auth\"");
    }
    
    @Override
    public void destroy() {
    }
}
