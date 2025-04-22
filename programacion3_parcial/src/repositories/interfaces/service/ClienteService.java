package repositories.interfaces.service;

import repositories.interfaces.interfaces.IRepository;
import repositories.interfaces.repository.PedidoDAO;
import repositories.interfaces.entities.ClienteEntity;
import repositories.interfaces.entities.PedidoEntity;
import repositories.interfaces.exceptions.ClientNotFoundException;
import repositories.interfaces.repository.ClienteDAO;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public class ClienteService implements IRepository<ClienteEntity> {
    private ClienteDAO clienteDAO;

    public ClienteService (){
        clienteDAO = new ClienteDAO();
    }

    public List<ClienteEntity> filterByLocalidad (String localidad){
        List<ClienteEntity> clientes = clienteDAO.list();

        return clientes.stream()
                .filter(n -> n.getLocalidad().equals(localidad))
                .toList();
    }

    public ClienteEntity filterById (int id) throws ClientNotFoundException {
        List<ClienteEntity> clientes = clienteDAO.list();

        Optional<ClienteEntity> optionalCliente = clientes.stream()
                .filter(n -> n.getId() == id)
                .reduce((a, b) -> a);

        if (optionalCliente.isEmpty()){
            throw new ClientNotFoundException("El cliente solicitado no existe");
        }

        return optionalCliente.orElse(new ClienteEntity());
    }

    public Map<ClienteEntity, List<PedidoEntity>> filterPedidosByClienteId (int id) throws ClientNotFoundException{
        ClienteEntity cliente = filterById(id);

        PedidoDAO pedidoDAO = new PedidoDAO();

        List<PedidoEntity> pedidos = pedidoDAO.list();

        List<PedidoEntity> filteredPedidos = pedidos.stream()
                .filter(n -> n.getIdCliente() == id)
                .toList();

        return Map.of(cliente, filteredPedidos);
    }
}
