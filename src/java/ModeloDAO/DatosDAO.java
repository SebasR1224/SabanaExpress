 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloDAO;

import ModeloVO.DatosVO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpSession;
import util.Conexion;
import util.Crud;

/**
 *
 * @author User
 */
public class DatosDAO extends Conexion implements Crud {
    
    
     //1. Declarar Atributos y objetos
    private Connection conexion;
    private PreparedStatement puente;
    private ResultSet mensajero;

    private boolean operacion = false;    
    private String sql;
    
    private String datId="", usuId="", datNombre="", datApellido1="", datApellido2="", datTelefono="", 
            datTipoDocumento="", datNumDocumento="", datFechaNacimiento="", datDirecion="", datEstado="";  
    
    //2. Conectarse y traemos los datos de los atributos de la clase VO
    public DatosDAO(DatosVO datVO) {
        super();
        try {
            conexion = this.obtenerConexion();
            datId = datVO.getDatId();
            usuId=datVO.getUsuId();
            datNombre=datVO.getDatNombre();
            datApellido1=datVO.getDatApellido1();
            datApellido2=datVO.getDatApellido2();
            datTelefono=datVO.getDatTelefono();
            datTipoDocumento=datVO.getDatTipoDocumento();
            datNumDocumento=datVO.getDatNumDocumento();
            datFechaNacimiento=datVO.getDatFechaNacimiento();
            datDirecion=datVO.getDatDirecion();
            datEstado=datVO.getDatEstado();

        } catch (Exception e) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public DatosDAO() {
    }
    
    
    public boolean agregarRegistro() {
        try {
            sql = "insert into datosusuario (IdUsuario, Nombre, Apellido1, Apellido2, Telefono, TipoDocumento, NumDocumento, "
                    + "FechaNacimiento, Direccion,  Estado) values (?,?,?,?,?,?,?,?,?,?)";
            puente = conexion.prepareStatement(sql);
            puente.setString(1, usuId);
            puente.setString(2, datNombre);
            puente.setString(3, datApellido1);
            puente.setString(4, datApellido2);
            puente.setString(5, datTelefono);
            puente.setString(6, datTipoDocumento);
            puente.setString(7, datNumDocumento);
            puente.setString(8, datFechaNacimiento);
            puente.setString(9, datDirecion);
            puente.setString(10, datEstado);
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
    
    public boolean actualizarRegistro() {
        try {
            sql = "UPDATE datosusuario SET Nombre =? , Apellido1 =?, Apellido2 = ?, Telefono =?, TipoDocumento = ?, FechaNacimiento = ?, Direccion = ? WHERE NumDocumento=?";
                   
            puente = conexion.prepareStatement(sql);
            puente.setString(1, datNombre);
            puente.setString(2, datApellido1);
            puente.setString(3, datApellido2);
            puente.setString(4, datTelefono);
            puente.setString(5, datTipoDocumento);
            puente.setString(6, datFechaNacimiento);
            puente.setString(7, datDirecion);
            puente.setString(8, datNumDocumento);
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
    
    
    
    public DatosVO consultarDatos(String idUsuario) {
        DatosVO datVO = null;

        try {
            conexion = this.obtenerConexion();
            sql = "select * from datosusuario where IdUsuario = ?";
            puente = conexion.prepareStatement(sql);
            puente.setString(1, idUsuario);
            mensajero = puente.executeQuery();
            
            while (mensajero.next()) {
                datVO = new DatosVO (mensajero.getString(1),
                        mensajero.getString(2), mensajero.getString(3),
                        mensajero.getString(4), mensajero.getString(5),
                        mensajero.getString(6), mensajero.getString(7), 
                        mensajero.getString(8), mensajero.getString(9),
                        mensajero.getString(10),mensajero.getString(11));
            }
        } catch (SQLException e) {
            Logger.getLogger(DatosDAO.class.getName()).log(Level.SEVERE, null, e);

        } finally {
            try {
                this.cerrarConexion();
            } catch (SQLException e) {
                Logger.getLogger(DatosDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        return datVO;
    }    
}