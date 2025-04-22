package repositories.interfaces.entities;

import repositories.interfaces.enums.Estados;

public class PedidoEntity {
    private int id;
    private int idCliente;
    private int idBebida;
    private int cantidad;
    private Estados estado;

    public PedidoEntity(int idCliente, int idBebida, int cantidad) {
        this.id = 0;
        this.idCliente = idCliente;
        this.idBebida = idBebida;
        this.cantidad = cantidad;
        this.estado = Estados.PENDIENTE;
    }

    public PedidoEntity(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getIdBebida() {
        return idBebida;
    }

    public void setIdBebida(int idBebida) {
        this.idBebida = idBebida;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Estados getEstado() {
        return estado;
    }

    public void setEstado(Estados estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "PedidoEntity(" +
                "id: " + id +
                ", idCliente: " + idCliente +
                ", idBebida: " + idBebida +
                ", cantidad: " + cantidad +
                ", estado:" + estado +
                ")";
    }
}
