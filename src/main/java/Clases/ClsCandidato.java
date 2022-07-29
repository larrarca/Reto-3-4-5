/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author larrc0
 */
public class ClsCandidato extends ClsPersona{
    private String partidopolitico;
    private String ciudadorigen;
    private String descripcion;
    private String mensajecampania;
    private String cargo;

    public ClsCandidato(String partidopolitico, String ciudadorigen, String descripcion, String mensajecampania, String cargo,String tipoDocumento, String numeroDocumento, String nombre, String telefono, String email) {
        super(tipoDocumento, numeroDocumento, nombre, telefono, email);
        this.partidopolitico = partidopolitico;
        this.ciudadorigen = ciudadorigen;
        this.descripcion = descripcion;
        this.mensajecampania = mensajecampania;
        this.cargo = cargo;
    }

    public String getPartidopolitico() {
        return partidopolitico;
    }

    public void setPartidopolitico(String partidopolitico) {
        this.partidopolitico = partidopolitico;
    }

    public String getCiudadorigen() {
        return ciudadorigen;
    }

    public void setCiudadorigen(String ciudadorigen) {
        this.ciudadorigen = ciudadorigen;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getMensajecampania() {
        return mensajecampania;
    }

    public void setMensajecampania(String mensajecampania) {
        this.mensajecampania = mensajecampania;
    }
        
    

   
    
}
