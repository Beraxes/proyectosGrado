/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proyectosgrado;

import javax.swing.JOptionPane;

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

    public void montarProyectos() {
        int cod;
        String titu, aut, fecha;
        cod = 0;
        titu = JOptionPane.showInputDialog("Ingrese El Titulo Del Proyecto: ");
        aut = JOptionPane.showInputDialog("Ingrese Los autores: ");
        fecha = JOptionPane.showInputDialog("Ingrese la fecha de proyecto: ");
        if (inicio == null) {
            inicio = new proyecto();
            inicio.registrarProyecto(cod + 1, titu, aut, fecha);
            fin = inicio;
        } else {
            proyecto temp;
            temp = new proyecto();
            if (contarProyectos()< 100) {
                temp.registrarProyecto(contarProyectos() + 1, titu, aut, fecha);
            }else{
                JOptionPane.showMessageDialog(null,"se ha excedido el numero de proyectos que se pueden registrar");
            }
        }
    }

    public int contarProyectos() {
        proyecto temp;
        temp = inicio;
        int contador = 0;
        while (temp != null) {
            contador++;
            temp = temp.getEnlace();
        }
        return contador;
    }

    public static void main(String[] args) {
        // TODO code application logic here
    }

}
