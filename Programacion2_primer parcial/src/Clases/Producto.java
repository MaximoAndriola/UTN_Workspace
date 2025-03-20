package Clases;

import Enumeradores.Categorias;
import Enumeradores.Marcas;

public abstract class Producto implements Comparable<Producto>{
    private int ID = ++Producto.cantidadProductos;
    private String nombre;
    private Double precio;
    private Marcas marca;
    private static int cantidadProductos;
    private Categorias categoria;

    //Constructor
    public Producto(String nombre, double precio, Marcas marca, Categorias categoria) {
        this.nombre = nombre;
        this.precio = precio;
        this.marca = marca;
        this.categoria = categoria;
    }

    //getters/setters
    public int getID() {
        return ID;
    }

    public Categorias getCategoria() {
        return categoria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public Marcas getMarca() {
        return marca;
    }

    public void setMarca(Marcas marca) {
        this.marca = marca;
    }

    //Metodo compareTo
    @Override
    public int compareTo(Producto p) {
        return p.precio.compareTo(this.precio);
    }

    //ToString
    @Override
    public String toString() {
        return "Producto{" +
                "ID=" + ID +
                ", nombre='" + nombre + '\'' +
                ", precio=" + precio +
                ", marca=" + marca +
                ", categoria=" + categoria +
                '}';
    }
}
