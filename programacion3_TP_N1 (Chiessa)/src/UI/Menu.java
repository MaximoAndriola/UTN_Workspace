package UI;

import model.Application;
import model.PaymentManager;
import model.PaymentMethods;

import java.util.Currency;
import java.util.Scanner;

public class Menu {
    private final Scanner input;
    private Integer opction;
    private String control;

    public Menu(Scanner input) {
        this.input = input;
    }

    public void showMenu () {
        do {
            System.out.println(
                    "1- Pagar\n" +
                    "2- Mostrar pagos\n");
            opction = input.nextInt();
            input.nextLine();

            switch (opction){
                case 1:
                    paymentMetod();
                    break;
                case 2:

                    break;
                default:
                    System.out.println("OPCION INVALIDA");
                    break;
            }

            System.out.println("Para volver al menu principal presione s");
            control = input.nextLine();

        }while (control.equalsIgnoreCase("s"));
    }

    public void paymentMetod (){
        System.out.println(
                "Elija el metodo de pago: \n" +
                "1- Aplicacion \n" +
                "2- Tarjeta \n" +
                "3- Efectivo \n");

        opction = input.nextInt();
        input.nextLine();

        do {
            switch (opction){
                case 1:
                    paymentApp();
                    break;
                case 2:

                    break;
                case 3:

                    break;
                default:
                    System.out.println("OPCION INVALIDA");
                    break;
            }
        }while (opction != 1 && opction != 2 && opction != 3);

    }

    public void paymentApp(){
        Application app = new Application();
        String currency;
        Double ammount;

        do {
            System.out.println("Tipo de moneda: ");
            currency = input.nextLine();

            try {
                app.setCurrency(currency);
            }catch (IllegalArgumentException e){
                System.out.println("tipo de moneda invalido");
                currency = "";
            }
        }while (currency.isEmpty());


        System.out.println("Cantidad: ");
        ammount = input.nextDouble();
        app.setValue(ammount);

        PaymentManager.processPayment(app);
    }
}
