package logica;

import modelo.*;

import java.util.ArrayList;
import java.util.List;

public class AdmGrupos {
    private ArrayList<Grupo> listaGrupos;

    public AdmGrupos() {
        this.listaGrupos = new ArrayList<Grupo>();
    }

    public boolean agregar(Grupo unGrupo){
        for (Grupo grupoActual: listaGrupos)
            if (grupoActual.equals(unGrupo))
                return false;
        listaGrupos.add(unGrupo);
        return true;
    }

    public boolean agregarEvaluacion(Curso elCurso, int numGrupo, TEvaluacion tipo, int numEval, String descripcion, double porcentaje){
        Grupo grupoABuscar = new Grupo();
        grupoABuscar.setElCurso(elCurso);
        grupoABuscar.setNumero(numGrupo);
        for (Grupo grupoActual: listaGrupos)
            if (grupoActual.equals(grupoABuscar)){
                return grupoActual.agregarEvaluacion(tipo, numEval, descripcion, porcentaje);
            }
        return false;
    }

    //-----------------------------------------
    public Grupo consultar(Curso elCurso, int numGrupo){
        for (Grupo grupoActual: listaGrupos){
            if (grupoActual.getElCurso().equals(elCurso) && grupoActual.getNumero() == numGrupo)
                return grupoActual;
        }
        return null;
    }
    public Grupo consultar(int numGrupo){ //polimorfismo
        for (Grupo grupoActual: listaGrupos){
            if (grupoActual.getNumero() == numGrupo)
                return grupoActual;
        }
        return null;
    }
    public boolean agregarEstudianteGrupo(Estudiante estudiante,Curso curso,Grupo grupo){
        for (Grupo nGrupo: listaGrupos){
            if (nGrupo.equals(grupo))
                return grupo.agregarEstudiante(estudiante, curso);
        }
        return false;
    }
    public String obtenerDetallesGrupo(Grupo grupo) {
        if (listaGrupos.contains(grupo)) {
            return grupo.toString();
        }
        return "Grupo no encontrado";
    }

    public List<Curso> obtenerCursosPorEstudiante(Estudiante estudiante){
        List<Curso> listaCursos =  new ArrayList<>();
        for (Grupo nGrupo: listaGrupos){
            if (nGrupo.estaMatriculado(estudiante)){
                listaCursos.add(nGrupo.getElCurso());
            }
        }
        return listaCursos;
    }

    public List<Curso> obtenerCursosPorProfesor(Profesor profesorBuscado){
        List<Curso> listaCursos = new ArrayList<>();
        for (Grupo nGrupo: listaGrupos){
            if (nGrupo.estaImpartiendo(profesorBuscado)){
                listaCursos.add(nGrupo.getElCurso());
            }
        }
        return listaCursos;
    }

    public int obtenerNumEstudiantesPorCurso(Curso curso){
        int contador = 0;
        for (Grupo nGrupo: listaGrupos){
            if (nGrupo.getElCurso().equals(curso)){
                contador = nGrupo.getEstudiantes().size();
                return contador;
            }
        }
        return contador;
    }

    public boolean registrarCalificacion(Estudiante estudiante, Curso cursoBuscado, int numGrupo, int numEvaluacion, TEvaluacion tipo, double notaObtenida){
        Grupo grupoBuscado = consultar(cursoBuscado, numGrupo); //polimorfismo
        Evaluacion evaluacionBuscado = null;
        if (grupoBuscado == null){
            System.out.println("El grupo no ha sido encontrado");
            return false;
        }
        //Para buscar el objeto de evaluación
        for (Evaluacion evaluacion: grupoBuscado.getEsquemaEvaluacion()){
            if (evaluacion.getTipo() == tipo && evaluacion.getNumero() == numEvaluacion){
                evaluacionBuscado =  evaluacion;
                break;
            }
        }
        if (evaluacionBuscado == null){
            System.out.println("La evaluación no ha sido encontrado");
            return false;
        }
        if (notaObtenida < 0 || notaObtenida > 100){
            System.out.println("La nota no puede ser menor a 0 o 100");
            return false;
        }
        Calificacion calificacion = new Calificacion(estudiante, evaluacionBuscado, notaObtenida);
        grupoBuscado.agregarCalificacion(calificacion);
        return true;
    }

    public String obtenerRendimientoEstudiante(Curso curso, int grupoId) {
        Grupo grupoBuscado = consultar(curso, grupoId);
        String resultado = "";
        for (Estudiante estudiante: grupoBuscado.getEstudiantes()){
            double rendimientoEstudiante = grupoBuscado.getRendimientoEstudiante(estudiante);
            resultado += ("Estudiante: " +  estudiante.getNombre() + " Rendimiento: " + rendimientoEstudiante + "\n");
        }
        return resultado;
    }

    public String obtenerPromedioEstudiantes(Curso curso, int grupoId) {
        Grupo grupoBuscado = consultar(curso, grupoId);
        double promedio = 0.0;
        for (Estudiante estudiante: grupoBuscado.getEstudiantes()){
            double rendimientoEstudiante = grupoBuscado.getRendimientoEstudiante(estudiante);
            promedio += rendimientoEstudiante;
        }
        return "Curso: " + curso.getNombre() + " Grupo: " + grupoBuscado.getNumero() + " Promedio: " + promedio/grupoBuscado.getEstudiantes().size() + "\n";
    }
    //-----------------------------------------

    @Override
    public String toString() {
        return "Lista de Grupos:\n" + listaGrupos + "\n";
    }
}
