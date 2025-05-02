import java.util.*;

/**
 * Encapsula la lógica para realizar y gestionar préstamos y devoluciones.
 */

public class GestorPrestamo {
    private List<Prestamo> prestamos = new ArrayList<>();
    private GestorLibro gestorLibro;
    private GestorUsuario gestorUsuario;

    public GestorPrestamo(GestorLibro libros, GestorUsuario usuarios) {
        this.gestorLibro = libros;
        this.gestorUsuario = usuarios;
    }

    public void prestarLibro(Scanner scanner) {
        System.out.print("ID del libro: ");
        int idLibro = scanner.nextInt();
        scanner.nextLine();
        System.out.print("ID del usuario: ");
        int idUsuario = scanner.nextInt();
        scanner.nextLine();

        Libro libro = gestorLibro.buscarPorId(idLibro);
        Usuario usuario = gestorUsuario.buscarPorId(idUsuario);

        if (libro == null || usuario == null || !libro.isDisponible()) {
            System.out.println("Error en préstamo.");
            return;
        }

        long activos = prestamos.stream()
            .filter(p -> p.getIdUsuario() == idUsuario && !p.isDevuelto())
            .count();

        if (activos >= usuario.getLimitePrestamos()) {
            System.out.println("El usuario ha alcanzado el límite de préstamos.");
            return;
        }

        Prestamo p = new Prestamo(prestamos.size() + 1, idLibro, idUsuario, new Date());
        prestamos.add(p);
        libro.setDisponible(false);
        System.out.println("Préstamo realizado.");
    }

    public void devolverLibro(Scanner scanner) {
        System.out.print("ID del libro: ");
        int idLibro = scanner.nextInt();
        scanner.nextLine();

        for (Prestamo p : prestamos) {
            if (p.getIdLibro() == idLibro && !p.isDevuelto()) {
                p.setDevuelto(true);
                p.setFechaDevolucion(new Date());
                Libro libro = gestorLibro.buscarPorId(idLibro);
                if (libro != null) libro.setDisponible(true);
                System.out.println("Libro devuelto.");
                return;
            }
        }
        System.out.println("No se encontró préstamo activo para ese libro.");
    }

    public void mostrarPrestamosActivos() {
        for (Prestamo p : prestamos) {
            if (!p.isDevuelto()) {
                Libro libro = gestorLibro.buscarPorId(p.getIdLibro());
                Usuario usuario = gestorUsuario.buscarPorId(p.getIdUsuario());
                System.out.println("ID: " + p.getId() + " | Libro: " + libro.getTitulo() + " | Usuario: " + usuario.getNombre());
            }
        }
    }
}