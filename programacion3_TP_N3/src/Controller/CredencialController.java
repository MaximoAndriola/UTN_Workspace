package Controller;

import Model.Credencial;
import Model.CredencialDAO;
import Model.Permisos;

import java.util.List;

public class CredencialController {
    CredencialDAO credencialDAO;

    public CredencialController (){
        this.credencialDAO = new CredencialDAO();
    }

    public void insertCredencial (int id_usuario, String username, String password, Permisos permiso){
        Credencial credencial = new Credencial(id_usuario, username, password, permiso);
        credencialDAO.insertCredencial(credencial);
    }

    public List<Credencial> listCredencials (){
        return credencialDAO.listCredencials();
    }
}
