<%-- 
    Document   : credito
    Created on : 23/09/2016, 11:13:15 AM
    Author     : Irbing Martinez Garcia
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Estudiante</title>
    </head>
    <body>
        <form action="CreditoController" method="post">
            <fieldset>
                <legend>Formulario de Ingreso de Creditos</legend>

                <div> 
                    <label for="idCredito"> Id Credito</label>
                    <input type="text" name="idCredito" value="${credito.idCredito}"
                           readonly="readonly" placeholder="Id del credito" />
                </div>

                <div> 
                    <label for="nombre"> Nombre:</label>
                    <input type="text" name="nombre" value="${credito.nombre}"
                           placeholder="Nombre del credito" />
                </div>

                <div> 
                    <label for="fechaExpedicion"> Fecha de expedicion:</label>
                    <input type="text" name="fechaExpedicion" value="${credito.fechaExpedicion}"
                           placeholder="Fecha de expedicion" />
                </div>

                <div> 
                    <label for="tipo"> Tipo</label>
                    <input type="text" name="tipo" value="${credito.tipo}"
                           placeholder="Tipo de Credito" />
                </div>

                <div> 
                    <input type="submit" value="Almacenar"/>
                </div>

            </fieldset>
        </form>
    </body>
</html>
