<%@page pageEncoding="UTF-8" contentType="text/html; ISO-8859-1"

import="org.rortega.apiservlet.webapp.carrito.models.*"
%>

<%
    Carro carro = (Carro) session.getAttribute("carro");

%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>Carro de compras</title>
    </head>
    <body>
        <h1>Carro de compras</h1>
        <% if(carro == null || carro.getItemsCarro().isEmpty()){%>
            <p>¡Lo sentimos, no hay productos en el carro de compras!</p>
        <%} else { %>
            <table>
                <tr>
                    <th>Id</th>
                    <th>Tipo</th>
                    <th>Nombre</th>
                    <th>Precio</th>
                    <th>Cantidad</th>
                    <th>Total</th>
                </tr>
                <%for(ItemCarro item: carro.getItemsCarro()){%>
                <tr>
                    <td><%=item.getProducto().getId()%></td>
                    <td><%=item.getProducto().getTipo()%></td>
                    <td><%=item.getProducto().getNombre()%></td>
                    <td><%=item.getProducto().getPrecio()%></td>
                    <td><%=item.getCantidad()%></td>
                    <td><%=item.getImporte()%></td>
                </tr>
                <%}%>
                <tr>
                    <td colspan="4" style="text-align: right">Total: <span ><%=carro.getTotal()%></span></td>
                </tr>
            </table>
        <%}%>
        <p><a href="<%=request.getContextPath().concat("/productos")%>">Seguir comprando</a></p>
        <p><a href="<%=request.getContextPath().concat("/index.html")%>">Inicio</a></p>
    </body>
</html>