package co.edu.uniquindio.poo.proyectojfx;

import co.edu.uniquindio.poo.proyectojfx.Modelo.*;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class AdministradorController {

    @FXML
    private TableView<SesionEntrenamiento> tablaSesiones;

    @FXML
    private TableColumn<SesionEntrenamiento, String> sesion;

    @FXML
    private TableColumn<SesionEntrenamiento, String> fecha;

    @FXML
    private TableColumn<SesionEntrenamiento, Double> duracion;

    @FXML
    private TableColumn<SesionEntrenamiento, String> estado;

    @FXML
    private TableColumn<SesionEntrenamiento, String> deporte;

    @FXML
    private TableColumn<SesionEntrenamiento, String> entrenador;

    @FXML
    private TextField txtFecha;

    @FXML
    private TextField txtDuracion;

    @FXML
    private TextField txtEstado;

    @FXML
    private ComboBox<Deporte> comboDeporte;

    @FXML
    private ComboBox<Entrenador> comboEntrenador;

    @FXML
    private Button btnAgregar;

    @FXML
    private Button btnEliminar;

    @FXML
    private Button btnActualizar;

    private ObservableList<SesionEntrenamiento> sesionesList = FXCollections.observableArrayList();
    private ObservableList<Deporte> deportesList = FXCollections.observableArrayList();
    private ObservableList<Entrenador> entrenadoresList = FXCollections.observableArrayList();

    private Club club;

    public void setClub(Club club) {
        this.club = club;
        this.deportesList.setAll(club.getDeportes());
        this.entrenadoresList.setAll(club.getEntrenadores());
        this.sesionesList.setAll(club.getSesiones());

        // Imprimir datos para verificar
        System.out.println("Deportes: " + deportesList);
        System.out.println("Entrenadores: " + entrenadoresList);
        System.out.println("Sesiones: " + sesionesList);

        comboDeporte.setItems(deportesList);
        comboEntrenador.setItems(entrenadoresList);
        tablaSesiones.setItems(sesionesList);

        // Seleccionar los primeros elementos por defecto
        comboDeporte.getSelectionModel().selectFirst();
        comboEntrenador.getSelectionModel().selectFirst();
    }


    @FXML
    public void initialize() {
        sesion.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getFechaInicio()));
        fecha.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getFechaInicio()));
        duracion.setCellValueFactory(cellData -> new SimpleDoubleProperty(cellData.getValue().getDuracion()).asObject());
        estado.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getEstado().name()));
        deporte.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getDeporte().toString()));
        entrenador.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getEntrenador().toString()));
    }

    @FXML
    private void agregarSesion() {
        try {
            String fecha = txtFecha.getText();
            double duracion = Double.parseDouble(txtDuracion.getText());
            Estado estado = Estado.valueOf(txtEstado.getText().toUpperCase());
            Deporte deporteSeleccionado = comboDeporte.getValue();
            Entrenador entrenadorSeleccionado = comboEntrenador.getValue();

            SesionEntrenamiento nuevaSesion = new SesionEntrenamiento(fecha, duracion, estado, deporteSeleccionado, entrenadorSeleccionado);
            sesionesList.add(nuevaSesion);
            club.getSesiones().add(nuevaSesion);
            limpiarCampos();
        } catch (NumberFormatException e) {
            showAlert(Alert.AlertType.ERROR, "Error", "Datos inválidos", "Por favor, ingrese valores válidos.");
        } catch (IllegalArgumentException e) {
            showAlert(Alert.AlertType.ERROR, "Error", "Estado inválido", "El estado ingresado no es válido.");
        }
    }

    @FXML
    private void eliminarSesion() {
        SesionEntrenamiento sesionSeleccionada = tablaSesiones.getSelectionModel().getSelectedItem();
        if (sesionSeleccionada != null) {
            sesionesList.remove(sesionSeleccionada);
            club.getSesiones().remove(sesionSeleccionada);
        }
    }

    @FXML
    private void actualizarSesion() {
        SesionEntrenamiento sesionSeleccionada = tablaSesiones.getSelectionModel().getSelectedItem();
        if (sesionSeleccionada != null) {
            try {
                sesionSeleccionada.setFechaInicio(txtFecha.getText());
                sesionSeleccionada.setDuracion(Double.parseDouble(txtDuracion.getText()));
                sesionSeleccionada.setEstado(Estado.valueOf(txtEstado.getText().toUpperCase()));
                sesionSeleccionada.setDeporte(comboDeporte.getValue());
                sesionSeleccionada.setEntrenador(comboEntrenador.getValue());
                tablaSesiones.refresh();
                limpiarCampos();
            } catch (NumberFormatException e) {
                showAlert(Alert.AlertType.ERROR, "Error", "Datos inválidos", "Por favor, ingrese valores válidos.");
            } catch (IllegalArgumentException e) {
                showAlert(Alert.AlertType.ERROR, "Error", "Estado inválido", "El estado ingresado no es válido.");
            }
        }
    }

    private void limpiarCampos() {
        txtFecha.clear();
        txtDuracion.clear();
        txtEstado.clear();
        comboDeporte.getSelectionModel().clearSelection();
        comboEntrenador.getSelectionModel().clearSelection();
        comboDeporte.getSelectionModel().selectFirst();
        comboEntrenador.getSelectionModel().selectFirst();
    }

    private void showAlert(Alert.AlertType type, String title, String header, String content) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(content);
        alert.showAndWait();
    }

}
