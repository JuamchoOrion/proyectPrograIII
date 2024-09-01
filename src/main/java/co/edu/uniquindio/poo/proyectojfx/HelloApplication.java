package co.edu.uniquindio.poo.proyectojfx;

import co.edu.uniquindio.poo.proyectojfx.Modelo.Club;
import co.edu.uniquindio.poo.proyectojfx.Modelo.ClubManager;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import co.edu.uniquindio.poo.proyectojfx.Modelo.DatosIniciales;

public class HelloApplication extends Application {

    private static Club club;

    @Override
    public void start(Stage stage) throws Exception {
        club = DatosIniciales.crearClubConDatosIniciales();
        ClubManager.setClubInstance(club);

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("homePage.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);

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
