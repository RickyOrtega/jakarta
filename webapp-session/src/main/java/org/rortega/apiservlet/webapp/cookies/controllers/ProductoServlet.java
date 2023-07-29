package org.rortega.apiservlet.webapp.cookies.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.rortega.apiservlet.webapp.cookies.models.Producto;
import org.rortega.apiservlet.webapp.cookies.services.LoginService;
import org.rortega.apiservlet.webapp.cookies.services.LoginServiceSessionImpl;
import org.rortega.apiservlet.webapp.cookies.services.ProductoService;
import org.rortega.apiservlet.webapp.cookies.services.ProductoServiceImpl;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Optional;

@WebServlet(name = "productos", value = {"/productos.html", "/productos"})
public class ProductoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ProductoService service = new ProductoServiceImpl();
        List<Producto> productos = service.listar();

        LoginService auth = new LoginServiceSessionImpl();
        Optional<String> usernameOptional = auth.getUsername(req);

        resp.setContentType("text/html");
        try (PrintWriter out = resp.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println(" <head>");
            out.println("     <meta charset=\"UTF-8\">");
            out.println("     <title>¡Listado de Productos!</title>");
            out.println(" </head>");
            out.println(" <body>");
            out.println("     <h1>¡Listado de Productos!</h1>");
            if(usernameOptional.isPresent()) {
                out.println("<div style='color: blue;'>Hola ".concat(usernameOptional.get()).concat(". Bienvenido.</div>"));
            }
            out.println("     <table>");
            out.println("       <tr>");
            out.println("           <th>Id</th>");
            out.println("           <th>Nombre</th>");
            out.println("           <th>Tipo</th>");
            if (usernameOptional.isPresent()) {
                out.println("           <th>Precio</th>");
            }
            out.println("       <tr>");
            productos.forEach(producto -> {
                out.println("       <tr>");
                out.println("           <td>".concat(String.valueOf(producto.getId())).concat("</td>"));
                out.println("           <td>".concat(producto.getNombre()).concat("</td>"));
                out.println("           <td>".concat(producto.getTipo()).concat("</td>"));
                if (usernameOptional.isPresent()) {
                    out.println("           <td>".concat(String.valueOf(producto.getPrecio())).concat("</td>"));
                }
                out.println("       </tr>");
            });
            out.println("     </table>");
            out.println(" </body>");
            out.println("</html>");

        }
    }
}