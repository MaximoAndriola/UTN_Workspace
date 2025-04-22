package repositories.interfaces.interfaces;

public interface IRepository<T> {
    //Metodos comunes en todos los Repositorios
    T filterById (int id) throws Exception;
}