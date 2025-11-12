package Caso3;

public class Libro {
    public String titulo;
    public String autor;
    public int paginas;
    public double precio;

    public Libro(String titulo, double precio, String autor, int paginas){
        this.titulo = titulo;
        this.paginas = paginas;
        this.precio = precio;
        this.autor = autor;

    }

    public double getPrecio() {
        return precio;
    }

    public String getAutor() {
        return autor;
    }

    public int getPaginas() {
        return paginas;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setPaginas(int paginas) {
        this.paginas = paginas;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    @Override
    public String toString() {
        // Puedes personalizar esto como quieras
        return "Libro{" +
                "Titulo='" + titulo + '\'' +
                ", precio=" + precio +
                ", paginas='" + paginas + '\'' +
                ", autor= " + autor +
                '}';
    }
}