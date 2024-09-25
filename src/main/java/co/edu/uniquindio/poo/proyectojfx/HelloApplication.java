package co.edu.uniquindio.poo.proyectojfx;

import co.edu.uniquindio.poo.proyectojfx.Modelo.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;

public class HelloApplication extends Application {

    private static final int WIDTH = 1100;   // Ancho estándar
    private static final int HEIGHT = 700;   // Alto estándar
    private static Club club;

    @Override
    public void start(Stage stage) throws Exception {
        // Inicializar el club con los datos quemados (sin sesiones)
        club = DatosIniciales.crearClubConDatosIniciales(); // Crea el club sin sesiones
        ClubManager.setClubInstance(club);

        // Cargar sesiones de entrenamiento desde archivo
        try {
            List<SesionEntrenamiento> sesiones = Utilities.getInstance().deserializarSesiones("C://Reportes_Java/" + "sesiones.dat");
            // Asumimos que hay un método en Club para establecer sesiones
            club.setSesionesEntrenamiento(sesiones);
            Utilities.getInstance().logInfo("Sesiones de entrenamiento cargadas correctamente.");
        } catch (IOException | ClassNotFoundException e) {
            Utilities.getInstance().logSevere("Error al cargar sesiones de entrenamiento: " + e.getMessage());
        }
        try {
            List<Entrenador> entrenadoresDeserializados = Utilities.getInstance().deserializarEntrenadoresXML("C://Reportes_Java/" + "entrenadores.xml");
            club.setEntrenadores(entrenadoresDeserializados); // Asegúrate de tener un método en Club para establecer entrenadores
            Utilities.getInstance().logInfo("Entrenadores cargados correctamente.");
        } catch (IOException e) {
            Utilities.getInstance().logSevere("Error al cargar entrenadores: " + e.getMessage());
        }

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
        Utilities.getInstance().logInfo("La aplicación se ha cerrado.");
        // Guardar los datos del club en archivos cuando la aplicación se cierra
        try {
            // Guardar la lista de miembros
            Utilities.getInstance().generarArchivoMiembros(club.getMiembros());
            // Guardar la lista de deportes
            Utilities.getInstance().generarArchivoDeportes(club.getDeportes());
            // Guardar la lista de sesiones
            List<SesionEntrenamiento> sesiones = club.getSesiones(); // Método para obtener sesiones
            Utilities.getInstance().generarArchivoSesiones(sesiones);
            // Log para indicar que los archivos se guardaron correctamente
            Utilities.getInstance().logInfo("Datos del club guardados correctamente.");
        } catch (Exception e) {
            // En caso de error, registrar un log de error
            Utilities.getInstance().logSevere("Error al guardar los datos del club: " + e.getMessage());
        }
        try {
            Utilities.getInstance().generarArchivoEntrenadores(club.getEntrenadores());
            Utilities.getInstance().logInfo("Datos del entrenador guardados correctamente.");
        } catch (Exception e) {
            Utilities.getInstance().logSevere("Error al guardar los datos del entrenador: " + e.getMessage());
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

    // Método para obtener todas las sesiones de entrenamiento
    private List<SesionEntrenamiento> obtenerSesionesEntrenamiento() {
        // Suponiendo que tu club tiene un método para obtener todas las sesiones
        return club.getSesiones();
    }
}
