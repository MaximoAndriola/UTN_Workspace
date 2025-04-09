import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        List<Integer> alteredNumbers = new ArrayList<>();
        List<String> names = new ArrayList<>();
        List<String> alteredNames = new ArrayList<>();
        int cant;
        int option;
        Scanner in = new Scanner(System.in);

        numbers.add(5);
        numbers.add(4);
        numbers.add(2);
        numbers.add(1);
        numbers.add(10);
        numbers.add(8);
        numbers.add(3);
        numbers.add(7);
        numbers.add(6);
        numbers.add(9);
        numbers.add(1);

        names.add("Mauro");
        names.add("Maximo");
        names.add("Julian");
        names.add("Tobias");
        names.add("Ignacio Ruibal");

        System.out.println(
                numbers + "\n" +
                names + "\n" +
                "1- Filtrar numeros pares\n" +
                "2- Transformar una lista de nombres a mayúsculas\n" +
                "3- Ordenar una lista de números\n" +
                "4- Contar elementos mayores a un valor dado\n" +
                "5- Obtener los primeros 5 elementos de una lista\n" +
                "6- Convertir una lista de palabras en su longitud\n" +
                "7- Concatenar nombres con una separación\n" +
                "8- Eliminar duplicados de una lista\n" +
                "9- Obtener los 3 números más grandes de una lista\n" +
                "10- Agrupar palabras por su longitud\n" +
                "11- Encontrar el producto de todos los números de una lista\n" +
                "12- Obtener el nombre más largo de una lista\n" +
                "13- Convertir una lista de enteros en una cadena separada por guiones\n" +
                "14- Agrupar una lista de números en pares e impares\n" +
                "15- Obtener la suma de los cuadrados de los números impares");

        option = in.nextInt();
        in.nextLine();

        switch (option){
            case 1:
                //1- Filtrar números pares
                //Dada una lista de números enteros, utiliza filter para obtener solo los números pares y guárdalos en una nueva lista.
                numbers.stream()
                        .filter(n -> n % 2 == 0)
                        .forEach(alteredNumbers::add);

                System.out.println(alteredNumbers);
                break;
            case 2:
                //2- Transformar una lista de nombres a mayúsculas
                //Usa map para convertir cada nombre de una lista en su versión en mayúsculas.
                names.stream()
                        .map(String::toUpperCase)
                        .forEach(alteredNames::add);

                System.out.println(alteredNames);
                break;
            case 3:
                //3- Ordenar una lista de números
                //Usa sorted para ordenar una lista de números enteros de menor a mayor
                numbers.stream()
                        .sorted()
                        .forEach(alteredNumbers::add);

                System.out.println(alteredNumbers);
                break;
            case 4:
                //4- Contar elementos mayores a un valor dado
                //Dada una lista de números, usa filter y count para contar cuántos valores son mayores que 7.
                int max = in.nextInt();
                cant = (int) numbers.stream()
                        .filter(n -> n > max)
                        .count();

                System.out.println(cant);
                break;
            case 5:
                //5- Obtener los primeros 5 elementos de una lista
                //Usa limit para extraer solo los primeros 5 elementos de una lista de números.
                numbers.stream()
                        .limit(5)
                        .forEach(alteredNumbers::add);

                System.out.println(alteredNumbers);
                break;
            case 6:
                //6- Convertir una lista de palabras en su longitud
                //Usa map para transformar una lista de palabras en una lista con la longitud de cada palabra.
                names.stream()
                        .map(String::length)
                        .forEach(alteredNumbers::add);

                System.out.println(alteredNumbers);
                break;
            case 7:
                //7- Concatenar nombres con una separación
                //Dada una lista de nombres, usa reduce para concatenarlos en un solo String separados por comas.
                String concatenedNames = names.stream()
                        .reduce("", (a, b) -> a + ", " + b);

                System.out.println(concatenedNames);
                break;
            case 8:
                //8- Eliminar duplicados de una lista
                //Usa distinct para remover duplicados de una lista de números enteros.
                numbers.stream()
                        .distinct()
                        .forEach(alteredNumbers::add);
                System.out.println(alteredNumbers);
                break;
            case 9:
                //9- Obtener los 3 números más grandes de una lista
                //Usa sorted y limit para encontrar los 3 números más grandes en una lista de enteros.
                numbers.stream()
                        .sorted(Comparator.reverseOrder())
                        .limit(3)
                        .forEach(alteredNumbers::add);

                System.out.println(alteredNumbers);
                break;
            case 10:
                //10- Agrupar palabras por su longitud
                //Usa Collectors.groupingBy para agrupar una lista de palabras según su cantidad de caracteres.
                Map<Integer, List<String>> groupingNames = names.stream()
                        .collect(Collectors.groupingBy(String::length));

                System.out.println(groupingNames);
                break;
            case 11:
                //11- Encontrar el producto de todos los números de una lista
                //Usa reduce para calcular el producto de todos los números de una lista.
                int product = numbers.stream()
                        .reduce(1, (a, b) -> a * b);

                System.out.println(product);
                break;
            case 12:
                //12- Obtener el nombre más largo de una lista
                //Usa reduce para encontrar el nombre con más caracteres en una lista de nombres.
                Optional<String> largestName = names.stream()
                        .reduce((a, b) -> a.length() >= b.length() ? a : b);

                System.out.println(largestName);
                break;
            case 13:
                //13- Convertir una lista de enteros en una cadena separada por guiones
                //Usa map y Collectors.joining para convertir una lista de enteros en una cadena con valores separados por -.
                String concatenedNumbers = numbers.stream()
                        .map(String::valueOf)
                        .collect(Collectors.joining(" - "));

                System.out.println(concatenedNumbers);
                break;
            case 14:
                //14- Agrupar una lista de números en pares e impares
                //Usa Collectors.partitioningBy para separar los números de una lista en pares e impares.
                Map<Boolean, List<Integer>> partitioned = numbers.stream()
                        .collect(Collectors.partitioningBy(n -> n % 2 == 0));

                System.out.println("Pares: " + partitioned.get(true));
                System.out.println("Impares: " + partitioned.get(false));
                break;
            case 15:
                //15. Obtener la suma de los cuadrados de los números impares
                //Usa filter, map y reduce para obtener la suma de los cuadrados de los números impares de una lista.
                int sum = numbers.stream()
                        .filter(n -> n % 2 == 0)
                        .map(n -> n * n)
                        .reduce(0, Integer::sum);

                System.out.println(sum);
                break;
            default:
                System.out.println("Opcion invalida");
                break;
        }


    }
}