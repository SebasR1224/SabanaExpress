<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Iniciar Sesión</title>


    <link rel="stylesheet" href="login/assets/css/style.css">

    <script
    src="https://kit.fontawesome.com/64d58efce2.js"
    crossorigin="anonymous">
    </script>

</head>
<body>
    <div class="container">
        <div class="forms-container">
            <div class="signin-signup">
                <form method="POST" action="Usuario" class="sign-in-form">
                    <h2 class="title">Iniciar Sesión</h2>
                    <div class="input-field">
                        <i class="fas fa-user"></i>
                        <input type="text" placeholder="Nombre Usuario"  name="textUsuario" name="textClave" required>
                    </div>
                    <div class="input-field">
                        <i class="fas fa-lock"></i>
                        <input type="password" placeholder="Contraseña" name="textClave" required>
                    </div>
                    
                    <button class="btn solid">Iniciar Sesión</button>
                    <input type="hidden" value="3" name="opcion">
                    
                    <p class="social-text">Iniciar sesión con</p>
                    <div class="social-media">
                        <a href="#" class="social-icon">
                            <i class="fab fa-facebook-f"></i>
                        </a>
                        <a href="#" class="social-icon">
                            <i class="fab fa-google"></i>
                        </a>
                    </div>
                    <div class="error">
                        <% if(request.getAttribute("mensajeError") !=null){%>
                        <div style="color: red">${mensajeError}</div>
                        <%} else{%>
                        <div style="color: cyan">${mensajeExito}</div>
                        <%}%>
                    </div> 
                </form>

                <form method="POST" action="Usuario" class="sign-up-form">
                    <h2 class="title">Registrarse</h2>
                    <div class="input-field">
                        <i class="fas fa-user"></i>
                        <input type="text" placeholder="Nombre Usuario"  name="textUsuario" required>
                    </div>
                    <div class="input-field">
                        <i class="fas fa-envelope"></i>
                        <input type="text" placeholder="Email" name="textCorreo" required>
                    </div>
                    <div class="input-field">
                        <i class="fas fa-lock"></i>
                        <input type="password" placeholder="Contraseña"  name="textClave" required>
                    </div>
                    <div class="mb-3">
                      <input type="hidden" id="rol" name="textIdRol" required value="3">
                    </div>
                    
                    <button class="btn solid">Registrarse</button>
                    <input type="hidden" value="1" name="opcion">
                    
                    <p class="social-text">Registrar sesión con</p>
                    <div class="social-media">
                        <a href="#" class="social-icon">
                            <i class="fab fa-facebook-f"></i>
                        </a>
                        <a href="#" class="social-icon">
                            <i class="fab fa-google"></i>
                        </a>
                    </div>
                    <div class="error">
                        <% if(request.getAttribute("mensajeError") !=null){%>
                        <div style="color: red">${mensajeError}</div>
                        <%} else{%>
                        <div style="color: cyan">${mensajeExito}</div>
                        <%}%>
                    </div> 
                </form>
            </div>
        </div>

        <div class="panels-container">
            <div class="panel left-panel">
              <div class="content">
                <h3>¿Cliente Nuevo?</h3>
                <p>
                    <i class="far fa-handshake"></i>
                    Beneficios de tener una cuenta
                    <ul>
                        <li>Realizar test médico</li>
                        <li>Acceso exclusivo a ofertas y promociones.</li>
                        <li>Compra más rápido.</li>
                        <li>Acceso a domicilios mas rápidos</li>
                        <li>Comunicación directa con el farmaceutico</li>
                        <li>Noticias y demas</li>
                    </ul>
                </p>
                <button class="btn transparent" id="sign-up-btn">
                  Registrarse
                </button>
              </div>
              <img src="login/assets/img/doctor.svg" class="image" alt="" />
            </div>
            <div class="panel right-panel">
              <div class="content">
                <h3>¿Cliente de la Sabana?</h3>
                <p>
                  Iniciar sesión otorga grandes beneficios y soluciones para tu salud
                </p>
                <button class="btn transparent" id="sign-in-btn">
                  Iniciar sesión
                </button>
              </div>
              <img src="login/assets/img/test.svg" class="image" alt="" />
            </div>
          </div>
        </div>
    </div>
    <script src="login/assets/js/main.js"></script>
</body>
</html>