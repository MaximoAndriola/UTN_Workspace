package Clases;

import Enumeradores.Estado;
import Enumeradores.TipoMaterial;
import Interfaces.I_Prestable;

public class Revista extends Material implements I_Prestable {
    protected boolean aColor;
    protected Estado estado;

    public Revista(String titulo, String autor, String anio, boolean aColor, double precio) {
        super(TipoMaterial.REVISTA, titulo, autor, anio, precio);
        this.aColor = aColor;
        this.estado = Estado.DISPONIBLE;
    }

    public boolean isaColor() {
        return aColor;
    }

    public void setaColor(boolean aColor) {
        this.aColor = aColor;
    }

    @Override
    public boolean prestar() {
        boolean prestado = false;
        if (estado.equals(Estado.DISPONIBLE)){
            estado = Estado.PRESTADO;
            prestado = true;
        }
        return prestado;
    }

    @Override
    public void devolver() {
        if(estado.equals(Estado.PRESTADO)){
            estado = Estado.DISPONIBLE;
        }
    }

    @Override
    public String toString() {
        return "Revista{" +
                "aColor=" + aColor +
                ", estado=" + estado +
                ", titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", anio='" + anio + '\'' +
                ", precio=" + precio +
                ", tipo=" + tipo +
                '}';
    }
}
