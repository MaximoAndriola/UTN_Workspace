package repositories.interfaces.service;

import repositories.interfaces.enums.Estados;
import repositories.interfaces.entities.BebidaEntity;
import repositories.interfaces.entities.PedidoEntity;
import repositories.interfaces.exceptions.BebidaNotFoundException;
import repositories.interfaces.exceptions.ClientNotFoundException;
import repositories.interfaces.exceptions.PedidoException;
import repositories.interfaces.interfaces.IRepository;
import repositories.interfaces.repository.BebidaDAO;
import repositories.interfaces.repository.ClienteDAO;
import repositories.interfaces.repository.PedidoDAO;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class PedidoService  {
    private PedidoDAO pedidoDAO;

    public PedidoService (){
        pedidoDAO = new PedidoDAO();
    }

    public void ingresarPedido (int idCliente, int idBebida, int cantidad) throws Exception {
        PedidoEntity pedido = new PedidoEntity(idCliente, idBebida, cantidad);
        pedidoDAO.insert(pedido);
    }

    public void changeEstado(int id, Estados estado) throws PedidoException {
        if (estado.equals(Estados.PENDIENTE)){
            throw new PedidoException("no puedes cambiar a un estado a pendiete");
        }

        List<PedidoEntity> pedidos = pedidoDAO.list();
        Optional<PedidoEntity> optionalPedido = pedidos.stream()
                .filter(n -> n.getId() == id)
                .reduce((a, b) -> a);

        if (optionalPedido.isEmpty()){
            throw new PedidoException("El pedido solicitado no existe");
        }

        PedidoEntity pedido = optionalPedido.orElse(new PedidoEntity());

        if (estado.equals(pedido.getEstado())){
            throw new PedidoException("El pedido ya tiene ese estado");
        }

        if (pedido.getEstado().equals(Estados.ENTREGADO)){
            throw new PedidoException("El pedido ya se entrego");
        }

        if (pedido.getEstado().equals(Estados.PENDIENTE) && estado.equals(Estados.ENTREGADO)){
            throw new PedidoException("No puedes cambiar el estado de pendiente a entregado");
        }

        pedido.setEstado(estado);

        pedidoDAO.update(pedido);
    }

    public static boolean validation (PedidoEntity pedido) throws PedidoException, ClientNotFoundException, BebidaNotFoundException {
        if (pedido.getCantidad() <= 0){
            throw new PedidoException("Se debe ingresar una cantidad positiva");
        }
        ClienteDAO clienteDAO = new ClienteDAO();
        ClienteService clienteService = new ClienteService();
        //Este metodo tira clientNotFoundException
        clienteService.filterById(pedido.getIdCliente());

        BebidaService bebidaService = new BebidaService();
        //Este metodo tira BebidaNotFoundException
        BebidaEntity bebida = bebidaService.filterById(pedido.getIdBebida());

        if (bebida.getStock() < pedido.getCantidad()){
            throw new PedidoException("La cantidad que se intenta pedir excede el stock disponible");
        }

        bebida.setStock(bebida.getStock() - pedido.getCantidad());

        BebidaDAO bebidaDAO = new BebidaDAO();
        bebidaDAO.update(bebida);

        return true;
    }

    public List<Map<Estados, List<PedidoEntity>>>  listByEstado (){
        List<Map<Estados, List<PedidoEntity>>> filteredList = new ArrayList<>();

        filteredList.add(Map.of(Estados.PENDIENTE, pedidoDAO.list().stream()
                .filter(n -> n.getEstado().equals(Estados.PENDIENTE))
                .toList()));

        filteredList.add(Map.of(Estados.PREPARADO, pedidoDAO.list().stream()
                .filter(n -> n.getEstado().equals(Estados.PREPARADO))
                .toList()));

        filteredList.add(Map.of(Estados.ENTREGADO, pedidoDAO.list().stream()
                .filter(n -> n.getEstado().equals(Estados.ENTREGADO))
                .toList()));

        return filteredList;
    }
}
