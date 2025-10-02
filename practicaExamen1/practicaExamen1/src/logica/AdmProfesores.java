package logica;

import modelo.Profesor;

import java.util.ArrayList;

public class AdmProfesores {
    private ArrayList<Profesor> listaProfesores;       //declaracion de una instancia

    public AdmProfesores() {
        this.listaProfesores = new ArrayList<Profesor>();
    }

    public boolean agregar(Profesor unProfesor){
        for (Profesor ProfesorActual: listaProfesores)
            if (ProfesorActual.equals(unProfesor))
                return false;
        listaProfesores.add(unProfesor);
        return true;
    }

    public Profesor consultar(int elId){
        for (int i = 0; i<listaProfesores.size(); i++){
            Profesor Profesor = listaProfesores.get(i);
            if (elId == Profesor.getId())
                return Profesor;
        } // for
        return null;   // no encontró el Profesor

    }

    public boolean modificar(Profesor nuevoProfesor){
        for (int i = 0; i < listaProfesores.size(); i++){
            if (listaProfesores.get(i).equals(nuevoProfesor)){
                listaProfesores.set(i, nuevoProfesor);
                return true;
            }
        }
        return false;
    }

    public boolean eliminar(int elId){
        for (int i = 0; i < listaProfesores.size(); i++){
            if (elId ==  listaProfesores.get(i).getId()){
                listaProfesores.remove(i);
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "lista de Profesores:\n" + listaProfesores ;
    }
}
