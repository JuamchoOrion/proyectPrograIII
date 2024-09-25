module co.edu.uniquindio.poo.proyectojfx {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.logging;
    requires jdk.jshell;
    requires java.desktop;

    opens co.edu.uniquindio.poo.proyectojfx to javafx.fxml;
    exports co.edu.uniquindio.poo.proyectojfx;
    exports co.edu.uniquindio.poo.proyectojfx.Modelo;

}