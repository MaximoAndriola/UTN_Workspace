package Clases.Animal;

import Interfaces.I_Animal;

public class Murcielago implements I_Animal {
    @Override
    public void comunicarse() {
        System.out.println("El pato le dijo cuack al ganzo");
    }

    @Override
    public void emitirSonido() {
        System.out.println("Cuack");
    }

    @Override
    public void habilidadUnica() {
        System.out.println("El pato vuela sobre el agua y nada bajo ella");
    }
}