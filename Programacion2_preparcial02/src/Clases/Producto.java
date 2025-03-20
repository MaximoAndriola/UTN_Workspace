package Clases;

import Exeptions.ProductoInvalidoExeption;

import java.util.ArrayList;

public abstract class Producto {
    private String tipo;
    private String nombre;
    private String marca;
    private double precio;
    private int cantiDisponible;
    private String seccionTienda;
    private ArrayList<Especificaciones> especificaciones;
    private ArrayList<Embalaje> embalajesDisponibles;

    //Constructor
    public Producto(String tipo, String nombre, String marca, double precio, int cantiDisponible, String seccionTienda, ArrayList<Especificaciones> especificaciones, ArrayList<Embalaje> embalajesDisponibles) {
        this.tipo = tipo;
        this.nombre = nombre;
        this.marca = marca;
        this.precio = precio;
        this.cantiDisponible = cantiDisponible;
        this.seccionTienda = seccionTienda;
        this.especificaciones = especificaciones;
        this.embalajesDisponibles = embalajesDisponibles;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        if(precio > 0){
            this.precio = precio;
        }else throw new ProductoInvalidoExeption("El precio no puede ser negativo");
    }

    public int getCantiDisponible() {
        return cantiDisponible;
    }

    public void setCantiDisponible(int cantiDisponible) {
        this.cantiDisponible = cantiDisponible;
    }

    public String getSeccionTienda() {
        return seccionTienda;
    }

    public void setSeccionTienda(String seccionTienda) {
        this.seccionTienda = seccionTienda;
    }

    public ArrayList<Especificaciones> getEspecificaciones() {
        return especificaciones;
    }

    public void setEspecificaciones(ArrayList<Especificaciones> especificaciones) {
        this.especificaciones = especificaciones;
    }

    public ArrayList<Embalaje> getEmbalajesDisponibles() {
        return embalajesDisponibles;
    }

    public void setEmbalajesDisponibles(ArrayList<Embalaje> embalajesDisponibles) {
        this.embalajesDisponibles = embalajesDisponibles;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "tipo='" + tipo + '\'' +
                ", nombre='" + nombre + '\'' +
                ", marca='" + marca + '\'' +
                ", precipo=" + precio +
                ", cantiDisponible=" + cantiDisponible +
                ", seccionTienda='" + seccionTienda + '\'' +
                ", especificaciones=" + especificaciones +
                ", embalajesDisponibles=" + embalajesDisponibles +
                '}';
    }
}
