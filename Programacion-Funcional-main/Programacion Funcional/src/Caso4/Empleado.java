package Caso4;

public class Empleado {
    public String nombre;
    public String departamento;
    public double salario;
    public int edad;

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public double getSalario() {
        return salario;
    }

    public int getEdad() {
        return edad;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }
    public Empleado(String nombre, double salario, String departamento, int edad){
        this.nombre = nombre;
        this.departamento = departamento;
        this.salario = salario;
        this.edad = edad;

    }
    @Override
    public String toString() {
        return "Empleado{nombre='" + nombre + "', depto='" + departamento + "', salario=" + salario + ", edad=" + edad + "}";
    }
}

