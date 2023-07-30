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
        <form name="formcarro" action="<%=request.getContextPath().concat("/actualizar-carro")%>" method="post">
            <table>
                <tr>
                    <th>Id</th>
                    <th>Tipo</th>
                    <th>Nombre</th>
                    <th>Precio</th>
                    <th>Cantidad</th>
                    <th>Total</th>
                    <th>Eliminar</th>
                </tr>
                <%for(ItemCarro item: carro.getItemsCarro()){%>
                <tr>
                    <td><%=item.getProducto().getId()%></td>
                    <td><%=item.getProducto().getTipo()%></td>
                    <td><%=item.getProducto().getNombre()%></td>
                    <td><%=item.getProducto().getPrecio()%></td>
                    <td><input type="text" size="4" name="cant_<%=item.getProducto().getId()%>" value="<%=item.getCantidad()%>" /></td>
                    <td><%=item.getImporte()%></td>
                    <td><input type="checkbox" value="<%=item.getProducto().getId()%>" name="deleteProductos" /></td>
                </tr>
                <%}%>
                <tr>
                    <td colspan="4" style="text-align: right">Total: <span ><%=carro.getTotal()%></span></td>
                </tr>
            </table>
        <a href="javascript:document.formcarro.submit();">Actualizar</a>
    </form>
        <%}%>
        <p><a href="<%=request.getContextPath().concat("/productos")%>">Seguir comprando</a></p>
        <p><a href="<%=request.getContextPath().concat("/index.html")%>">Inicio</a></p>
    </body>
</html>