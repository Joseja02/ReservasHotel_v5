package org.iesalandalus.programacion.reservashotel;


import org.iesalandalus.programacion.reservashotel.controlador.Controlador;
import org.iesalandalus.programacion.reservashotel.modelo.FactoriaFuenteDatos;
import org.iesalandalus.programacion.reservashotel.modelo.IModelo;
import org.iesalandalus.programacion.reservashotel.modelo.Modelo;
import org.iesalandalus.programacion.reservashotel.vista.texto.VistaTexto;

public class MainApp {
    public static void main(String[] args) {

        VistaTexto vista = new VistaTexto();
        IModelo modelo = procesarArgumentosFuenteDatos(args[0]);
        Controlador controlador = new Controlador(modelo, vista);
        controlador.comenzar();
    }

    private static IModelo procesarArgumentosFuenteDatos(String args){
        IModelo modelo = new Modelo(FactoriaFuenteDatos.MEMORIA);
        if (args.equals("-fdmemoria")){
            modelo = new Modelo(FactoriaFuenteDatos.MEMORIA);
        }
        if (args.equals("-fdmongodb")){
            modelo = new Modelo(FactoriaFuenteDatos.MONGODB);
        }
        return modelo;
    }
}
