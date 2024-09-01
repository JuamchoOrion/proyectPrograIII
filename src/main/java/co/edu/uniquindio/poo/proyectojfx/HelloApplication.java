package co.edu.uniquindio.poo.proyectojfx;

import co.edu.uniquindio.poo.proyectojfx.Modelo.Club;
import co.edu.uniquindio.poo.proyectojfx.Modelo.ClubManager;
import co.edu.uniquindio.poo.proyectojfx.Modelo.DatosIniciales;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import static javafx.application.Application.launch;

public class HelloApplication extends Application {

    public static final int ANCHO_VENTANA = 1300;
    public static final int ALTO_VENTANA = 800;

    private static Club club;

    @Override
    public void start(Stage stage) throws Exception {
        club = DatosIniciales.crearClubConDatosIniciales();
        ClubManager.setClubInstance(club);

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("homePage.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), ANCHO_VENTANA, ALTO_VENTANA);

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