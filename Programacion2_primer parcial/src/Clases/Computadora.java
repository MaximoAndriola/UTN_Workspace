package Clases;

import Enumeradores.Categorias;
import Enumeradores.Marcas;
import Enumeradores.TiposPC;
import Interfaces.I_Conectividad;

public class Computadora extends Producto implements I_Conectividad {
    private TiposPC tipo;

    //Constructor
    public Computadora(String nombre, double precio, Marcas marca, TiposPC tipo) {
        super(nombre, precio, marca, Categorias.COMPUTADORA);
        this.tipo = tipo;

    }

    //Getters/setters
    public TiposPC getTipo() {
        return tipo;
    }

    public void setTipo(TiposPC tipo) {
        this.tipo = tipo;
    }

    //Metodos
    @Override
    public void activarBluetooth() {
        System.out.println("Se activo el bluetooth en la pc");
    }

    @Override
    public void activarWifi() {
        System.out.println("Se activo el wifi en la pc");
    }

    //ToString
    @Override
    public String toString() {
        return "Computadora{" +
                "Tipo= " + tipo +
                ", nombre='" + getNombre() +
                ", precio=" + getPrecio() +
                ", marca=" + getMarca() +
                ", categoria=" + getCategoria() +
                '}';
    }
}
