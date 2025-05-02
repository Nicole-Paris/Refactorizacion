import java.util.Date;

/**
 * Representa un préstamo de un libro a un usuario.
 */

public class Prestamo {
    private int id;
    private int idLibro;
    private int idUsuario;
    private Date fechaPrestamo;
    private Date fechaDevolucion;
    private boolean devuelto;

    /**
     * Crea un nuevo préstamo.
     */

    public Prestamo(int id, int idLibro, int idUsuario, Date fechaPrestamo) {
        this.id = id;
        this.idLibro = idLibro;
        this.idUsuario = idUsuario;
        this.fechaPrestamo = fechaPrestamo;
        this.devuelto = false;
    }

    public int getId() { return id; }
    public int getIdLibro() { return idLibro; }
    public int getIdUsuario() { return idUsuario; }
    public Date getFechaPrestamo() { return fechaPrestamo; }
    public Date getFechaDevolucion() { return fechaDevolucion; }
    public boolean isDevuelto() { return devuelto; }

    public void setFechaDevolucion(Date fecha) { this.fechaDevolucion = fecha; }
    public void setDevuelto(boolean devuelto) { this.devuelto = devuelto; }
}