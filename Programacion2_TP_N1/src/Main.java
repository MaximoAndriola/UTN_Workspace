import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int [] numeros = new int[5]; //declaracion arreglos

        //punto1();
        //punto2(scanner);
        //punto3(scanner);
        //punto5(scanner);
        //punto6(scanner);
        //punto7(scanner);
        //punto8(scanner);
        //punto9(scanner);
        punto10(scanner);
        scanner.close();
    }


    public static void punto1() {
        int numN = 4;
        double numA = 3.2;
        char numC = 'o';

        System.out.println("El numN es " + numN);
        System.out.println("El numA es " + numA);
        System.out.println("El numC es " + numC);
        System.out.println("La suma de numN y numA es " + (numN + numA));
        System.out.println("numC pasado a numero es " + (int)numC);
    }

    public static void  punto2(Scanner scanner){

        int num1, num2, suma = 0;
        String opcion;

        System.out.println("+ = suma");
        System.out.println("- = resta");

        opcion = scanner.nextLine();

        System.out.println("Ingresar 2 numeros");
        num1 = scanner.nextInt();
        scanner.nextLine();
        num2 = scanner.nextInt();
        scanner.nextLine();

        if(Objects.equals(opcion, "+"))
            suma = num1 + num2;
        else if (Objects.equals(opcion, "-"))
            suma = num1 - num2;

        System.out.println("La suma es " + suma);
    }

    public static void punto3(Scanner scanner){
        int num = scanner.nextInt();
        scanner.nextLine();
        System.out.printf("%d + 3 = %d\n", num, (num + 3));
        System.out.printf("%d x 2 = %d\n", num, (num * 2));
        System.out.printf("%d - 77 = %d", num, (num - 77));
    }

    public static void punto5(Scanner scanner){
        int num = scanner.nextInt();
        scanner.nextLine();
        if(num%2 == 0)
            System.out.println("Es par");
        else
            System.out.println("Es impar");
    }

    public static void punto6(Scanner scanner){
        int num = scanner.nextInt();
        scanner.nextLine();
        if(num > 0)
            System.out.println("Es positivo");
        else if (num < 0)
            System.out.println("Es negativo");
        else
            System.out.println("Es cero");

    }

    public static void punto7(Scanner scanner){
        char caracter = scanner.nextLine().charAt(0);
        System.out.println("Su numero ASCI es "+(int)caracter);
    }

    public static void punto8(Scanner scanner){
        int numero = scanner.nextInt();
        scanner.nextLine();
        if(numero%2 == 0)
            System.out.println("Es par");
        if(numero > 0)
            System.out.println("Es positivo");
        if(numero%5 == 0)
            System.out.println("Es multiplo de 5");
        if(numero%10 == 0)
            System.out.println("Es multiplo de 10");
    }

    public static void  punto9(Scanner scanner){
        System.out.println("Ingrese su nombre");
        String nombre = new String();
        nombre = scanner.nextLine();
        System.out.println("Buenos dias " +nombre);
    }

    public static void punto10(Scanner scanner){
        double radio = scanner.nextDouble();
        scanner.nextLine();
        double longitud = 2 * Math.PI * radio;
        double area = Math.PI * Math.pow(radio, 2);
        System.out.println("Longitud: "+longitud+
                "\tArea: "+area);
    }

}
