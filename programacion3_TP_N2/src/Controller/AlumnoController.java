package Controller;

import Model.Alumno;
import Model.AlumnoDAO;

import java.util.List;

public class AlumnoController {
    private AlumnoDAO alumnoDAO;

    public AlumnoController (){
        this.alumnoDAO = new AlumnoDAO();
    }

    public void addAlumno(String nombre, String apellido, int edad, String email){
        Alumno alumno = new Alumno(0, nombre, apellido, edad, email);
        alumnoDAO.insertAlumno(alumno);
    }

    public List<Alumno> listAlumno(){
        return alumnoDAO.listAlumnos();
    }

    public void updateAlumno (int id, String nombre, String apellido, int edad, String email){
        Alumno alumno = new Alumno(id, nombre, apellido, edad, email);
        alumnoDAO.updateAlumno(alumno);
    }

    public void deleteAlumno (int id){
        alumnoDAO.deleteAlumno(id);
    }
}
