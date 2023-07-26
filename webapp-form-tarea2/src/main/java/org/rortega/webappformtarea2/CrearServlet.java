package org.rortega.webappformtarea2;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "crearServlet", value = "/crear")
public class CrearServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");

        String linkBootStrap = "<link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css\" rel=\"stylesheet\"\n" +
                "          integrity=\"sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM\" crossorigin=\"anonymous\">";

        String nombre = req.getParameter("nombre");
        String precio = req.getParameter("precio");
        String fabricante = req.getParameter("fabricante");

        Map<String, String> errores = new HashMap<>();

        if(nombre.isEmpty() || nombre == null){
            errores.put("nombre", "Debe introducir un nombre");
        }
        if (precio==null){
            errores.put("precio1", "Debe introducir el precio");
        }
        try{
            Integer p = Integer.valueOf(precio);
        } catch (NumberFormatException ex){
            errores.put("precio2", "Debe introducir un valor válido (Número entero mayor que 0)");
        }
        if(fabricante.length()<4 || fabricante.length()>10){
            errores.put("fabricante", "Debe introducir un fabricante con nombre mayor o igual a 4 y menor o igual a 10");
        }
        if(!errores.isEmpty()){
            req.setAttribute("errores",errores);
            getServletContext().getRequestDispatcher("/index.jsp").forward(req, resp);
        } else{
            try(PrintWriter out = resp.getWriter()){
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("   <head>");
                out.println("       <meta charset=\"UTF-8\">");
                out.println("       <title>Producto Creado</title");
                out.println("       ".concat(linkBootStrap));
                out.println("   </head>");
                out.println("   <body>");
                out.println("       <h1>Resultado form</h1>");
                out.println("           <ul>");
                out.println("               <li>Nombre: ".concat(nombre).concat("</li>"));
                out.println("               <li>Precio: $".concat(precio).concat("</li>"));
                out.println("               <li>Fabricante: ".concat(fabricante).concat("</li>"));
                out.println("           </ul>");
                out.println("   </body>");
                out.println("</html>");
            }
        }
    }
}