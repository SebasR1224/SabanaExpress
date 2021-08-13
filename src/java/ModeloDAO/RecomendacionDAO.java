/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloDAO;

import ModeloVO.DatosVO;
import ModeloVO.RecomendacionVO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.Conexion;
import util.Crud;

/**
 *
 * @author User
 */
public class RecomendacionDAO extends Conexion implements Crud {
    
     //1. Declarar Atributos y objetos

    private Connection conexion;
    private PreparedStatement puente;
    private ResultSet mensajero;

    private boolean operacion = false;
    private String sql;

    public RecomendacionDAO() {
    }
    
        private String recId="", recNombre="", parId="", sinId="", medId="", 
                       recDosis="", recFrecuencia="", recTiempo="", 
                       recIntensidadMin="", recIntensidadMax="", recEdadMin="", 
                       recEdadMax="", imcId="", recInformacion="", recEstado="";

    public RecomendacionDAO(RecomendacionVO recVO) {
        super();
        try {
            conexion = this.obtenerConexion();
            recId = recVO.getRecId();
            recNombre = recVO.getRecNombre();
            parId = recVO.getParId();
            sinId = recVO.getSinId();
            medId=recVO.getMedId();
            recDosis=recVO.getRecDosis();
            recFrecuencia=recVO.getRecFrecuencia();
            recTiempo = recVO.getRecTiempo();
            recIntensidadMin = recVO.getRecIntensidadMin();
            recIntensidadMax = recVO.getRecIntensidadMax();
            recEdadMin = recVO.getRecEdadMin();
            recEdadMax = recVO.getRecEdadMax();
            imcId = recVO.getImcId();
            recInformacion = recVO.getRecInformacion();
            recEstado = recVO.getRecEstado();
            
        } catch (Exception e) {
            Logger.getLogger(RecomendacionDAO.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    
    @Override
    public boolean agregarRegistro() {
        try {
            sql = "INSERT INTO `recomendacion` (NombreRecomendacion, IdParte, IdSintoma, IdMedicamento, Dosis, Frecuencia, Tiempo, IntensidadMin, IntensidadMax, EdadMin, EdadMax, IdIMC, InformacionAdicional, Estado) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            
            puente = conexion.prepareStatement(sql);
           
            puente.setString(1, recNombre);
            puente.setString(2, parId);
            puente.setString(3, sinId);
            puente.setString(4, medId); 
            puente.setString(5, recDosis);
            puente.setString(6, recFrecuencia);
            puente.setString(7, recTiempo);
            puente.setString(8, recIntensidadMin);
            puente.setString(9, recIntensidadMax); 
            puente.setString(10, recEdadMin); 
            puente.setString(11, recEdadMax);
            puente.setString(12, imcId);
            puente.setString(13, recInformacion);
            puente.setString(14, recEstado);
            puente.executeUpdate();
            operacion = true;
            
        } catch (Exception e) {
            Logger.getLogger(RecomendacionDAO.class.getName()).log(Level.SEVERE, null, e);
        }finally {
            try {
                this.cerrarConexion();
            } catch (SQLException e) {
                Logger.getLogger(RecomendacionDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        return operacion;  
    }
    

    public boolean actualizarRegistro() {
        try {
            sql = "UPDATE recomendacion SET NombreRecomendacion = ?, IdParte = ?, IdSintoma = ?, IdMedicamento=?, Dosis = ?, Frecuencia = ?, Tiempo = ?, IntensidadMin = ?, IntensidadMax = ?, EdadMin = ?, EdadMax = ?, IdIMC = ?, InformacionAdicional = ? WHERE IdRecomendacion = ?";
            puente = conexion.prepareStatement(sql);
            puente.setString(1, recNombre);
            puente.setString(2, parId);
            puente.setString(3, sinId);
            puente.setString(4, medId); 
            puente.setString(5, recDosis);
            puente.setString(6, recFrecuencia);
            puente.setString(7, recTiempo);
            puente.setString(8, recIntensidadMin);
            puente.setString(9, recIntensidadMax); 
            puente.setString(10, recEdadMin); 
            puente.setString(11, recEdadMax);
            puente.setString(12, imcId);
            puente.setString(13, recInformacion);
            puente.setString(14, recId);
            puente.executeUpdate();
            operacion = true;
        } catch (SQLException e) {
            Logger.getLogger(RecomendacionDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                this.cerrarConexion();
            } catch (SQLException e) {
                Logger.getLogger(RecomendacionDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        return operacion;
    }

    @Override
    public boolean eliminarRegistro() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public RecomendacionVO consultarRecomendacion(String recId) {
        RecomendacionVO recVO = null;

        try {
            conexion = this.obtenerConexion();
            sql = "select * from recomendacion where IdRecomendacion=?";
            puente = conexion.prepareStatement(sql);
            puente.setString(1, recId);
            mensajero = puente.executeQuery();
            
            while (mensajero.next()) {
                recVO = new RecomendacionVO(recId, mensajero.getString(2),
                        mensajero.getString(3), mensajero.getString(4),
                        mensajero.getString(5), mensajero.getString(6),
                        mensajero.getString(7), mensajero.getString(8), 
                        mensajero.getString(9), mensajero.getString(10), 
                        mensajero.getString(11), mensajero.getString(12),
                        mensajero.getString(13) ,mensajero.getString(14),
                        mensajero.getString(15));
            }
        } catch (SQLException e) {
            Logger.getLogger(RecomendacionDAO.class.getName()).log(Level.SEVERE, null, e);

        } finally {
            try {
                this.cerrarConexion();
            } catch (SQLException e) {
                Logger.getLogger(RecomendacionDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        return recVO;
    }
    
    public ArrayList<RecomendacionVO> listar() {
        ArrayList<RecomendacionVO> listaVehiculos = new ArrayList<>();
        try {
            conexion = this.obtenerConexion();
            sql = "select * from recomendacion";
            puente = conexion.prepareStatement(sql);
            mensajero = puente.executeQuery();
            while (mensajero.next()) {

                RecomendacionVO recVO = new RecomendacionVO
                       (mensajero.getString(1), mensajero.getString(2),
                        mensajero.getString(3), mensajero.getString(4),
                        mensajero.getString(5), mensajero.getString(6),
                        mensajero.getString(7),mensajero.getString(8),
                        mensajero.getString(9), mensajero.getString(10),
                        mensajero.getString(11), mensajero.getString(12),
                        mensajero.getString(13), mensajero.getString(14),
                        mensajero.getString(15));
                listaVehiculos.add(recVO);

            }
        } catch (SQLException e) {
            Logger.getLogger(RecomendacionDAO.class.getName()).log(Level.SEVERE, null, e);

        }finally {
            try {
                this.cerrarConexion();
            } catch (SQLException e) {
                Logger.getLogger(RecomendacionDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        return listaVehiculos;   
    }
    
    
}
