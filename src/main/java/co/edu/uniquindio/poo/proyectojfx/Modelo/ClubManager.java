package co.edu.uniquindio.poo.proyectojfx.Modelo;

public class ClubManager {

    private static Club clubInstance;

    private ClubManager() {
        // Constructor privado para prevenir la instanciación
    }

    public static Club getClubInstance() {
        if (clubInstance == null) {
            clubInstance = new Club(); // Inicializa con los datos necesarios
        }
        return clubInstance;
    }

    public static void setClubInstance(Club club) {
        clubInstance = club;
    }
}
