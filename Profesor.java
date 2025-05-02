public class Profesor extends Usuario {
    public Profesor(int id, String nombre, String email, String telefono) {
        super(id, nombre, email, telefono);
    }

    @Override
    public int getLimitePrestamos() {
        return 5;
    }
}