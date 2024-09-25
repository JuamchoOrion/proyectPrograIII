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

    private static final int WIDTH = 1100;   // Ancho estándar
    private static final int HEIGHT = 700;   // Alto estándar
    private static Club club;

    @Override
    public void start(Stage stage) throws Exception {
        // Inicializar el club con los datos quemados
        club = DatosIniciales.crearClubConDatosIniciales();
        ClubManager.setClubInstance(club);

        // Cargar el FXML
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("homePage.fxml"));
        Parent root = fxmlLoader.load();

        // Log de inicio de la aplicación
        Utilities.getInstance().logInfo("La aplicación se inició correctamente.");

        // Configurar la escena y mostrar el stage
        Scene scene = new Scene(root, WIDTH, HEIGHT);
        stage.setScene(scene);
        stage.setTitle("JavaDictos");
        stage.show();
    }

    @Override
    public void stop() {
        Utilities.getInstance().logInfo("La aplicacion se ha cerrado. ");
        // Guardar los datos del club en archivos cuando la aplicación se cierra
        try {
            // Guardar la lista de miembros
            Utilities.getInstance().generarArchivoMiembros(club.getMiembros());
            // Guardar la lista de deportes
            Utilities.getInstance().generarArchivoDeportes(club.getDeportes());
            // Log para indicar que los archivos se guardaron correctamente
            Utilities.getInstance().logInfo("Datos del club guardados correctamente.");
        } catch (Exception e) {
            // En caso de error, registrar un log de error
            Utilities.getInstance().logSevere("Error al guardar los datos del club: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        // Lanza la aplicación
        launch();
    }

    // Métodos getter
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
