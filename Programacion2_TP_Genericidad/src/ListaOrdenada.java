import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ListaOrdenada <T> implements Comparable {
    private ArrayList<T> lista = new ArrayList<>();

    public void agregar(T t){
        lista.add(t);
        Collections.sort(lista);
    }

    public boolean eliminar(T t){
        boolean eliminado = false;

        if(lista.contains(t)){
            lista.remove(t);
            eliminado = true;
        }

        return eliminado;
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }

    @Override
    public String toString() {
        return "ListaOrdenada{" +
                "lista=" + lista +
                '}';
    }
}
