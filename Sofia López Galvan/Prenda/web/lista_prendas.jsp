<%-- 
    Document   : lista_prendas
   
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista de Prendas</title>
    </head>
    <body>
        <table>
            <thead>  
            <tr>
                <th>Id de Prenda</th>
                <th> Descripción </th>
                <th>Color</th>
                <th>Stand</th>
                <th>Precio</th>
            </tr>
            </thead>
            <tbody>
                <c:forEach var="prenda" 
                           items="${prenda}">
                    <tr>
                        <td>${prenda.idPrenda}</td>
                        <td>${prenda.descripcion}</td>
                        <td>${prenda.color}</td>
                        <td>${prenda.stand}</td>
                        <td>${prenda.precio}</td>
                        <td><a href="PrendaController?action=cambiar&idPrenda=${prenda.idPrenda}">Cambiar</a></td>
                        <td><a href="PrendaController?action=borrar&idPrenda=${prenda.idPrenda}">Borrar</a></td>
                     </tr>  
                </c:forEach> 
            </tbody>
        </table>
        <p>
            <a href="PrendaController?action=agregar">
                Agregar prenda
            </a>
        </p>
    </body>
</html>
