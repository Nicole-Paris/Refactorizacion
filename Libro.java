/**
 * Representa un libro en el sistema de biblioteca.
 */

public abstract class Libro {
    protected int id;
    protected String titulo;
    protected String autor;
    protected int anio;
    protected String genero;
    protected boolean disponible;

    /**
     * Crea un nuevo libro con los atributos proporcionados.
     */

    public Libro(int id, String titulo, String autor, int anio, String genero) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.anio = anio;
        this.genero = genero;
        this.disponible = true;
    }

    public int getId() { return id; }
    public String getTitulo() { return titulo; }
    public String getAutor() { return autor; }
    public String getGenero() { return genero; }
    public int getAnio() { return anio; }
    public boolean isDisponible() { return disponible; }
    public void setDisponible(boolean disponible) { this.disponible = disponible; }
}