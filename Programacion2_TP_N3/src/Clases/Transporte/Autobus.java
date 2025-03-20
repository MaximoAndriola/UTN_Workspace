package Clases.Transporte;

import Enums.TipoTransporte;
import Interfaces.I_Transporte;

public class Autobus implements I_Transporte {
    int numeroLinea;
    int capacidad;
    TipoTransporte tipo;

    public Autobus(int numeroLinea, int capacidad) {
        this.numeroLinea = numeroLinea;
        this.capacidad = capacidad;
        this.tipo = TipoTransporte.AUTOBUS;
    }

    void anunciarParada (String parada){
        System.out.println("Proximar parada: "+parada);
    }

    @Override
    public void arrancar() {
        System.out.println("arranco el autobus runrun");
    }

    @Override
    public void detener() {
        System.out.println("se detubo el autobus");
    }

    @Override
    public int obtenerCapacidad() {
        return capacidad;
    }

    public TipoTransporte getTipo() {
        return tipo;
    }

    public void setTipo(TipoTransporte tipo) {
        this.tipo = tipo;
    }
}
