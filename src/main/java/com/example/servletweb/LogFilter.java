package com.example.servletweb;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

//@WebFilter(filterName = "LogFilter",urlPatterns = "/log",servletNames = "Login",dispatcherTypes = DispatcherType.REQUEST)
public class LogFilter implements Filter {
    ServletContext servletContext;

    @Override
    public void init(final FilterConfig filterConfig) throws ServletException {
       servletContext = filterConfig.getServletContext();
    }

    @Override
    public void doFilter(final ServletRequest servletRequest, final ServletResponse servletResponse, final FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;
        String logMessage = logMessage(httpServletRequest);
        servletContext.log(String.valueOf(logMessage));

        filterChain.doFilter(httpServletRequest,httpServletResponse);

    }

    @Override
    public void destroy() {

    }

    private String logMessage(HttpServletRequest httpServletRequest) {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("Request: {" + httpServletRequest.getMethod() + " ");

        ArrayList<String> list = Collections.list(httpServletRequest.getParameterNames());
        stringBuilder.append("[{");
        for (String s : list) {
            stringBuilder.append(s + ": " + httpServletRequest.getParameter(s) + ", ");
        }
        StringBuilder stringBuilderSubString =
                new StringBuilder(stringBuilder.substring(0, stringBuilder.lastIndexOf(",")));

        stringBuilderSubString.append("}]}");

        return String.valueOf(stringBuilderSubString);
    }
}
