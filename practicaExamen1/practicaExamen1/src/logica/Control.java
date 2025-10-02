package logica;
import modelo.Curso;
import modelo.Estudiante;
import modelo.Profesor;
import modelo.Grupo;
import modelo.TEvaluacion;

import java.util.List;


public class Control {

    private AdmCursos admCursos;
    private AdmProfesores admProfesores;
    private AdmEstudiantes admEstudiantes;
    private AdmGrupos admGrupos;

    public Control() {
        admCursos = new AdmCursos();
        admProfesores = new AdmProfesores();
        admEstudiantes = new AdmEstudiantes();
        admGrupos = new AdmGrupos();
    }

    // servicios asociados a la gestión de cursos
    public boolean agregarCurso(Curso datosCurso){
        return admCursos.agregar(datosCurso);
    }

    public Curso localizarCurso(String codigo){
        return admCursos.consultar(codigo);
    }

    public String mostrarCursos(){
        return admCursos.toString();
    }

    // servicios asociados a la gestión de profesores
    public boolean agregarProfesor(Profesor datosProfesor){
        return admProfesores.agregar(datosProfesor);
    }

    public Profesor localizarProfesor(int id){
        return admProfesores.consultar(id);
    }

    public String mostrarProfesores(){
        return admProfesores.toString();
    }

    // servicios asociados a la gestión de estudiantes
    public boolean agregarEstudiante(Estudiante datosEstudiante){
        return admEstudiantes.agregar(datosEstudiante);
    }

    public Estudiante localizarEstudiante(String carne){
        return admEstudiantes.consultar(carne);
    }

    public String mostrarEstudiantes(){
        return admEstudiantes.toString();
    }

    // servicios asociados a la gestión de grupos
    public boolean agregarGrupo(Grupo unGrupo){
        return admGrupos.agregar(unGrupo);
    }

    public boolean agregarEvaluacion( Curso elCurso, int numGrupo, TEvaluacion tipo, int numEval, String descripcion, double porcentaje){
        return admGrupos.agregarEvaluacion(elCurso, numGrupo, tipo, numEval, descripcion, porcentaje);
    }

    //-----------------------------------------
    public boolean agregarEstudianteAGrupo(String carnet, String codigoCurso, int numGrupo){
        Estudiante estudianteBuscado = admEstudiantes.consultar(carnet);
        if (estudianteBuscado == null){
            return false;
        }
        Curso cursoBuscado = admCursos.consultar(codigoCurso);
        if (cursoBuscado == null){
            return false;
        }
        Grupo grupoBuscado = admGrupos.consultar(cursoBuscado, numGrupo);
        if (grupoBuscado == null){
            return false;
        }
        return admGrupos.agregarEstudianteGrupo(estudianteBuscado, cursoBuscado, grupoBuscado);
    }

    public String obtenerTodoDetalleDeGrupo(int numGrupo){
        Grupo grupoBuscado = admGrupos.consultar(numGrupo); //polimorfismo
        if (grupoBuscado == null){
            return "No se encontró grupo";
        }
        return admGrupos.obtenerDetallesGrupo(grupoBuscado);
    }

    public List<Curso> obtenerDetalleCursosDeEstudiante(String carnet){
        Estudiante estudianteBuscado = admEstudiantes.consultar(carnet);
        if (estudianteBuscado == null){
            System.out.println("El estudiante no ha sido encontrado");
            return null;
        }
        return admGrupos.obtenerCursosPorEstudiante(estudianteBuscado);
    }

    public List<Curso> mostrarCursosDeProfesor(int idProfesor){
        Profesor profesorBuscado = admProfesores.consultar(idProfesor);
        if (profesorBuscado == null){
            System.out.println("El estudiante no ha sido encontrado");
            return null;
        }
        return admGrupos.obtenerCursosPorProfesor(profesorBuscado);
    }

    public void mostrarNumEstudiantesDeProfesor(int idProfesor){
        Profesor profesorBuscado = admProfesores.consultar(idProfesor);
        if (profesorBuscado == null){
            System.out.println("El estudiante no ha sido encontrado");
        }else{
            List<Curso> listaCursosProfe = mostrarCursosDeProfesor(idProfesor);
            for (Curso nCurso: listaCursosProfe) {
                int numEstudiantes = admGrupos.obtenerNumEstudiantesPorCurso(nCurso);
                System.out.println("Curso: " + nCurso.getNombre() + " Cantidad de estudiantes: " + numEstudiantes);
            }
        }
    }

    public boolean registrarNotaEstudiante(String codigoCurso, int numGrupo, String carnet, int numEvaluacion, TEvaluacion tipo, double notaObtenida){
        Estudiante estudianteBuscado = admEstudiantes.consultar(carnet);
        if (estudianteBuscado == null){
            System.out.println("El estudiante no ha sido encontrado");
            return false;
        }
        Curso cursoBuscado = admCursos.consultar(codigoCurso);
        if (cursoBuscado == null){
            return false;
        }
        admGrupos.registrarCalificacion(estudianteBuscado, cursoBuscado, numGrupo, numEvaluacion, tipo, notaObtenida);
        return true;
    }

    public String mostrarRendimientoEstudiante(String codigoCurso, int numGrupo){
        Curso cursoBuscado = admCursos.consultar(codigoCurso);
        if (cursoBuscado == null){
            System.out.println("No se ha encontrado");
            return null;
        }
        return admGrupos.obtenerRendimientoEstudiante(cursoBuscado, numGrupo);
    }

    public String mostrarPromedioEstudiantesDeGrupo(String codigoCurso, int numGrupo){
        Curso cursoBuscado = admCursos.consultar(codigoCurso);
        if (cursoBuscado == null){
            System.out.println("No se ha encontrado");
            return null;
        }
        return admGrupos.obtenerPromedioEstudiantes(cursoBuscado, numGrupo);
    }
    //-----------------------------------------

    public String mostrarGrupos(){
        return admGrupos.toString();
    }
}


