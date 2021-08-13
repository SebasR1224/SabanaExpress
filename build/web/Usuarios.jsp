<%-- 
    Document   : mi_Perfil
    Created on : 05-ago-2021, 11:20:30
    Author     : User
--%>

<%@page import="ModeloDAO.RolDAO"%>
<%@page import="ModeloDAO.UsuarioDAO"%>
<%@page import="ModeloVO.UsuarioVO"%>
<%@page import="ModeloVO.DatosVO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="DB_Gerente.jsp"%>
<!DOCTYPE html>
    <%                        
        UsuarioVO usuVO = new UsuarioVO();
        ArrayList<UsuarioVO> listaRoles = (ArrayList<UsuarioVO>)buscarSesion.getAttribute("roles");
        for (int i = 0; i < listaRoles.size(); i++) {
        usuVO = listaRoles.get(i);
        }
     %>

<html lang="es">
<head>
        <!-- DATATABLES -->
    <!--  <link rel="stylesheet" href="https://cdn.datatables.net/1.10.20/css/jquery.dataTables.min.css"> -->
    <!-- BOOTSTRAP -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.1.3/css/bootstrap.css">
    <link rel="stylesheet" href="https://cdn.datatables.net/1.10.20/css/dataTables.bootstrap4.min.css">

    <link rel="stylesheet" href="https://maxst.icons8.com/vue-static/landings/line-awesome/line-awesome/1.3.0/css/line-awesome.min.css">
    <link rel="stylesheet" href="farmaceutico/css/style.css">
    <!-- CSS MODAL -->
    <link href="usuarios/css/style.css" rel="stylesheet" type="text/css"/>
</head>
<body>
    <div class="home_content">
            <div class="text">Comunidad express</div>
            <div class="container" style="margin-top: 10px;padding: 5px">
                    <button type="submit" class="ctaUsuarios">
                        <i class="far fa-edit"></i>
                        Nuevo
                    </button>
                <table id="tablax" class="table table-striped table-bordered" style="width:100%">
                    <thead>
                        <th>Codigo usuario</th>
                        <th>Nombre usuario</th>
                        <th>Clave</th>
                        <th>Correo</th>
                        <th>Rol</th>
                        <th>Acciones</th>
                    </thead>
                    <tbody>
                        <%                        
                        UsuarioDAO usuDAO = new UsuarioDAO();           
                        ArrayList<UsuarioVO>listaUsuario= usuDAO.listar();
                        for (int i = 0; i <listaUsuario.size() ; i++) {
                                usuVO = listaUsuario.get(i);
                        %>
                        <%
                        UsuarioVO rolVO = new UsuarioVO();    
                        RolDAO rolDAO = new RolDAO();
                        rolVO = rolDAO.consultarRoles(usuVO.getIdRol());
                        %>
                        <tr>
                            <td><%=usuVO.getUsuId()%></td>
                            <td><%=usuVO.getUsuLogin()%></td>
                            <td><%=usuVO.getUsuPassword()%></td>
                            <td><%=usuVO.getUsuCorreo()%></td>
                            <td><%=rolVO.getNombreRol()%></td>

                            <td>
                                <form action="Usuario" method="POST">
                                    <input type="hidden" value="<%=usuVO.getUsuId()%>" name="textId" id="">
                                    <button name="opcion" value="5">Editar</button>
                                </form> 
                            </td>
                        </tr>
                        <%}%>
                    </tbody>
                </table>
            </div>
               
            <!-- Modal -->
        <div class="modal-containerUsuarios">
            <div class="modalUsuarios modal-close">
                <p class="closeUsuarios">X</p>
                <div class="modal-form">
                    <form method="POST" action="Usuario">
                        <h2 class="title">Registrar Usuarios</h2>
                        <div class="input-field">
                            <i class="fas fa-envelope"></i>
                            <input type="text" placeholder="Nombre Usuario" name="textUsuario" required>
                        </div>
                        <div class="input-field">
                            <i class="fas fa-envelope"></i>
                            <input type="text" placeholder="Clave" name="textClave" required>
                        </div>
                        <div class="input-field">
                            <i class="fas fa-envelope"></i>
                            <input type="text" placeholder="Correo" name="textCorreo"  required>
                        </div>
                        <div class="input-field">
                           <select name="textIdRol" id="IdRol">
                                <option value="0">Selecioné...</option>
                                <%
                                    RolDAO rolDAO = new RolDAO();
                                    for(UsuarioVO rolVO: rolDAO.listar()){
                                %>
                                <option value="<%=rolVO.getUsuId()%>"><%=rolVO.getNombreRol()%></option>
                                <%}%>
                            </select>
                        </div>
                        <button class="btn solid" value="4" name="opcion">Crear Usuario</button>
                    </form>
                </div>
            </div>
        </div>        
                    
                    
                    
        </div>
         <!-- JS Modal -->                   
         <script src="usuarios/js/modalUsuarios.js" type="text/javascript"></script>
        <!-- JQUERY -->
         <script src="https://code.jquery.com/jquery-3.4.1.js" integrity="sha256-WpOohJOqMqqyKL9FccASB9O0KwACQJpFTUBLTYOVvVU=" crossorigin="anonymous"></script>
        <!-- DATATABLES -->
        <script src="https://cdn.datatables.net/1.10.20/js/jquery.dataTables.min.js"></script>
        <!-- BOOTSTRAP -->
        <script src="https://cdn.datatables.net/1.10.20/js/dataTables.bootstrap4.min.js"></script>
        <!-- -JAVASCRIPT -->
        <script src="farmaceutico/js/main.js"></script>
</body>
</html>        

