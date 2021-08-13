/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloDAO;


import ModeloVO.ParteCuerpoVO;
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
public class ParteCuerpoDAO extends Conexion  implements Crud{
    
    //1. Declarar atributos y metodos
    private Connection conexion;
    private PreparedStatement puente;
    private ResultSet mensajero;
    
    private boolean operacion = false;
    private String sql;
    
    private String parId = "" , parNombre="";
    
    public ParteCuerpoDAO() {
    }
    
    //2. Conectarse y traemos los datos de los atributos de la clase VO
    public ParteCuerpoDAO(ParteCuerpoVO parVO) {
            super();
            try {
                conexion = this.obtenerConexion();

               parId = parVO.getParId();
               parNombre = parVO.getParNombre();
            } catch (Exception e) {
                Logger.getLogger(ParteCuerpoDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }
    
    @Override
    public boolean agregarRegistro() {
        try {
            sql = "insert into partecuerpo (NombreParte) values (?)";
            puente = conexion.prepareStatement(sql);
            puente.setString(1, parNombre);
            puente.executeUpdate();
            operacion = true;

        } catch (SQLException e) {
            Logger.getLogger(ParteCuerpoDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                this.cerrarConexion();
            } catch (SQLException e) {
                Logger.getLogger(ParteCuerpoDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        return operacion;
    }
    
    public boolean actualizarRegistro() {
        try {
            sql = "update partecuerpo set NombreParte=?  where IdParte=?";
            puente = conexion.prepareStatement(sql);
            puente.setString(1, parNombre);
            puente.setString(2, parId);
            puente.executeUpdate();
            operacion = true;

        } catch (SQLException e) {

            Logger.getLogger(ParteCuerpoDAO.class.getName()).log(Level.SEVERE, null, e);
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
    
    
    public ArrayList<ParteCuerpoVO> listar() {
        ArrayList<ParteCuerpoVO> listaPartes = new ArrayList<>();
        try {
            conexion = this.obtenerConexion();
            sql = "select * from partecuerpo";
            puente = conexion.prepareStatement(sql);
            mensajero = puente.executeQuery();
            while (mensajero.next()) {

                ParteCuerpoVO parVO = new ParteCuerpoVO(mensajero.getString(1), mensajero.getString(2));
                listaPartes.add(parVO);

            }
        } catch (SQLException e) {
            Logger.getLogger(ParteCuerpoDAO.class.getName()).log(Level.SEVERE, null, e);

        }finally {
            try {
                this.cerrarConexion();
            } catch (SQLException e) {
                Logger.getLogger(ParteCuerpoDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        return listaPartes;   
    }
    
    public ParteCuerpoVO consultarPartes(String parId) {
        ParteCuerpoVO parVO = null;

        try {
            conexion = this.obtenerConexion();
            sql = "select * from partecuerpo where IdParte = ?";
            puente = conexion.prepareStatement(sql);
            puente.setString(1, parId);
            mensajero = puente.executeQuery();
            
            while (mensajero.next()) {
                parVO = new ParteCuerpoVO (mensajero.getString(1),
                                          mensajero.getString(2));
            }
        } catch (SQLException e) {
            Logger.getLogger(ParteCuerpoDAO.class.getName()).log(Level.SEVERE, null, e);

        } finally {
            try {
                this.cerrarConexion();
            } catch (SQLException e) {
                Logger.getLogger(ParteCuerpoDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        return parVO;
    }
    
}
