package co.edu.uniquindio.poo.proyectojfx;

import co.edu.uniquindio.poo.proyectojfx.Modelo.*;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;

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
    @FXML
    private Button AnadirMiembro;
    @FXML
    private Button btnVerEntrenadores;
    @FXML
    private Button btnVerDeportes;
    @FXML
    private Button btnAgregarEnntrenador;
    // Agregar las referencias a los labels
    @FXML
    private Label entrenadorLabel;

    @FXML
    private Label duracionLabel;

    @FXML
    private Label fechaLabel;

    @FXML
    private Label idioma;
    @FXML
    private Label estadoLabel;

    @FXML
    private Label deporteLabel;

    @FXML
    private ComboBox<String> comboIdioma; // ComboBox para seleccionar idioma

    private ObservableList<SesionEntrenamiento> sesionesList = FXCollections.observableArrayList();
    private ObservableList<Deporte> deportesList = FXCollections.observableArrayList();
    private ObservableList<Entrenador> entrenadoresList = FXCollections.observableArrayList();

    private Club club;

    private ResourceBundle bundle;  // Para manejar las traducciones

    @FXML
    public void initialize() {
        // Inicializar las columnas de la tabla
        sesion.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getFechaInicio()));
        fecha.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getFechaInicio()));
        duracion.setCellValueFactory(cellData -> new SimpleDoubleProperty(cellData.getValue().getDuracion()).asObject());
        estado.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getEstado().name()));
        deporte.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getDeporte().toString()));
        entrenador.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getEntrenador().toString()));

        // Inicializar el ComboBox de idiomas
        comboIdioma.getItems().addAll("Español", "English", "Français");
        comboIdioma.setOnAction(event -> cambiarIdioma()); // Cambia el idioma cuando seleccionas uno en el ComboBox

        // Cargar el idioma por defecto (Español)
        cargarIdioma(new Locale("es", "CO"));
    }

    // Método para cambiar el idioma según la selección en el ComboBox
    private void cambiarIdioma() {
        String idiomaSeleccionado = comboIdioma.getValue();

        if ("English".equals(idiomaSeleccionado)) {
            cargarIdioma(new Locale("en", "US"));
        } else if ("Français".equals(idiomaSeleccionado)) {
            cargarIdioma(new Locale("fr", "FR"));
        } else {
            cargarIdioma(new Locale("es", "CO"));
        }
    }

    // Método para cargar el archivo de propiedades correspondiente al idioma seleccionado
    private void cargarIdioma(Locale locale) {
        bundle = ResourceBundle.getBundle("resources/homePage", locale);
        actualizarTextos();
    }

    // Método para actualizar los textos de la interfaz según el idioma cargado
    private void actualizarTextos() {
        idioma.setText(bundle.getString("idioma"));
        entrenadorLabel.setText(bundle.getString("lentrenador"));
        duracionLabel.setText(bundle.getString("lduracion"));
        fechaLabel.setText(bundle.getString("lfecha"));
        estadoLabel.setText(bundle.getString("lestado"));
        deporteLabel.setText(bundle.getString("ldeporte"));
        txtFecha.setPromptText(bundle.getString("fecha"));
        txtDuracion.setPromptText(bundle.getString("duracion"));
        txtEstado.setPromptText(bundle.getString("estado"));
        btnAgregar.setText(bundle.getString("agregar"));
        btnEliminar.setText(bundle.getString("eliminar"));
        btnActualizar.setText(bundle.getString("actualizar"));
        sesion.setText(bundle.getString("sesion"));
        fecha.setText(bundle.getString("fecha"));
        duracion.setText(bundle.getString("duracion"));
        estado.setText(bundle.getString("estado"));
        deporte.setText(bundle.getString("deporte"));
        entrenador.setText(bundle.getString("entrenador"));
        AnadirMiembro.setText(bundle.getString("anadirMiembro"));
        btnAgregarEnntrenador.setText(bundle.getString("anadirEntrenador"));
        btnVerDeportes.setText(bundle.getString("verDeportes"));
        btnVerEntrenadores.setText(bundle.getString("verEntrenadores"));

    }
    public void setClub(Club club) {
        this.club = club;

        // Inicializar las listas
        deportesList.setAll(club.getDeportes());
        entrenadoresList.setAll(club.getEntrenadores());
        sesionesList.setAll(club.getSesiones());

        if (comboDeporte != null) {
            comboDeporte.setItems(deportesList);
        }
        if (comboEntrenador != null) {
            comboEntrenador.setItems(entrenadoresList);
        }
        if (tablaSesiones != null) {
            tablaSesiones.setItems(sesionesList);
        }

        if (!deportesList.isEmpty()) {
            comboDeporte.getSelectionModel().selectFirst();
        }
        if (!entrenadoresList.isEmpty()) {
            comboEntrenador.getSelectionModel().selectFirst();
        }
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
            Utilities.getInstance().logWarning("Sesión con datos inválidos");
        } catch (IllegalArgumentException e) {
            showAlert(Alert.AlertType.ERROR, "Error", "Estado inválido", "El estado ingresado no es válido.");
            Utilities.getInstance().logWarning("Sesión con estado inválido");
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
                Utilities.getInstance().logWarning("Sesión actualizada con datos inválidos");
            } catch (IllegalArgumentException e) {
                showAlert(Alert.AlertType.ERROR, "Error", "Estado inválido", "El estado ingresado no es válido.");
                Utilities.getInstance().logWarning("Sesión actualizada con estado invalido");
            }
        }
    }

    @FXML
    private void mostrarDeportes() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/co/edu/uniquindio/poo/proyectojfx/DeportesView.fxml"));
        Parent root = loader.load();

        DeportesController controller = loader.getController();
        controller.setClub(club);

        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setTitle("Deportes del Club");
        stage.show();
    }
    @FXML
    private void mostrarAgregarEntrenador() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/co/edu/uniquindio/poo/proyectojfx/AgregarEntrenador.fxml"));
        Parent root = loader.load();

        AgregarEntrenadorController controller = loader.getController();
        controller.setClub(club); // Pasar la instancia del Club
        controller.setAdministradorController(this); // Pasar el controlador del administrador

        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setTitle("Agregar Entrenador");
        stage.show();
    }
    public void actualizarComboBoxEntrenadores(Entrenador nuevoEntrenador) {
        comboEntrenador.getItems().add(nuevoEntrenador); // Agrega el nuevo entrenador al ComboBox
        showAlert(Alert.AlertType.INFORMATION, "Entrenador Agregado", "Entrenador agregado con éxito: " + nuevoEntrenador.getNombre(), "");
    }
    @FXML
    private void mostrarEntrenadores() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/co/edu/uniquindio/poo/proyectojfx/EntrenadoresView.fxml"));
        Parent root = loader.load();

        EntrenadoresController controller = loader.getController();
        controller.setClub(club);

        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setTitle("Entrenadores del Club");
        stage.show();
    }

    private void limpiarCampos() {
        txtFecha.clear();
        txtDuracion.clear();
        txtEstado.clear();
        comboDeporte.getSelectionModel().clearSelection();
        comboEntrenador.getSelectionModel().clearSelection();
        if (!deportesList.isEmpty()) {
            comboDeporte.getSelectionModel().selectFirst();
        }
        if (!entrenadoresList.isEmpty()) {
            comboEntrenador.getSelectionModel().selectFirst();
        }
    }

    private void showAlert(Alert.AlertType type, String title, String header, String content) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(content);
        alert.showAndWait();
    }

    public void handleAgregarMiembro() {
        SesionEntrenamiento sesionSeleccionada = tablaSesiones.getSelectionModel().getSelectedItem();

        if (sesionSeleccionada != null) {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("AgregarMiembro.fxml"));
                Parent root = loader.load();

                AgregarMiembroController agregarMiembroController = loader.getController();
                agregarMiembroController.setSesion(sesionSeleccionada);
                agregarMiembroController.setClub(club);  // Pasar la instancia del Club

                Stage stage = new Stage();
                stage.setScene(new Scene(root));
                stage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            // Mostrar una advertencia si no se selecciona ninguna sesión
            System.out.println("Por favor, seleccione una sesión primero.");
            Utilities.getInstance().logWarning("No se seleccionó una sesión");
        }
    }
}