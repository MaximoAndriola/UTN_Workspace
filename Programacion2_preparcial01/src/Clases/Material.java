package Clases;

import Enumeradores.TipoComparacion;
import Enumeradores.TipoMaterial;

public abstract class Material implements Comparable<Material>{
    private int ID = ++Material.cantMateriales;
    protected String titulo;
    protected String autor;
    protected String anio;
    protected Double precio;
    protected TipoMaterial tipo;
    public static int cantMateriales;

    public Material(TipoMaterial tipo, String titulo, String autor, String anio, double precio) {
        this.tipo = tipo;
        this.titulo = titulo;
        this.autor = autor;
        this.anio = anio;
        this.precio = precio;
    }

    public int getID() {
        return ID;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getAnio() {
        return anio;
    }

    public void setAnio(String anio) {
        this.anio = anio;
    }

    public TipoMaterial getTipo() {
        return tipo;
    }

    public void setTipo(TipoMaterial tipo) {
        this.tipo = tipo;
    }

    //Metodos
    @Override
    public int compareTo(Material o) {
        return o.titulo.compareTo(this.titulo);
    }

    //ToString
    @Override
    public String toString() {
        return "Material{" +
                "ID=" + ID +
                ", titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", anio='" + anio + '\'' +
                ", tipo=" + tipo +
                '}';
    }
}
