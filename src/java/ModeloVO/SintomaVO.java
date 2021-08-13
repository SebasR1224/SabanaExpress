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
public class SintomaVO {
    
    private String sinId, sinDescripcion;

    public SintomaVO() {
    }

    public SintomaVO(String sinId, String sinDescripcion) {
        this.sinId = sinId;
        this.sinDescripcion = sinDescripcion;
    }

    public String getSinId() {
        return sinId;
    }

    public void setSinId(String sinId) {
        this.sinId = sinId;
    }

    public String getSinDescripcion() {
        return sinDescripcion;
    }

    public void setSinDescripcion(String sinDescripcion) {
        this.sinDescripcion = sinDescripcion;
    }
    
    
    
    
}
