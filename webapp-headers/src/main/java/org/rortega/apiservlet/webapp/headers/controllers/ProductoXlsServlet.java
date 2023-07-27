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
import java.util.List;

@WebServlet(name = "convertidorAExcel", value = {"/productos.xls", "/productos.html", "/productos"})
public class ProductoXlsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ProductoService service = new ProductoServiceImpl();
        List<Producto> productos = service.listar();

        resp.setContentType("text/html");
        String servletPath = req.getServletPath();
        boolean esXls = servletPath.endsWith(".xls");

        if (esXls) {
            resp.setContentType("application/vnd.ms-excel");
            resp.setHeader("Content-Disposition", "attachment;filename=productos.xls");
        }

        try (PrintWriter out = resp.getWriter()) {

            if (!esXls) {
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println(" <head>");
                out.println("     <meta charset=\"UTF-8\">");
                out.println("     <title>¡Listado de Productos!</title>");
                out.println(" </head>");
                out.println(" <body>");
                out.println("     <h1>¡Listado de Productos!</h1>");
                out.println("     <p><a href=\"".concat(req.getContextPath()).concat("/productos.xls").concat("\">Exportar a Excel</a></p>"));
                out.println("     <p><a href=\"".concat(req.getContextPath()).concat("/productos.json").concat("\">Mostrar JSON</a></p>"));
            }
            out.println("     <table>");
            out.println("       <tr>");
            out.println("           <th>Id</th>");
            out.println("           <th>Nombre</th>");
            out.println("           <th>Tipo</th>");
            out.println("           <th>Precio</th>");
            out.println("       <tr>");
            productos.forEach(producto -> {
                out.println("       <tr>");
                out.println("           <td>".concat(String.valueOf(producto.getId())).concat("</td>"));
                out.println("           <td>".concat(producto.getNombre()).concat("</td>"));
                out.println("           <td>".concat(producto.getTipo()).concat("</td>"));
                out.println("           <td>".concat(String.valueOf(producto.getPrecio())).concat("</td>"));
                out.println("       </tr>");
            });
            out.println("     </table>");
            if(!esXls){
                out.println(" </body>");
                out.println("</html>");
            }
        }
    }
}