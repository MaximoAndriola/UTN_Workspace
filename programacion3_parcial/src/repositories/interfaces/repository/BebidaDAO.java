package repositories.interfaces.repository;

import config.DBConnection;
import repositories.interfaces.interfaces.IABMRepository;
import repositories.interfaces.enums.Tipos;
import repositories.interfaces.entities.BebidaEntity;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BebidaDAO implements IABMRepository<BebidaEntity> {
    private final Connection connection;

    public BebidaDAO (){
        this.connection = DBConnection.getInstance().getConnection();
    }
    @Override
    public void insert (BebidaEntity bebida){
        String sql = "INSERT INTO bebidas (nombre, tipo, precioUnitario, stock) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)){
            stmt.setString(1, bebida.getNombre());
            stmt.setString(2, bebida.getTipo().toString());
            stmt.setDouble(3, bebida.getPrecioUnitario());
            stmt.setInt(4, bebida.getStock());

            stmt.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public List<BebidaEntity> list (){
        List<BebidaEntity> bebidas = new ArrayList<>();
        String sql = "SELECT * FROM bebida ";

        try(Statement stmt = connection.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()){
                BebidaEntity bebida = new BebidaEntity();

                bebida.setId(rs.getInt("id"));
                bebida.setNombre(rs.getString("nombre"));
                bebida.setTipo(Tipos.valueOf(rs.getString("tipo")));
                bebida.setStock(rs.getInt("stock"));
                bebida.setPrecioUnitario(rs.getDouble("precioUnitario"));

                bebidas.add(bebida);
            }

        }catch (SQLException e ){
            e.printStackTrace();
        }

        return bebidas;
    }

    public void update (BebidaEntity bebida){
        String sql = "UPDATE bebidas SET nombre = ?, tipo = ?, precioUnitario = ?, stock = ? WHERE id = ?";

        try (PreparedStatement stmt = connection.prepareStatement(sql)){
            stmt.setString(1, bebida.getNombre());
            stmt.setString(2, bebida.getTipo().toString());
            stmt.setDouble(3, bebida.getPrecioUnitario());
            stmt.setInt(4, bebida.getStock());
            stmt.setInt(5, bebida.getId());

            stmt.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void delete (int id){
        String sql = "DELETE FROM bebidas WHERE id = ?";

        try (PreparedStatement stmt = connection.prepareStatement(sql)){
            stmt.setInt(1, id);

            stmt.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }




}
