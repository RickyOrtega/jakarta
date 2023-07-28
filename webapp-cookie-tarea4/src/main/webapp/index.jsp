<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
        <title>JSP - Hello World</title>
    </head>
    <body>



        <h3 style="color: ${cookie.color.getValue() == null? "black": cookie.color.getValue()}">Tarea 4: cambiar el color de los textos</h3>
        <p style="color: ${cookie.color.getValue() == null? "black": cookie.color.getValue()}">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Architecto illo perferendis ratione
            soluta tenetur? Alias autem ex, fugiat, ipsam laboriosam laudantium magni minima molestias nam necessitatibus omnis
            tempora vero! Molestias?</p>

        <form action="/webapp-cookie-tarea4/cambiar-color" method="GET">
            <div>
                <label for="color">Cambiar color</label>
                <div>
                    <select name="color" id="color">
                        <option value="blue">Azul</option>
                        <option value="red">Rojo</option>
                        <option value="green">Verde</option>
                        <option value="aqua">Aqua</option>
                        <option value="BlueViolet">Violeta</option>
                        <option value="Gray">Gris</option>
                        <option value="Cyan">Cyan</option>
                    </select>
                </div>
            </div>
            <div>
                <input type="submit" value="Cambiar color">
            </div>
        </form>
    </body>
</html>