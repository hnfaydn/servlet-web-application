package com.example.servletweb;

import com.example.servletweb.user.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;

//@WebServlet(name = "Login",urlPatterns = "/login")
public class Login extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

         response.setCharacterEncoding(StandardCharsets.UTF_8.name());
         response.setContentType("text/html;charset=UTF-8");

        User user = new User();

        user.setUsername(request.getParameter("username"));
        user.setPassword(request.getParameter("password"));


        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/login.jsp");
        requestDispatcher.forward(request,response);

    }
}
