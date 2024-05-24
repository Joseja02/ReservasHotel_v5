package org.iesalandalus.programacion.reservashotel.vista.grafica.controladores;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.iesalandalus.programacion.reservashotel.vista.grafica.recursos.LocalizadorRecursos;
import org.iesalandalus.programacion.reservashotel.vista.grafica.utilidades.Dialogos;

import java.io.IOException;

public class ControladorVentanaPrincipal {

    @FXML private Button btnMenuHuespedes;
    @FXML private Button btnMenuHabitaciones;
    @FXML private Button btnMenuReservas;
    @FXML private Button btnSalir;

    @FXML void abrirVentanaHuespedes() {
        FXMLLoader fxmlLoader = new FXMLLoader(LocalizadorRecursos.class.getResource("vistas/ventanaHuespedes.fxml"));
        ControladorVentanaHuespedes c = fxmlLoader.getController();
        try {
            Parent raiz = fxmlLoader.load();

            Scene escena = new Scene(raiz, 1022, 660);
            Stage ventanaHuespedes = new Stage();
            ventanaHuespedes.setScene(escena);
            ventanaHuespedes.initModality(Modality.WINDOW_MODAL);
            ventanaHuespedes.setTitle("Huespedes");
            ventanaHuespedes.setResizable(false);
            ventanaHuespedes.showAndWait();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    @FXML void abrirVentanaHabitaciones() {
        FXMLLoader fxmlLoader = new FXMLLoader(LocalizadorRecursos.class.getResource("vistas/ventanaHabitaciones.fxml"));
        ControladorVentanaHabitaciones c = fxmlLoader.getController();
        try {
            Parent raiz = fxmlLoader.load();

            Scene escena = new Scene(raiz, 800, 600);
            Stage ventanaHuespedes = new Stage();
            ventanaHuespedes.setScene(escena);
            ventanaHuespedes.initModality(Modality.WINDOW_MODAL);
            ventanaHuespedes.setTitle("Habitaciones");
            ventanaHuespedes.setResizable(false);
            ventanaHuespedes.showAndWait();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    @FXML void abrirVentanaReservas() {
        FXMLLoader fxmlLoader = new FXMLLoader(LocalizadorRecursos.class.getResource("vistas/ventanaReservas.fxml"));
        ControladorVentanaReservas c = fxmlLoader.getController();
        try {
            Parent raiz = fxmlLoader.load();

            Scene escena = new Scene(raiz, 800, 600);
            Stage ventanaHuespedes = new Stage();
            ventanaHuespedes.setScene(escena);
            ventanaHuespedes.initModality(Modality.WINDOW_MODAL);
            ventanaHuespedes.setTitle("Reservas");
            ventanaHuespedes.setResizable(false);
            ventanaHuespedes.showAndWait();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    @FXML void salir(ActionEvent event) {
        if (Dialogos.mostrarDialogoConfirmacion("Reservas Hotel v5 - Jose Javier Sierra Berdun", "Estas seguro que quieres salir de la aplicacion"))
        {
            System.exit(0);
        }
        else
            event.consume();
    }
}
