package Clases;

import Exeptions.ProductoInvalidoExeption;

import java.security.ProtectionDomain;
import java.util.ArrayList;
import java.util.Scanner;

public class Tienda<T extends Producto> {
    private String nombre;
    private String ubicacion;
    private ArrayList<T> productos;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public ArrayList<T> getProductos() {
        return productos;
    }

    public void setProductos(ArrayList<T> productos) {
        this.productos = productos;
    }

    //Metodos
    public void agregarProducto(T t){
        productos.add(t);
    }

    public Producto cargarNuevoProducto (){
        Scanner scanner = new Scanner(System.in);
        String tipo = new String();
        System.out.println("Ingresar:");
        System.out.println("tipo:");
        do {
            tipo = scanner.nextLine();
            if(!tipo.equalsIgnoreCase("dispositivoMovil") & !tipo.equalsIgnoreCase("accesorio") & !tipo.equalsIgnoreCase("portatil")){
                throw new ProductoInvalidoExeption();
            }
        }while (!tipo.equalsIgnoreCase("dispositivoMovil") & !tipo.equalsIgnoreCase("accesorio") & !tipo.equalsIgnoreCase("portatil"));

        System.out.println("nombre: ");
        String nombre = scanner.nextLine();
        System.out.println("marca: ");
        String marca = scanner.nextLine();
        System.out.println("precio: ");
        double precio = scanner.nextDouble();
        System.out.println("cantidad: ");
        int cantidad = scanner.nextInt();
        System.out.println("seccion: ");
        String seccion = scanner.nextLine();
        Especificaciones especificaciones = new Especificaciones("pantalla", "5.2");
        ArrayList<Especificaciones> arrayEs = new ArrayList<>();
        arrayEs.add(especificaciones);
        Embalaje embalaje = new Embalaje("carton", "duro", "20cm");
        ArrayList<Embalaje> arrayEm = new ArrayList<>();
        arrayEm.add(embalaje);

        if(tipo.equalsIgnoreCase("dispositivoMovil")){
            DispositivoMovil producto = new DispositivoMovil(
                    "dispositivoMovil"
                    , nombre
                    , marca
                    , precio
                    , cantidad
                    , seccion
                    , arrayEs
                    , arrayEm);
            return producto;
        } else if (tipo.equalsIgnoreCase("portatil")) {
            Portatil producto = new Portatil(
                    "Portatil"
                    , nombre
                    , marca
                    , precio
                    , cantidad
                    , seccion
                    , arrayEs
                    , arrayEm);
            return producto;
        } else {
            Accesorio producto = new Accesorio(
                    "Portatil"
                    , nombre
                    , marca
                    , precio
                    , cantidad
                    , seccion
                    , arrayEs
                    , arrayEm);
            return producto;
        }
    }

    //Filtros
    public ArrayList<T> filtrarPorCategoria (String categoria){
        ArrayList<T> listaFiltrada = new ArrayList<>();

        for (int i = 0; i < productos.size(); i++) {
            if(productos.get(i).getTipo().equalsIgnoreCase(categoria)){
                listaFiltrada.add(productos.get(i));
            }
        }

        return listaFiltrada;
    }

    public ArrayList<T> filtrarPorPrecioYMarca (double pMin, String marca){
        ArrayList<T> listaFilrada = new ArrayList<>();

        for (int i = 0; i < productos.size(); i++) {
            if (productos.get(i).getPrecio() >= pMin){
                if (productos.get(i).getMarca().equalsIgnoreCase(marca)){
                    listaFilrada.add(productos.get(i));
                }
            }
        }

        return listaFilrada;
    }

    public ArrayList<T> filtrarPorEspecificacionesYUnidades (String especificacion, int unidades){
        ArrayList<T> listaFiltrada = new ArrayList<>();

        for (int i = 0; i < productos.size(); i++){
            if(productos.get(i).getCantiDisponible() >= unidades){
                ArrayList<Especificaciones> especificaciones = productos.get(i).getEspecificaciones();
                for (int j = 0; j < especificaciones.size(); j++) {
                    if (especificaciones.get(j).getNombre().equalsIgnoreCase(especificacion)){
                        listaFiltrada.add(productos.get(i));
                    }
                }
            }
        }

        return listaFiltrada;
    }

    @Override
    public String toString() {
        return "Tienda{" +
                "nombre='" + nombre + '\'' +
                ", ubicacion='" + ubicacion + '\'' +
                ", productos=" + productos +
                '}';
    }
}