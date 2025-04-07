package Model;

import Enums.Genero;
import Exeptions.IdentificadorDuplicadoException;
import Interfaces.I_Biblioteca;

import java.util.*;

public class Biblioteca<T extends Media> implements I_Biblioteca <T> {
    protected List<T> biblioteca = new ArrayList<T>();

    public Biblioteca() {
    }

    public Biblioteca(List<T> biblioteca) {
        this.biblioteca = biblioteca;
    }

    public void agregar (T media) throws IdentificadorDuplicadoException {
        for (int i = 0; i < biblioteca.size(); i++){
            if (biblioteca.get(i).getId() == media.getId()){

                throw new IdentificadorDuplicadoException( media.getTitulo() + " YA EXISTE.");
            }
        }

        biblioteca.add(media);
    }

    public boolean eliminar (Integer id){
        Boolean eliminado = false;
        int i = 0;

        while (i < biblioteca.size() && !eliminado){
            if (biblioteca.get(i).getId() == id){
                biblioteca.remove(i);
                eliminado = true;
            }
            i++;
        }

        return eliminado;
    }

    public void mostrarOrdenadoPorTitulo (){
        Collections.sort(biblioteca);
        System.out.println(biblioteca);
    }

    public ArrayList<T> filtrarPorGenero (Genero genero){
        ArrayList<T> listaFiltrada = new ArrayList();

        for (T m : biblioteca){
            if (m.getGenero().equals(genero)){
                listaFiltrada.add(m);
            }
        }

        return listaFiltrada;
    }

    public void modificarAtributo (Integer id, String tipoAtributo, String nuevoAtributo){
        boolean encontrado = false;

        for (int i = 0; i < biblioteca.size(); i++){
            if (biblioteca.get(i).getId() == id){
                switch (tipoAtributo.toLowerCase()){
                    case "titulo":
                        biblioteca.get(i).setTitulo(nuevoAtributo);

                        encontrado = true;

                        break;

                    case "creador":
                        biblioteca.get(i).setCreador(nuevoAtributo);

                        encontrado = true;

                        break;
                    default:
                        System.out.println("atributo invalido");
                }
            }
        }

        if (!encontrado){
            System.out.println("NO EXISTE NINGUN REGISTRO CON EL ID INGRESADO");
        }
    }

    public void modificarAtributo (Integer id, String tipoAtributo, Genero nuevoAtributo){
        boolean encontrado = false;

        for (int i = 0; i < biblioteca.size(); i++){
            if (biblioteca.get(i).getId() == id){

                biblioteca.get(i).setGenero(nuevoAtributo);
            }
        }

        if (!encontrado){
            System.out.println("NO EXISTE NINGUN REGISTRO CON EL ID INGRESADO");
        }
    }

    @Override
    public String toString() {
        return "Biblioteca{" +
                "biblioteca=" + biblioteca +
                '}';
    }
}
