package co.edu.uniquindio.poo.proyectojfx;

import co.edu.uniquindio.poo.proyectojfx.Modelo.Club;
import co.edu.uniquindio.poo.proyectojfx.Modelo.SesionEntrenamiento;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.layout.HBox;

//
public class AdministradorController{
    SesionEntrenamientoController sesionEntrenamientoController;
    ObservableList<SesionEntrenamiento> listaSesionEntrenamiento = FXCollections.observableArrayList();
    SesionEntrenamiento sesionEntrenamientoSeleccionada;
    private Club club;
    @FXML
    private Button Actualizar;

    @FXML
    private Button Agregar;

    @FXML
    private HBox Deporte;

    @FXML
    private HBox Duracion;

    @FXML
    private Button Eliminar;

    @FXML
    private HBox Entrenador;

    @FXML
    private HBox Estado;

    @FXML
    private HBox Nombre;

    @FXML
    //clase que tiene ese parametro y String
    private TableColumn<?, ?> deporte;

    @FXML
    private TableColumn<?, ?> duracion;

    @FXML
    private TableColumn<?, ?> entrenador;

    @FXML
    private TableColumn<?, ?> estado;

    @FXML
    private TableColumn<?, ?> fecha;

    @FXML
    private TableColumn<SesionEntrenamiento, String> sesion;
    @FXML
    public void initialize() {
        sesionEntrenamientoController = new SesionEntrenamientoController();
        initView();
    }
    private void initView() {
    }

    public void setClub(Club club){
        this.club = club;
    }

}