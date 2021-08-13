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
public class ParteCuerpoVO {
    private String parId, parNombre;

    public ParteCuerpoVO() {
    }

    public ParteCuerpoVO(String parId, String parNombre) {
        this.parId = parId;
        this.parNombre = parNombre;
    }

    public String getParId() {
        return parId;
    }

    public void setParId(String parId) {
        this.parId = parId;
    }

    public String getParNombre() {
        return parNombre;
    }

    public void setParNombre(String parNombre) {
        this.parNombre = parNombre;
    }
    
    
}