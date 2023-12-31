package org.rortega.apiservlet.webapp.headers.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.rortega.apiservlet.webapp.headers.models.Producto;
import org.rortega.apiservlet.webapp.headers.services.ProductoService;
import org.rortega.apiservlet.webapp.headers.services.ProductoServiceImpl;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Optional;

@WebServlet(name="buscarProducto", value="/buscar-producto")
public class BuscarProductoServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ProductoService service = new ProductoServiceImpl();
        String nombre = req.getParameter("producto");

        Optional<Producto> encontrado = service.buscarProducto(nombre);
        if(encontrado.isPresent()){
            resp.setContentType("text/html");
            try (PrintWriter out = resp.getWriter()) {

                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println(" <head>");
                out.println("     <meta charset=\"UTF-8\">");
                out.println("     <title>Producto encontrado</title>");
                out.println(" </head>");
                out.println(" <body>");
                out.println("     <h1>Producto encontrado</h1>");
                out.println("     <h3>Nombre: ".concat(encontrado.get().getNombre()).concat("</h3>"));
                out.println("     <h3>Precio: $".concat(String.valueOf(encontrado.get().getPrecio())).concat("</h3>"));
                out.println("     <h3>Tipo: ".concat(String.valueOf(encontrado.get().getTipo())).concat("</h3>"));
                out.println(" </body>");
                out.println("</html>");
            }
        } else {
            resp.sendError(HttpServletResponse.SC_NOT_FOUND, "Lo sentimos. No se encontró el producto".concat(nombre));
        }
    }
}