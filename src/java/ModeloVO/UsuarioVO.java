/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloVO;

/**
 *
 * @author sebasguapo
 */
public class UsuarioVO {

    //atributos
    private String usuId, usuLogin, usuPassword, usuCorreo, idRol;
    private String usuRol, nombreRol;
    
    //metodos constructores

    public UsuarioVO() {
    }

    public UsuarioVO(String usuId, String usuLogin, String usuPassword, String usuCorreo, String idRol) {
        this.usuId = usuId;
        this.usuLogin = usuLogin;
        this.usuPassword = usuPassword;
        this.usuCorreo = usuCorreo;
        this.idRol = idRol;
    }

    public UsuarioVO(String usuId, String nombreRol) {
        this.usuId = usuId;
        this.nombreRol = nombreRol;
    }

    public String getUsuId() {
        return usuId;
    }

    public void setUsuId(String usuId) {
        this.usuId = usuId;
    }

    public String getUsuLogin() {
        return usuLogin;
    }

    public void setUsuLogin(String usuLogin) {
        this.usuLogin = usuLogin;
    }

    public String getUsuPassword() {
        return usuPassword;
    }

    public void setUsuPassword(String usuPassword) {
        this.usuPassword = usuPassword;
    }

    public String getUsuCorreo() {
        return usuCorreo;
    }

    public void setUsuCorreo(String usuCorreo) {
        this.usuCorreo = usuCorreo;
    }

    public String getIdRol() {
        return idRol;
    }

    public void setIdRol(String idRol) {
        this.idRol = idRol;
    }

    public String getUsuRol() {
        return usuRol;
    }

    public void setUsuRol(String usuRol) {
        this.usuRol = usuRol;
    }

    public String getNombreRol() {
        return nombreRol;
    }

    public void setNombreRol(String nombreRol) {
        this.nombreRol = nombreRol;
    }
    
    
    
  


   
   
    
    

}
