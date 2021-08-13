/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloDAO;

import ModeloVO.UsuarioVO;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.Conexion;
import util.Crud;

/**
 *
 * @author sebasguapo
 */
public class UsuarioDAO extends Conexion implements Crud {

    //1. Declarar Atributos y objetos
    private Connection conexion;
    private PreparedStatement puente;
    private ResultSet mensajero;

    private boolean operacion = false;
    private String sql;

    private String usuId = "", usuLogin = "", usuPassword = "", usuCorreo="" , idRol="";

    //2. Conectarse y traemos los datos de los atributos de la clase VO
    public UsuarioDAO(UsuarioVO usuVO) {
        super();
        try {
            conexion = this.obtenerConexion();
            usuId = usuVO.getUsuId();
            usuLogin = usuVO.getUsuLogin();
            usuPassword = usuVO.getUsuPassword();
            usuCorreo = usuVO.getUsuCorreo();
            idRol = usuVO.getIdRol();

        } catch (Exception e) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public UsuarioDAO() {
    }
    
    

    //3. Implimentar los metodos abstractos de la interface CRUD
    @Override
    public boolean agregarRegistro() {
        try {
            sql = "insert into usuario (NombreUsuario, Clave, Correo, IdRol) values (?,?,?,?)";
            puente = conexion.prepareStatement(sql);
            puente.setString(1, usuLogin);
            puente.setString(2, usuPassword);
            puente.setString(3, usuCorreo);
            puente.setString(4, idRol);
            puente.executeUpdate();
            operacion = true;

        } catch (SQLException e) {

            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                this.cerrarConexion();
            } catch (SQLException e) {
            }
        }
        return operacion;
    }

    @Override
    public boolean actualizarRegistro() {
        try {
            sql = "update usuario set NombreUsuario=?, Clave=?, Correo=? , IdRol=? where IdUsuario=?";
            puente = conexion.prepareStatement(sql);
            puente.setString(1, usuLogin);
            puente.setString(2, usuPassword);
            puente.setString(3, usuCorreo);
            puente.setString(4, idRol);
            puente.setString(5, usuId);
            puente.executeUpdate();
            operacion = true;

        } catch (SQLException e) {

            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, e);
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

    //4. Metodos propios del modulo
    public boolean iniciarSesion(String usuario, String clave) {

        try {
            conexion = this.obtenerConexion();
            sql = "select * from usuario where NombreUsuario=? and Clave=?";
            puente = conexion.prepareStatement(sql);
            puente.setString(1, usuario);
            puente.setString(2, clave);
            mensajero = puente.executeQuery();
            if (mensajero.next()) {
                operacion = true;
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
        return operacion;
    }
    
    public ArrayList<UsuarioVO> listar() {
        ArrayList<UsuarioVO> listaUsuarios = new ArrayList<>();
        try {
            conexion = this.obtenerConexion();
            sql = "select * from usuario";
            puente = conexion.prepareStatement(sql);
            mensajero = puente.executeQuery();
            while (mensajero.next()) {

                UsuarioVO usuVO = new UsuarioVO
                       (mensajero.getString(1), mensajero.getString(2),
                        mensajero.getString(3), mensajero.getString(4),
                        mensajero.getString(5));
                listaUsuarios.add(usuVO);

            }
        } catch (SQLException e) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, e);

        }finally {
            try {
                this.cerrarConexion();
            } catch (SQLException e) {
                Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        return listaUsuarios;   
    }
    public UsuarioVO consultarUsuarios(String usuId) {
        UsuarioVO usuVO = null;

        try {
            conexion = this.obtenerConexion();
            sql = "select * from usuario where IdUsuario=?";
            puente = conexion.prepareStatement(sql);
            puente.setString(1, usuId);
            mensajero = puente.executeQuery();
            
            while (mensajero.next()) {
                usuVO = new UsuarioVO(usuId, mensajero.getString(2),
                        mensajero.getString(3), mensajero.getString(4),
                        mensajero.getString(5));
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
    
    
}
