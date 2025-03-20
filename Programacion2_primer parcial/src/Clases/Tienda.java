package Clases;

import Enumeradores.Categorias;
import Enumeradores.Marcas;

import java.security.ProtectionDomain;
import java.util.ArrayList;
import java.util.Collections;

public class Tienda {
    //Lista de productos
    private ArrayList<Producto> productos = new ArrayList<>();

    //Metodos

    //Ordenamiento
    public void ordenarPorPrecio(){
        Collections.sort(productos);
    }

    //Filtros

    public ArrayList<Producto> filtrarPorCategoria (Categorias categoria) {
        //Se crea lista auxiliar en la que se guardan los productos que cumplan las condiciones
        ArrayList<Producto> listaFiltrada = new ArrayList<>();

        //Se compara la categoria de los productos con la que se pasa por parametro
        for (Producto p : productos){
            if (p.getCategoria().equals(categoria)) {
                //Se agrega a la lista filtrada
                listaFiltrada.add(p);
            }
        }
        return listaFiltrada;
    }

    public ArrayList<Producto> filtrarPorRangoPrecios (double min, double max){
        //Se crea lista auxiliar en la que se guardan los productos que cumplan las condiciones
        ArrayList<Producto> listaFiltrada = new ArrayList<>();

        for (Producto p : productos){
            //Se compara que el precio del producto este dentro del rango que se pasa por parametro
            if(p.getPrecio() > min && p.getPrecio() < max){
                //Se agrega a la lista filtrada
                listaFiltrada.add(p);
            }
        }
        return listaFiltrada;
    }

    public ArrayList<Producto> filtrarCelularPorMarca (Marcas marca){
        //Se crea lista auxiliar en la que se guardan los productos que cumplan las condiciones
        ArrayList<Producto> listaFiltrada = new ArrayList<>();

        for (Producto p : productos){
            //Se revisa que sea instancia de celular
            if(p instanceof Celular c) {
                //Se compara la categoria de los productos con la que se pasa por parametro
                if (c.getMarca().equals(marca)) {
                    //Se agrega a la lista filtrada
                    listaFiltrada.add(p);
                }
            }
        }
        return listaFiltrada;
    }

    //Alta
    public void darDeAlta(Producto p){
        productos.add(p);
    }

    //Baja
    public void darDeBaja(String nombre){
        for (int i = 0; i < productos.size(); i++) {
            Producto p = productos.get(i);
            if(p.getNombre().equals(nombre)){
                productos.remove(p);
            }
        }
    }

    @Override
    public String toString() {
        return "Tienda{" +
                "productos=" + productos +
                '}';
    }
}
