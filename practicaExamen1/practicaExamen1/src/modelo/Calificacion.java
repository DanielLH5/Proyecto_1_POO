package modelo;

public class Calificacion {
    Estudiante datosEstudiante;
    Evaluacion datosEvaluacion;
    double nota;

    public Calificacion(Estudiante datosEstudiante, Evaluacion datosEvaluacion, double nota) {
        this.datosEstudiante = datosEstudiante;
        this.datosEvaluacion = datosEvaluacion;
        this.nota = nota;
    }

    public Estudiante getDatosEstudiante() {
        return datosEstudiante;
    }

    public Calificacion setDatosEstudiante(Estudiante datosEstudiante) {
        this.datosEstudiante = datosEstudiante;
        return this;
    }

    public Evaluacion getDatosEvaluacion() {
        return datosEvaluacion;
    }

    public Calificacion setDatosEvaluacion(Evaluacion datosEvaluacion) {
        this.datosEvaluacion = datosEvaluacion;
        return this;
    }

    public double getNota() {
        return nota;
    }

    public Calificacion setNota(double nota) {
        this.nota = nota;
        return this;
    }

    @Override
    public String toString() {
        return "Calificacion{" +
                "datosEstudiante=" + datosEstudiante +
                ", datosEvaluacion=" + datosEvaluacion +
                ", nota=" + nota +
                '}';
    }
}
