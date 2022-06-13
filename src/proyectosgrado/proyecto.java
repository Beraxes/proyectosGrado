/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectosgrado;

/**
 *
 * @author beraxes
 */
public class proyecto {
    private int codigo;
    private String titulo;
    private String autores;
    private String fechaRegistro;
    public proyecto enlace;
    
    public proyecto(){
        codigo = 0;
        titulo = "";
        autores = "";
        fechaRegistro = "";
        enlace = null;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutores() {
        return autores;
    }

    public void setAutores(String autores) {
        this.autores = autores;
    }

    public String getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(String fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public proyecto getEnlace() {
        return enlace;
    }

    public void setEnlace(proyecto enlace) {
        this.enlace = enlace;
    }
    
    
}
