package com.centro;

import com.centro.model.*;
import com.centro.service.*;

import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;
import java.util.Scanner;

public class Main {

    private static final Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
    private static final DateTimeFormatter FORMATO_FECHA = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private static final DateTimeFormatter FORMATO_HORA = DateTimeFormatter.ofPattern("HH:mm");

    private static final DisciplinaService disciplinaService = new DisciplinaService();
    private static final EntrenadorService entrenadorService = new EntrenadorService();
    private static final DeportistaService deportistaService = new DeportistaService();
    private static final EntrenamientoService entrenamientoService = new EntrenamientoService();
    private static final CompetenciaService competenciaService = new CompetenciaService();
    private static final ResultadoService resultadoService = new ResultadoService();

    public static void main(String[] args) {
        System.setOut(new PrintStream(System.out, true, StandardCharsets.UTF_8));
        boolean salir = false;
        while (!salir) {
            mostrarMenuPrincipal();
            int opcion = leerEntero("Seleccione una opción: ");
            switch (opcion) {
                case 1 -> menuDisciplinas();
                case 2 -> menuDeportistas();
                case 3 -> menuEntrenadores();
                case 4 -> menuEntrenamientos();
                case 5 -> menuCompetencias();
                case 6 -> menuResultados();
                case 0 -> {
                    salir = true;
                    System.out.println("¡Hasta luego!");
                }
                default -> System.out.println("Opción inválida.\n");
            }
        }
    }

    // ==================== MENÚ PRINCIPAL ====================

    private static void mostrarMenuPrincipal() {
        System.out.println("=========================================");
        System.out.println(" SISTEMA DE GESTIÓN - CENTRO DE FORMACIÓN");
        System.out.println("=========================================");
        System.out.println("1. Gestionar disciplinas");
        System.out.println("2. Gestionar deportistas");
        System.out.println("3. Gestionar entrenadores");
        System.out.println("4. Programar entrenamientos");
        System.out.println("5. Gestionar competencias");
        System.out.println("6. Registrar resultados");
        System.out.println("0. Salir");
        System.out.println("=========================================");
    }

    // ==================== DISCIPLINAS ====================

    private static void menuDisciplinas() {
        boolean volver = false;
        while (!volver) {
            System.out.println("\n--- DISCIPLINAS ---");
            System.out.println("1. Registrar disciplina");
            System.out.println("2. Listar disciplinas");
            System.out.println("3. Eliminar disciplina");
            System.out.println("0. Volver");
            int opcion = leerEntero("Seleccione una opción: ");
            switch (opcion) {
                case 1 -> {
                    String nombre = leerTexto("Nombre de la disciplina: ");
                    String descripcion = leerTexto("Descripción: ");
                    Disciplina d = disciplinaService.registrar(nombre, descripcion);
                    System.out.println("Disciplina registrada: " + d);
                }
                case 2 -> listarDisciplinas();
                case 3 -> {
                    int id = leerEntero("ID de la disciplina a eliminar: ");
                    System.out.println(disciplinaService.eliminar(id) ? "Eliminada." : "No se encontró esa disciplina.");
                }
                case 0 -> volver = true;
                default -> System.out.println("Opción inválida.");
            }
        }
    }

    private static void listarDisciplinas() {
        if (disciplinaService.listar().isEmpty()) {
            System.out.println("No hay disciplinas registradas.");
            return;
        }
        disciplinaService.listar().forEach(System.out::println);
    }

    // ==================== ENTRENADORES ====================

    private static void menuEntrenadores() {
        boolean volver = false;
        while (!volver) {
            System.out.println("\n--- ENTRENADORES ---");
            System.out.println("1. Registrar entrenador");
            System.out.println("2. Listar entrenadores");
            System.out.println("3. Eliminar entrenador");
            System.out.println("0. Volver");
            int opcion = leerEntero("Seleccione una opción: ");
            switch (opcion) {
                case 1 -> {
                    String nombre = leerTexto("Nombre: ");
                    String apellido = leerTexto("Apellido: ");
                    String especialidad = leerTexto("Especialidad: ");
                    Entrenador e = entrenadorService.registrar(nombre, apellido, especialidad);
                    System.out.println("Entrenador registrado: " + e);
                }
                case 2 -> listarEntrenadores();
                case 3 -> {
                    int id = leerEntero("ID del entrenador a eliminar: ");
                    System.out.println(entrenadorService.eliminar(id) ? "Eliminado." : "No se encontró ese entrenador.");
                }
                case 0 -> volver = true;
                default -> System.out.println("Opción inválida.");
            }
        }
    }

    private static void listarEntrenadores() {
        if (entrenadorService.listar().isEmpty()) {
            System.out.println("No hay entrenadores registrados.");
            return;
        }
        entrenadorService.listar().forEach(System.out::println);
    }

    // ==================== DEPORTISTAS ====================

