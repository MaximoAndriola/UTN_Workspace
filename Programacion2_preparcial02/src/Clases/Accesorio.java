package Clases;

import java.util.ArrayList;

public class Accesorio extends Producto{
    public Accesorio(String tipo, String nombre, String marca, double precio, int cantiDisponible, String seccionTienda, ArrayList<Especificaciones> especificaciones, ArrayList<Embalaje> embalajesDisponibles) {
        super(tipo, nombre, marca, precio, cantiDisponible, seccionTienda, especificaciones, embalajesDisponibles);
    }
}