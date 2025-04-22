package repositories.interfaces.repository;

import config.DBConnection;
import repositories.interfaces.enums.TiposCliente;
import repositories.interfaces.entities.ClienteEntity;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {
    Connection connection;

    public ClienteDAO(){
        connection = DBConnection.getInstance().getConnection();
    }

    public List<ClienteEntity> list (){
        List<ClienteEntity> clientes = new ArrayList<>();
        String sql = "SELECT * FROM cliente ";

        try(Statement stmt = connection.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()){
                ClienteEntity cliente = new ClienteEntity();

                cliente.setId(rs.getInt("id"));
                cliente.setNombre(rs.getString("nombre"));
                cliente.setTipoCliente(TiposCliente.valueOf(rs.getString("tipoCliente")));
                cliente.setLocalidad(rs.getString("localidad"));

                clientes.add(cliente);
            }

        }catch (SQLException e ){
            e.printStackTrace();
        }
        return clientes;
    }
}
