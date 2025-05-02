import java.util.*;

/**
 * Clase encargada de gestionar los libros de la biblioteca.
 */

public class GestorLibro {
    private List<Libro> libros = new ArrayList<>();

    public void agregarLibro(Libro libro) {
        libros.add(libro);
    }

    public Libro buscarPorId(int id) {
        for (Libro l : libros) {
            if (l.getId() == id) return l;
        }
        return null;
    }

    public void registrarLibro(Scanner scanner) {
        System.out.print("ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Título: ");
        String titulo = scanner.nextLine();
        System.out.print("Autor: ");
        String autor = scanner.nextLine();
        System.out.print("Año: ");
        int anio = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Género: ");
        String genero = scanner.nextLine();

        agregarLibro(new LibroFisico(id, titulo, autor, anio, genero));
        System.out.println("Libro registrado.");
    }

    public void buscarPorTitulo(Scanner scanner) {
        System.out.print("Ingrese título: ");
        String termino = scanner.nextLine().toLowerCase();
        for (Libro l : libros) {
            if (l.getTitulo().toLowerCase().contains(termino)) {
                System.out.println(l.getId() + ": " + l.getTitulo() + " - " + l.getAutor() + " [" + (l.isDisponible() ? "Disponible" : "Prestado") + "]");
            }
        }
    }

    public void mostrarLibros() {
        if (libros.isEmpty()) {
            System.out.println("No hay libros registrados.");
            return;
        }
        for (Libro l : libros) {
            System.out.println(l.getId() + ": " + l.getTitulo() + " - " + l.getAutor() + " [" + (l.isDisponible() ? "Disponible" : "Prestado") + "]");
        }
    }
}