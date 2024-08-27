module co.edu.uniquindio.poo.proyectojfx {
    requires javafx.controls;
    requires javafx.fxml;


    opens co.edu.uniquindio.poo.proyectojfx to javafx.fxml;
    exports co.edu.uniquindio.poo.proyectojfx;
}