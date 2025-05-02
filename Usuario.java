/**
 * Representa un usuario de la biblioteca.
 * Puede ser extendido por clases como Estudiante o Profesor.
 */

public abstract class Usuario {
    protected int id;
    protected String nombre;
    protected String email;
    protected String telefono;

    /**
     * Crea un nuevo usuario con los datos especificados.
     */

    public Usuario(int id, String nombre, String email, String telefono) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.telefono = telefono;
    }

    public abstract int getLimitePrestamos();

    public int getId() { return id; }
    public String getNombre() { return nombre; }
    public String getEmail() { return email; }
    public String getTelefono() { return telefono; }
}