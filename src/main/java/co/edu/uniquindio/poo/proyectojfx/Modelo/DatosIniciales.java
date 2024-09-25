package co.edu.uniquindio.poo.proyectojfx.Modelo;

import java.util.ArrayList;
import java.util.List;

public class DatosIniciales {

    public static Club crearClubConDatosIniciales() {
        List<Miembro> miembros = new ArrayList<>();
        // Miembros existentes
        miembros.add(new Joven("Juan", "juan@", 1234));
        miembros.add(new Adulto("David", "david.com", 5678));
        miembros.add(new Joven("Lala", "la@", 1234));
        miembros.add(new Adulto("Ana", "ana@example.com", 9101));

        // 7 miembros adicionales
        miembros.add(new Joven("Carlos", "carlos@domain.com", 1235));
        miembros.add(new Adulto("Marta", "marta@domain.com", 5679));
        miembros.add(new Joven("Lucia", "lucia@domain.com", 1111));
        miembros.add(new Adulto("Andrea", "andrea@domain.com", 4321));
        miembros.add(new Joven("Sofia", "sofia@domain.com", 2222));
        miembros.add(new Adulto("Fernando", "fernando@domain.com", 8765));
        miembros.add(new Joven("Lucas", "lucas@domain.com", 3333));

        List<Deporte> deportes = new ArrayList<>();
        // Deportes existentes
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

        // 7 deportes adicionales
        Deporte d6 = new Deporte("Basketball", "balón", Dificultad.MEDIO);
        deportes.add(d6);
        Deporte d7 = new Deporte("Tenis", "raqueta", Dificultad.BAJO);
        deportes.add(d7);
        Deporte d8 = new Deporte("Atletismo", "pista", Dificultad.MEDIO);
        deportes.add(d8);
        Deporte d9 = new Deporte("Gimnasia", "cuerpo", Dificultad.ALTO);
        deportes.add(d9);
        Deporte d10 = new Deporte("Esgrima", "espada", Dificultad.ALTO);
        deportes.add(d10);
        Deporte d11 = new Deporte("Patinaje", "patines", Dificultad.BAJO);
        deportes.add(d11);
        Deporte d12 = new Deporte("Escalada", "equipamiento", Dificultad.ALTO);
        deportes.add(d12);

        List<Entrenador> entrenadores = new ArrayList<>();
        // Entrenadores existentes
        Entrenador e1 = new Entrenador("Francisco", "2468");
        entrenadores.add(e1);
        Entrenador e2 = new Entrenador("Gloria", "1357");
        entrenadores.add(e2);
        Entrenador e3 = new Entrenador("Carlos", "9876");
        entrenadores.add(e3);
        Entrenador e4 = new Entrenador("María", "5432");
        entrenadores.add(e4);

        // 7 entrenadores adicionales
        Entrenador e5 = new Entrenador("Luis", "1111");
        entrenadores.add(e5);
        Entrenador e6 = new Entrenador("Gabriela", "2222");
        entrenadores.add(e6);
        Entrenador e7 = new Entrenador("Santiago", "3333");
        entrenadores.add(e7);
        Entrenador e8 = new Entrenador("Valeria", "4444");
        entrenadores.add(e8);
        Entrenador e9 = new Entrenador("Mateo", "5555");
        entrenadores.add(e9);
        Entrenador e10 = new Entrenador("Isabela", "6666");
        entrenadores.add(e10);
        Entrenador e11 = new Entrenador("Juan", "7777");
        entrenadores.add(e11);

        List<SesionEntrenamiento> sesiones = new ArrayList<>();
        // Sesiones existentes
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

        // 7 sesiones adicionales
        SesionEntrenamiento s6 = new SesionEntrenamiento("septiembre 6", 60, Estado.PROGRAMADA, d6, e5);
        sesiones.add(s6);
        SesionEntrenamiento s7 = new SesionEntrenamiento("septiembre 7", 60, Estado.PROGRAMADA, d7, e6);
        sesiones.add(s7);
        SesionEntrenamiento s8 = new SesionEntrenamiento("septiembre 8", 60, Estado.PROGRAMADA, d8, e7);
        sesiones.add(s8);
        SesionEntrenamiento s9 = new SesionEntrenamiento("septiembre 9", 60, Estado.PROGRAMADA, d9, e8);
        sesiones.add(s9);
        SesionEntrenamiento s10 = new SesionEntrenamiento("septiembre 10", 60, Estado.PROGRAMADA, d10, e9);
        sesiones.add(s10);
        SesionEntrenamiento s11 = new SesionEntrenamiento("septiembre 11", 60, Estado.PROGRAMADA, d11, e10);
        sesiones.add(s11);
        SesionEntrenamiento s12 = new SesionEntrenamiento("septiembre 12", 60, Estado.PROGRAMADA, d12, e11);
        sesiones.add(s12);

        List<Administrador> administrativos = new ArrayList<>();
        // Administradores existentes
        Administrador a1 = new Administrador("Pedro", 2789);
        administrativos.add(a1);
        Administrador a2 = new Administrador("Laura", 8888);
        administrativos.add(a2);
        Administrador a3 = new Administrador("Roberto", 1234);
        administrativos.add(a3);

        // 7 administradores adicionales
        Administrador a4 = new Administrador("Pablo", 9999);
        administrativos.add(a4);
        Administrador a5 = new Administrador("Juliana", 4321);
        administrativos.add(a5);
        Administrador a6 = new Administrador("Samuel", 5555);
        administrativos.add(a6);
        Administrador a7 = new Administrador("Camila", 6666);
        administrativos.add(a7);
        Administrador a8 = new Administrador("Esteban", 7777);
        administrativos.add(a8);
        Administrador a9 = new Administrador("Natalia", 1111);
        administrativos.add(a9);
        Administrador a10 = new Administrador("Andres", 2222);
        administrativos.add(a10);

        // Crear el club con todos los elementos
        Club club = new Club(sesiones, "Club Deportivo", miembros, entrenadores, deportes, administrativos);
        club.setEntrenadores(entrenadores);
        club.setDeportes(deportes);
        club.setAdministrativos(administrativos);
        club.setSesiones(sesiones);
        club.setMiembros(miembros);
        club.setNombre("JavaDictos");

        // Añadir miembros a las sesiones
        d1.addMember(new Joven("jhon", "juan@", 1234)); // Deporte de dificultad MEDIO
        d2.addMember(new Joven("Lala", "la@", 1234)); // Deporte de dificultad MEDIO
        d3.addMember(new Adulto("Pedro", "pedro@example.com", 5678)); // Deporte de dificultad ALTO
        d4.addMember(new Joven("Ana", "ana@example.com", 9101)); // Deporte de dificultad BAJO
        d5.addMember(new Adulto("Luis", "luis@example.com", 1112)); // Deporte de dificultad MEDIO

        return club;
    }
}
