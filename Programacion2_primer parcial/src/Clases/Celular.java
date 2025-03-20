package Clases;

import Enumeradores.Categorias;
import Enumeradores.Marcas;
import Interfaces.I_Conectividad;

public class Celular extends Producto implements I_Conectividad {
     private String numero;

    //Constructor
    public Celular(String nombre, double precio, Marcas marca, String numero) {
        super(nombre, precio, marca, Categorias.CELULAR);
        this.numero = numero;
    }

    //Getters/setters
    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
           this.numero = numero;
    }

    //Metodos I_Conectividad
    @Override
    public void activarBluetooth() {
        System.out.println("El bluetooth se activo correctamente");
    }

    @Override
    public void activarWifi() {
        System.out.println("Ingrese la red a la que desea conectarse");
    }

    //ToString

    @Override
    public String toString() {
        return "CELULAR{" +
                "numero=" + numero +
                ", nombre='" + getNombre() +
                ", precio=" + getPrecio()+
                ", marca=" + getMarca() +
                ", categoria=" + getCategoria() +
                '}';
    }
}
