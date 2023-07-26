<%@ page import="java.util.Map" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%
    Map<String, String> errores = (Map<String, String>) request.getAttribute("errores");
%>
<!DOCTYPE html>
<html>
<head>
    <title>Formulario Tarea 2</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
    <style>
        .campo-formulario{
            margin: 20px;
        }
    </style>
</head>
<body style="margin: 0 auto;">
    <div>
        <h1>Formulario Tarea 2</h1>
        <form action="/webapp-form-tarea2/crear" method="GET">
            <div class="campo-formulario">
                <label for="nombre" class="col-form-label col-sm-1">
                    Nombre:
                </label>
                <input type="text" name="nombre" id="nombre">
                <%
                    if(!(errores == null) && !errores.isEmpty() && errores.containsKey("nombre")){
                    out.println("<span class='alert alert-danger'>".concat(errores.get("nombre")).concat("</small>"));
                }%>
            </div>
            <div class="campo-formulario">
                <label for="precio" class="col-form-label col-sm-1">
                    Precio:
                </label>
                <input type="text" name="precio" id="precio">
                <%
                    if(!(errores == null) && !errores.isEmpty()){
                        if(errores.containsKey("precio1")){
                            out.println("<span class='alert alert-danger'>".concat(errores.get("precio1")).concat("</small>"));
                        }
                        if(errores.containsKey("precio2")){
                            out.println("<span class='alert alert-danger'>".concat(errores.get("precio2")).concat("</small>"));
                        }
                }%>
            </div>
            <div class="campo-formulario">
                <label for="fabricante" class="col-form-label col-sm-1">
                    Fabricante:
                </label>
                <input type="text" name="fabricante" id="fabricante" maxlength="10" minlength="4">
                <%
                    if(!(errores == null) && !errores.isEmpty() && errores.containsKey("fabricante")){
                        out.println("<span class='alert alert-danger'>".concat(errores.get("fabricante")).concat("</small>"));
                    }%>
            </div>
            <input type="submit" value="Enviar">
        </form>
    </div>
</body>
</html>