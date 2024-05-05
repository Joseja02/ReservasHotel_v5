package org.iesalandalus.programacion.reservashotel.vista.texto;

import org.iesalandalus.programacion.reservashotel.modelo.dominio.*;
import org.iesalandalus.programacion.utilidades.Entrada;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import static org.iesalandalus.programacion.reservashotel.modelo.dominio.Reserva.FORMATO_FECHA_RESERVA;

public final class Consola {
    public Consola() {
    }

    public static void mostrarMenu() {
        System.out.println("");
        System.out.println(" | ------- Programa reservas del hotel IES Al-�ndalus (hecho por Jos� Javier Sierra) ------- |");
        for (Opcion opcion : Opcion.values()) {
            System.out.println(opcion.toString());
        }
        System.out.println("| ------------------------------------------------------------------------- |");
    }

    public static Opcion elegirOpcion() {
        try {
            Opcion opcion;
            System.out.println("");
            System.out.print("Elige una opci�n: ");
            opcion = Opcion.values()[Entrada.entero()];
            return opcion;
        } catch (Exception e) {
            System.out.print("ERROR: Has introducido una opci�n fuera de rango. Selecciona una de las opciones mostradas arriba: ");
            return elegirOpcion();
        }
    }

    public static Huesped leerHuesped() {
        Huesped huesped;
        String nombre;
        String telefono;
        String correo;
        String dni;
        LocalDate fechaNacimiento;
        System.out.print("Introduzca DNI del Huesped: ");
        dni = Entrada.cadena();
        System.out.print("Introduzca nombre del Huesped: ");
        nombre = Entrada.cadena();
        System.out.print("Introduzca tel�fono del Huesped: ");
        telefono = Entrada.cadena();
        System.out.print("Introduzca email del Huesped: ");
        correo = Entrada.cadena();
        System.out.print("Introduzca fecha de nacimiento del Huesped (Formato fecha: " + FORMATO_FECHA_RESERVA + ")");
        fechaNacimiento = LocalDate.parse(Entrada.cadena(), DateTimeFormatter.ofPattern(FORMATO_FECHA_RESERVA));

        huesped = new Huesped(nombre, dni, correo, telefono, fechaNacimiento);
        return huesped;
    }

    public static Huesped leerHuespedPorDni() {
        Huesped huesped;
        String dni;
        System.out.print("Introduzca DNI del Huesped: ");
        dni = Entrada.cadena();

        huesped = new Huesped("Nombre Ficticio", dni, "ficticio@test.com", "123456789", LocalDate.of(2002, 8, 19));

        return huesped;
    }

    public static LocalDate leerFecha(String mensaje) {
        try {
            System.out.print(mensaje);
            return LocalDate.parse(Entrada.cadena(), DateTimeFormatter.ofPattern(FORMATO_FECHA_RESERVA));
        } catch (DateTimeParseException e) {
            System.out.println("El formato de fecha introducido no es v�lido.");
            return leerFecha(mensaje);
        }
    }

    public static Habitacion leerHabitacion() {
        Habitacion habitacion = null;
        int planta;
        int puerta;
        double precio;
        TipoHabitacion tipoHabitacion;

        System.out.print("Introduzca planta de habitaci�n: ");
        planta = Entrada.entero();
        System.out.print("Introduzca puerta de habitaci�n: ");
        puerta = Entrada.entero();
        System.out.print("Introduzca precio de habitaci�n: ");
        precio = Double.parseDouble(Entrada.cadena());
        System.out.print("Introduzca tipo de habitaci�n: ");
        tipoHabitacion = leerTipoHabitacion();

        if (tipoHabitacion.equals(TipoHabitacion.SIMPLE)){
            habitacion =  new Simple(planta, puerta, precio);
        }
        if (tipoHabitacion.equals(TipoHabitacion.DOBLE)){
            int numCamasIndividuales;
            int numCamasDobles;

            System.out.print("Introduzca el n�mero de camas individuales: ");
            numCamasIndividuales = Entrada.entero();
            System.out.print("Introduzca el n�mero de camas dobles: ");
            numCamasDobles = Entrada.entero();

            habitacion = new Doble(planta, puerta, precio, numCamasIndividuales, numCamasDobles);
        }
        if (tipoHabitacion.equals(TipoHabitacion.TRIPLE)){
            int numCamasIndividuales;
            int numCamasDobles;
            int numBanos;

            System.out.print("Introduzca el n�mero de camas individuales: ");
            numCamasIndividuales = Entrada.entero();
            System.out.print("Introduzca el n�mero de camas dobles: ");
            numCamasDobles = Entrada.entero();
            System.out.println("Introduzca el n�mero de ba�os: ");
            numBanos = Entrada.entero();

            habitacion = new Triple(planta, puerta, precio, numBanos, numCamasIndividuales, numCamasDobles);
        }
        if (tipoHabitacion.equals(TipoHabitacion.SUITE)){
            int numBanos;
            boolean tieneJacuzzi = false;

            System.out.println("Introduzca el n�mero de ba�os: ");
            numBanos = Entrada.entero();
            System.out.println("�Tiene esta Suite Jacuzzi?: ");
            System.out.println("(1) Si");
            System.out.println("(2) No");
            int respuesta = Entrada.entero();
            if (respuesta != 1 && respuesta != 2) {
                do {
                    System.out.println("Por favor, escoge entre (1) Si y (2) No");
                    respuesta = Entrada.entero();
                    if (respuesta == 1){
                        tieneJacuzzi = true;
                    }
                    else if (respuesta == 2){
                        tieneJacuzzi = false;
                    }
                } while (respuesta != 1 && respuesta != 2);
            }
            habitacion = new Suite(planta, puerta, precio, numBanos, tieneJacuzzi);
        }
        return habitacion;
    }

