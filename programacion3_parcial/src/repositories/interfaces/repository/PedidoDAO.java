package repositories.interfaces.repository;

import config.DBConnection;
import repositories.interfaces.enums.Estados;
import repositories.interfaces.entities.PedidoEntity;
import repositories.interfaces.service.PedidoService;

import java.sql.*;
import java.util.*;

public class PedidoDAO {
    private Connection connection;

    public PedidoDAO (){
        this.connection = DBConnection.getInstance().getConnection();
    }

    public void insert (PedidoEntity pedido) throws Exception{
        PedidoService.validation(pedido);

        String sql = "INSERT INTO pedidos (idCliente, idBebida, cantidad, estado) VALUES (?, ?, ?, ?)";

        try (PreparedStatement stmt = connection.prepareStatement(sql)){
            stmt.setInt(1, pedido.getIdCliente());
            stmt.setInt(2, pedido.getIdBebida());
            stmt.setInt(3, pedido.getCantidad());
            stmt.setString(4, Estados.PENDIENTE.toString());

            stmt.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public List<PedidoEntity> list (){
        List<PedidoEntity> pedidos = new ArrayList<>();
        String sql = "SELECT * FROM pedido ";

        try(Statement stmt = connection.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()){
                PedidoEntity pedido = new PedidoEntity();

                pedido.setId(rs.getInt("id"));
                pedido.setIdBebida(rs.getInt("idBebida"));
                pedido.setIdCliente(rs.getInt("idCliente"));
                pedido.setCantidad(rs.getInt("cantidad"));
                pedido.setEstado(Estados.valueOf(rs.getString("estado")));

                pedidos.add(pedido);
            }

        }catch (SQLException e ){
            e.printStackTrace();
        }
        return pedidos;
    }

    public void update (PedidoEntity pedido){
        String sql = "UPDATE pedidos SET idCliente = ?, idBebida = ?, cantidad = ?, estado = ? WHERE id = ?";

        try (PreparedStatement stmt = connection.prepareStatement(sql)){
            stmt.setInt(1, pedido.getIdCliente());
            stmt.setInt(2, pedido.getIdBebida());
            stmt.setInt(3, pedido.getCantidad());
            stmt.setString(4, pedido.getEstado().toString());
            stmt.setInt(5, pedido.getId());

            stmt.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }


}
