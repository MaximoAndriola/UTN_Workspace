import Clases.*;
import Enumeradores.Categorias;
import Enumeradores.Marcas;
import Enumeradores.TiposPC;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Arreglo de tienda
        Tienda tienda = new Tienda();
        //Scanner
        Scanner scanner = new Scanner(System.in);
        //Arraylist aux para manejo de funciones
        ArrayList<Producto> aux = new ArrayList<>();
        //Controlador de opciones Switch
        String opcion;
        //Controlador de repeticion
        String control;

        do {
            System.out.println("1: Alta");
            System.out.println("2: Baja");
            System.out.println("3: Mostrar");
            System.out.println("4: Ordenar");
            System.out.println("5: Filtrar por categoria: ");
            System.out.println("6: Filtrar por marca: ");
            System.out.println("7: Filtrar por rango precio: ");

            opcion = scanner.nextLine();

            switch (opcion) {
                case "1":
                    tienda.darDeAlta(new Celular("Iphone", 1200, Marcas.APPLE, "2234243399"));
                    tienda.darDeAlta(new Celular("Samsung Galaxy S20", 2000, Marcas.SAMSUNG, "2231112222"));
                    tienda.darDeAlta(new Celular("Samsung Galaxy A54", 1500, Marcas.SAMSUNG, "2234445555"));
                    tienda.darDeAlta(new Celular("Samsung Galaxy A20", 1000, Marcas.SAMSUNG, "2236667777"));
                    tienda.darDeAlta(new Computadora("MacBook", 3000, Marcas.APPLE, TiposPC.PORTATIL));
                    tienda.darDeAlta(new Accesorio("FundaSamsung", 200, Marcas.SAMSUNG, "Roja"));

                    break;
                case "2":
                    tienda.darDeBaja("Iphone");

                    break;
                case "3":
                    System.out.println(tienda);

                    break;
                case "4":
                    tienda.ordenarPorPrecio();

                    break;
                case "5":
                    aux = tienda.filtrarPorCategoria(Categorias.CELULAR);
                    System.out.println(aux);

                    break;
                case "6":
                    aux = tienda.filtrarCelularPorMarca(Marcas.APPLE);
                    System.out.println(aux);

                    break;
                case "7":
                    tienda.ordenarPorPrecio();
                    aux = tienda.filtrarPorRangoPrecios(1100, 5000);
                    System.out.println(aux);
                    break;
                default:
                    System.out.println("Opcion invalida");
                    break;
            }
            System.out.println("Para dejar de ejecutar el programa precione n");
            control = scanner.nextLine();
        }while (!control.equalsIgnoreCase("n"));

    }
}