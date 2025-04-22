package repositories.interfaces.service;

import repositories.interfaces.enums.Tipos;
import repositories.interfaces.entities.BebidaEntity;
import repositories.interfaces.exceptions.BebidaNotFoundException;
import repositories.interfaces.interfaces.IRepository;
import repositories.interfaces.repository.BebidaDAO;

import java.util.List;
import java.util.Optional;

public class BebidaService implements IRepository<BebidaEntity> {
    private BebidaDAO bebidaDAO;

    public BebidaService(){
        bebidaDAO = new BebidaDAO();
    }

    public void createBebida (String nombre, Tipos tipo, Double precioUnitario, Integer stock){
        BebidaEntity bebida = new BebidaEntity(nombre, tipo, precioUnitario, stock);
        bebidaDAO.insert(bebida);
    }

    public List<BebidaEntity> listBebidas (){
        return bebidaDAO.list();
    }

    public void updateBebida (String nombre, Tipos tipo, Double precioUnitario, Integer stock){
        BebidaEntity bebida = new BebidaEntity(nombre, tipo, precioUnitario, stock);
        bebidaDAO.update(bebida);
    }

    public void deleteBebida (int id){
        bebidaDAO.delete(id);
    }

    public List<BebidaEntity> filterByTipo (Tipos tipo){
        List<BebidaEntity> filtered = listBebidas();

        return filtered.stream()
                .filter(n -> n.getTipo().equals(tipo))
                .toList();
    }

    public List<BebidaEntity> filterByStock (Integer stock){
        List<BebidaEntity> filtered = listBebidas();

        return filtered.stream()
                .filter(n -> n.getStock() < stock)
                .toList();
    }

    public BebidaEntity filterById (int id) throws BebidaNotFoundException {
        Optional<BebidaEntity> optionalBebida =
                listBebidas().stream()
                        .filter(n -> n.getId() == id)
                        .reduce((a, b) -> a);

        if (optionalBebida.isEmpty()){
            throw new BebidaNotFoundException("La bebida no existe");
        }

        return optionalBebida.orElse(new BebidaEntity());
    }
}
