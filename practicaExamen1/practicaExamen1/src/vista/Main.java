package vista;

import logica.Control;
import modelo.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Control receptor = new Control();       // se instancia la asociación con la lógica de negocio

        //creación de dos cursos...
        Curso c1 = new Curso("IC2101", "POO", 3);
        Curso c2 = new Curso("IC2001", "ED", 4);
        Curso c3 = new Curso("IC5831", "Requerimiento software", 4);

        // se agregan al control de la aplicación.
        receptor.agregarCurso(c1);      //registrar en el administrador de cursos
        receptor.agregarCurso(c2);      //registrar en el administrador de cursos
        receptor.agregarCurso(c3);      //registrar en el administrador de cursos
        System.out.println("Lista de Cursos registrados " + receptor.mostrarCursos());

        // creación de dos Profesores
        Profesor p1 = new Profesor(10, "Ericka Solano");
        Profesor p2 = new Profesor(20, "Mauricio Avilés");

        // se agregan al control de la aplicación.
        receptor.agregarProfesor(p1);      //registrar en el administrador de profesores
        receptor.agregarProfesor(p2);      //registrar en el administrador de profesores
        System.out.println("Lista de Profesores registrados " + receptor.mostrarProfesores());

        Estudiante e1 = new Estudiante("1000", "Luis López");
        Estudiante e2 = new Estudiante("2000", "Ana Cabezas");
        Estudiante e3 = new Estudiante("3000", "José Lanudo");
        Estudiante e4 = new Estudiante("4000", "Isabela Kops");
        receptor.agregarEstudiante(e1);
        receptor.agregarEstudiante(e2);
        receptor.agregarEstudiante(e3);
        receptor.agregarEstudiante(e4);
        System.out.println("Lista de Estudiantes registrados " + receptor.mostrarEstudiantes());


        // para crear un grupo se debe localizar previamente la info del profe y curso... (agregación)
        Curso cursoPOO = receptor.localizarCurso("IC2101");
        Profesor elProfe = receptor.localizarProfesor(10);
        if (cursoPOO != null && elProfe != null) {   //los encontro a ambos..
            Grupo g40 = new Grupo(40, "K-J 13:00-14:50", "SJ06-103",
                    TModalidad.SEMI_PRESENCIAL, cursoPOO, elProfe);
            receptor.agregarGrupo(g40);
        } else {
            System.out.println("El curso o el profesor no existe");
        }

        //Agregando el esquema de evaluación al grupo 40 del curso POO
        receptor.agregarEvaluacion(cursoPOO, 40, TEvaluacion.EXAMEN, 1, "Primer Parcial", 20);
        receptor.agregarEvaluacion(cursoPOO, 40, TEvaluacion.EXAMEN, 2, "Examen Final", 35);
        receptor.agregarEvaluacion(cursoPOO, 40, TEvaluacion.PROYECTO, 1, "Proyecto 1", 15);
        receptor.agregarEvaluacion(cursoPOO, 40, TEvaluacion.PROYECTO, 2, "Proyecto 2", 15);
        receptor.agregarEvaluacion(cursoPOO, 40, TEvaluacion.PROYECTO, 3, "Proyecto 3", 15);

        Curso cursoED = receptor.localizarCurso("IC2001");
        Profesor profeED = receptor.localizarProfesor(20);
        if (cursoED != null && profeED != null) {   //los encontro a ambos..
            Grupo g50 = new Grupo(50, "M-V 9:00-11:00", "CA06-103",
                    TModalidad.SEMI_PRESENCIAL, cursoED, profeED);
            receptor.agregarGrupo(g50);
        } else {
            System.out.println("El curso o el profesor no existe");
        }

        //Agregando el esquema de evaluación al grupo 50 del curso ED
        receptor.agregarEvaluacion(cursoED, 50, TEvaluacion.PROYECTO, 1, "Proyecto 1", 25);
        receptor.agregarEvaluacion(cursoED, 50, TEvaluacion.PROYECTO, 2, "Proyecto 2", 25);
        receptor.agregarEvaluacion(cursoED, 50, TEvaluacion.PROYECTO, 3, "Proyecto 3", 25);
        receptor.agregarEvaluacion(cursoED, 50, TEvaluacion.PROYECTO, 4, "Proyecto 4", 25);


        Curso cursoRS = receptor.localizarCurso("IC5831");
        Profesor profeRS = receptor.localizarProfesor(10);
        if (cursoRS  != null && profeRS != null) {   //los encontro a ambos..
            Grupo g40 = new Grupo(40, "M 1:00-4:00", "SJ02-120",
                    TModalidad.SEMI_PRESENCIAL, cursoRS, profeRS);
            receptor.agregarGrupo(g40);
        }
        else{
            System.out.println("El curso o el profesor no existe");
        }

        //Agregando el esquema de evaluación al grupo 40 del curso POO
        receptor.agregarEvaluacion( cursoRS, 40, TEvaluacion.PROYECTO, 1, "Proyecto 1", 15);
        receptor.agregarEvaluacion( cursoRS, 40, TEvaluacion.PROYECTO, 2, "proyecto 2", 20);
        receptor.agregarEvaluacion( cursoRS, 40, TEvaluacion.PROYECTO, 3, "Proyecto 3", 25);
        receptor.agregarEvaluacion( cursoRS, 40, TEvaluacion.EXPOSICION, 1, "Exposicion 1", 20);
        receptor.agregarEvaluacion( cursoRS, 40, TEvaluacion.TAREA, 1, "Tarea 1", 5);
        receptor.agregarEvaluacion( cursoRS, 40, TEvaluacion.TAREA, 2, "Tarea 2", 5);
        receptor.agregarEvaluacion( cursoRS, 40, TEvaluacion.TAREA, 3, "Tarea 3", 5);
        receptor.agregarEvaluacion( cursoRS, 40, TEvaluacion.TAREA, 4, "Tarea 4", 5);

        System.out.println("Los grupos creados son " + receptor.mostrarGrupos());

        System.out.println("\nRegistro matricula estudiantes: ");
        receptor.agregarEstudianteAGrupo("1000", "IC2101", 40);
        receptor.agregarEstudianteAGrupo("1000", "IC5831", 40);
        receptor.agregarEstudianteAGrupo("1000", "IC2001", 50);
        receptor.agregarEstudianteAGrupo("2000", "IC5831", 40);
        receptor.agregarEstudianteAGrupo("2000", "IC2001", 50);
        receptor.agregarEstudianteAGrupo("3000", "IC2001", 50);
        receptor.agregarEstudianteAGrupo("3000", "IC2101", 40);
        receptor.agregarEstudianteAGrupo("4000", "IC2101", 40);
        receptor.agregarEstudianteAGrupo("4000", "IC5831", 40);
        System.out.println("Registro completado\n");

        System.out.println("\nGrupos: ");
        String detalleGrupo = receptor.obtenerTodoDetalleDeGrupo(40);
        System.out.println("Detalle Grupo "+detalleGrupo);
        String detalleGrupo50 = receptor.obtenerTodoDetalleDeGrupo(50);
        System.out.println("Detalle Grupo "+detalleGrupo50);

        System.out.println("\nCursos de Jose Lanudo: ");
        List<Curso> listaCursos = receptor.obtenerDetalleCursosDeEstudiante("3000");
        System.out.println("Lista de curso del estudiante: "+listaCursos);

        System.out.println("\nCursos que imparte el profesor Mauricio Avilés: ");
        List<Curso> listaCursosProfe = receptor.mostrarCursosDeProfesor(20);
        System.out.println("Lista de curso del profesor: "+listaCursosProfe);

        System.out.println("\nCantidad de estudiantes matriculados con Ericka Solano: ");
        receptor.mostrarNumEstudiantesDeProfesor(10);

        System.out.println("\nRegistro de notas: ");
        Random random = new Random();
        receptor.registrarNotaEstudiante("IC2001", 50, "1000", 1, TEvaluacion.PROYECTO, random.nextDouble(100.0));
        receptor.registrarNotaEstudiante("IC2001", 50, "1000", 3, TEvaluacion.PROYECTO, random.nextDouble(100.0));
        receptor.registrarNotaEstudiante("IC2101", 40, "1000", 3, TEvaluacion.PROYECTO, random.nextDouble(100.0));
        receptor.registrarNotaEstudiante("IC5831", 40, "1000", 1, TEvaluacion.TAREA, random.nextDouble(100.0));

        receptor.registrarNotaEstudiante("IC2001", 50, "2000", 3, TEvaluacion.PROYECTO, random.nextDouble(100.0));
        receptor.registrarNotaEstudiante("IC2001", 50, "2000", 4, TEvaluacion.PROYECTO, random.nextDouble(100.0));
        receptor.registrarNotaEstudiante("IC5831", 40, "2000", 1, TEvaluacion.EXPOSICION, random.nextDouble(100.0));
        receptor.registrarNotaEstudiante("IC5831", 40, "2000", 1, TEvaluacion.TAREA, random.nextDouble(100.0));

        receptor.registrarNotaEstudiante("IC2001", 50, "3000", 2, TEvaluacion.PROYECTO, random.nextDouble(100.0));
        receptor.registrarNotaEstudiante("IC2001", 50, "3000", 4, TEvaluacion.PROYECTO, random.nextDouble(100.0));
        receptor.registrarNotaEstudiante("IC2101", 40, "3000", 1, TEvaluacion.EXAMEN, random.nextDouble(100.0));
        receptor.registrarNotaEstudiante("IC2101", 40, "3000", 2, TEvaluacion.EXAMEN, random.nextDouble(100.0));

        receptor.registrarNotaEstudiante("IC2101", 40, "4000", 1, TEvaluacion.EXAMEN, random.nextDouble(100.0));
        receptor.registrarNotaEstudiante("IC2101", 40, "4000", 1, TEvaluacion.EXAMEN, random.nextDouble(100.0));
        receptor.registrarNotaEstudiante("IC5831", 40, "4000", 4, TEvaluacion.TAREA, random.nextDouble(100.0));
        receptor.registrarNotaEstudiante("IC5831", 40, "4000", 3, TEvaluacion.PROYECTO, random.nextDouble(100.0));
        System.out.println("Notas registradas \n" + receptor.mostrarGrupos());

        System.out.println("\nRendimiento académico de los estudiantes: ");
        String rendimiento = receptor.mostrarRendimientoEstudiante("IC2101", 40);
        System.out.println(rendimiento);
        String rendimiento2 = receptor.mostrarRendimientoEstudiante("IC2001", 50);
        System.out.println(rendimiento2);
        String rendimiento3 = receptor.mostrarRendimientoEstudiante("IC5831", 40);
        System.out.println(rendimiento3);

        System.out.println("\nPromedio obtenido: ");
        String promedio = receptor.mostrarPromedioEstudiantesDeGrupo("IC2101", 40);
        System.out.println(promedio);
        String promedio2 = receptor.mostrarPromedioEstudiantesDeGrupo("IC2001", 50);
        System.out.println(promedio2);
        String promedio3 = receptor.mostrarPromedioEstudiantesDeGrupo("IC5831", 40);
        System.out.println(promedio3);
    }
}