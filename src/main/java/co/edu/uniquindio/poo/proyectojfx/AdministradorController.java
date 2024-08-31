package co.edu.uniquindio.poo.proyectojfx;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.layout.HBox;

public class AdministradorController{

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
    private TableColumn<?, ?> sesion;

}