/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import ModeloDAO.ParteCuerpoDAO;
import ModeloDAO.RecomendacionDAO;
import ModeloVO.ParteCuerpoVO;
import ModeloVO.RecomendacionVO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author User
 */
@WebServlet(name = "RecomendacionControlador", urlPatterns = {"/Recomendacion"})
public class RecomendacionControlador extends HttpServlet {

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

        String recId = request.getParameter("textRecId"); 
        String recNombre = request.getParameter("textRecNombre");
        String parId = request.getParameter("textParId");
        String sinId = request.getParameter("textSinId");
        String medId = request.getParameter("textMedId");
        String recDosis = request.getParameter("textRecDosis");
        String recFrecuencia = request.getParameter("textRecFrecuencia");
        String recTiempo = request.getParameter("textRecTiempo"); 
        String recIntensidadMin = request.getParameter("textRecIntensidadMin");
        String recIntensidadMax = request.getParameter("textRecIntensidadMax");
        String recEdadMin = request.getParameter("textRecEdadMin"); 
        String recEdadMax = request.getParameter("textRecEdadMax");
        String imcId = request.getParameter("textImcId");
        String recInformacion = request.getParameter("textRecInformacion");
        String recEstado = request.getParameter("textRecEstado");  
        int opcion = Integer.parseInt(request.getParameter("opcion"));
        
        //2. Quién tiene los datos en el sistema = VO
        RecomendacionVO recVO = new RecomendacionVO(recId, recNombre, parId, sinId, medId, recDosis, recFrecuencia, recTiempo, recIntensidadMin, recIntensidadMax, recEdadMin, recEdadMax, imcId, recInformacion, recEstado);
        //3. Quién hace las operacion en el sistema = DAO
        RecomendacionDAO recDAO = new RecomendacionDAO(recVO);
        
        //DATOS PARTE CUERPO
        String parNombre = request.getParameter("textParNombre");
        
        ParteCuerpoVO parVO = new ParteCuerpoVO(parId ,parNombre);
        ParteCuerpoDAO parDAO = new ParteCuerpoDAO(parVO);
        
        
        switch(opcion){
            case 1: //Agregar
                if(recDAO.agregarRegistro()){
                    request.setAttribute("mensajeExito", "Recomendacion agregada");
                    
                }else {
                    request.setAttribute("mensajeError", "Error al Registar");
                }
            request.getRequestDispatcher("Recomendacion.jsp").forward(request, response);    
            break;
            case 2: //Actualizar
                if(recDAO.actualizarRegistro()){
                   request.setAttribute("mensajeExito", "Datos se actualizados correctamente");
                } else{
                    request.setAttribute("mensajeError", "Error al actualizar los datos");
                }
                request.getRequestDispatcher("Recomendacion.jsp").forward(request, response);
            break;
            case 3: //Consultar Recomendacion
                recVO = recDAO.consultarRecomendacion(recId);
                if (recVO !=null) {
                    request.setAttribute("recomendacion", recVO);
                    request.getRequestDispatcher("Actualizar_Recomendacion.jsp").forward(request, response);  
                }
            case 4:
                if(parDAO.agregarRegistro()){
                  request.setAttribute("mensajeExito", "Parte Cuerpo Agregada");  
                }else{
                    request.setAttribute("mensajeError", "Error al Agregar");
                }
                request.getRequestDispatcher("Recomendacion.jsp").forward(request, response);
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
