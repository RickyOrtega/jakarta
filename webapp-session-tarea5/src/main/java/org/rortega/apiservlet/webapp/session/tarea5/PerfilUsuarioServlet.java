package org.rortega.apiservlet.webapp.session.tarea5;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name="perfilUsuario", value="/perfil-usuario")
public class PerfilUsuarioServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String nombreUsuario = (String) req.getSession().getAttribute("nombre");

        System.out.println(nombreUsuario);

        resp.setContentType("text/html");
        try (PrintWriter out = resp.getWriter()) {

            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println(" <head>");
            out.println("     <meta charset=\"UTF-8\">");
            out.println("     <title>Perfil de usuario</title>");
            out.println(" </head>");
            out.println(" <body>");
            out.println("     <h1>Nombre usuario: ".concat(nombreUsuario).concat("</h1>"));
            out.println("     <a href='".concat(req.getContextPath().concat("/index.jsp")).concat("'>Volver al index</a>"));
            out.println(" </body>");
            out.println("</html>");
        }
    }
}