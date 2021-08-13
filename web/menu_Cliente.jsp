<%-- 
    Document   : menu_Cliente
    Created on : 05-ago-2021, 10:16:01
    Author     : User
--%>

<%@page import="ModeloVO.DatosVO"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="Sesiones.jsp"%>

    <%
        DatosVO datVO = new DatosVO();
        datVO = (DatosVO)buscarSesion.getAttribute("datosPersonales");
    %>
    <%                        
        UsuarioVO usuVO = new UsuarioVO();
        ArrayList<UsuarioVO> listaRoles = (ArrayList<UsuarioVO>) buscarSesion.getAttribute("roles");
        for (int i = 0; i < listaRoles.size(); i++) {
        usuVO = listaRoles.get(i);
     %>
        
    <%}
        if (usuVO.getNombreRol().equals("Farmaceutico")) {
        request.getRequestDispatcher("menu_Farmaceutico.jsp").forward(request, response);
        }
        else if (usuVO.getNombreRol().equals("Gerente")) {
        request.getRequestDispatcher("menu_Gerente.jsp").forward(request, response);
        }
    %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <h1>Hola cliente</h1>
</body>
</html>
