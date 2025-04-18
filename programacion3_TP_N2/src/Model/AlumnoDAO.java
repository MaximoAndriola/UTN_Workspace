package Model;

import Config.ConexionMySQL;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AlumnoDAO {
    private final Connection connection;

    public AlumnoDAO() {
        this.connection = ConexionMySQL.getInstance().getConexion();
    }

    public void insertAlumno (Alumno alumno){
        String sql = "INSERT INTO alumnos (nombre, apellido, edad, email) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)){
            stmt.setString(1, alumno.getNombre());
            stmt.setString(2, alumno.getApellido());
            stmt.setInt(3, alumno.getEdad());
            stmt.setString(4, alumno.getEmail());

            stmt.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public List<Alumno> listAlumnos(){
        List<Alumno> alumnoList = new ArrayList<>();
        String sql = "SELECT * FROM alumnos ";

        try (Statement stmt = connection.createStatement(); ResultSet rs = stmt.executeQuery(sql)){
            while (rs.next()){
                Alumno alumno = new Alumno();
                alumno.setId(rs.getInt("id"));
                alumno.setNombre(rs.getString("nombre"));
                alumno.setApellido(rs.getString("apellido"));
                alumno.setEdad(rs.getInt("edad"));
                alumno.setEmail(rs.getString("email"));

                alumnoList.add(alumno);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }

        return alumnoList;
    }

    public void updateAlumno (Alumno alumno){
        String sql = "UPDATE alumnos SET nombre = ?, apellido = ?, edad = ?, email = ? WHERE id = ?";

        try (PreparedStatement stmt = connection.prepareStatement(sql)){
            stmt.setString(1, alumno.getNombre());
            stmt.setString(2, alumno.getApellido());
            stmt.setInt(3, alumno.getEdad());
            stmt.setString(4, alumno.getEmail());
            stmt.setInt(5, alumno.getId());

            stmt.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void deleteAlumno (int id){
        String sql = "DELETE FROM alumnos WHERE id = ?";

        try (PreparedStatement stmt = connection.prepareStatement(sql)){
            stmt.setInt(1, id);

            stmt.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
