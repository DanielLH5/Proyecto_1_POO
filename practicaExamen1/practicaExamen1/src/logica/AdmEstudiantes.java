package logica;

import modelo.Estudiante;

import java.util.ArrayList;

public class AdmEstudiantes {
    private ArrayList<Estudiante> listaEstudiantes;       //declaracion de una instancia

    public AdmEstudiantes() {
        this.listaEstudiantes = new ArrayList<Estudiante>();
    }

    public boolean agregar(Estudiante unEstudiante){
        for (Estudiante EstudianteActual: listaEstudiantes)
            if (EstudianteActual.equals(unEstudiante))
                return false;
        listaEstudiantes.add(unEstudiante);
        return true;
    }

    public Estudiante consultar(String elCarne){
        for (int i = 0; i<listaEstudiantes.size(); i++){
            Estudiante Estudiante = listaEstudiantes.get(i);
            if (elCarne.equals(Estudiante.getCarne()))
                return Estudiante;
        } // for
        return null;   // no encontró el Estudiante

    }

    public boolean modificar(Estudiante nuevoEstudiante){
        for (int i = 0; i < listaEstudiantes.size(); i++){
            if (listaEstudiantes.get(i).equals(nuevoEstudiante)){
                listaEstudiantes.set(i, nuevoEstudiante);
                return true;
            }
        }
        return false;
    }

    public boolean eliminar(String elCarne){
        for (int i = 0; i < listaEstudiantes.size(); i++){
            if (elCarne.equals(listaEstudiantes.get(i).getCarne())){
                listaEstudiantes.remove(i);
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "lista de Estudiantes:\n" + listaEstudiantes ;
    }
}
