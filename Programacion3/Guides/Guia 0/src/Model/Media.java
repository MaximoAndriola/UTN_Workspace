package Model;

import Enums.Genero;

public abstract class Media implements Comparable<Media>{
    protected String titulo;
    protected String creador;
    protected Genero genero;
    protected static int contador = 0;
    protected int id = contador ++;

    public Media(String titulo, String creador, Genero genero) {
        this.titulo = titulo;
        this.creador = creador;
        this.genero = genero;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getCreador() {
        return creador;
    }

    public Genero getGenero() {
        return genero;
    }

    public int getId() {
        return id;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public void setCreador(String creador) {
        this.creador = creador;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    @Override
    public int compareTo(Media o) {
        return this.titulo.compareTo(o.getTitulo());
    }

    @Override
    public String toString() {
        return  " Titulo: " + titulo +
                ", Creador: " + creador +
                ", Genero: "+ genero +
                ", Id: " + id;
    }
}
