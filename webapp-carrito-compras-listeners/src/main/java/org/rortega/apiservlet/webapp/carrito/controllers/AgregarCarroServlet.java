package org.rortega.apiservlet.webapp.carrito.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.rortega.apiservlet.webapp.carrito.models.Carro;
import org.rortega.apiservlet.webapp.carrito.models.ItemCarro;
import org.rortega.apiservlet.webapp.carrito.models.Producto;
import org.rortega.apiservlet.webapp.carrito.services.ProductoService;
import org.rortega.apiservlet.webapp.carrito.services.ProductoServiceImpl;

import java.io.IOException;
import java.util.Optional;

@WebServlet(name="agregarCarro", value="/agregar-carro")
public class AgregarCarroServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long id = Long.valueOf(req.getParameter("id"));
        ProductoService service = new ProductoServiceImpl();
        Optional<Producto> producto = service.buscarProductoPorId(id);

        if(producto.isPresent()){
            ItemCarro item = new ItemCarro(1, producto.get());
            HttpSession session = req.getSession();

            Carro carro = (Carro) session.getAttribute("carro");

            carro.addItemCarro(item);
        }
        resp.sendRedirect(req.getContextPath().concat("/ver-carro"));
    }
}