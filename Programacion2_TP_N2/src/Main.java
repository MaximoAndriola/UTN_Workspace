//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Empleado maximo = new Empleado("Maximo", "Andriola", 100000);
        Empleado marcos = new Empleado("Marcos", "Sosa", 200000);

        System.out.println(maximo);
        System.out.println(marcos);
        System.out.println("Su salario anual es: " +
                "\nMarcos: " + marcos.calcularSalarioAnual() +
                "\nMaximo: " + maximo.calcularSalarioAnual());
        maximo.setSalario(maximo.aumentarSalario(20));
        marcos.setSalario(marcos.aumentarSalario(50));
        System.out.println("Su salario despues del aumento es: " +
                "\nMarcos: " + marcos.getSalario() +
                "\nMaximo: " + maximo.getSalario());
    }
}