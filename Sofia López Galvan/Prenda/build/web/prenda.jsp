<%-- 

--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Prenda </title>
    </head>
    <body>
        <form action="PrendaController" method="post">
            <fieldset>
                <legend>Formulario de registro</legend>
                
                <div>
                <label for="idPrenda">Id Prenda:</label>
                <input type="text" name="idPrenda"
                       value="${prenda.idPrenda}"
                       readonly="readonly" 
                       placeholder="Id de prenda"/>
                </div>
                
                <div>
                <label for="descripcion"> Descripción :</label>
                <input type="text" name="descripcion"
                       value="${prenda.descripcion}"
                       placeholder="Descripcion "/>
                </div>
                 
                <div>
                <label for="color">Color:</label>
                <input type="text" name="color"
                       value="${prenda.color}"
                       placeholder="Color "/>
                </div>
                
                <div>
                <label for="stand">Stand:</label>
                <input type="text" name="stand"
                       value="${prenda.stand}"
                       placeholder="Stand"/>
                </div>
                       
                <div>
                <label for="precio">Precio:</label>
                <input type="text" name="precio"
                       value="${prenda.precio}"
                       placeholder="Precio"/>
                </div>
                
                 <div>
                     <input type="submit" 
                       value="Guardar" />
                </div>
            </fieldset>
            
        </form>
    </body>
</html>
