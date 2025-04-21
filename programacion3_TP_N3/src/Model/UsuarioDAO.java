package Model;

import Config.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {
    Connection connection;

    public UsuarioDAO(){
        connection = DBConnection.getInstance().getConexion();
    }

    public void insertUser (Usuario usuario) throws SQLException{
        String sql = "INSERT INTO usuarios (nombre, apellido, dni, email) VALUES (?, ?, ?, ?)";

        PreparedStatement stmt = connection.prepareStatement(sql);

            stmt.setString(1, usuario.getNombre());
            stmt.setString(2, usuario.getApellido());
            stmt.setString(3, usuario.getDni());
            stmt.setString(4, usuario.getEmail());

            stmt.executeUpdate();
    }

    public List<Usuario> listUsers (){
        List<Usuario> users = new ArrayList<>();

        String sql = "SELECT * FROM usuarios";

        try (Statement stmt = connection.createStatement(); ResultSet rs = stmt.executeQuery(sql)){
            while (rs.next()){
                Usuario user = new Usuario();

                user.setId(rs.getInt("id_usuario"));
                user.setNombre(rs.getString("nombre"));
                user.setApellido(rs.getString("apellido"));
                user.setDni(rs.getString("dni"));
                user.setFecha_creacion(rs.getString("fecha_creacion"));

                users.add(user);
            }

        }catch (SQLException e){
            e.printStackTrace();
        }

        return users;
    }
}
