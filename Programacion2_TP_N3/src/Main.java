import Clases.Transporte.Autobus;
import Clases.Transporte.Bicicleta;
import Clases.Transporte.Tranvia;
import Enums.TipoTransporte;

public class Main {
    public static void main(String[] args) {
        punto1();
    }

    public static void punto1(){
        Autobus autobus = new Autobus(554, 40);
        Bicicleta bicicleta = new Bicicleta("30A", TipoTransporte.BICICLETA);
        Tranvia tranvia = new Tranvia("ruta 2", 150, TipoTransporte.TRANVIA);

        autobus.arrancar();
        autobus.detener();
        System.out.println("capacidad: "+autobus.obtenerCapacidad());
        System.out.println(autobus.getTipo());
        tranvia.arrancar();
        tranvia.detener();
        System.out.println("capacidad: "+tranvia.obtenerCapacidad());
        System.out.println(tranvia.getTipo());
        bicicleta.arrancar();
        bicicleta.detener();
        System.out.println("capacidad: "+bicicleta.obtenerCapacidad());
        System.out.println(tranvia.getTipo());
    }

    public static void punto2(){

    }
}

