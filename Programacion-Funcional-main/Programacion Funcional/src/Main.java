import Caso1.Alumno;
import Caso2.Producto;
import Caso3.Libro;
import Caso4.Empleado;

import java.util.*;
import java.util.stream.Collectors;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
    //CASO PRACTICO 1
       List<Alumno> alumnos = Arrays.asList(
               new Alumno("Benjamin", 9.5, "10B"),
               new Alumno("Martina", 10, "10B"),
               new Alumno("Rodrigo", 5, "5B"),
               new Alumno("Julian", 2, "6B"),
               new Alumno("Juliana", 6.99, "7B"),
               new Alumno("Francisca", 0, "8A"));
    //Punto 1
       List<String> aprobados = alumnos.stream()
               .filter(a -> a.nota >= 7)
               .map(a -> a.nombre.toUpperCase())
               .sorted()
               .collect(Collectors.toList());

       System.out.println("Los alumnos aprobados son:" + aprobados);
    //Punto 2
        double promedioGeneral = alumnos.stream()
                .collect(Collectors.averagingDouble(Alumno::getNota));

        System.out.printf("El promedio general de notas es: %.2f%n", promedioGeneral);

    //Punto 3
        Map<String, List<Alumno>> alumnosPorCurso = alumnos.stream()
                .collect(Collectors.groupingBy(Alumno::getCurso));
        alumnosPorCurso.forEach((curso, lista) -> {
            System.out.println(" Curso: " + curso + " (Total: " + lista.size() + " alumnos)");
            lista.forEach(a -> System.out.println("  - " + a.getNombre() + " (" + a.getNota() + ")"));
        });

    //Punto 4
        List<Alumno> top3Notas = alumnos.stream()
                .sorted(Comparator.comparingDouble(Alumno::getNota).reversed())
                .limit(3)
                .collect(Collectors.toList());

        System.out.println("Los 3 alumnos con las notas más altas son:");
        top3Notas.forEach(a -> System.out.printf(" %s con %.2f%n", a.getNombre(), a.getNota()));

       //CASO PRACTICO 2
        //Punto 1
        List<Producto> productos = Arrays.asList(
                new Producto("Pepsi", 100, "Bebida", 1000),
                new Producto("Coca Cola", 120, "Bebida", 1000),
                new Producto("Lays", 50, "Snacks", 500),
                new Producto("Pringles", 80, "Snacks", 300),
                new Producto("Mayonesa", 20, "Condimentos", 300),
                new Producto("Ketchup", 20, "Condimentos", 230));

        List<Producto> producto = productos.stream()
                //Filtrar productos con precio mayor a 100
                .filter(p -> p.getPrecio() > 100)
                .sorted(Comparator.comparing(Producto::getPrecio).reversed())
                .collect(Collectors.toList());

        producto.forEach(System.out::println);

        //Punto 2
        Map<String, Integer> categoriastock = productos.stream()
                .collect(Collectors.groupingBy(Producto::getCategoria, Collectors.summingInt(Producto::getStock)));
        System.out.println("Stock total por categoria: ");
        categoriastock.forEach((categoria, stocktotal)-> {
            System.out.println(categoria + ": " + stocktotal + " unidades");
        });

        //Punto 3
        String listaProductosString = productos.stream()
                .map(p -> p.getNombre() + ": " + p.getPrecio())
                .collect(Collectors.joining("; "));

        System.out.println(listaProductosString);

        //Punto 4
        double precioPromedioGeneral = productos.stream()
                .collect(Collectors.averagingDouble(Producto::getPrecio));

        System.out.printf("Precio promedio general: $%.2f%n", precioPromedioGeneral);

        Map<String, Double> promedioPorCategoria = productos.stream()
                // GroupingBy: Agrupa los productos por su categoría (clave del Map)
                .collect(Collectors.groupingBy(
                        Producto::getCategoria,
                        // AveragingDouble: Calcula el promedio del precio para cada grupo
                        Collectors.averagingDouble(Producto::getPrecio)
                ));

        System.out.println("\nPrecio promedio por categoría:");
        promedioPorCategoria.forEach((categoria, promedio) ->
                System.out.printf("  %s: $%.2f%n", categoria, promedio)
        );

        //CASO PRACTICO 3
        List<Libro> libros = Arrays.asList(
                new Libro("Sherlock Holmes", 200, "Arthur Conan Doyle", 300),
                new Libro("Iron Man", 500, "Marvel", 300),
                new Libro("Capitan America", 250, "Marvel", 250),
                new Libro("Thor", 600, "Marvel", 600),
                new Libro("Estudio en Escarlata", 300, "Arthur Conan Doyle", 350),
                new Libro("Martin Fierro", 800, "Jose Hernandez", 200));
        //Punto 1
        List<String> libro = libros.stream()
                .filter(l -> l.paginas > 300)
                .map(Libro::getTitulo)
                .sorted(Comparator.naturalOrder())
                .collect(Collectors.toList());
        libro.forEach(titulo -> System.out.println(" Los libros con mas de 300 paginas son:" + titulo));
        //Punto 2
        double promedioPaginas = libros.stream()
                .collect(Collectors.averagingInt(Libro::getPaginas)); // Calcula el promedio de enteros

        System.out.printf("El promedio de páginas es: %.2f%n", promedioPaginas);

        //Punto 3
        Map<String, Long> conteoPorAutor = libros.stream()
                .collect(Collectors.groupingBy(
                        Libro::getAutor,
                        Collectors.counting() // Función para contar elementos en cada grupo
                ));

        conteoPorAutor.forEach((autor, cantidad) ->
                System.out.println(" " + autor + ": " + cantidad + " libro(s)"));

        //Punto 4
        Optional<Libro> libroMasCaro = libros.stream()
                .max(Comparator.comparingDouble(Libro::getPrecio));


        libroMasCaro.ifPresent(librocaro ->
                System.out.println(" El libro más caro es: " + libroMasCaro.get().getTitulo()+ " ($" + libroMasCaro.get().precio + ")")
        );

        //CASO PRACTICO 4

        List<Empleado> empleados = Arrays.asList(
             new Empleado("Juan Perez", 5000, "Front End", 25),
             new Empleado("Rodrigo Sanchez", 6000, "Back End", 22),
             new Empleado("Carina Gonzales", 4000, "Testing", 26),
             new Empleado("Sonia Paez", 6000, "CiberSeguridad", 27),
             new Empleado("Benjamin Saez", 2000, " UX/UI", 21),
             new Empleado("Martina Paredes", 1500, "Diseño grafico", 21),
             new Empleado("Raul Asensio", 4500, "Front End", 28),
             new Empleado("Francisco Alarcon", 2500, "Back End", 20),
             new Empleado("Maria Garcia", 2500, "Testing", 28),
             new Empleado("Cristiano Salvador", 6800, "CiberSeguridad", 30));

        //Punto 1
        List<Empleado> salariosAltos = empleados.stream()
                .filter(e -> e.getSalario() > 2000)
                .sorted(Comparator.comparingDouble(Empleado::getSalario).reversed()) // Orden descendente por salario
                .collect(Collectors.toList());

        salariosAltos.forEach(System.out::println);

        //Punto 2
        double salarioPromedio = empleados.stream()
                .collect(Collectors.averagingDouble(Empleado::getSalario));

        System.out.printf("El salario promedio general es: $%.2f%n", salarioPromedio);

        //Punto 3
        Map<String, Double> sumaSalariosPorDepto = empleados.stream()
                .collect(Collectors.groupingBy(
                        Empleado::getDepartamento,
                        Collectors.summingDouble(Empleado::getSalario)
                ));
        sumaSalariosPorDepto.forEach((depto, suma) ->
                System.out.printf(" %s: $%.2f%n", depto, suma));

        //Punto 4

        List<String> nombresMasJovenes = empleados.stream()
                .sorted(Comparator.comparingInt(Empleado::getEdad)) // Ordena por edad ascendente
                .limit(2)                                            // Toma solo los 2 primeros (los más jóvenes)
                .map(Empleado::getNombre)                            // Transforma el resultado a solo el nombre
                .collect(Collectors.toList());

        System.out.println("Los 2 empleados más jóvenes son: " + nombresMasJovenes);






    }



}