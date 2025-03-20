import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        punto1(scanner);
    }

    public static void punto1(Scanner scanner){
        List <Libro> libros = new ArrayList<>();
        Libro libro = new Libro();
        int opcion;
        String control;

        System.out.println("1- Agregar un nuevo libro al inventario.\n" +
                "2- Eliminar un libro del inventario.\n" +
                "3- Mostrar todos los libros en el inventario.\n" +
                "4- Buscar un libro por su título.\n" +
                "5- Actualizar el precio de un libro.\n" +
                "6- Calcular el precio total de todos los libros en el inventario.\n" +
                "7- Contar el número total de libros en el inventario.\n" +
                "8- Encontrar el libro más caro y el más barato en el inventario.\n");

        opcion = scanner.nextInt();
        scanner.nextLine();

        do {
            switch (opcion) {
                case 1:
                    libro.addLibro(scanner);
                    libros.add(libro);
                    System.out.println(libros);
                    break;

                case 2:
                    System.out.println("Ingrese el titulo del libro que desea eliminar");
                    String titulo = scanner.nextLine();
                    if (libro.deleteLibro(libros, titulo)) {
                        System.out.println("Se elimino correctamente");
                    } else
                        System.out.println("No se encontro el libro deseado2");
                    break;

                default:
                    System.out.println("Opcion Invalida");
            }
            System.out.println("para volver a ejecutar el programa pulse y");
            control = scanner.nextLine();
        }while (control.equals("y") || control.equals("Y"));

    }
}