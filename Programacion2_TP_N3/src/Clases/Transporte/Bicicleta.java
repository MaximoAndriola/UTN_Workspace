package Clases.Transporte;

import Enums.TipoTransporte;
import Interfaces.I_Transporte;

public class Bicicleta implements I_Transporte {
    String numeroSerie;
    TipoTransporte tipo;

    public Bicicleta(String numeroSerie, TipoTransporte tipo) {
        this.numeroSerie = numeroSerie;
        this.tipo = tipo;
    }

    @Override
    public void arrancar() {
        System.out.println("Arranco el malignoBMX boeeee");
    }

    @Override
    public void detener() {
        System.out.println("Freno la bici");
    }

    @Override
    public int obtenerCapacidad() {
        return 1;
    }

    void ajustarAsiento(int altura){
        System.out.println("La altura del asiento se ajusto a "+altura+"cm");
    }

    public TipoTransporte getTipo() {
        return tipo;
    }

    public void setTipo(TipoTransporte tipo) {
        this.tipo = tipo;
    }
}
