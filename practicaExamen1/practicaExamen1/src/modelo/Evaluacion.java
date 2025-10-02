package modelo;

import java.util.Objects;

public class Evaluacion {
    private TEvaluacion tipo;
    private int numero;
    private String descripcion;
    private double porcentaje;

    public Evaluacion(TEvaluacion tipo, int numero, String descripcion, double porcentaje) {
        this.tipo = tipo;
        this.numero = numero;
        this.descripcion = descripcion;
        this.porcentaje = porcentaje;
    }

    public double getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(double porcentaje) {
        this.porcentaje = porcentaje;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public TEvaluacion getTipo() {
        return tipo;
    }

    public void setTipo(TEvaluacion tipo) {
        this.tipo = tipo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Evaluacion that = (Evaluacion) o;
        return getNumero() == that.getNumero() && getTipo() == that.getTipo();
    }

    @Override
    public String toString() {
        return "Evaluacion: Tipo=" + tipo + ", Número=" + numero +", Descripción='" + descripcion +
                ", Porcentaje=" + porcentaje + "\n";
    }
}
