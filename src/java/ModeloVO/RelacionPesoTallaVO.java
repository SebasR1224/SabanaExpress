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
public class RelacionPesoTallaVO {
    
    private String imcId, imcNombre, imcPrimerValor, imcSegundoValor;

    public RelacionPesoTallaVO() {
    }

    public RelacionPesoTallaVO(String imcId, String imcNombre, String imcPrimerValor, String imcSegundoValor) {
        this.imcId = imcId;
        this.imcNombre = imcNombre;
        this.imcPrimerValor = imcPrimerValor;
        this.imcSegundoValor = imcSegundoValor;
    }

    public String getImcId() {
        return imcId;
    }

    public void setImcId(String imcId) {
        this.imcId = imcId;
    }

    public String getImcNombre() {
        return imcNombre;
    }

    public void setImcNombre(String imcNombre) {
        this.imcNombre = imcNombre;
    }

    public String getImcPrimerValor() {
        return imcPrimerValor;
    }

    public void setImcPrimerValor(String imcPrimerValor) {
        this.imcPrimerValor = imcPrimerValor;
    }

    public String getImcSegundoValor() {
        return imcSegundoValor;
    }

    public void setImcSegundoValor(String imcSegundoValor) {
        this.imcSegundoValor = imcSegundoValor;
    }

    
    
    
    
    
}
