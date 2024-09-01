package co.edu.uniquindio.poo.proyectojfx;

import co.edu.uniquindio.poo.proyectojfx.Modelo.ClubManager;
import co.edu.uniquindio.poo.proyectojfx.Modelo.Deporte;
import co.edu.uniquindio.poo.proyectojfx.Modelo.Club;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class DeportesController {

    @FXML
    private TableView<Deporte> tablaDeportes;

    @FXML
    private TableColumn<Deporte, String> nombreColumn;

    @FXML
    private TableColumn<Deporte, String> descripcionColumn;

    @FXML
    private TableColumn<Deporte, String> dificultadColumn;

    private Club club = ClubManager.getClubInstance();

    @FXML
    public void initialize() {
        // Inicializar las columnas de la tabla
        nombreColumn.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        descripcionColumn.setCellValueFactory(new PropertyValueFactory<>("descripcion"));
        dificultadColumn.setCellValueFactory(new PropertyValueFactory<>("dificultad"));
    }

    public void setClub(Club club) {
        this.club = club;
        cargarDeportes();
    }

    private void cargarDeportes() {
        if (club != null) {
            tablaDeportes.getItems().setAll(club.getDeportes());
        }
    }
}
