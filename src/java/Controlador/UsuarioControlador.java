/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;


import ModeloDAO.DatosDAO;
import ModeloDAO.RolDAO;
import ModeloDAO.UsuarioDAO;
import ModeloVO.DatosVO;
import ModeloVO.UsuarioVO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author sebasGuapo
 */
@WebServlet(name = "UsuarioControlador", urlPatterns = {"/Usuario"})
public class UsuarioControlador extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        //1. Regojer los datos
        String usuId = request.getParameter("textId");
        String usuLogin = request.getParameter("textUsuario");
        String usuPassword = request.getParameter("textClave");
        String usuCorreo = request.getParameter("textCorreo");
        String idRol = request.getParameter("textIdRol");
        int opcion = Integer.parseInt(request.getParameter("opcion"));
        

        //2. Quién tiene los datos en el sistema = VO
        UsuarioVO usuVO = new UsuarioVO(usuId, usuLogin, usuPassword, usuCorreo, idRol);
        //3. Quién hace las operacion en el sistema = DAO
        UsuarioDAO usuDAO = new UsuarioDAO(usuVO);
        
        

        switch (opcion) {
            case 1: //Agregar Registro
                if (usuDAO.agregarRegistro()) {
                    request.setAttribute("mensajeExito", "El usuario se registró correctamente");
                } else {
                    request.setAttribute("mensajeError", "El usuario  NO se registró correctamente");

                }
                request.getRequestDispatcher("login.jsp").forward(request, response);
            break;
            case 2: //Actualizar Registro

                if (usuDAO.actualizarRegistro()) {
                    request.setAttribute("mensajeExito", "El usuario se actualizó correctamente");
                } else {
                    request.setAttribute("mensajeError", "El usuario  NO se actualizó correctamente");

                }
                request.getRequestDispatcher("Usuarios.jsp").forward(request, response);
                break;

            case 3: //Iniciar Sesión
                 
              String idUsuario = "";

                if (usuDAO.iniciarSesion(usuLogin, usuPassword)) {
                    
                    HttpSession miSesion = request.getSession(true);
                    RolDAO rolDAO = new RolDAO();
                    
                    ArrayList<UsuarioVO> listaRoles = rolDAO.roles(usuLogin);
                    
                    usuVO = new UsuarioVO(usuId, usuLogin, usuPassword, usuCorreo, idRol);
                    miSesion.setAttribute("datos", usuVO); 
                    
                    for (int i = 0; i < listaRoles.size(); i++) {
                        usuVO= listaRoles.get(i);   
                        idUsuario = usuVO.getUsuId();
                    }
                    
                    miSesion.setAttribute("roles", listaRoles);
                    
                    DatosVO datVO = new DatosVO();
                    DatosDAO datDAO = new DatosDAO(datVO);
                    
                    
                    datVO = datDAO.consultarDatos(idUsuario);
                    miSesion.setAttribute("datosPersonales", datVO);
                    
                    if (usuVO.getNombreRol().equals("Cliente")) {
                         request.getRequestDispatcher("menu_Cliente.jsp").forward(request, response);
                    }else if (usuVO.getNombreRol().equals("Farmaceutico")){
                        request.getRequestDispatcher("menu_Farmaceutico.jsp").forward(request, response);
                    }else if (usuVO.getNombreRol().equals("Gerente")){
                        request.getRequestDispatcher("menu_Gerente.jsp").forward(request, response);
                    }
                } else {
                    request.setAttribute("mensajeError", "Datos de inicio de sesion incorrectos");
                    request.getRequestDispatcher("index.jsp").forward(request, response);
                }
                break;
                case 4: //Agregar Empleado
                if (usuDAO.agregarRegistro()) {
                    request.setAttribute("mensajeExito", "Has creado un nuevo empleado");
                } else {
                    request.setAttribute("mensajeError", "El empleado NO se registró correctamente");
                }
                request.getRequestDispatcher("Usuarios.jsp").forward(request, response);
                break;
                
                case 5: //Consultar Usuarios
                     usuVO =usuDAO.consultarUsuarios(usuId);
                     if(usuVO !=null){
                        request.setAttribute("datosUsuarios", usuVO);
                        request.getRequestDispatcher("Actualizar_Usuarios.jsp").forward(request, response);
                     }
                break;
        }

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
