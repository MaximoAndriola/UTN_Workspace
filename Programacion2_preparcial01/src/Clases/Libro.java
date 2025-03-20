package Clases;

import Enumeradores.Estado;
import Enumeradores.Genero;
import Enumeradores.TipoMaterial;
import Interfaces.I_Prestable;

public class Libro extends Material implements I_Prestable {
    protected String cantPaginas;
    protected Genero genero;
    protected Estado estado;

    public Libro(String titulo, String autor, String anio, String cantPaginas, Genero genero, double precio) {
        super(TipoMaterial.LIBRO, titulo, autor, anio, precio);
        this.cantPaginas = cantPaginas;
        this.genero = genero;
        this.estado = Estado.DISPONIBLE;
    }

    public String getCantPaginas() {
        return cantPaginas;
    }

    public void setCantPaginas(String cantPaginas) {
        this.cantPaginas = cantPaginas;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    @Override
    public boolean prestar() {
        boolean prestado = false;
        if(estado.equals(Estado.DISPONIBLE)){
            estado = Estado.PRESTADO;
            prestado = true;
        }
        return prestado;
    }

    @Override
    public void devolver() {
        if(estado.equals(Estado.PRESTADO)) {
            estado = Estado.DISPONIBLE;
        }
    }

    @Override
    public String toString() {
        return "Libro{" +
                "Prestado" + estado + '\'' +
                ", titulo='" + titulo + '\'' +
                ", genero=" + genero +
                ", autor='" + autor + '\'' +
                ", anio='" + anio + '\'' +
                ", tipo=" + tipo +
                '}';
    }
}
