import java.util.Stack;

public class Pila <T>{
    private Stack<T> pilita = new Stack<>();

    public void agregar (T t){
        pilita.add(t);
    }

    public boolean eliminar (T t){
        boolean eliminado = false;

        while (!pilita.isEmpty() && !eliminado){
            if(pilita.pop().equals(t)){
                pilita.remove(t);
                eliminado = true;
            }
        }

        return eliminado;
    }

     public int cantidad (){
        int i = 0;
        for (Object o : pilita){
            i++;
        }
        return i;
     }

    @Override
    public String toString() {
        return "Pila{" +
                "pilita=" + pilita +
                '}';
    }
}
