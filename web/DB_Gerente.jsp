<%@include file="Sesiones.jsp"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    
    <!--CDN Logo FONTAWESOME-->
    <script src="https://kit.fontawesome.com/64d58efce2.js" crossorigin="anonymous"></script>
     <!--CSS-->
     <link rel="stylesheet" href="gerente/css/style.css">

    <title>Menu gerente</title>
</head>
<body>
    <div class="sidebar">
        <div class="logo_content">
            <div class="logo">
                <i class="fas fa-syringe"></i>
                <div class="logo_name">vitaltest</div>
            </div>
            <i class="fas fa-bars" id="btn"></i>
        </div>
        <ul class="nav_list">
            <li>
                <i class="fas fa-search"></i>
                <input type="text" placeholder="Buscar..."> 
                <span class="tooltip">Buscar</span>
            </li>
            <li>
                <a href="menu_Gerente.jsp">
                    <i class="fas fa-th-large"></i>
                    <span class="links_name">Inicio</span> 
                </a>
                <span class="tooltip">Inicio</span>
            </li>
            <li>
                <a href="mi_Perfil.jsp">
                    <i class="fas fa-user-md"></i>
                    <span class="links_name">Mi perfil</span> 
                </a>
                <span class="tooltip">Mi perfil</span>
            </li>
            <li>
                <a href="">
                    <i class="fas fa-band-aid"></i>
                    <span class="links_name">Inventario</span> 
                </a>
                <span class="tooltip">Inventario</span>
            </li>
            <li>
                <a href="Usuarios.jsp">
                    <i class="fas fa-users-cog"></i>
                    <span class="links_name">Comunidad</span> 
                </a>
                <span class="tooltip">Comunidad</span>
            </li>
            <li>
                <a href="#">
                    <i class="fas fa-heartbeat"></i>
                    <span class="links_name">Test médico</span> 
                </a>
                <span class="tooltip">Test médico</span>
            </li>
            <li>
                <a href="#">
                    <i class="fas fa-file-contract"></i>
                    <span class="links_name">Reportes</span> 
                </a>
                <span class="tooltip">Reportes</span>
            </li>
        </ul>
        <div class="profile_content">
            <div class="profile">
                <div class="profile_details">
                    <img src="gerente/img/gerente.jpg" alt="">
                    <div class="name_job">
                        <div class="name"><%=usuario%></div>
                        <div class="job">Gerente</div>
                    </div>
                </div>
                <form method="post" action="Sesiones">        
                <button type="submit"><i class="fas fa-door-open" id="log_out"></i></button>  
                </form>
            </div>
        </div>
    </div>
    <script src="gerente/js/main.js"></script>
</body>
</html>