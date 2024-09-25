package co.edu.uniquindio.poo.proyectojfx;

import co.edu.uniquindio.poo.proyectojfx.Modelo.Club;
import co.edu.uniquindio.poo.proyectojfx.Modelo.ClubManager;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import co.edu.uniquindio.poo.proyectojfx.Modelo.DatosIniciales;

public class HelloApplication extends Application {
    private LoggingExample loggingExample = new LoggingExample();
    private static final int WIDTH = 1100;   // Ancho estándar
    private static final int HEIGHT = 700; // Alto estándar
    private static Club club;

    @Override
    public void start(Stage stage) throws Exception {
        club = DatosIniciales.crearClubConDatosIniciales();
        ClubManager.setClubInstance(club);

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("homePage.fxml"));
        Parent root = fxmlLoader.load();
        loggingExample.logInfo("Se inició la app");

        Scene scene = new Scene(root, WIDTH, HEIGHT);
        stage.setScene(scene);
        stage.setTitle("JavaDictos");
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

    public static Club getClub() {
        return club;
    }

    public static int getWidth() {
        return WIDTH;
    }

    public static int getHeight() {
        return HEIGHT;
    }
}

