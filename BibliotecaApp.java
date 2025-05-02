import java.util.Scanner;

/**
 * Clase principal que muestra el menú e inicia la ejecución del sistema de biblioteca.
 */

public class BibliotecaApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GestorLibro gestorLibros = new GestorLibro();
        GestorUsuario gestorUsuarios = new GestorUsuario();
        GestorPrestamo gestorPrestamos = new GestorPrestamo(gestorLibros, gestorUsuarios);

        // Datos de ejemplo
        gestorLibros.agregarLibro(new LibroFisico(1, "Don Quijote", "Cervantes", 1605, "Ficción"));
        gestorLibros.agregarLibro(new LibroFisico(2, "Cien años de soledad", "García Márquez", 1967, "Novela"));
        gestorLibros.agregarLibro(new LibroFisico(3, "El principito", "Saint-Exupéry", 1943, "Fábula"));

        gestorUsuarios.agregarUsuario(new Estudiante(101, "Jose Camacho", "jantonio@gmail.com", "123456789"));
        gestorUsuarios.agregarUsuario(new Profesor(102, "Patricia Moreno", "patricia@gmail.com", "987654321"));

        boolean salir = false;
        while (!salir) {
            System.out.println("\n--- SISTEMA DE BIBLIOTECA ---");
            System.out.println("1. Registrar nuevo libro");
            System.out.println("2. Registrar nuevo usuario");
            System.out.println("3. Prestar libro");
            System.out.println("4. Devolver libro");
            System.out.println("5. Buscar libros por título");
            System.out.println("6. Ver todos los libros");
            System.out.println("7. Ver todos los usuarios");
            System.out.println("8. Ver préstamos activos");
            System.out.println("9. Salir");
            System.out.print("Seleccione una opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1 -> gestorLibros.registrarLibro(scanner);
                case 2 -> gestorUsuarios.registrarUsuario(scanner);
                case 3 -> gestorPrestamos.prestarLibro(scanner);
                case 4 -> gestorPrestamos.devolverLibro(scanner);
                case 5 -> gestorLibros.buscarPorTitulo(scanner);
                case 6 -> gestorLibros.mostrarLibros();
                case 7 -> gestorUsuarios.mostrarUsuarios();
                case 8 -> gestorPrestamos.mostrarPrestamosActivos();
                case 9 -> {
                    salir = true;
                    System.out.println("Sesión finalizada.");
                }
                default -> System.out.println("Opción no válida.");
            }
        }
    }
}