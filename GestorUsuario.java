import java.util.*;

/**
 * Gestiona el registro y recuperación de usuarios.
 */

public class GestorUsuario {
    private List<Usuario> usuarios = new ArrayList<>();

    public void agregarUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }

    public Usuario buscarPorId(int id) {
        for (Usuario u : usuarios) {
            if (u.getId() == id) return u;
        }
        return null;
    }

    public void registrarUsuario(Scanner scanner) {
        System.out.print("ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("Teléfono: ");
        String telefono = scanner.nextLine();

        agregarUsuario(new Estudiante(id, nombre, email, telefono));
        System.out.println("Usuario registrado.");
    }

    public void mostrarUsuarios() {
        for (Usuario u : usuarios) {
            System.out.println(u.getId() + ": " + u.getNombre() + " - " + u.getEmail());
        }
    }
}