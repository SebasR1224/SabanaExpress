package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import ModeloVO.UsuarioVO;
import ModeloVO.DatosVO;
import java.util.ArrayList;
import ModeloVO.UsuarioVO;

public final class mi_005fPerfil_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(2);
    _jspx_dependants.add("/DB_Gerente.jsp");
    _jspx_dependants.add("/Sesiones.jsp");
  }

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("\n");

    response.setHeader("Pragma", "No-cache");
    response.setHeader("Cache-control", "no-cache, no-store, must-revalidate");
    response.setDateHeader("Expires", 0);

      out.write('\n');


    HttpSession buscarSesion = (HttpSession)request.getSession();
    String usuario="";
if (buscarSesion.getAttribute("datos") == null) {
         request.getRequestDispatcher("index.jsp").forward(request, response);
         
    }else{
    UsuarioVO  usuVO = (UsuarioVO)buscarSesion.getAttribute("datos");
    usuario = usuVO.getUsuLogin();

}

      out.write("\n");
      out.write("\n");
      out.write("<html lang=\"es\">\n");
      out.write("<head>\n");
      out.write("    <title>Sabana Express</title>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("\n");
      out.write("</body>\n");
      out.write("\n");
      out.write("</html>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"es\">\n");
      out.write("<head>\n");
      out.write("    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("\n");
      out.write("    \n");
      out.write("    <!--CDN Logo FONTAWESOME-->\n");
      out.write("    <script src=\"https://kit.fontawesome.com/64d58efce2.js\" crossorigin=\"anonymous\"></script>\n");
      out.write("     <!--CSS-->\n");
      out.write("     <link rel=\"stylesheet\" href=\"gerente/css/style.css\">\n");
      out.write("\n");
      out.write("    <title>Menu gerente</title>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("    <div class=\"sidebar\">\n");
      out.write("        <div class=\"logo_content\">\n");
      out.write("            <div class=\"logo\">\n");
      out.write("                <i class=\"fas fa-syringe\"></i>\n");
      out.write("                <div class=\"logo_name\">vitaltest</div>\n");
      out.write("            </div>\n");
      out.write("            <i class=\"fas fa-bars\" id=\"btn\"></i>\n");
      out.write("        </div>\n");
      out.write("        <ul class=\"nav_list\">\n");
      out.write("            <li>\n");
      out.write("                <i class=\"fas fa-search\"></i>\n");
      out.write("                <input type=\"text\" placeholder=\"Buscar...\"> \n");
      out.write("                <span class=\"tooltip\">Buscar</span>\n");
      out.write("            </li>\n");
      out.write("            <li>\n");
      out.write("                <a href=\"menu_Gerente.jsp\">\n");
      out.write("                    <i class=\"fas fa-th-large\"></i>\n");
      out.write("                    <span class=\"links_name\">Inicio</span> \n");
      out.write("                </a>\n");
      out.write("                <span class=\"tooltip\">Inicio</span>\n");
      out.write("            </li>\n");
      out.write("            <li>\n");
      out.write("                <a href=\"mi_Perfil.jsp\">\n");
      out.write("                    <i class=\"fas fa-user-md\"></i>\n");
      out.write("                    <span class=\"links_name\">Mi perfil</span> \n");
      out.write("                </a>\n");
      out.write("                <span class=\"tooltip\">Mi perfil</span>\n");
      out.write("            </li>\n");
      out.write("            <li>\n");
      out.write("                <a href=\"\">\n");
      out.write("                    <i class=\"fas fa-band-aid\"></i>\n");
      out.write("                    <span class=\"links_name\">Inventario</span> \n");
      out.write("                </a>\n");
      out.write("                <span class=\"tooltip\">Inventario</span>\n");
      out.write("            </li>\n");
      out.write("            <li>\n");
      out.write("                <a href=\"\">\n");
      out.write("                    <i class=\"fas fa-users-cog\"></i>\n");
      out.write("                    <span class=\"links_name\">Empleados</span> \n");
      out.write("                </a>\n");
      out.write("                <span class=\"tooltip\">Empleados</span>\n");
      out.write("            </li>\n");
      out.write("            <li>\n");
      out.write("                <a href=\"\">\n");
      out.write("                    <i class=\"fas fa-heartbeat\"></i>\n");
      out.write("                    <span class=\"links_name\">Test médico</span> \n");
      out.write("                </a>\n");
      out.write("                <span class=\"tooltip\">Test médico</span>\n");
      out.write("            </li>\n");
      out.write("            <li>\n");
      out.write("                <a href=\"\">\n");
      out.write("                    <i class=\"fas fa-file-contract\"></i>\n");
      out.write("                    <span class=\"links_name\">Reportes</span> \n");
      out.write("                </a>\n");
      out.write("                <span class=\"tooltip\">Reportes</span>\n");
      out.write("            </li>\n");
      out.write("        </ul>\n");
      out.write("        <div class=\"profile_content\">\n");
      out.write("            <div class=\"profile\">\n");
      out.write("                <div class=\"profile_details\">\n");
      out.write("                    <img src=\"gerente/img/gerente.jpg\" alt=\"\">\n");
      out.write("                    <div class=\"name_job\">\n");
      out.write("                        <div class=\"name\">");
      out.print(usuario);
      out.write("</div>\n");
      out.write("                        <div class=\"job\">Gerente</div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <form method=\"post\" action=\"Sesiones\">        \n");
      out.write("                <button type=\"submit\"><i class=\"fas fa-door-open\" id=\"log_out\"></i></button>  \n");
      out.write("                </form>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("    <script src=\"gerente/js/main.js\"></script>\n");
      out.write("</body>\n");
      out.write("</html>");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("\n");
      out.write("    ");

        DatosVO datVO =  (DatosVO)buscarSesion.getAttribute("datosPersonales");
        if(datVO !=null){
    
      out.write("\n");
      out.write("    ");
                        
        UsuarioVO usuVO = new UsuarioVO();
        ArrayList<UsuarioVO> listaRoles = (ArrayList<UsuarioVO>)buscarSesion.getAttribute("roles");
        for (int i = 0; i < listaRoles.size(); i++) {
        usuVO = listaRoles.get(i);
        }
     
      out.write("\n");
      out.write("\n");
      out.write("<html lang=\"es\">\n");
      out.write("<head>\n");
      out.write("    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("     <!--CSS-->\n");
      out.write("     <link rel=\"stylesheet\" href=\"perfil/css/style.css\">\n");
      out.write("     \n");
      out.write("    <title>Mi perfil</title>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("    <div class=\"home_content\">\n");
      out.write("        <section class=\"seccion-perfil-usuario\">\n");
      out.write("            <div class=\"perfil-usuario-header\">\n");
      out.write("                <div class=\"perfil-usuario-portada\">\n");
      out.write("                    <div class=\"perfil-usuario-avatar\">\n");
      out.write("                        <img src=\"gerente/img/gerente.jpg\" alt=\"img-avatar\">\n");
      out.write("                        <button type=\"button\" class=\"boton-avatar\">\n");
      out.write("                            <i class=\"far fa-image\"></i>\n");
      out.write("                        </button>\n");
      out.write("                    </div>\n");
      out.write("                    <button type=\"button\" class=\"boton-portada\">\n");
      out.write("                        <i class=\"far fa-image\"></i> Cambiar fondo\n");
      out.write("                    </button>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"perfil-usuario-body\">\n");
      out.write("                <div class=\"perfil-usuario-bio\">\n");
      out.write("                    <h3 class=\"titulo\">");
      out.print(usuario);
      out.write("</h3>\n");
      out.write("                    <p class=\"texto\">Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod\n");
      out.write("                        tempor incididunt ut labore et dolore magna aliqua.</p>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"perfil-usuario-footer\">\n");
      out.write("                    <ul class=\"lista-datos\">\n");
      out.write("                        <li><i class=\"icono fas fa-crown\"></i>Nombre: \n");
      out.write("                            ");
      out.print(datVO.getDatNombre());
      out.write("\n");
      out.write("                        </li>\n");
      out.write("                        <li><i class=\"icono fab fa-envira\"></i>Apellidos: \n");
      out.write("                            ");
      out.print(datVO.getDatApellido1());
      out.write(' ');
      out.print(datVO.getDatApellido2());
      out.write(" \n");
      out.write("                        </li>\n");
      out.write("                        <li><i class=\"icono fas fa-monument\"></i>Tipo documento: \n");
      out.write("                            ");
      out.print(datVO.getDatTipoDocumento());
      out.write(" \n");
      out.write("                        </li>\n");
      out.write("                        <li><i class=\"icono fas fa-id-card\"></i>Número de documento: \n");
      out.write("                            ");
      out.print(datVO.getDatNumDocumento());
      out.write("\n");
      out.write("                        </li>\n");
      out.write("                    </ul>\n");
      out.write("                    <ul class=\"lista-datos\">\n");
      out.write("                        <li><i class=\"icono fas fa-calendar-alt\"></i>Fecha de nacimiendo: \n");
      out.write("                            ");
      out.print(datVO.getDatFechaNacimiento());
      out.write("\n");
      out.write("                        </li>\n");
      out.write("                        <li><i class=\"icono fas fa-map-marker-alt\"></i>Dirección: \n");
      out.write("                            ");
      out.print(datVO.getDatDirecion());
      out.write("\n");
      out.write("                        </li>\n");
      out.write("                        <li><i class=\"icono fas fa-envelope\"></i>Correo: \n");
      out.write("                            ");
      out.print(usuVO.getUsuCorreo());
      out.write(" \n");
      out.write("                        </li>\n");
      out.write("                        <li><i class=\"icono fas fa-phone\"></i>Teléfono: \n");
      out.write("                            ");
      out.print(datVO.getDatTelefono());
      out.write("\n");
      out.write("                        </li>\n");
      out.write("                    </ul>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"perfil-editar\">\n");
      out.write("                    <button type=\"submit\" class=\"cta\">\n");
      out.write("                        <i class=\"far fa-edit\"></i>\n");
      out.write("                        Editar\n");
      out.write("                    </button>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </section>\n");
      out.write("\n");
      out.write("        <!-- Modal -->\n");
      out.write("        <div class=\"modal-container\">\n");
      out.write("            <div class=\"modal modal-close\">\n");
      out.write("                <p class=\"close\">X</p>\n");
      out.write("                <div class=\"modal-form\">\n");
      out.write("                    <form method=\"POST\" action=\"Datos\">\n");
      out.write("                        <h2 class=\"title\">Datos</h2>\n");
      out.write("                        <div class=\"input-field\">\n");
      out.write("                            <i class=\"fas fa-user\"></i>\n");
      out.write("                            <input type=\"hidden\"  value=\"");
      out.print(usuVO.getUsuId());
      out.write("\" name=\"textUsuId\">\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"input-field\">\n");
      out.write("                            <i class=\"fas fa-envelope\"></i>\n");
      out.write("                            <input type=\"text\" placeholder=\"Nombre Completo\" name=\"textDatNom\" value=\"");
      out.print(datVO.getDatNombre());
      out.write("\" required>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"input-field\">\n");
      out.write("                            <i class=\"fas fa-envelope\"></i>\n");
      out.write("                            <input type=\"text\" placeholder=\"Primer Apellido\" name=\"textDatApelli1\" value=\"");
      out.print(datVO.getDatApellido1());
      out.write("\" required>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"input-field\">\n");
      out.write("                            <i class=\"fas fa-envelope\"></i>\n");
      out.write("                            <input type=\"text\" placeholder=\"Segundo Apellido\" name=\"textDatApelli2\" value=\"");
      out.print(datVO.getDatApellido2());
      out.write(" \"  required>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"input-field\">\n");
      out.write("                            <i class=\"fas fa-envelope\"></i>\n");
      out.write("                            <input type=\"text\" placeholder=\"Telefono\" name=\"textDatTel\" value=\" ");
      out.print(datVO.getDatTelefono());
      out.write("\" required>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"input-field\">\n");
      out.write("                            <i class=\"fas fa-envelope\"></i>\n");
      out.write("                            <input type=\"text\" placeholder=\"Tipo documento\" name=\"textDatTipoDoc\" value=\" ");
      out.print(datVO.getDatTipoDocumento());
      out.write(" \" required>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"input-field\">\n");
      out.write("                            <i class=\"fas fa-envelope\"></i>\n");
      out.write("                            <input type=\"text\" placeholder=\"Numero de documento\" name=\"textDatNumDoc\" readonly value=\"");
      out.print(datVO.getDatNumDocumento());
      out.write("\" required>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"input-field\">\n");
      out.write("                            <i class=\"fas fa-envelope\"></i>\n");
      out.write("                            <input type=\"date\" placeholder=\"Fecha de Nacimiento\" name=\"textDatFechaNa\" value=\"");
      out.print(datVO.getDatFechaNacimiento());
      out.write("\" required>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"input-field\">\n");
      out.write("                            <i class=\"fas fa-envelope\"></i>\n");
      out.write("                            <input type=\"text\" placeholder=\"Direccion\" name=\"textDatDirec\" value=\" ");
      out.print(datVO.getDatDirecion());
      out.write("\" required>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"mb-3\">\n");
      out.write("                          <input type=\"hidden\" id=\"estado\" name=\"textDatEsta\" value=\"Activo\">\n");
      out.write("                        </div>\n");
      out.write("                        <button class=\"btn solid\" value=\"2\" name=\"opcion\">Actualizar</button>\n");
      out.write("                    </form>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("    ");
}
    else{
        request.getRequestDispatcher("Registrar_datos.jsp").forward(request, response);
    }
    
      out.write("\n");
      out.write("    <script src=\"perfil/js/main.js\"></script>\n");
      out.write("</body>\n");
      out.write("</html>        \n");
      out.write("\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
