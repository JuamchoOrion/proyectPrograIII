package co.edu.uniquindio.poo.proyectojfx;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
import co.edu.uniquindio.poo.proyectojfx.Modelo.Club;
import co.edu.uniquindio.poo.proyectojfx.Modelo.ClubManager;

public class LoginAdminController {

    @FXML
    private TextField inputId;

    @FXML
    private TextField inputNombre;

    @FXML
    private Button ingresoLoginAdmin;

    private Club club = ClubManager.getClubInstance(); // Obtén la instancia del Club

    @FXML
    public void initialize() {
        ingresoLoginAdmin.setOnAction(event -> login());
    }

    private void login() {
        //Tomar Inputs
        String nombre = inputNombre.getText();
        String idString = inputId.getText();
//Verificar que no esten vacios
        if (nombre.isEmpty() || idString.isEmpty()) {
            showAlert(AlertType.ERROR, "Campos vacíos", "Por favor, complete todos los campos.");
            return;
        }

        int id;
        try {
            id = Integer.parseInt(idString);
        } catch (NumberFormatException e) {
            showAlert(AlertType.ERROR, "ID inválido", "El ID debe ser un número entero.");
            return;
        }
        //si nombre e id coinciden en la lista de club entonces argar vista de administrador
        if (club.verificarAdministrador(nombre, id)) {
            // Cargar la vista de administrador
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("administrador.fxml"));
                Scene scene = new Scene(loader.load());

                // Obtener el controlador de la vista de administrador y pasarle el Club
                AdministradorController controller = loader.getController();
                controller.setClub(club);

                Stage stage = (Stage) ingresoLoginAdmin.getScene().getWindow();
                stage.setScene(scene);
                stage.show();
            } catch (IOException e) {
                e.printStackTrace();
                showAlert(AlertType.ERROR, "Error de carga", "No se pudo cargar la vista de administrador.");
            }
        } else {
            showAlert(AlertType.ERROR, "Acceso denegado", "El nombre o ID del administrador es incorrecto.");
        }
    }

    private void showAlert(AlertType type, String title, String content) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }
}
