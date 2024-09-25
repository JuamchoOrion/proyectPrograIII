package co.edu.uniquindio.poo.proyectojfx;

import co.edu.uniquindio.poo.proyectojfx.Modelo.Club;
import co.edu.uniquindio.poo.proyectojfx.Modelo.Miembro;
import co.edu.uniquindio.poo.proyectojfx.Modelo.Joven;
import co.edu.uniquindio.poo.proyectojfx.Modelo.Adulto;
import co.edu.uniquindio.poo.proyectojfx.Modelo.SesionEntrenamiento;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DialogPane;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AgregarMiembroController {

    @FXML
    private ComboBox<String> tipoMiembroComboBox;

    @FXML
    private TextField nombreTextField;

    @FXML
    private TextField correoTextField;

    @FXML
    private TextField idTextField;

    private SesionEntrenamiento sesion;
    private Club club;  // Nueva instancia de Club

    public void setSesion(SesionEntrenamiento sesion) {
        this.sesion = sesion;
    }

    public void setClub(Club club) {  // Método para setear el Club
        this.club = club;
    }

    @FXML
    public void agregarMiembro() {
        String tipoMiembro = tipoMiembroComboBox.getValue();
        String nombre = nombreTextField.getText();
        String correo = correoTextField.getText();
        int id;

        try {
            id = Integer.parseInt(idTextField.getText());
        } catch (NumberFormatException e) {
            showAlert(Alert.AlertType.ERROR, "Error", "ID inválido", "Por favor, ingrese un ID válido.");
            // Usar Singleton para el logging de advertencias
            Utilities.getInstance().logWarning("Miembro creado con ID inválido");
            return; // Salir del método si el ID no es válido
        }

        Miembro miembro;

        if ("Joven".equals(tipoMiembro)) {
            miembro = new Joven(nombre, correo, id);
        } else {
            miembro = new Adulto(nombre, correo, id);
        }

        try {
            // Agregar el miembro al club y a la sesión correspondiente
            club.getMiembros().add(miembro);
            sesion.getDeporte().addMember(miembro);

            // Usar Singleton para el logging de información
            Utilities.getInstance().logInfo("Miembro agregado: " + nombre + " (ID: " + id + ")");

            // Cerrar la ventana después de agregar el miembro
            Stage stage = (Stage) nombreTextField.getScene().getWindow();
            stage.close();
        } catch (IllegalArgumentException e) {
            showAlert(Alert.AlertType.ERROR, "Error", "No se puede agregar miembro", e.getMessage());
            // Usar Singleton para el logging de errores
            Utilities.getInstance().logSevere("El miembro no se pudo agregar: " + e.getMessage());
        }
    }

    private void showAlert(Alert.AlertType type, String title, String header, String content) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(content);
        alert.showAndWait();
    }
}