    private static void menuDeportistas() {
        boolean volver = false;
        while (!volver) {
            System.out.println("\n--- DEPORTISTAS ---");
            System.out.println("1. Registrar deportista");
            System.out.println("2. Listar deportistas");
            System.out.println("3. Inscribir deportista en disciplina");
            System.out.println("4. Eliminar deportista");
            System.out.println("0. Volver");
            int opcion = leerEntero("Seleccione una opción: ");
            switch (opcion) {
                case 1 -> {
                    String nombre = leerTexto("Nombre: ");
                    String apellido = leerTexto("Apellido: ");
                    LocalDate fecha = leerFecha("Fecha de nacimiento (dd/MM/yyyy): ");
                    Deportista d = deportistaService.registrar(nombre, apellido, fecha);
                    System.out.println("Deportista registrado: " + d);
                }
                case 2 -> listarDeportistas();
                case 3 -> inscribirDeportistaEnDisciplina();
                case 4 -> {
                    int id = leerEntero("ID del deportista a eliminar: ");
                    System.out.println(deportistaService.eliminar(id) ? "Eliminado." : "No se encontró ese deportista.");
                }
                case 0 -> volver = true;
                default -> System.out.println("Opción inválida.");
            }
        }
    }

    private static void listarDeportistas() {
        if (deportistaService.listar().isEmpty()) {
            System.out.println("No hay deportistas registrados.");
            return;
        }
        for (Deportista d : deportistaService.listar()) {
            System.out.println(d + " | Disciplinas: " + nombresDisciplinas(d));
        }
    }

    private static String nombresDisciplinas(Deportista d) {
        if (d.getDisciplinas().isEmpty()) return "(ninguna)";
        StringBuilder sb = new StringBuilder();
        for (Disciplina disc : d.getDisciplinas()) {
            sb.append(disc.getNombre()).append(", ");
        }
        return sb.substring(0, sb.length() - 2);
    }

    private static void inscribirDeportistaEnDisciplina() {
        listarDeportistas();
        int idDeportista = leerEntero("ID del deportista: ");
        listarDisciplinas();
        int idDisciplina = leerEntero("ID de la disciplina: ");

        Optional<Disciplina> disciplinaOpt = disciplinaService.buscarPorId(idDisciplina);
        if (disciplinaOpt.isEmpty()) {
            System.out.println("Esa disciplina no existe.");
            return;
        }
        boolean ok = deportistaService.inscribirEnDisciplina(idDeportista, disciplinaOpt.get());
        System.out.println(ok ? "Inscripción realizada." : "No se pudo inscribir (deportista inexistente o ya inscrito).");
    }

    // ==================== ENTRENAMIENTOS ====================

    private static void menuEntrenamientos() {
        boolean volver = false;
        while (!volver) {
            System.out.println("\n--- ENTRENAMIENTOS ---");
            System.out.println("1. Programar entrenamiento");
            System.out.println("2. Listar entrenamientos");
            System.out.println("3. Eliminar entrenamiento");
            System.out.println("0. Volver");
            int opcion = leerEntero("Seleccione una opción: ");
            switch (opcion) {
                case 1 -> programarEntrenamiento();
                case 2 -> listarEntrenamientos();
                case 3 -> {
                    int id = leerEntero("ID del entrenamiento a eliminar: ");
                    System.out.println(entrenamientoService.eliminar(id) ? "Eliminado." : "No se encontró ese entrenamiento.");
                }
                case 0 -> volver = true;
                default -> System.out.println("Opción inválida.");
            }
        }
    }

    private static void programarEntrenamiento() {
        listarDisciplinas();
        int idDisciplina = leerEntero("ID de la disciplina: ");
        Optional<Disciplina> disciplinaOpt = disciplinaService.buscarPorId(idDisciplina);
        if (disciplinaOpt.isEmpty()) {
            System.out.println("Esa disciplina no existe.");
            return;
        }

        listarEntrenadores();
        int idEntrenador = leerEntero("ID del entrenador: ");
        Optional<Entrenador> entrenadorOpt = entrenadorService.buscarPorId(idEntrenador);
        if (entrenadorOpt.isEmpty()) {
            System.out.println("Ese entrenador no existe.");
            return;
        }

        LocalDate fecha = leerFecha("Fecha (dd/MM/yyyy): ");
        LocalTime hora = leerHora("Hora (HH:mm): ");
        String lugar = leerTexto("Lugar: ");

        Entrenamiento entrenamiento = entrenamientoService.programar(
                disciplinaOpt.get(), entrenadorOpt.get(), fecha, hora, lugar);
        System.out.println("Entrenamiento programado: " + entrenamiento);
    }

    private static void listarEntrenamientos() {
        if (entrenamientoService.listar().isEmpty()) {
            System.out.println("No hay entrenamientos programados.");
            return;
        }
        entrenamientoService.listar().forEach(System.out::println);
    }

    // ==================== COMPETENCIAS ====================

