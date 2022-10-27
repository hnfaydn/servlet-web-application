package com.example.servletweb;


import com.example.servletweb.exception.PasswordIsNotCorrectException;
import com.example.servletweb.exception.UsernameIsNotCorrectException;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "AuthenticationFilter",urlPatterns = "/authentication",servletNames = "Login",dispatcherTypes = DispatcherType.REQUEST)
public class AuthenticationFilter implements Filter {
    @Override
    public void init(final FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(final ServletRequest request, final ServletResponse response, final FilterChain chain) throws IOException, ServletException {
        RequestDispatcher dispatcher;
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;

        String userName = httpServletRequest.getParameter("username");
        String password = httpServletRequest.getParameter("password");
        try {
            userNameCheck(userName);
            passwordCheck(password);
        } catch (UsernameIsNotCorrectException e) {
            httpServletRequest.setAttribute("usernameMessage", e.getMessage());
            dispatcher = httpServletRequest.getServletContext().getRequestDispatcher("/index.jsp");
            dispatcher.forward(request, response);
        } catch (PasswordIsNotCorrectException e) {
            httpServletRequest.setAttribute("passwordMessage", e.getMessage());
            dispatcher = httpServletRequest.getServletContext().getRequestDispatcher("/index.jsp");
            dispatcher.forward(request, response);
        }
        chain.doFilter(httpServletRequest,httpServletResponse);
    }

    private void userNameCheck(String userName) throws UsernameIsNotCorrectException {
        if (!"admin".equals(userName)) {
            throw new UsernameIsNotCorrectException("Name does not match!");
        }
    }

    private void passwordCheck(String password)
            throws PasswordIsNotCorrectException {
        if (!"atmosware".equals(password)) {
            throw new PasswordIsNotCorrectException("Password is not correct!");
        }
    }

    @Override
    public void destroy() {

    }
}
