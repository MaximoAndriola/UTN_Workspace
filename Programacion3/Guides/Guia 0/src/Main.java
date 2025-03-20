import Enums.Genero;
import Exeptions.IdentificadorDuplicadoException;
import Model.Biblioteca;
import Model.Expansion;
import Model.Videojuego;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();

        Videojuego videojuego = new Videojuego("Pokemon Espada", "Satoshi Tajiri", Genero.AVENTURA, 1.2);
        Expansion expansion = new Expansion("Las Nieves de la Corona", "Satoshi Tajiri", Genero.AVENTURA, LocalDate.now().toString());
        Videojuego videojuego2 = new Videojuego("Dark Souls", "Hidetaka Miyazaki", Genero.SOULS_LIKE, 2.0);

        try {
            biblioteca.agregar(videojuego);
            biblioteca.agregar(expansion);
            biblioteca.agregar(videojuego);
        } catch (IdentificadorDuplicadoException e) {
            System.out.println(e.getMessage());
        }


        System.out.println(biblioteca);

        //biblioteca.eliminar(1);

        //System.out.println(biblioteca);

        biblioteca.mostrarOrdenadoPorTitulo();

        Biblioteca filtro = new Biblioteca(biblioteca.filtrarPorGenero(Genero.AVENTURA));

        filtro.mostrarOrdenadoPorTitulo();

        System.out.printf("\n");
        biblioteca.modificarAtributo(0, "titulo", "Pokemon Escudo");
        biblioteca.mostrarOrdenadoPorTitulo();
    }
}