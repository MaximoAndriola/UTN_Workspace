package repositories.interfaces.entities;

import repositories.interfaces.enums.TiposCliente;

public class ClienteEntity {
    private int id;
    private String nombre;
    private String localidad;
    private TiposCliente tipoCliente;

    public ClienteEntity(String nombre, String localidad, TiposCliente tipoCliente) {
        this.id = 0;
        this.nombre = nombre;
        this.localidad = localidad;
        this.tipoCliente = tipoCliente;
    }

    public ClienteEntity (){}

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

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public TiposCliente getTipoCliente() {
        return tipoCliente;
    }

    public void setTipoCliente(TiposCliente tipoCliente) {
        this.tipoCliente = tipoCliente;
    }

    @Override
    public String toString() {
        return "ClienteEntity(" +
                "id: " + id +
                ", nombre: " + nombre +
                ", localidad: " + localidad +
                ", tipoCliente: " + tipoCliente +
                ")";
    }
}
