import Clases.*;
import Exeptions.ProductoInvalidoExeption;
import JSONUtiles.JSONUtiles;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import JSONUtiles.GestionJSON;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String control;
        int opcion;
        Scanner scanner = new Scanner(System.in);
        Tienda tienda = GestionJSON.mapeoTienda();
        ArrayList<Producto> listaFiltrada = new ArrayList<>();

        do{
            System.out.println("1- cargar producto nuevo\n" +
                    "2- mostrar productos\n" +
                    "3- filtrar por portatiles\n" +
                    "4- filtrar por precio y marca\n" +
                    "5- filtrar por unidadades disponibles y especificaciones\n");
            opcion = scanner.nextInt();
            scanner.nextLine();
            switch (opcion){
                case 1:
                    tienda.agregarProducto(tienda.cargarNuevoProducto());
                    break;
                case 2:
                    System.out.println(tienda);
                    break;
                case 3:
                    System.out.println("Ingresar la categoria que se quiere filtrar");
                    String categoria = scanner.nextLine();
                    listaFiltrada = tienda.filtrarPorCategoria(categoria);
                    System.out.println(listaFiltrada);
                    break;
                case 4:
                    System.out.println("Ingresar precio minimo a filtrar");
                    double pMin = scanner.nextDouble();
                    scanner.nextLine();
                    if (pMin < 0){
                        throw new ProductoInvalidoExeption("El precio ingresado no puede ser menor a 0");
                    }
                    System.out.println("Ingresar marca a filtrar");
                    String marca = scanner.nextLine();
                    listaFiltrada = tienda.filtrarPorPrecioYMarca(pMin, marca);
                    System.out.println(listaFiltrada);
                    break;
                case 5:
                    System.out.println("Ingresar especificaciones deseadas");
                    String especificaciones = scanner.nextLine();
                    System.out.println("Ingresar minimo de unidades disponibles");
                    int unidades = scanner.nextInt();
                    scanner.nextLine();
                    listaFiltrada = tienda.filtrarPorEspecificacionesYUnidades(especificaciones, unidades);

                    System.out.println(listaFiltrada);
                    break;
                default:
                    System.out.println("Opcion ingresada invalida");
                    break;
            }
            System.out.println("Para continuar presione s");
            control = scanner.nextLine();
        }while (control.equalsIgnoreCase("s"));
    }
}