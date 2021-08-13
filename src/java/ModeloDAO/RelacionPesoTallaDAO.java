/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloDAO;


import ModeloVO.RelacionPesoTallaVO;
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
 * @author User
 */
public class RelacionPesoTallaDAO extends Conexion {
    
      //1. Declarar atributos y metodos
    private Connection conexion;
    private PreparedStatement puente;
    private ResultSet mensajero;
    
    private String sql;
    
    
    public ArrayList<RelacionPesoTallaVO> listar() {
        ArrayList<RelacionPesoTallaVO> listaImc = new ArrayList<>();
        try {
            conexion = this.obtenerConexion();
            sql = "select * from imc";
            puente = conexion.prepareStatement(sql);
            mensajero = puente.executeQuery();
            while (mensajero.next()) {

                RelacionPesoTallaVO imcVO = new RelacionPesoTallaVO(
                        mensajero.getString(1), 
                        mensajero.getString(2), 
                        mensajero.getString(3), 
                        mensajero.getString(4));
                listaImc.add(imcVO);

            }
        } catch (SQLException e) {
            Logger.getLogger(RelacionPesoTallaDAO.class.getName()).log(Level.SEVERE, null, e);

        }finally {
            try {
                this.cerrarConexion();
            } catch (SQLException e) {
                Logger.getLogger(RelacionPesoTallaDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        return  listaImc;   
    }
}
