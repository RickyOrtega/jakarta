<%@page contentType="text/html; ISO-8859-1" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Formulario Login</title>
</head>
<body>
    <h1>Iniciar Sesión</h1>
    <form action="/webapp-carrito-compras/login" method="POST">
        <div>
            <label for="username">Username: </label>
            <div>
                <input type="text" name="username" id="username">
            </div>
        </div>
        <div>
            <label for="password">Password: </label>
            <div>
                <input type="password" name="password" id="password">
            </div>
        </div>
        <div>
            <input type="submit" value="Iniciar Sesión">
        </div>
    </form>
</body>
</html>