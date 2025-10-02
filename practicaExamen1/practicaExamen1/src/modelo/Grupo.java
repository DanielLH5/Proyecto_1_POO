package modelo;

import java.util.Objects;
import java.util.ArrayList;

public class Grupo {

    // atributos básicos
    private int numero;
    private String horario;
    private String aula;
    private TModalidad modalidad;

    //atributos que son relaciones (estructuralmente lo definen)
    Curso elCurso;               // AGREGACION, solo se registra una declaración de instancia
    Profesor elProfe;               // AGREGACION, solo se registra una declaración de instancia
    private ArrayList<Estudiante> estudiantes; // AGREGACION, solo se registra una declaración de instancia

    // atributo que representa la COMPOSICION de la evaluación (estructuralmente la define)
    private ArrayList<Evaluacion> esquemaEvaluacion;

    private ArrayList<Calificacion> registroCalificaciones;

    public Grupo() {
    }

    public Grupo(int numero, String horario, String aula, TModalidad modalidad, Curso elCurso, Profesor elProfesor) {
        this.numero = numero;
        this.horario = horario;
        this.aula = aula;
        this.modalidad = modalidad;
        this.elCurso = elCurso;                         // inicialización de la AGREGACION del curso
        this.elProfe = elProfesor;                      // inicialización de la AGREGACION del profesor
        this.estudiantes = new ArrayList<>();           //se crea el espacio para almacenar estudiantes.

        this.esquemaEvaluacion = new ArrayList<>();     // instanciación del espacio para las evaluaciones

        this.registroCalificaciones = new ArrayList<>();
    }

    /**
     * agregarEvaluacion intenta registrar un nuevo rubro de evaluación dentro del esquema de un
     * grupo, debe considerarse que la evaluación no haya sido registgrada anteriormente y que su
     * incorporación al esquema actual no sobrepase el 100%
     *
     * @param tipoEval:    uno de los posibles rubros definidos en TEvaluacion
     * @param numero:      entero que representa el número de ítem dentro del rubro. Ej Quiz 2
     * @param descripcion: describe el contenido que abarca la evaluación
     * @param porc:        valor real que representa el porcentaje asociado a la evaluación
     * @return
     */
    public boolean agregarEvaluacion(TEvaluacion tipoEval, int numero, String descripcion, double porc) {

        if (!evaluacionExiste(tipoEval, numero)) {
            // recuperar el total de porcentajes registrados
            double totalPorcentajes = 0;
            for (Evaluacion evaluacion : esquemaEvaluacion)
                totalPorcentajes += evaluacion.getPorcentaje();

            //verifica que el total de evaluaciones registradas no exceda al 100% incluyendo la nueva
            if (totalPorcentajes + porc <= 100) {
                Evaluacion nuevaEvaluacion = new Evaluacion(tipoEval, numero, descripcion, porc);
                esquemaEvaluacion.add(nuevaEvaluacion);
                return true;
            }
            return false;       // no la registra porque excede al 100%
        }
        return false;           // no la registra porque ya existe
    }

    public boolean evaluacionExiste(TEvaluacion tipo, int numero) {
        for (Evaluacion evaluacion : esquemaEvaluacion) {
            if (evaluacion.getTipo().equals(tipo) && evaluacion.getNumero() == numero) {
                return true;
            }
        }
        return false;
    }


    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public String getAula() {
        return aula;
    }

    public void setAula(String aula) {
        this.aula = aula;
    }

    public TModalidad getModalidad() {
        return modalidad;
    }

    public void setModalidad(TModalidad modalidad) {
        this.modalidad = modalidad;
    }

    public Curso getElCurso() {
        return elCurso;
    }

    public void setElCurso(Curso elCurso) {
        this.elCurso = elCurso;
    }

    public Profesor getElProfe() {
        return elProfe;
    }

    public void setElProfe(Profesor elProfe) {
        this.elProfe = elProfe;
    }

    public ArrayList<Evaluacion> getEsquemaEvaluacion() {
        return esquemaEvaluacion;
    }

    //-----------------------------------------
    public ArrayList<Estudiante> getEstudiantes() {
        return estudiantes;
    }

    public boolean agregarEstudiante(Estudiante estudiante, Curso curso) {
        if (!estudiantes.contains(estudiante) && curso.equals(this.elCurso)) {
            estudiantes.add(estudiante);
            return true;
        }
        return false;
    }

    public boolean estaMatriculado(Estudiante estudiante) {
        return estudiantes.contains(estudiante);
    }

    public boolean estaImpartiendo(Profesor profesor) {
        return profesor.equals(this.elProfe);
    }

    public void agregarCalificacion(Calificacion calificacion) {
        registroCalificaciones.add(calificacion);
    }

    public double getRendimientoEstudiante(Estudiante estudiante) {
        double rendimientoEstudiante = 0.0;
        for (Calificacion calificacion : registroCalificaciones) {
            if (calificacion.datosEstudiante == estudiante) {
                rendimientoEstudiante += (calificacion.datosEvaluacion.getPorcentaje() * calificacion.getNota()) / 100;
            }
        }
        return rendimientoEstudiante;
    }
    //-----------------------------------------

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Grupo grupo = (Grupo) o;
        return getNumero() == grupo.getNumero() && Objects.equals(getElCurso(), grupo.getElCurso());
    }

    @Override
    public String toString() {
        return "Grupo: Numero=" + numero + ", Horario='" + horario +
                ", Aula='" + aula + ", Modalidad=" + modalidad +
                "\n" + elCurso + elProfe +
                "\n" + esquemaEvaluacion +
                "\n" + estudiantes +
                "\n" + registroCalificaciones;
    }
}
