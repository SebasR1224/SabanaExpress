/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloDAO;
import ModeloVO.UsuarioVO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.Conexion;

/**
 *
 * @author sebas
 */
public class RolDAO extends Conexion {
    
    private Connection conexion;
    private PreparedStatement puente;
    private ResultSet mensajero;
    private String sql;
    
    public ArrayList<UsuarioVO> roles (String usuario) {
        
        ArrayList<UsuarioVO> listaRoles = new ArrayList<>();
        
        try {
            conexion = this.obtenerConexion();
            sql = "SELECT usuario.IdUsuario, rolusuario.NombreRol\n" +
                  "FROM usuario \n" +
                  "INNER JOIN rolusuario\n" +
                  "ON usuario.IdRol = rolusuario.IdRol \n" +
                  "WHERE NombreUsuario = ?";
            puente = conexion.prepareStatement(sql);
            puente.setString(1, usuario);
            mensajero = puente.executeQuery();
            
            while(mensajero.next()){
               UsuarioVO usuVO = new UsuarioVO(mensajero.getString(1), mensajero.getString(2));
                listaRoles.add(usuVO);               
            }
            
        } catch (SQLException e) {
        Logger.getLogger(RolDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return listaRoles;
    }
    
    public UsuarioVO consultarRoles(String idRol) {
        UsuarioVO usuVO = null;

        try {
            conexion = this.obtenerConexion();
            sql = "select * from rolusuario where IdRol = ?";
            puente = conexion.prepareStatement(sql);
            puente.setString(1, idRol);
            mensajero = puente.executeQuery();
            
            while (mensajero.next()) {
                usuVO = new UsuarioVO (mensajero.getString(1),
                                          mensajero.getString(2));
            }
        } catch (SQLException e) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, e);

        } finally {
            try {
                this.cerrarConexion();
            } catch (SQLException e) {
                Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        return usuVO;
    }
    
    public ArrayList<UsuarioVO> listar() {
        ArrayList<UsuarioVO> listaRoles = new ArrayList<>();
        try {
            conexion = this.obtenerConexion();
            sql = "select * from rolusuario";
            puente = conexion.prepareStatement(sql);
            mensajero = puente.executeQuery();
            while (mensajero.next()) {

                UsuarioVO usuVO = new UsuarioVO
                       (mensajero.getString(1), mensajero.getString(2));
                listaRoles.add(usuVO);

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
        return listaRoles;   
    }
}
