<%-- 
    Document   : menu_Vendedor
    Created on : 01-jun-2021, 16:18:15
    Author     : sebas
--%>


<%@page import="ModeloVO.DatosVO"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="DB_Farmaceutico.jsp"%>

<!DOCTYPE html>
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
        if (usuVO.getNombreRol().equals("Cliente")) {
        request.getRequestDispatcher("menu_Cliente.jsp").forward(request, response);
        }
        else if (usuVO.getNombreRol().equals("Gerente")) {
        request.getRequestDispatcher("menu_Gerente.jsp").forward(request, response);
        }
    %>


<html>
    <head>
    </head>
    <body>
        <div class="home_content">
            <div class="text">Farmaceutico</div>
        </div>
    </body>
</html>