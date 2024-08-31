package co.edu.uniquindio.poo.proyectojfx;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class HomePageController {

    @FXML
    private Button AdministradorButton; // ID del botón en homePage.fxml

    @FXML
    public void initialize() {
        AdministradorButton.setOnAction(event -> cambiarVista("loginAdmin.fxml"));
    }

    private void cambiarVista(String fxml) {
        try {
            // Cargar la nueva vista
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxml));
            Parent root = loader.load();

            // Obtener el escenario actual y cambiar la escena
            Stage stage = (Stage) AdministradorButton.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
