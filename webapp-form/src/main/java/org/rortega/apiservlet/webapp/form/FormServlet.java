package org.rortega.apiservlet.webapp.form;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "formServlet", value = "/form")
public class FormServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");

        String usr = req.getParameter("username");
        String pass = req.getParameter("password");
        String email = req.getParameter("email");
        String pais = req.getParameter("pais");
        String[] lenguajes = req.getParameterValues("lenguajes");
        String[] roles = req.getParameterValues("roles");
        String idioma = req.getParameter("idioma");
        boolean habilitar = req.getParameter("habilitar") != null &&
                req.getParameter("habilitar").equals("on");
        String secreto = req.getParameter("secreto");

        Map<String, String> errores = new HashMap<>();

        if (usr.isBlank() || usr == null) {
            errores.put("username", "¡El username es requerido!");
        }

        if (pass.isBlank() || pass == null) {
            errores.put("password", "¡El password no puede ser vacío!");
        }

        if (email.isBlank() || email == null || !email.contains("@")) {
            errores.put("email", "¡Debe introducir un correo electrónico válido!");
        }

        if (pais.isBlank() || pais == null) {
            errores.put("pais", "¡Debe seleccionar un país de la lista!");
        }

        if (lenguajes == null || lenguajes.length < 1) {
            errores.put("lenguajes", "¡Debe seleccionar al menos un lenguaje!");
        }

        if (roles == null || roles.length < 1) {
            errores.put("roles", "¡Debe seleccionar al menos un rol!");
        }

        if (idioma == null) {
            errores.put("idioma", "¡Debe seleccionar un idioma!");
        }
        if (errores.isEmpty()) {
            try (PrintWriter out = resp.getWriter()) {

                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println(" <head>");
                out.println("     <meta charset=\"UTF-8\">");
                out.println("     <title>Resultado form</title>");
                out.println(" </head>");
                out.println(" <body>");
                out.println("     <h1>Resultado form</h1>");
                out.println("       <ul>");
                out.println("           <li>Username: ".concat(usr).concat("</li>"));
                out.println("           <li>Password: ".concat(pass).concat("</li>"));
                out.println("           <li>Email: ".concat(email).concat("</li>"));
                out.println("           <li>País: ".concat(pais).concat("</li>"));

                out.println("           <li>Lenguajes: <ul>");
                Arrays.asList(lenguajes).forEach(lenguaje -> {
                    out.println("           <li>".concat(lenguaje).concat("</li>"));
                });

                out.println("           </ul></li>");
                Arrays.asList(roles).forEach(rol -> {
                    out.println("           <li>".concat(rol).concat("</li>"));
                });

                out.println("           </li>");
                out.println("           <li>Idioma: ".concat(idioma).concat("</li>"));
                out.println("           <li>Habilitado: ".concat(String.valueOf(habilitar)).concat("</li>"));
                out.println("           <li>Secreto: ".concat(secreto).concat("</li>"));
                out.println("       </ul>");
                out.println(" </body>");
                out.println("</html>");

            }

        } else {
                /*errores.forEach(error -> {
                    out.println("<li>".concat(error).concat("</li>"));
                });
                out.println("<p><a href=\"/webapp-form/index.jsp\">Volver</a></p>");*/
            req.setAttribute("errores", errores);
            getServletContext().getRequestDispatcher("/index.jsp").forward(req, resp);
        }
    }
}