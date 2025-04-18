package Model;

import Config.ConexionMySQL;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DireccionDAO {
    private Connection connection;

    public DireccionDAO (){
        this.connection = ConexionMySQL.getInstance().getConexion();
    }

    public void insertDireccion (Direccion direccion){
        String sql = "INSERT INTO direcciones (calle, altura, alumno_id) VALUES (?, ?, ?)";

        try (PreparedStatement stmt = connection.prepareStatement(sql)){
            stmt.setString(1, direccion.getCalle());
            stmt.setInt(2, direccion.getAltura());
            stmt.setInt(3, direccion.getAlumno_id());

            stmt.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public List<Direccion> listDirecciones (){
        List<Direccion> direccionList = new ArrayList<>();
        String sql = "SELECT * FROM direcciones";

        try (Statement stmt = connection.createStatement(); ResultSet rs = stmt.executeQuery(sql)){
            while (rs.next()){
                Direccion direccion = new Direccion();

                direccion.setId(rs.getInt("id"));
                direccion.setCalle(rs.getString("calle"));
                direccion.setAltura(rs.getInt("altura"));
                direccion.setAlumno_id(rs.getInt("alumno_id"));

                direccionList.add(direccion);
            }

        }catch (SQLException e){
            e.printStackTrace();
        }

        return direccionList;
    }

    public List<Direccion> listDirectiosByAlumno (int id_alumno){
        List<Direccion> direccionList = new ArrayList<>();
        String sql = "SELECT * FROM direcciones WHERE alumno_id = ?";

        try (PreparedStatement stmt = connection.prepareStatement(sql)){
            stmt.setInt(1, id_alumno);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()){
                Direccion direccion = new Direccion();

                direccion.setId(rs.getInt("id"));
                direccion.setAlumno_id(rs.getInt("alumno_id"));
                direccion.setCalle(rs.getString("calle"));
                direccion.setAltura(rs.getInt("altura"));

                direccionList.add(direccion);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }

        return direccionList;
    }

    public void deleteDireccion (int id){
        String sql = "DELETE FROM direcciones WHERE id = ?";

        try (PreparedStatement stmt = connection.prepareStatement(sql)){
            stmt.setInt(1, id);

            stmt.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
