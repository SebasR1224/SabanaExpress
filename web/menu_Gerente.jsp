<%-- 
    Document   : menu_Gerente
    Created on : 10-ago-2021, 12:48:09
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@include file="DB_Gerente.jsp"%>

<%                        
    UsuarioVO usuVO = new UsuarioVO();
    ArrayList<UsuarioVO> listaRoles = (ArrayList<UsuarioVO>)buscarSesion.getAttribute("roles");
    for (int i = 0; i < listaRoles.size(); i++) {
    usuVO = listaRoles.get(i);
%>
<%}
    if (usuVO.getNombreRol().equals("Cliente")) {
    request.getRequestDispatcher("menu_Cliente.jsp").forward(request, response);
    }
    else if (usuVO.getNombreRol().equals("Farmaceutico")) {
    request.getRequestDispatcher("menu_Farmaceutico.jsp").forward(request, response);
    }
%>
<!DOCTYPE html>
<html>
    <head>
    </head>
    <body>
        <div class="home_content">
            <div class="text">Home Content</div>
        </div>
    </body>
</html>
