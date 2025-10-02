package modelo;

import java.util.Objects;

public class Estudiante {
    private String carne;
    private String nombre;

    public Estudiante(String carne, String nombre) {
        this.carne = carne;
        this.nombre = nombre;
    }

    public String getCarne() {
        return carne;
    }

    public void setCarne(String carne) {
        this.carne = carne;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Estudiante that = (Estudiante) o;
        return Objects.equals(getCarne(), that.getCarne());
    }

    @Override
    public String toString() {
        return "Estudiante: Carne=" + carne + ", Nombre=" + nombre + "\n";
    }
}
