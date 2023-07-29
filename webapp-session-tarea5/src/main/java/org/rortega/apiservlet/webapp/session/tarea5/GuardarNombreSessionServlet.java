package org.rortega.apiservlet.webapp.session.tarea5;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(name="GuardarNombreSession", value="/guardar-nombre-session")
public class GuardarNombreSessionServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String nombre = req.getParameter("nombre");
        req.getSession().setAttribute("nombre", nombre);
        resp.sendRedirect(req.getContextPath().concat("/perfil-usuario"));
    }
}