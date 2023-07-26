<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>
<%

    Map<String, String> errores = (HashMap<String, String>) request.getAttribute("errores");

%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Formulario de usuarios</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
</head>
<body>
<h3>Formulario de usuarios</h3>

<%
    if (errores != null && errores.size() > 0) {
%>
<ul class="alert alert-danger">
    <%
        for (String error : errores.values()) {%>
    <li>
        <%=error%>
    </li>
    <%}%>
</ul>
<%
    }
%>
<div class="px-5">
    <form action="/webapp-form/form" method="POST">
        <div class="row mb-3">
            <label for="username" class="col-form-label col-sm-2">Username</label>
            <div class="col-sm-4">
                <input type="text" name="username" id="username" class="form-control" value="${param.username}">
            </div>
            <%
                if (errores != null && errores.containsKey("username")) {
                    out.println("<small class='alert alert-danger' style='color: red'>".concat(errores.get("username")).concat("</small>"));
                }
            %>
        </div>
        <div class="row mb-3">
            <label for="password" class="col-form-label col-sm-2">Password</label>
            <div class="col-sm-4">
                <input type="password" name="password" id="password" class="form-control">
            </div>
            <%
                if (errores != null && errores.containsKey("password")) {
                    out.println("<small class='alert alert-danger' style='color: red'>".concat(errores.get("password")).concat("</small>"));
                }
            %>
        </div>
        <div class="row mb-3">
            <label for="email" class="col-form-label col-sm-2">Email</label>
            <div class="col-sm-4">
                <input type="text" name="email" id="email" class="form-control" value="${param.email}">
            </div>
            <%
                if (errores != null && errores.containsKey("email")) {
                    out.println("<small class='alert alert-danger' style='color: red'>".concat(errores.get("email")).concat("</small>"));
                }
            %>
        </div>
        <div class="row mb-3">
            <label for="pais" class="col-form-label col-sm-2">País</label>
            <div class="col-sm-4">
                <select name="pais" id="pais" class="form-select">
                    <option value=">-- seleccionar --<"></option>
                    <option value="AR" ${param.pais.equals("AR")? "selected":""}>Argentina</option>
                    <option value="CL" ${param.pais.equals("CL")? "selected":""}>Chile</option>
                    <option value="CO" ${param.pais.equals("CO")? "selected":""}>Colombia</option>
                    <option value="ES" ${param.pais.equals("ES")? "selected":""}>España</option>
                    <option value="MX" ${param.pais.equals("MX")? "selected":""}>México</option>
                    <option value="PE" ${param.pais.equals("PE")? "selected":""}>Perú</option>
                    <option value="VE" ${param.pais.equals("VE")? "selected":""}>Venezuela</option>
                </select>
            </div>
            <%
                if (errores != null && errores.containsKey("pais")) {
                    out.println("<small class='alert alert-danger' style='color: red'>".concat(errores.get("pais")).concat("</small>"));
                }
            %>
        </div>
        <div class="row mb-3">
            <label for="lenguajes" class="col-form-label col-sm-2">Lenguajes de programación.</label>
            <div class="col-sm-4">
                <select name="lenguajes" id="lenguajes" multiple class="form-select">
                    <option value="java" ${paramValues.lenguajes.stream().anyMatch(v -> v.equals("java")).get()?"selected": ""}>Java SE</option>
                    <option value="jakarta" ${paramValues.lenguajes.stream().anyMatch(v -> v.equals("jakarta")).get()?"selected": ""}>Jakarta</option>
                    <option value="spring" ${paramValues.lenguajes.stream().anyMatch(v -> v.equals("spring")).get()?"selected": ""}>Spring</option>
                    <option value="springboot" ${paramValues.lenguajes.stream().anyMatch(v -> v.equals("springboot")).get()?"selected": ""}>Spring Boot</option>
                    <option value="js" ${paramValues.lenguajes.stream().anyMatch(v -> v.equals("js")).get()?"selected": ""}>JavaScript</option>
                    <option value="angular" ${paramValues.lenguajes.stream().anyMatch(v -> v.equals("angular")).get()?"selected": ""}>Angular</option>
                    <option value="react" ${paramValues.lenguajes.stream().anyMatch(v -> v.equals("react")).get()?"selected": ""}>React</option>
                </select>
            </div>
            <%
                if (errores != null && errores.containsKey("lenguajes")) {
                    out.println("<small class='alert alert-danger' style='color: red'>".concat(errores.get("lenguajes")).concat("</small>"));
                }
            %>
        </div>
        <div class="row mb-3">
            <label class="col-form-label col-sm-2">Roles</label>
            <div class="form-check">
                <input type="checkbox" name="roles" value="ROLE_ADMIN" class="form-check-input" ${paramValues.roles.stream().anyMatch(v -> v.equals("ROLE_ADMIN")).get()?"checked": ""}>
                <label class="form-check-label">Administrador</label>
            </div>
            <div class="form-check">
                <input type="checkbox" name="roles" value="ROLE_USER" class="form-check-input" ${paramValues.roles.stream().anyMatch(v -> v.equals("ROLE_USER")).get()?"checked": ""}>
                <label class="form-check-label">Usuario</label>
            </div>
            <div class="form-check">
                <input type="checkbox" name="roles" value="ROLE_MODERATOR" class="form-check-input" ${paramValues.roles.stream().anyMatch(v -> v.equals("ROLE_MODERATOR")).get()?"checked": ""}>
                <label class="form-check-label">Moderator</label>
            </div>
            <%
                if (errores != null && errores.containsKey("roles")) {
                    out.println("<small class='alert alert-danger' style='color: red'>".concat(errores.get("roles")).concat("</small>"));
                }
            %>
        </div>
        <div class="row mb-3">
            <label class="col-form-label col-sm-2">Idiomas</label>
            <div class="form-check">
                <input type="radio" name="idioma" value="es" class="form-check-input">
                <label class="form-check-label" ${param.idioma.equals("es")? "checked":""}>Español</label>
            </div>
            <div class="form-check">
                <input type="radio" name="idioma" value="en" class="form-check-input">
                <label class="form-check-label" ${param.idioma.equals("en")? "checked":""}>Inglés</label>
            </div>
            <div class="form-check">
                <input type="radio" name="idioma" value="fr" class="form-check-input">
                <label class="form-check-label" ${param.idioma.equals("fr")? "checked":""}>Francés</label>
            </div>
            <%
                if (errores != null && errores.containsKey("idioma")) {
                    out.println("<small class='alert alert-danger' style='color: red'>".concat(errores.get("idioma")).concat("</small>"));
                }
            %>
        </div>
        <div class="row mb-3">
            <label for="habilitar" class="col-form-label col-sm-2">Habilitar</label>
            <div class="form-check">
                <input type="checkbox" name="habilitar" id="habilitar" checked class="form-check-input">
            </div>
        </div>
        <div class="row mb-3">
            <div>
                <input type="submit" value="Enviar" class="btn btn-primary">
            </div>
        </div>
        <input type="hidden" name="secreto" value="12345">
    </form>
</div>
</body>
</html>