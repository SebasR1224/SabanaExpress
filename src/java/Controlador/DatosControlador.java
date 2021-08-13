/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import ModeloDAO.DatosDAO;
import ModeloVO.DatosVO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author User
 */
@WebServlet(name = "DatosControlador", urlPatterns = {"/Datos"})
public class DatosControlador extends HttpServlet {

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
        
        //Recoger los datos
        String datId = request.getParameter("textDatId"); 
        String usuId = request.getParameter("textUsuId");
        String datNombre = request.getParameter("textDatNom");
        String datApellido1 = request.getParameter("textDatApelli1");
        String datApellido2 = request.getParameter("textDatApelli2");
        String datTelefono = request.getParameter("textDatTel");
        String datTipoDocumento = request.getParameter("textDatTipoDoc");
        String datNumDocumento = request.getParameter("textDatNumDoc");
        String datFechaNacimiento = request.getParameter("textDatFechaNa");
        String datDirecion = request.getParameter("textDatDirec");
        String datEstado = request.getParameter("textDatEsta");  
        int opcion = Integer.parseInt(request.getParameter("opcion"));
        
        //2. Quién tiene los datos en el sistema = VO
        DatosVO datVO = new DatosVO(datId, usuId, datNombre, datApellido1, datApellido2, datTelefono, 
            datTipoDocumento, datNumDocumento, datFechaNacimiento, datDirecion, datEstado);
        //3. Quién hace las operacion en el sistema = DAO
        DatosDAO datDAO = new DatosDAO(datVO);
        
        switch (opcion){
            case 1 : //Agregar Registro
                if (datDAO.agregarRegistro()) {
                    
                    HttpSession buscarSesion = (HttpSession)request.getSession();
                    buscarSesion.setAttribute("datosPersonales", datVO);
                    request.setAttribute("mensajeExito", "Campos Agregados corecctamente");
                }else {
                    request.setAttribute("mensajeError", "Error al ingresar los datos");
                }
                request.getRequestDispatcher("mi_Perfil.jsp").forward(request, response);
            break;
            
            case 2 : //Actualizar Registro
                if (datDAO.actualizarRegistro()){
                    HttpSession buscarSesion = (HttpSession)request.getSession();
                    buscarSesion.setAttribute("datosPersonales", datVO);
                    
                    request.setAttribute("mensajeExito", "Datos se actualizados correctamente");  
                }else {
                    request.setAttribute("mensajeError", "Error al actualizar los datos");
                }
                request.getRequestDispatcher("mi_Perfil.jsp").forward(request, response);
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
