package Caso1;

public class Alumno {
    public String nombre;
    public double nota;
    public String curso;

    public double getNota() {
        return nota;
    }

    public String getCurso() {
        return curso;
    }

    public String getNombre() {
        return nombre;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Alumno(String nombre, double nota, String curso){
        this.nombre = nombre;
        this.nota = nota;
        this.curso = curso;

    }

}
