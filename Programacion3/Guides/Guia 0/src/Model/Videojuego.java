package Model;

import Enums.Genero;

public class Videojuego extends Media {
    protected Double numeroVersion;

    public Videojuego(String titulo, String creador, Genero genero, Double numeroVersion) {
        super(titulo, creador, genero);
        this.numeroVersion = numeroVersion;
    }

    public Double getNumeroVersion() {
        return numeroVersion;
    }

    public void setNumeroVersion(Double numeroVersion) {
        this.numeroVersion = numeroVersion;
    }

    @Override
    public String toString() {
        return  "Videojuego {" +
                super.toString() +
                ", NumeroVersion: " + numeroVersion +
                "}";
    }
}
