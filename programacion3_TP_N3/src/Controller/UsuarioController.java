package Controller;

import Model.Usuario;
import Model.UsuarioDAO;

import java.sql.SQLException;
import java.util.List;

public class UsuarioController {
    private UsuarioDAO usuarioDAO;

    public UsuarioController (){
        this.usuarioDAO = new UsuarioDAO();
    }

    public void insertUser (String nombre, String apellido, String dni, String email) throws SQLException {
        Usuario usuario = new Usuario(nombre, apellido, dni, email);
        usuarioDAO.insertUser(usuario);
    }

    public List<Usuario> listUsers (){
        return usuarioDAO.listUsers();
    }
}
