package Clases;

import Enumeradores.Categorias;
import Enumeradores.Marcas;

public class Accesorio extends Producto{
    private String color;

    //Constructor
    public Accesorio(String nombre, double precio, Marcas marca, String color) {
        super(nombre, precio, marca, Categorias.ACCESORIO);
        this.color = color;
    }
    //Getters/setters
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    //ToString


    @Override
    public String toString() {
        return "ACCESORIO{" +
                ", nombre=" + getNombre()  +
                ", color=" + getColor() +
                ", precio=" + getPrecio() +
                ", marca=" + getMarca() +
                ", categoria=" + getCategoria() +
                '}';
    }
}
