package Model;

import Enums.Genero;

public class Expansion extends Media{
    protected String fechaLanzamieto;

    public Expansion(String titulo, String creador, Genero genero, String  fechaLanzamieto) {
        super(titulo, creador, genero);
        this.fechaLanzamieto = fechaLanzamieto;
    }

    public String  getFechaLanzamieto() {
        return fechaLanzamieto;
    }

    public void setFechaLanzamieto(String  fechaLanzamieto) {
        this.fechaLanzamieto = fechaLanzamieto;
    }

    @Override
    public String toString() {
        return  "Expansion {" +
                super.toString() +
                ", Fecha de Lanzamieto: " + fechaLanzamieto +
                "}";
    }
}
