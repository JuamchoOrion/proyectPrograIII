package co.edu.uniquindio.poo.proyectojfx.Modelo;

public interface GestionMiembros {
    Miembro crearMiembro(String nombre, String direccionCorreo, int id, boolean esJoven);
    Miembro actualizarMiembro(Miembro miembro, String nombre, String direccionCorero, int id);
    void eliminarMiembro(Club club, Miembro miembro);
    String mostrarMiembro(Miembro miembro);

}