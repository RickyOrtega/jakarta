package org.rortega.webapp.tarea6;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name="index", value= {"/index.html", ""})
public class IndexServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String nombreCompleto = (String) req.getAttribute("nombreCompleto");
        System.out.println(nombreCompleto);
        resp.setContentType("text/html");
        try (PrintWriter out = resp.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println(" <head>");
            out.println("     <meta charset=\"UTF-8\">");
            out.println("     <title>Hola, ".concat(nombreCompleto).concat("</title>"));
            out.println(" </head>");
            out.println(" <body>");
            out.println("     <h1>Hola, ".concat(nombreCompleto).concat("</h1>" ));
            out.println(" </body>");
            out.println("</html>");
        }
    }
}