<%-- 
    Document   : mi_Perfil
    Created on : 05-ago-2021, 11:20:30
    Author     : User
--%>

<%@page import="ModeloVO.UsuarioVO"%>
<%@page import="ModeloVO.DatosVO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="DB_Gerente.jsp"%>
<!DOCTYPE html>

    <%
        DatosVO datVO =  (DatosVO)buscarSesion.getAttribute("datosPersonales");
        if(datVO !=null){
    %>
    <%                        
        UsuarioVO usuVO = new UsuarioVO();
        ArrayList<UsuarioVO> listaRoles = (ArrayList<UsuarioVO>)buscarSesion.getAttribute("roles");
        for (int i = 0; i < listaRoles.size(); i++) {
        usuVO = listaRoles.get(i);
        }
     %>

<html lang="es">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
     <!--CSS-->
     <link rel="stylesheet" href="perfil/css/style.css">
     
    <title>Mi perfil</title>
</head>
<body>
    <div class="home_content">
        <section class="seccion-perfil-usuario">
            <div class="perfil-usuario-header">
                <div class="perfil-usuario-portada">
                    <div class="perfil-usuario-avatar">
                        <img src="gerente/img/gerente.jpg" alt="img-avatar">
                        <button type="button" class="boton-avatar">
                            <i class="far fa-image"></i>
                        </button>
                    </div>
                    <button type="button" class="boton-portada">
                        <i class="far fa-image"></i> Cambiar fondo
                    </button>
                </div>
            </div>
            <div class="perfil-usuario-body">
                <div class="perfil-usuario-bio">
                    <h3 class="titulo"><%=usuario%></h3>
                    <p class="texto">Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod
                        tempor incididunt ut labore et dolore magna aliqua.</p>
                </div>
                <div class="perfil-usuario-footer">
                    <ul class="lista-datos">
                        <li><i class="icono fas fa-crown"></i>Nombre: 
                            <%=datVO.getDatNombre()%>
                        </li>
                        <li><i class="icono fab fa-envira"></i>Apellidos: 
                            <%=datVO.getDatApellido1()%> <%=datVO.getDatApellido2()%> 
                        </li>
                        <li><i class="icono fas fa-monument"></i>Tipo documento: 
                            <%=datVO.getDatTipoDocumento()%> 
                        </li>
                        <li><i class="icono fas fa-id-card"></i>Número de documento: 
                            <%=datVO.getDatNumDocumento()%>
                        </li>
                    </ul>
                    <ul class="lista-datos">
                        <li><i class="icono fas fa-calendar-alt"></i>Fecha de nacimiendo: 
                            <%=datVO.getDatFechaNacimiento()%>
                        </li>
                        <li><i class="icono fas fa-map-marker-alt"></i>Dirección: 
                            <%=datVO.getDatDirecion()%>
                        </li>
                        <li><i class="icono fas fa-envelope"></i>Correo: 
                            <%=usuVO.getUsuCorreo()%> 
                        </li>
                        <li><i class="icono fas fa-phone"></i>Teléfono: 
                            <%=datVO.getDatTelefono()%>
                        </li>
                    </ul>
                </div>
                <div class="perfil-editar">
                    <button type="submit" class="cta">
                        <i class="far fa-edit"></i>
                        Editar
                    </button>
                </div>
            </div>
        </section>

        <!-- Modal -->
        <div class="modal-container">
            <div class="modal modal-close">
                <p class="close">X</p>
                <div class="modal-form">
                    <form method="POST" action="Datos">
                        <h2 class="title">Datos</h2>
                        <div class="input-field">
                            <i class="fas fa-user"></i>
                            <input type="hidden"  value="<%=usuVO.getUsuId()%>" name="textUsuId">
                        </div>
                        <div class="input-field">
                            <i class="fas fa-envelope"></i>
                            <input type="text" placeholder="Nombre Completo" name="textDatNom" value="<%=datVO.getDatNombre()%>" required>
                        </div>
                        <div class="input-field">
                            <i class="fas fa-envelope"></i>
                            <input type="text" placeholder="Primer Apellido" name="textDatApelli1" value="<%=datVO.getDatApellido1()%>" required>
                        </div>
                        <div class="input-field">
                            <i class="fas fa-envelope"></i>
                            <input type="text" placeholder="Segundo Apellido" name="textDatApelli2" value="<%=datVO.getDatApellido2()%> "  required>
                        </div>
                        <div class="input-field">
                            <i class="fas fa-envelope"></i>
                            <input type="text" placeholder="Telefono" name="textDatTel" value=" <%=datVO.getDatTelefono()%>" required>
                        </div>
                        <div class="input-field">
                            <i class="fas fa-envelope"></i>
                            <input type="text" placeholder="Tipo documento" name="textDatTipoDoc" value=" <%=datVO.getDatTipoDocumento()%> " required>
                        </div>
                        <div class="input-field">
                            <i class="fas fa-envelope"></i>
                            <input type="text" placeholder="Numero de documento" name="textDatNumDoc" readonly value="<%=datVO.getDatNumDocumento()%>" required>
                        </div>
                        <div class="input-field">
                            <i class="fas fa-envelope"></i>
                            <input type="date" placeholder="Fecha de Nacimiento" name="textDatFechaNa" value="<%=datVO.getDatFechaNacimiento()%>" required>
                        </div>
                        <div class="input-field">
                            <i class="fas fa-envelope"></i>
                            <input type="text" placeholder="Direccion" name="textDatDirec" value=" <%=datVO.getDatDirecion()%>" required>
                        </div>
                        <div class="mb-3">
                          <input type="hidden" id="estado" name="textDatEsta" value="Activo">
                        </div>
                        <button class="btn solid" value="2" name="opcion">Actualizar</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
    <%}
    else{
        request.getRequestDispatcher("Registrar_datos.jsp").forward(request, response);
    }
    %>
    <script src="perfil/js/main.js"></script>
</body>
</html>        

