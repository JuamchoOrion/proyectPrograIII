package co.edu.uniquindio.poo.proyectojfx;

import co.edu.uniquindio.poo.proyectojfx.Modelo.Club;
import co.edu.uniquindio.poo.proyectojfx.Modelo.Entrenador;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class EntrenadoresController {

    @FXML
    private TableView<Entrenador> tablaEntrenadores;
    @FXML
    private TableColumn<Entrenador, String> nombreColumn;
    @FXML
    private TableColumn<Entrenador, String> especialidadColumn;
    @FXML
    private TableColumn<Entrenador, String> idColumn;

    private Club club;

    @FXML
    public void initialize() {
        nombreColumn.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        especialidadColumn.setCellValueFactory(new PropertyValueFactory<>("especialidad"));
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));

        // Cargar datos del club
        cargarEntrenadores();
    }

    public void setClub(Club club) {
        this.club = club;
    }

    private void cargarEntrenadores() {
        if (club != null) {
            tablaEntrenadores.getItems().setAll(club.getEntrenadores());
        }
    }
}