    private static void menuCompetencias() {
        boolean volver = false;
        while (!volver) {
            System.out.println("\n--- COMPETENCIAS ---");
            System.out.println("1. Registrar competencia");
            System.out.println("2. Listar competencias");
            System.out.println("3. Eliminar competencia");
            System.out.println("0. Volver");
            int opcion = leerEntero("Seleccione una opción: ");
            switch (opcion) {
                case 1 -> registrarCompetencia();
                case 2 -> listarCompetencias();
                case 3 -> {
                    int id = leerEntero("ID de la competencia a eliminar: ");
                    System.out.println(competenciaService.eliminar(id) ? "Eliminada." : "No se encontró esa competencia.");
                }
                case 0 -> volver = true;
                default -> System.out.println("Opción inválida.");
            }
        }
    }

    private static void registrarCompetencia() {
        String nombre = leerTexto("Nombre de la competencia: ");
        LocalDate fecha = leerFecha("Fecha (dd/MM/yyyy): ");
        String lugar = leerTexto("Lugar: ");

        listarDisciplinas();
        int idDisciplina = leerEntero("ID de la disciplina: ");
        Optional<Disciplina> disciplinaOpt = disciplinaService.buscarPorId(idDisciplina);
        if (disciplinaOpt.isEmpty()) {
            System.out.println("Esa disciplina no existe.");
            return;
        }

        Competencia c = competenciaService.registrar(nombre, fecha, lugar, disciplinaOpt.get());
        System.out.println("Competencia registrada: " + c);
    }

    private static void listarCompetencias() {
        if (competenciaService.listar().isEmpty()) {
            System.out.println("No hay competencias registradas.");
            return;
        }
        competenciaService.listar().forEach(System.out::println);
    }

    // ==================== RESULTADOS ====================

    private static void menuResultados() {
        boolean volver = false;
        while (!volver) {
            System.out.println("\n--- RESULTADOS ---");
            System.out.println("1. Registrar resultado");
            System.out.println("2. Listar resultados");
            System.out.println("3. Eliminar resultado");
            System.out.println("0. Volver");
            int opcion = leerEntero("Seleccione una opción: ");
            switch (opcion) {
                case 1 -> registrarResultado();
                case 2 -> listarResultados();
                case 3 -> {
                    int id = leerEntero("ID del resultado a eliminar: ");
                    System.out.println(resultadoService.eliminar(id) ? "Eliminado." : "No se encontró ese resultado.");
                }
                case 0 -> volver = true;
                default -> System.out.println("Opción inválida.");
            }
        }
    }

    private static void registrarResultado() {
        listarDeportistas();
        int idDeportista = leerEntero("ID del deportista: ");
        Optional<Deportista> deportistaOpt = deportistaService.buscarPorId(idDeportista);
        if (deportistaOpt.isEmpty()) {
            System.out.println("Ese deportista no existe.");
            return;
        }

        listarCompetencias();
        int idCompetencia = leerEntero("ID de la competencia: ");
        Optional<Competencia> competenciaOpt = competenciaService.buscarPorId(idCompetencia);
        if (competenciaOpt.isEmpty()) {
            System.out.println("Esa competencia no existe.");
            return;
        }

        int posicion = leerEntero("Posición obtenida: ");
        String marca = leerTexto("Marca / puntaje (ej: 10.23 seg): ");

        Optional<Resultado> resultadoOpt = resultadoService.registrar(
                deportistaOpt.get(), competenciaOpt.get(), posicion, marca);

        if (resultadoOpt.isPresent()) {
            System.out.println("Resultado registrado: " + resultadoOpt.get());
        } else {
            System.out.println("No se pudo registrar: el deportista no está inscrito en la disciplina de esa competencia.");
        }
    }

    private static void listarResultados() {
        if (resultadoService.listar().isEmpty()) {
            System.out.println("No hay resultados registrados.");
            return;
        }
        resultadoService.listar().forEach(System.out::println);
    }

    // ==================== UTILIDADES DE LECTURA ====================

    private static int leerEntero(String mensaje) {
        while (true) {
            System.out.print(mensaje);
            String linea = scanner.nextLine();
            try {
                return Integer.parseInt(linea.trim());
            } catch (NumberFormatException e) {
                System.out.println("Por favor ingrese un número válido.");
            }
        }
    }

    private static String leerTexto(String mensaje) {
        System.out.print(mensaje);
        return scanner.nextLine().trim();
    }

    private static LocalDate leerFecha(String mensaje) {
        while (true) {
            System.out.print(mensaje);
            String linea = scanner.nextLine().trim();
            try {
                return LocalDate.parse(linea, FORMATO_FECHA);
            } catch (Exception e) {
                System.out.println("Formato inválido. Use dd/MM/yyyy, ej: 15/03/2010");
            }
        }
    }

    private static LocalTime leerHora(String mensaje) {
        while (true) {
            System.out.print(mensaje);
            String linea = scanner.nextLine().trim();
            try {
                return LocalTime.parse(linea, FORMATO_HORA);
            } catch (Exception e) {
                System.out.println("Formato inválido. Use HH:mm, ej: 14:30");
            }
        }
    }
}