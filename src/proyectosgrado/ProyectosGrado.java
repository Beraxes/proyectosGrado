/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proyectosgrado;

import javax.swing.*;

/**
 *
 * @author beraxes
 */
public class ProyectosGrado {

    proyecto inicio;
    proyecto fin;

    public ProyectosGrado() {
        inicio = null;
        fin = null;
    }

    public void montarProyectos() { //con este metodo pido los datos que se guardaran en el proyecto a registrar
        int fecha;
        String titu, aut;        
        titu = JOptionPane.showInputDialog("Ingrese El Titulo Del Proyecto: ");//en cada optionpane se pide un dato
        aut = JOptionPane.showInputDialog("Ingrese Los autores: ");
        fecha = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la fecha de proyecto: "));
        if (inicio == null) {
            inicio = new proyecto();
            inicio.registrarProyecto(1, titu, aut, fecha);
            fin = inicio;
        } else {
            proyecto temp;
            temp = new proyecto();
            if (codigoProyecto() < 100) {
                temp.registrarProyecto(codigoProyecto() + 1, titu, aut, fecha);
            } else {
                JOptionPane.showMessageDialog(null, "No se pueden registrar mas proyectos");
            }
            fin.setEnlace(temp);
            fin = temp;
        }
    }

    public int codigoProyecto() {// con este metodo cuento los proyectos
        proyecto temp;
        temp = inicio;
        int codigoP = 0;
        while (temp != null) {
            codigoP = temp.getCodigo();
            temp = temp.getEnlace();
        }
        return codigoP;
    }

    public void eliminarMayoresA20Años() {// este metodo elimina los proyectos que sean mayores a 20 años
        proyecto temp = inicio, ant = null;
        while (temp != null) {
            if (2022 - temp.getFechaRegistro() > 20) {
                if (temp == inicio) {
                    if (temp == fin) {
                        inicio = null;
                        fin = null;
                        temp = null;
                    } else {
                        ant = temp;
                        inicio = inicio.getEnlace();
                        temp = temp.getEnlace();
                        ant.setEnlace(null);
                    }
                } else if (temp == fin) {
                    fin = ant;
                    fin.setEnlace(null);
                    temp = null;
                } else {
                    ant.setEnlace(temp.getEnlace());
                    temp.setEnlace(null);
                    temp = ant.getEnlace();
                }
            } else {
                ant = temp;
                temp = temp.getEnlace();
            }

        }
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
    }

}
