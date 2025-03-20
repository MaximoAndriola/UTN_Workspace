import Clases.Biblioteca;
import Clases.Libro;
import Clases.Material;
import Enumeradores.Genero;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();
        Scanner scanner = new Scanner(System.in);
        Material m;
        int opcion;
        String control;
        String titulo;

        do {
            System.out.println("1:agregar " +
                    "2:eliminar " +
                    "3:modificar " +
                    "4:ordenar " +
                    "5:mostrar " +
                    "6:prestar " +
                    "7:devolver " +
                    "8:filtrar genero");
            opcion = scanner.nextInt();
            scanner.nextLine();
            switch (opcion) {
                case 1:
                    biblioteca.agregarMaterial(new Libro("Harry Potter", "J.K. Rowlling", "2014", "200", Genero.DRAMA, 2000));
                    biblioteca.agregarMaterial(new Libro("Yo Robot", "J.K. Rowlling", "2014", "200", Genero.DRAMA, 1200));
                    biblioteca.agregarMaterial(new Libro("El señor de los anillos", "J.K. Rowlling", "2014", "200", Genero.DRAMA, 1200.4));
                    biblioteca.agregarMaterial(new Libro("Iron Man", "J.K. Rowlling", "2014", "200", Genero.DRAMA, 200));
                    break;
                case 2:
                    biblioteca.eliminarMaterial("El señor de los anillos");
                    break;
                case 3:
                    m = new Libro("Mundo Gaturro", "YO", "1999", "5000", Genero.TERROR, 5000);

                    biblioteca.modificarMaterial("Yo Robot", m);
                    break;
                case 4:
                    biblioteca.ordenarTitulo(biblioteca);
                    break;
                case 5:
                    System.out.println(biblioteca);
                    break;
                case 6:
                    System.out.println("Ingrese el titulo del material que desea");
                    titulo = scanner.nextLine();
                    m = biblioteca.filtrarTitulo(biblioteca.getCatalogo(), titulo);
                    biblioteca.prestable(m);
                    break;
                case 7:
                    System.out.println("Ingrese el titulo del material que se devolvera");
                    titulo = scanner.nextLine();
                    m = biblioteca.filtrarTitulo(biblioteca.getCatalogo(), titulo);
                    biblioteca.prestable(m);
                    break;
                case 8:
                    List<Libro> l = new ArrayList<>();
                    l = biblioteca.filtrarLibrosPorGenero(Genero.DRAMA);
                    System.out.println(l);
                    break;
            }
            System.out.println("Para continuar presione y");
            System.out.println("Para salir presione cualquier tecla");

            control = scanner.nextLine();
        }while (control.equals("y") || control.equals("Y"));
    }
}