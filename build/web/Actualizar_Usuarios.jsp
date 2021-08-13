<%-- 
    Document   : mi_Perfil
    Created on : 05-ago-2021, 11:20:30
    Author     : User
--%>

<%@page import="ModeloDAO.RolDAO"%>
<%@page import="ModeloVO.UsuarioVO"%>
<%@page import="ModeloVO.DatosVO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="DB_Gerente.jsp"%>
<!DOCTYPE html>
<html lang="es">
<head>
     <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Usuarios Recomendación</title>
</head>
<body>
     <%
        UsuarioVO usuVO =  (UsuarioVO)request.getAttribute("datosUsuarios");
        if(usuVO !=null){
     %>
    <div class="home_content">
        <div class="text">Actualizar Recomendación</div>
        <form action="Usuario" method="POST">
             
            <input type="hidden" name="textId" value="<%=usuVO.getUsuId()%>">
            
            <label for="Usuario">Nombre Usuario</label>
            <input type="text" name="textUsuario" id="Usuario" class="" value="<%=usuVO.getUsuLogin()%>">
            
            <label for="Clave">Clave</label>
            <input type="text" name="textClave" id="Clave" class="" value="<%=usuVO.getUsuPassword()%>">
            
            <label for="Correo">Correo</label>
            <input type="text" name="textCorreo" id="Correo" class="" value="<%=usuVO.getUsuCorreo()%>">
            
            
            <label for="IdRol">Parte del cuerpo</label>
            <select name="textIdRol" id="IdRol">
                <option value="0">Selecioné...</option>
                <%
                    RolDAO rolDAO = new RolDAO();
                    for(UsuarioVO rolVO: rolDAO.listar()){
                %>
                <option value="<%=rolVO.getUsuId()%>"><%=rolVO.getNombreRol()%></option>
                <%}%>
            </select>
            <button name="opcion" value="2">Actualizar</button>
        </form>
         <%}%>  
</body>
</html>        

