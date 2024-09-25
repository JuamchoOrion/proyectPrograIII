package co.edu.uniquindio.poo.proyectojfx;

import co.edu.uniquindio.poo.proyectojfx.Modelo.Club;
import co.edu.uniquindio.poo.proyectojfx.Modelo.Deporte;
import co.edu.uniquindio.poo.proyectojfx.Modelo.Entrenador;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AgregarEntrenadorController {

    @FXML
    private TextField txtNombre;

    @FXML
    private ComboBox<Deporte> comboEspecialidad;

    private Club club;
    private AdministradorController administradorController; // Controlador del administrador

    public void setClub(Club club) {
        this.club = club;
        comboEspecialidad.getItems().addAll(club.getDeportes());
    }

    public void setAdministradorController(AdministradorController controller) {
        this.administradorController = controller; // Establece el controlador del administrador
    }

    @FXML
    private void agregarEntrenador() {
        String nombre = txtNombre.getText();
        Deporte especialidad = comboEspecialidad.getValue();
        String id = String.valueOf(System.currentTimeMillis());

        if (nombre.isEmpty() || especialidad == null) {
            showAlert("Por favor complete todos los campos.");
            return;
        }

        Entrenador nuevoEntrenador = new Entrenador(nombre, especialidad, null, id);
        club.getEntrenadores().add(nuevoEntrenador);
        if (administradorController != null) {
            administradorController.actualizarComboBoxEntrenadores(nuevoEntrenador); // Notifica al controlador del administrador
        }
        limpiarCampos();
        cerrarVentana();
    }

    private void limpiarCampos() {
        txtNombre.clear();
        comboEspecialidad.getSelectionModel().clearSelection();
    }

    private void cerrarVentana() {
        Stage stage = (Stage) txtNombre.getScene().getWindow();
        stage.close();
    }

    private void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Advertencia");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
