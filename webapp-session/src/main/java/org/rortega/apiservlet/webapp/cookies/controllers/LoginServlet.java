package org.rortega.apiservlet.webapp.cookies.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import org.rortega.apiservlet.webapp.cookies.services.LoginService;
import org.rortega.apiservlet.webapp.cookies.services.LoginServiceCookieImpl;
import org.rortega.apiservlet.webapp.cookies.services.LoginServiceSessionImpl;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Optional;

@WebServlet(name = "loginServlet", value = {"/login", "/login.html"})
public class LoginServlet extends HttpServlet {

    final static String USERNAME = "admin";
    final static String PASSWORD = "12345";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        LoginService auth = new LoginServiceSessionImpl();
        Optional<String> usernameOptional = auth.getUsername(req);

        if (usernameOptional.isPresent()) {
            resp.setContentType("text/html");
            try (PrintWriter out = resp.getWriter()) {

                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println(" <head>");
                out.println("     <meta charset=\"UTF-8\">");
                out.println("     <title>Hola ".concat(usernameOptional.get()).concat("</title>"));
                out.println(" </head>");
                out.println(" <body>");
                out.println("     <h1>¡Hola ".concat(usernameOptional.get()).concat(". Has iniciado sesión con éxito!.</h1>"));
                out.println(" <p><a href='".concat(req.getContextPath()).concat("/index.html'>Volver</a>").concat("</p>"));
                out.println(" <p><a href='".concat(req.getContextPath()).concat("/logout'>Cerrar Sesión</a>").concat("</p>"));
                out.println(" </body>");
                out.println("</html>");
            }
        } else {
            getServletContext().getRequestDispatcher("/login.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        if (USERNAME.equals(username) && PASSWORD.equals(password)) {

            HttpSession session = req.getSession();
            session.setAttribute("username", username);

            resp.sendRedirect("/login.html");
        } else {
            resp.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Lo sentimos mucho, no está autorizado para acceder a este recurso.");
        }
    }
}