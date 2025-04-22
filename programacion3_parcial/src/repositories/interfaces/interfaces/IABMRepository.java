package repositories.interfaces.interfaces;

import java.util.List;

public interface IABMRepository<T> {
    //Repositorios que implementan Alta, Baja y Modificacion
    void insert (T t);
    List<T> list ();
    void update (T t);
    void delete (int id);
}
