package Model;

import Config.DBConnection;
import Controller.CredencialController;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CredencialDAO {
    Connection connection;

    public CredencialDAO (){
        connection = DBConnection.getInstance().getConexion();
    }

    public void insertCredencial(Credencial credencial){
        String sql = "INSERT INTO credenciales (id_usuario, username, password, permiso) VALUES (?, ?, ?, ?)";

        try (PreparedStatement stmt = connection.prepareStatement(sql)){
            stmt.setInt(1, credencial.getId_usuario());
            stmt.setString(2, credencial.getUsername());
            stmt.setString(3, credencial.getPassword());
            stmt.setString(4, credencial.getPermiso().toString());

            stmt.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public List<Credencial> listCredencials (){
        List<Credencial> credencials = new ArrayList<>();

        String sql = "SELECT * FROM credenciales";
        try (Statement stmt = connection.createStatement(); ResultSet rs = stmt.executeQuery(sql)){
            while (rs.next()){
                Credencial credencial = new Credencial();

                credencial.setId(rs.getInt("id_credencial"));
                credencial.setId_usuario(rs.getInt("id_usuario"));
                credencial.setUsername(rs.getString("username"));
                credencial.setPassword(rs.getString("password"));
                credencial.setPermiso(Permisos.valueOf(rs.getString("permiso")));

                credencials.add(credencial);
            }


        }catch (SQLException e){
            e.getStackTrace();
        }

        return credencials;
    }
}
