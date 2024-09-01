package co.edu.uniquindio.poo.proyectojfx;

import co.edu.uniquindio.poo.proyectojfx.Modelo.Club;
import co.edu.uniquindio.poo.proyectojfx.Modelo.ClubManager;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ToolBar;
import javafx.stage.Stage;

import java.io.IOException;

public class HomePageController {

    @FXML
    private Button AdministradorButton;
    // ID del botón en homePage.fxml
    @FXML
    private ToolBar Entrenador;

    @FXML
    private Button EntrenadorButton;

    @FXML
    private ToolBar Miembro;

    @FXML
    private Button MiembroButton;
    @FXML
    public void initialize() {
        AdministradorButton.setOnAction(event -> cambiarVista("loginAdmin.fxml"));
    }

    private void cambiarVista(String fxml) {
        try {
            // Cargar la nueva vista
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxml));
            Parent root = loader.load();

            // Obtener el escenario actual
            Stage stage = (Stage) AdministradorButton.getScene().getWindow();

            // Establecer el tamaño de la nueva escena
            Scene scene = new Scene(root, HelloApplication.getWidth(), HelloApplication.getHeight());
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
