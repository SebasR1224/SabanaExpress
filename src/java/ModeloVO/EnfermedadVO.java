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
public class EnfermedadVO {
 
    private String enfId, enfNombre;

    public EnfermedadVO() {
    }

    public EnfermedadVO(String enfId, String enfNombre) {
        this.enfId = enfId;
        this.enfNombre = enfNombre;
    }

    public String getEnfId() {
        return enfId;
    }

    public void setEnfId(String enfId) {
        this.enfId = enfId;
    }

    public String getEnfNombre() {
        return enfNombre;
    }

    public void setEnfNombre(String enfNombre) {
        this.enfNombre = enfNombre;
    }

   
    
    
}
