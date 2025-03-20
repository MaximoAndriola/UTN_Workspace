package Interfaces;

import Enums.Genero;
import Exeptions.IdentificadorDuplicadoException;

import java.util.ArrayList;

public interface I_Biblioteca <T>{
    void agregar (T media) throws IdentificadorDuplicadoException;
    boolean eliminar (Integer id);
    void mostrarOrdenadoPorTitulo ();
    ArrayList<T> filtrarPorGenero (Genero genero);
    void modificarAtributo (Integer id, String tipoAtributo, String nuevoAtributo);
    void modificarAtributo (Integer id, String tipoAtributo, Genero nuevoAtributo);
}
