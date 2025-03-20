import java.util.ArrayList;

public class Conjunto<T> {
    private ArrayList<T> conjunto = new ArrayList<>();

    public boolean agregar(T t){
        boolean agregado = false;

        if (!conjunto.contains(t)){
            conjunto.add(t);
            agregado = true;
        }
        return agregado;
    }

    public boolean eliminar(T t){
        boolean eliminado = false;

        if (conjunto.contains(t)){
            conjunto.remove(t);
            eliminado = true;
        }
        return eliminado;
    }

    @Override
    public String toString() {
        return "Conjunto{" +
                "conjunto=" + conjunto +
                '}';
    }
}
