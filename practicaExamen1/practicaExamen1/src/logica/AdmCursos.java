package logica;

import java.util.ArrayList;
import modelo.Curso;

public class AdmCursos {

    private ArrayList<Curso> listaCursos;       //declaracion de una instancia

    public AdmCursos() {
        this.listaCursos = new ArrayList<Curso>();
    }

    public boolean agregar(Curso unCurso){
        for (Curso cursoActual: listaCursos)
            if (cursoActual.equals(unCurso))
                return false;
        listaCursos.add(unCurso);
        return true;
    }

    public Curso consultar(String elCodigo){
        for (int i = 0; i<listaCursos.size(); i++){
            Curso curso = listaCursos.get(i);
            if (elCodigo.equals(curso.getCodigo()))
                return curso;
        } // for
        return null;   // no encontró el curso

    }

    public boolean modificar(Curso nuevoCurso){
        for (int i = 0; i < listaCursos.size(); i++){
            if (listaCursos.get(i).equals(nuevoCurso)){
                listaCursos.set(i, nuevoCurso);
                return true;
            }
        }
        return false;
    }

    public boolean eliminar(String elCodigo){
        for (int i = 0; i < listaCursos.size(); i++){
            if (elCodigo.equals(listaCursos.get(i).getCodigo())){
                listaCursos.remove(i);
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "lista de Cursos:\n" + listaCursos ;
    }
}
