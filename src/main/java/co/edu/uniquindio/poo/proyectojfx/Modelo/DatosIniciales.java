package co.edu.uniquindio.poo.proyectojfx.Modelo;

import java.util.ArrayList;
import java.util.List;

public class DatosIniciales {

    public static Club crearClubConDatosIniciales() {
        List<Miembro> miembros = new ArrayList<>();
        miembros.add(new Joven("Juan", "juan@", 1234));
        miembros.add(new Adulto("David", "david.com", 5678));
        miembros.add(new Joven("Lala", "la@", 1234));
        miembros.add(new Adulto("Ana", "ana@example.com", 9101));

        List<Deporte> deportes = new ArrayList<>();
        Deporte d1 = new Deporte("Voleibol", "balón", Dificultad.MEDIO);
        deportes.add(d1);
        Deporte d2 = new Deporte("Fútbol", "balón", Dificultad.MEDIO);
        deportes.add(d2);
        Deporte d3 = new Deporte("Box", "Cuerpo a cuerpo", Dificultad.ALTO);
        deportes.add(d3);
        Deporte d4 = new Deporte("Natación", "agua", Dificultad.BAJO);
        deportes.add(d4);
        Deporte d5 = new Deporte("Ciclismo", "bici", Dificultad.MEDIO);
        deportes.add(d5);

        List<Entrenador> entrenadores = new ArrayList<>();
        Entrenador e1 = new Entrenador("Francisco", "2468");
        entrenadores.add(e1);
        Entrenador e2 = new Entrenador("Gloria", "1357");
        entrenadores.add(e2);
        Entrenador e3 = new Entrenador("Carlos", "9876");
        entrenadores.add(e3);
        Entrenador e4 = new Entrenador("María", "5432");
        entrenadores.add(e4);

        List<SesionEntrenamiento> sesiones = new ArrayList<>();
        SesionEntrenamiento s1 = new SesionEntrenamiento("septiembre 1", 60, Estado.PROGRAMADA, d1, e1);
        SesionEntrenamiento s2 = new SesionEntrenamiento("septiembre 2", 60, Estado.PROGRAMADA, d2, e2);
        SesionEntrenamiento s3 = new SesionEntrenamiento("septiembre 3", 60, Estado.PROGRAMADA, d3, e3);
        SesionEntrenamiento s4 = new SesionEntrenamiento("septiembre 4", 60, Estado.PROGRAMADA, d4, e4);
        SesionEntrenamiento s5 = new SesionEntrenamiento("septiembre 5", 60, Estado.PROGRAMADA, d5, e1);
        sesiones.add(s1);
        sesiones.add(s2);
        sesiones.add(s3);
        sesiones.add(s4);
        sesiones.add(s5);

        List<Administrador> administrativos = new ArrayList<>();
        Administrador a1 = new Administrador("Pedro", 2789);
        administrativos.add(a1);
        Administrador a2 = new Administrador("Laura", 8888);
        administrativos.add(a2);
        Administrador a3 = new Administrador("Roberto", 1234);
        administrativos.add(a3);

        Club club = new Club(sesiones, "Club Deportivo", miembros, entrenadores, deportes, administrativos);
        club.setEntrenadores(entrenadores);
        club.setDeportes(deportes);
        club.setAdministrativos(administrativos);
        club.setSesiones(sesiones);
        club.setMiembros(miembros);
        club.setNombre("JavaDictos");

        // Añadir miembros a las sesiones teniendo en cuenta la dificultad del deporte
        d1.addMember(new Joven("jhon", "juan@", 1234)); // Deporte de dificultad MEDIO
        d2.addMember(new Joven("Lala", "la@", 1234)); // Deporte de dificultad MEDIO
        d3.addMember(new Adulto("Pedro", "pedro@example.com", 5678)); // Deporte de dificultad ALTO
        d4.addMember(new Joven("Ana", "ana@example.com", 9101)); // Deporte de dificultad BAJO
        d5.addMember(new Adulto("Luis", "luis@example.com", 1112)); // Deporte de dificultad MEDIO

        return club;
    }
}


