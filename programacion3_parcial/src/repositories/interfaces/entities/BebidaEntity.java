package repositories.interfaces.entities;

import repositories.interfaces.enums.Tipos;

public class BebidaEntity {
    private int id;
    private String nombre;
    private Tipos tipo;
    private Double precioUnitario;
    private int stock;

    public BebidaEntity(String nombre, Tipos tipo, Double precioUnitario, int stock) {
        this.id = 0;
        this.nombre = nombre;
        this.tipo = tipo;
        this.precioUnitario = precioUnitario;
        this.stock = stock;
    }

    public BebidaEntity (){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Tipos getTipo() {
        return tipo;
    }

    public void setTipo(Tipos tipo) {
        this.tipo = tipo;
    }

    public Double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(Double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "Bebida(" +
                "id: " + id +
                ", nombre: " + nombre +
                ", tipo: " + tipo +
                ", precioUnitario: " + precioUnitario +
                ", stock: " + stock +
                ")";
    }
}