    public static Habitacion leerHabitacionPorIdentificador() {
        Habitacion habitacion = null;
        int planta;
        int puerta;
        double precio;
        TipoHabitacion tipoHabitacion;

        System.out.print("Introduzca planta de la habitaci�n: ");
        planta = Entrada.entero();
        System.out.print("Introduzca puerta de la habitaci�n: ");
        puerta = Entrada.entero();
        System.out.print("Introduzca tipo de habitaci�n: ");
        tipoHabitacion = leerTipoHabitacion();

        if (tipoHabitacion.equals(TipoHabitacion.SIMPLE)){
            habitacion = new Simple(planta, puerta, 40);
        }
        if (tipoHabitacion.equals(TipoHabitacion.DOBLE)){
            habitacion = new Doble(planta, puerta, 50, 2, 0);
        }
        if (tipoHabitacion.equals(TipoHabitacion.TRIPLE)){
            habitacion = new Triple(planta, puerta, 60, 1, 3, 0);
        }
        if (tipoHabitacion.equals(TipoHabitacion.SUITE)){
            habitacion = new Suite(planta, puerta, 70, 1, false);
        }
        return habitacion;
    }

    public static TipoHabitacion leerTipoHabitacion() {
        for (TipoHabitacion opcion : TipoHabitacion.values()) {
            System.out.println(opcion);
        }
        System.out.print("Escoja tipo de habitaci�n: ");
        int eleccionHabitacion = Entrada.entero();

        if (eleccionHabitacion < 1 || eleccionHabitacion > TipoHabitacion.values().length-1){
            throw new IllegalArgumentException("ERROR: El tipo de habitaci�n escogido no existe o est� fuera de rango.");
        }
        return TipoHabitacion.values()[eleccionHabitacion];
    }

    public static Regimen leerRegimen() {
        for (Regimen opcion : Regimen.values()) {
            System.out.println(opcion.ordinal() + "  -  " + opcion.toString());
        }
        System.out.print("Escoja tipo de r�gimen: ");
        int eleccionRegimen = Entrada.entero();

        if (eleccionRegimen < 1 || eleccionRegimen > Regimen.values().length-1){
            throw new IllegalArgumentException("ERROR: El tipo de habitaci�n escogido no existe o est� fuera de rango.");
        }
        return Regimen.values()[eleccionRegimen];
    }

    public static Reserva leerReserva() {
        Reserva reserva;
        Huesped huesped;
        Habitacion habitacion;
        Regimen regimen;
        LocalDate fechaInicioReserva;
        LocalDate fechaFinReserva;
        int numeroPersonas;

        System.out.print("Introduzca la fecha inicio de reserva(" + FORMATO_FECHA_RESERVA + "): ");
        fechaInicioReserva = LocalDate.parse(Entrada.cadena(), DateTimeFormatter.ofPattern(FORMATO_FECHA_RESERVA));
        System.out.print("Introduzca la fecha fin de reserva(" + FORMATO_FECHA_RESERVA + "): ");
        fechaFinReserva = LocalDate.parse(Entrada.cadena(), DateTimeFormatter.ofPattern(FORMATO_FECHA_RESERVA));
        System.out.print("Introduzca n�mero de personas: ");
        numeroPersonas = Entrada.entero();

        huesped = leerHuespedPorDni();
        habitacion = leerHabitacionPorIdentificador();
        regimen = leerRegimen();

        reserva = new Reserva(huesped, habitacion, regimen, fechaInicioReserva, fechaFinReserva, numeroPersonas);
        return reserva;
    }

    public static LocalDateTime leerFechaHora(String mensaje) {
        boolean comprobacionFechaErronea;
        do {
            try {
                comprobacionFechaErronea = false;
                System.out.print(mensaje);
                return LocalDateTime.parse(Entrada.cadena(), DateTimeFormatter.ofPattern(FORMATO_FECHA_RESERVA));
            } catch (Exception e) {
                System.out.println("El formato de fecha introducido no es v�lido.");
                comprobacionFechaErronea = true;
            }
        } while (comprobacionFechaErronea == true);
        return leerFechaHora(mensaje);
    }

}
