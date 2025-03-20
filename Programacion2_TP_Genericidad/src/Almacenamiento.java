import java.util.ArrayList;

public class Almacenamiento <T>{
    private ArrayList<T> almacenamiento = new ArrayList<>();

    public void agregar (T t){
        almacenamiento.add(t);
    }

    public boolean eliminar (T t){
        boolean eliminado = false;

        for (int i = 0; i < almacenamiento.size() && !eliminado; i++){
            if(almacenamiento.get(i).equals(t)){
                almacenamiento.remove(t);
                eliminado = true;
            }
        }
        return eliminado;
    }

    public Object buscar(T buscador){
        Object encontrado = new Object();

        for (Object o: almacenamiento){
            if(o.equals(buscador)){
                encontrado = o;
            }
        }

        return encontrado;
    }

    @Override
    public String toString() {
        return "Almacenamiento{" +
                "almacenamiento=" + almacenamiento +
                '}';
    }
}
