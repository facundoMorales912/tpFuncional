package Caso2;

public class Producto {
        public String nombre;
        public String categoria;
        public double precio;
        public int stock;

        public double getPrecio() {
            return precio;
        }

        public String getCategoria() {
            return categoria;
        }

        public String getNombre() {
            return nombre;
        }

        public int getStock() {
            return stock;
        }

        public void setCategoria(String categoria) {
            this.categoria = categoria;
        }

        public void setPrecio(double precio) {
            this.precio = precio;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public void setStock(int stock) {
            this.stock = stock;
        }

        public Producto(String nombre, double precio, String categoria, int stock){
            this.nombre = nombre;
            this.categoria = categoria;
            this.precio = precio;
            this.stock = stock;

        }
        @Override
        public String toString() {
            // Puedes personalizar esto como quieras
            return "Producto{" +
                    "nombre='" + nombre + '\'' +
                    ", precio=" + precio +
                    ", categoria='" + categoria + '\'' +
                    '}';
        }
    }


