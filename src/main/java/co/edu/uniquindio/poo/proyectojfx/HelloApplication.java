package co.edu.uniquindio.poo.proyectojfx;

import co.edu.uniquindio.poo.proyectojfx.Modelo.ClubManager;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import co.edu.uniquindio.poo.proyectojfx.Modelo.Club;
import co.edu.uniquindio.poo.proyectojfx.Modelo.DatosIniciales;

public class HelloApplication extends Application {

    private static Club club; // Instancia de Club

    @Override
    public void start(Stage stage) throws Exception {
        // Crear el club con datos iniciales
        club = DatosIniciales.crearClubConDatosIniciales();
        System.out.println("Club creado: " + club); // Imprime el club creado para verificación

        // Configurar el ClubManager con la instancia del Club
        ClubManager.setClubInstance(club);
        System.out.println("ClubManager configurado con el club: " + ClubManager.getClubInstance()); // Verifica la configuración

        // Cargar la vista principal
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("administrador.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1204, 811);

        // Configurar el escenario
        stage.setTitle("Página de inicio");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

    public static Club getClub() {
        return club;
    }
}
