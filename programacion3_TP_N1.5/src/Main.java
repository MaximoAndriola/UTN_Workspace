import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    Shop shop = new Shop();
    int option;
    String category;
    Scanner in = new Scanner(System.in);

    System.out.println(
            "1- Obtener una lista con los nombres y precios de los productos de la categoría Electrónica cuyo precio sea mayor a 1000, ordenados de mayor a menor precio.\n" +
            "2- Reducción de Datos: Calcular el precio promedio de los productos de la categoría Hogar, perosolo considerando aquellos con stock disponible.\n" +
            "3- Obtener el producto más caro de cada categoría y devolver un mapa con la categoría como clave y el producto más caro como valor.\n" +
            "");
    option = in.nextInt();
    in.nextLine();

    switch (option) {
        case 1:
            System.out.println("Categoria: ");
            category = in.nextLine();
            System.out.println("Precio minimo: ");
            Double price = in.nextDouble();
            in.nextLine();

            List<Map<String, Double>> filteredMap = shop.getListedNamesAndPricesByCategory(category, price);
            System.out.println(filteredMap);
            break;
        case 2:
            System.out.println("Categoria: ");
            category = in.nextLine();


            Optional<Double> average = shop.getAveragePriceByCategory(category);
            Double dAverage = average.orElse(0.00);
            System.out.println("El promedio de los productos de la categoria " + category + " es $" + dAverage);
            break;
        case 3:
            List<Map<String, Product>> filteredMap1 = shop.getExpesivestProductByCategory();

            System.out.println(filteredMap1);
            break;
            //TODO Seguir con los puntos que faltan
        default:
            System.out.println("Opcion invalida");
            break;
    }

    }
}