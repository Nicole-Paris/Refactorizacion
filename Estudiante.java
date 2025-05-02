public class Estudiante extends Usuario {
    public Estudiante(int id, String nombre, String email, String telefono) {
        super(id, nombre, email, telefono);
    }

    @Override
    public int getLimitePrestamos() {
        return 3;
    }
}