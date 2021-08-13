/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloDAO;


import ModeloVO.SintomaVO;
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
public class SintomaDAO extends Conexion implements Crud{
    
     //1. Declarar atributos y metodos
    private Connection conexion;
    private PreparedStatement puente;
    private ResultSet mensajero;
    
    private boolean operacion = false;
    private String sql;
    
    private String sinId="", sinDescripcion="";
    
    public SintomaDAO() {
    }
    //2. Conectarse y traemos los datos de los atributos de la clase VO
    public SintomaDAO(SintomaVO sinVO) {
            super();
            try {
                conexion = this.obtenerConexion();

               sinId= sinVO.getSinId();
               sinDescripcion = sinVO.getSinDescripcion();
            } catch (Exception e) {
                Logger.getLogger(SintomaDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }
    
    @Override
    public boolean agregarRegistro() {
        try {
            sql = "insert into sintoma (DescripcionSintoma) values (?)";
            puente = conexion.prepareStatement(sql);
            puente.setString(1, sinDescripcion);
            puente.executeUpdate();
            operacion = true;

        } catch (SQLException e) {
            Logger.getLogger(SintomaDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                this.cerrarConexion();
            } catch (SQLException e) {
                Logger.getLogger(SintomaDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        return operacion;
    }
    
    @Override
    public boolean actualizarRegistro() {
        try {
            sql = "update sintoma set DescripcionSintoma=?  where IdSintoma=?";
            puente = conexion.prepareStatement(sql);
            puente.setString(1, sinDescripcion);
            puente.setString(2, sinId);
            puente.executeUpdate();
            operacion = true;

        } catch (SQLException e) {

            Logger.getLogger(SintomaDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                this.cerrarConexion();
            } catch (SQLException e) {
            }
        }
        return operacion;
    }
    
     @Override
    public boolean eliminarRegistro() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public ArrayList<SintomaVO> listar() {
        ArrayList<SintomaVO> listaSintomas = new ArrayList<>();
        try {
            conexion = this.obtenerConexion();
            sql = "select * from sintoma";
            puente = conexion.prepareStatement(sql);
            mensajero = puente.executeQuery();
            while (mensajero.next()) {
                SintomaVO sinVO = new SintomaVO(mensajero.getString(1), mensajero.getString(2));
                listaSintomas.add(sinVO);
            }
        } catch (SQLException e) {
            Logger.getLogger(SintomaDAO.class.getName()).log(Level.SEVERE, null, e);

        }finally {
            try {
                this.cerrarConexion();
            } catch (SQLException e) {
                Logger.getLogger(SintomaDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        return listaSintomas;   
    }
    
    public SintomaVO consultarSintomas(String sinId) {
        SintomaVO sinVO = null;

        try {
            conexion = this.obtenerConexion();
            sql = "select * from sintoma where IdSintoma = ?";
            puente = conexion.prepareStatement(sql);
            puente.setString(1, sinId);
            mensajero = puente.executeQuery();
            
            while (mensajero.next()) {
                sinVO = new SintomaVO (mensajero.getString(1),
                                          mensajero.getString(2));
            }
        } catch (SQLException e) {
            Logger.getLogger(SintomaDAO.class.getName()).log(Level.SEVERE, null, e);

        } finally {
            try {
                this.cerrarConexion();
            } catch (SQLException e) {
                Logger.getLogger(SintomaDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        return sinVO;
    }
    
    
    
}
