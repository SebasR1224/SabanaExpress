<%-- 
    Document   : Registrar_datos
    Created on : 11-ago-2021, 11:25:17
    Author     : User
--%>
<%@include file="DB_Gerente.jsp"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%                        
        UsuarioVO usuVO = new UsuarioVO();
        ArrayList<UsuarioVO> listaRoles = (ArrayList<UsuarioVO>) buscarSesion.getAttribute("roles");
        for (int i = 0; i < listaRoles.size(); i++) {
        usuVO = listaRoles.get(i);
        }
     %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div class="home_content">
            <div class="text">Registrar Datos</div>
            <form method="POST" action="Datos" class="sign-up-form">
                    <div class="input-field">
                        <i class="fas fa-user"></i>
                        <input type="hidden"  value="<%=usuVO.getUsuId()%>" name="textUsuId">
                    </div>
                    <div class="input-field">
                        <i class="fas fa-envelope"></i>
                        <input type="text" placeholder="Nombre Completo" name="textDatNom" required>
                    </div>
                    <div class="input-field">
                        <i class="fas fa-envelope"></i>
                        <input type="text" placeholder="Primer Apellido" name="textDatApelli1" required>
                    </div>
                    <div class="input-field">
                        <i class="fas fa-envelope"></i>
                        <input type="text" placeholder="Segundo Apellido" name="textDatApelli2" required>
                    </div>
                    <div class="input-field">
                        <i class="fas fa-envelope"></i>
                        <input type="text" placeholder="Telefono" name="textDatTel" required>
                    </div>
                    <div class="input-field">
                        <i class="fas fa-envelope"></i>
                        <input type="text" placeholder="Tipo documento" name="textDatTipoDoc" required>
                    </div>
                    <div class="input-field">
                        <i class="fas fa-envelope"></i>
                        <input type="text" placeholder="Numero de documento" name="textDatNumDoc" required>
                    </div>
                    <div class="input-field">
                        <i class="fas fa-envelope"></i>
                        <input type="date" placeholder="Fecha de Nacimiento" name="textDatFechaNa" required>
                    </div>
                    <div class="input-field">
                        <i class="fas fa-envelope"></i>
                        <input type="text" placeholder="Direccion" name="textDatDirec" required>
                    </div>
                    <div class="mb-3">
                      <input type="hidden" id="estado" name="textDatEsta" value="Activo">
                    </div>
                    
                    <button class="btn solid" value="1" name="opcion">Registrar</button>
                   
                    
                    <div class="error">
                        <% if(request.getAttribute("mensajeError") !=null){%>
                        <div style="color: red">${mensajeError}</div>
                        <%} else{%>
                        <div style="color: cyan">${mensajeExito}</div>
                        <%}%>
                    </div> 
                </form>
        </div>
    </body>
</html>
