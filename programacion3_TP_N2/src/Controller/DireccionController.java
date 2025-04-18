package Controller;

import Model.Direccion;
import Model.DireccionDAO;

import java.util.List;

public class DireccionController {
    DireccionDAO direccionDAO;

    public DireccionController (){
        direccionDAO = new DireccionDAO();
    }

    public void insertDireccion (String calle, int altura, int alumno_id){
        Direccion direccion = new Direccion(0, calle, altura, alumno_id);
        direccionDAO.insertDireccion(direccion);
    }

    public List<Direccion> listDirecciones (){
        return direccionDAO.listDirecciones();
    }

    public List<Direccion> listDireccionesByAlumno (int id){
        return direccionDAO.listDirectiosByAlumno(id);
    }

    public void deleteDireccion (int id){
        direccionDAO.deleteDireccion(id);
    }
}
