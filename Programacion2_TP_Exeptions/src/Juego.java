import java.util.Random;

public class Juego {
    private int valor;

    public Juego() {
        valor = (int) (Math.random() * 500);
    }

    public int getValor() {
        return valor;
    }

    public String jugar (int num){
        String mensaje = new String();

        if(num == valor){
            mensaje = "Ganaste, felicidades!!!";
        }else if(num < valor){
            mensaje = "mas";
        }else{
            mensaje = "menos";
        }

        return mensaje;
    }

}
