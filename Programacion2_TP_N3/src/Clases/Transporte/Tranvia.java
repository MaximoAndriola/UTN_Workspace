package Clases.Transporte;

import Enums.TipoTransporte;
import Interfaces.I_Transporte;

public class Tranvia implements I_Transporte {
    String ruta;
    int capacidad;
    TipoTransporte tipo;

    public Tranvia(String ruta, int capacidad, TipoTransporte tipo) {
        this.ruta = ruta;
        this.capacidad = capacidad;
        this.tipo = tipo;
    }

    @Override
    public void arrancar() {
        System.out.println("Arranco el tranvia chuchu");
    }

    @Override
    public void detener() {
        System.out.println("Se detubio el tranvia");
    }

    @Override
    public int obtenerCapacidad() {
        return capacidad;
    }

    void cambiarVia (int nuevaVia){
        System.out.println("Ingresamos en la via N° "+nuevaVia);
    }

    public TipoTransporte getTipo() {
        return tipo;
    }

    public void setTipo(TipoTransporte tipo) {
        this.tipo = tipo;
    }
}
