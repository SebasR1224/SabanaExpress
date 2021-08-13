/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloVO;

/**
 *
 * @author User
 */
public class DatosVO {
    
    private String datId, usuId, datNombre, datApellido1, datApellido2, datTelefono, 
            datTipoDocumento, datNumDocumento, datFechaNacimiento, datDirecion, datEstado;  
    
     public DatosVO() {
    }

    public DatosVO(String datId, String usuId, String datNombre, String datApellido1, String datApellido2, String datTelefono, String datTipoDocumento, String datNumDocumento, String datFechaNacimiento, String datDirecion, String datEstado) {
        this.datId = datId;
        this.usuId = usuId;
        this.datNombre = datNombre;
        this.datApellido1 = datApellido1;
        this.datApellido2 = datApellido2;
        this.datTelefono = datTelefono;
        this.datTipoDocumento = datTipoDocumento;
        this.datNumDocumento = datNumDocumento;
        this.datFechaNacimiento = datFechaNacimiento;
        this.datDirecion = datDirecion;
        this.datEstado = datEstado;
    }

    public String getDatId() {
        return datId;
    }

    public void setDatId(String datId) {
        this.datId = datId;
    }

    public String getUsuId() {
        return usuId;
    }

    public void setUsuId(String usuId) {
        this.usuId = usuId;
    }

    public String getDatNombre() {
        return datNombre;
    }

    public void setDatNombre(String datNombre) {
        this.datNombre = datNombre;
    }

    public String getDatApellido1() {
        return datApellido1;
    }

    public void setDatApellido1(String datApellido1) {
        this.datApellido1 = datApellido1;
    }

    public String getDatApellido2() {
        return datApellido2;
    }

    public void setDatApellido2(String datApellido2) {
        this.datApellido2 = datApellido2;
    }

    public String getDatTelefono() {
        return datTelefono;
    }

    public void setDatTelefono(String datTelefono) {
        this.datTelefono = datTelefono;
    }

    public String getDatTipoDocumento() {
        return datTipoDocumento;
    }

    public void setDatTipoDocumento(String datTIpoDocumento) {
        this.datTipoDocumento = datTIpoDocumento;
    }

    public String getDatNumDocumento() {
        return datNumDocumento;
    }

    public void setDatNumDocumento(String datNumDocumento) {
        this.datNumDocumento = datNumDocumento;
    }

    public String getDatFechaNacimiento() {
        return datFechaNacimiento;
    }

    public void setDatFechaNacimiento(String datFechaNacimiento) {
        this.datFechaNacimiento = datFechaNacimiento;
    }

    public String getDatDirecion() {
        return datDirecion;
    }

    public void setDatDirecion(String datDirecion) {
        this.datDirecion = datDirecion;
    }

    public String getDatEstado() {
        return datEstado;
    }

    public void setDatEstado(String datEstado) {
        this.datEstado = datEstado;
    }   
}
