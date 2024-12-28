package com.skse.serverio.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.jersey.JerseyProperties;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.server.ServerWebExchange;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.ref.ReferenceQueue;
import java.util.Enumeration;

/**
 * @Author: sukang
 * @Date: 2021/12/23 16:45
 */
@Slf4j
public class WebServlet implements Servlet {

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        HttpServletRequest request;
        HttpServletResponse response;

        if (!(servletRequest instanceof HttpServletRequest && servletResponse instanceof HttpServletResponse)) {
            throw new ServletException("non-HTTP request or response");
        }

        request = (HttpServletRequest) servletRequest;
        response = (HttpServletResponse) servletResponse;
        doService(request,response);
    }



    public void doService(HttpServletRequest request, HttpServletResponse response){

        Enumeration<String> headerNames = request.getHeaderNames();

        WebClient.builder().baseUrl(request.getRequestURI());

    }



    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
