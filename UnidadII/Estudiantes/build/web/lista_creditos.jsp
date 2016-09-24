<%-- 
    Document   : lista_creditos
    Created on : 23/09/2016, 11:13:29 AM
    Author     : Irbing Martinez Garcia
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista de Creditos</title>
    </head>
    <body>
        
        <table>
            <thead> 
            <tr>
                <th> Id de credito</th>
                <th>Nombre:</th>
                <th>Fecha de Expedición:</th>
                <th>Tipo:</th>
            </tr>
            </thead>
            <tbody>
                <c:forEach var="credito" items="${creditos}">
                    <tr>
                        <td>${credito.idCredito}</td>
                        <td>${credito.nombre}</td>
                        <td>${credito.fechaExpedicion}</td>
                        <td>${credito.tipo}</td>
                        <td><a href="CreditoController?action=cambiar&idCredito=${credito.idCredito}">Cambiar</a></td>
                        <td><a href="CreditoController?action=borrar&idCredito=${credito.idCredito}">Borrar</a></td>
                    </tr>                    
                </c:forEach>
            </tbody>
            
        </table>
        <p>
            <a href="CreditoController?action=agregar">
                Agregar Credito
            </a>
        </p>
        
    </body>
</html>
