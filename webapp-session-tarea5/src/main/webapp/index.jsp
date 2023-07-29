<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%String nombre = session.getAttribute("nombre") != null ? session.getAttribute("nombre").toString() : "anónimo";%>

<!DOCTYPE html>
<html>
    <head>
        <title>Tarea 5: Session HTTP</title>
    </head>
    <body>
        <h1>Tarea 5: Session HTTP</h1>
        <a>Hola <%=nombre%>, bienvenido a la tarea 5.</a>
        <form action="/webapp-session-tarea5/guardar-nombre-session" method="POST">
            <div>
                <label for="nombre">Nombre:</label>
                <div>
                    <input type="text" id="nombre" name="nombre">
                </div>
            </div>
            <div>
                <input type="submit" value="Enviar">
            </div>
        </form>
    </body>
</html>