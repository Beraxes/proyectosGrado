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

    public int contar() {
        proyecto temp;
        temp = inicio;
        int contador = 0;
        while (temp != null) {
            contador++;
            temp = temp.getEnlace();
        }
        return contador;
    }

    public void consultarDatos() {
        int co = 0;
        proyecto temp;
        temp = inicio;
        co = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el Codigo del Proyecto a buscar"));
        while (temp != null) {
            if (temp.getCodigo() != co) {
                temp = temp.getEnlace();
            } else if (temp.getCodigo() == co) {
                temp.mostrarDatos();
                break;
            } else {
                JOptionPane.showMessageDialog(null, "El Proyecto Con codigo " + co + "no se encontro");
                break;
            }

        }
    }
    
    public int aleatorio(){
        int min =1,max = 100;       
        int Aleatiorio = (int)Math.floor(Math.random()*(max-min+1)+min);
        return Aleatiorio;
    }

    public void mostrarLista() {
        proyecto temp;
        temp = inicio;
        while (temp != null) {
            temp.mostrarDatos();
            temp = temp.getEnlace();

        }
    }

    public static void main(String[] args) {
        int opcion;
        ProyectosGrado objetoListaProyecto;
        objetoListaProyecto = new ProyectosGrado();
        opcion = Integer.parseInt(JOptionPane.showInputDialog("Opcion 1. Crear O anexar Proyecto \n Opcion 2 Listar Proyectos \n Opcion 3 Eliminar Proyectos Mayores a 20 Años \n Opcion 4 Buscar Proyecto Por Codigo \n Opcion 5 Salir"));
        do {
            if (opcion == 1) {
                objetoListaProyecto.montarProyectos();

            } else if (opcion == 2) {
                objetoListaProyecto.mostrarLista();

            } else if (opcion == 3) {
                objetoListaProyecto.eliminarMayoresA20Años();
            } else if (opcion == 4) {
                objetoListaProyecto.consultarDatos();
            } else {
                System.exit(0);
            }
            opcion = Integer.parseInt(JOptionPane.showInputDialog("Opcion 1. Crear O anexar Proyecto \n Opcion 2 Listar Proyectos \n Opcion 3 Eliminar Proyectos Mayores a 20 Años \n Opcion 4 Buscar Proyecto Por Codigo"));

        } while (opcion < 5);
    }

}
