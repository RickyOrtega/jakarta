package org.rortega.apiservlet.webapp.carrito.listeners;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;
import org.rortega.apiservlet.webapp.carrito.models.Carro;

@WebListener
public class AplicacionListener implements ServletContextListener,
        ServletRequestListener, HttpSessionListener {

    private ServletContext servletContext;

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        servletContext = sce.getServletContext();
        servletContext.log("¡Inicializando la aplicación!");
        servletContext.setAttribute("mensaje", "¡Algún valor globar de la app!");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        servletContext.log("¡Destruyendo la aplicación!");
    }

    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        servletContext.log("¡Inicializando el request!");
        sre.getServletRequest().setAttribute("mensaje", "Guardando algún valor para el request");
    }

    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
        servletContext.log("¡Destruyendo el request!");
    }
    @Override
    public void sessionCreated(HttpSessionEvent se) {
        servletContext.log("¡Creando la sesión HTTP!");
        Carro carro = new Carro();
        HttpSession session = se.getSession();
        session.setAttribute("carro", carro);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        servletContext.log("¡Destruyendo la sesión HTTP!");
    }
}