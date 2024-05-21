package org.iesalandalus.programacion.reservashotel.vista.grafica;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import org.iesalandalus.programacion.reservashotel.vista.grafica.recursos.LocalizadorRecursos;

public class LanzadorVentanaPrincipal extends Application {

    public void comenzar() throws Exception {
        Stage escenario = new Stage();
        start(escenario);
    }
    @Override
    public void start(Stage escenarioPrincipal) throws Exception {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(LocalizadorRecursos.class.getResource("vistas/ventanaPrincipal.fxml"));
            Parent raiz=fxmlLoader.load();
            Scene escena = new Scene(raiz, 600, 800);
            escenarioPrincipal.setTitle("Reservas Hotel v5 - Jose Javier Sierra Berdún");
            escenarioPrincipal.setScene(escena);
            escenarioPrincipal.setOnCloseRequest(e->confirmarSalida(escenarioPrincipal,e));
            escenarioPrincipal.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    private void confirmarSalida(Stage escenarioPrincipal, WindowEvent e){
        if (Dialogos.mostrarDialogoConfirmacion("Reservas Hotel v5 - Jose Javier Sierra Berdún", "Estas seguro que quieres salirte de la aplicacion"))
        {
            escenarioPrincipal.close();
        }
        else
            e.consume();
    }
}
