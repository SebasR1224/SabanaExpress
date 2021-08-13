<%-- 
    Document   : Sesiones
    Created on : 31-may-2021, 16:08:41
    Author     : sebas
--%>


<%@page import="java.util.ArrayList"%>
<%@page import="ModeloVO.UsuarioVO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%
    response.setHeader("Pragma", "No-cache");
    response.setHeader("Cache-control", "no-cache, no-store, must-revalidate");
    response.setDateHeader("Expires", 0);
%>
<%

    HttpSession buscarSesion = (HttpSession)request.getSession();
    String usuario="";
if (buscarSesion.getAttribute("datos") == null) {
         request.getRequestDispatcher("index.jsp").forward(request, response);
         
    }else{
    UsuarioVO  usuVO = (UsuarioVO)buscarSesion.getAttribute("datos");
    usuario = usuVO.getUsuLogin();

}
%>

<html lang="es">
<head>
    <title>Sabana Express</title>
</head>
<body>

</body>

</html>

