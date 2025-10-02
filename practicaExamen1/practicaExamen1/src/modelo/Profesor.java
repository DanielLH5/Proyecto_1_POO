package modelo;

import java.util.Objects;

public class Profesor {
    private int id;
    private String nombre;

    public Profesor(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
        Profesor profesor = (Profesor) o;
        return getId() == profesor.getId() ;
    }

    @Override
    public String toString() {
        return "Profesor: Id=" + id +", Nombre=" + nombre + "\n";
    }
}
