package org.rortega.apiservlet.webapp.headers.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name="loginServlet", value="/login")
public class LoginServlet extends HttpServlet {

    final static String USERNAME = "admin";
    final static String PASSWORD = "12345";

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        if(USERNAME.equals(username) && PASSWORD.equals(password)){
            resp.setContentType("text/html");
            try (PrintWriter out = resp.getWriter()) {

                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println(" <head>");
                out.println("     <meta charset=\"UTF-8\">");
                out.println("     <title>¡Login correcto!</title>");
                out.println(" </head>");
                out.println(" <body>");
                out.println("     <h1>¡Login correcto!</h1>");
                out.println("     <h3>Hola ".concat(username).concat("</h3>"));
                out.println("     <h3>Si llegaste a este punto, eso quiere decir que te loggeaste correctamente.</h3>");
                out.println(" </body>");
                out.println("</html>");
            }
        } else {
            resp.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Lo sentimos mucho, no está autorizado para acceder a este recurso.");
        }
    }
}