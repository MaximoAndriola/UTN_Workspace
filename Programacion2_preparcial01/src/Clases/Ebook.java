package Clases;

import Enumeradores.TipoMaterial;
import Interfaces.I_Digital;

public class Ebook extends Material implements I_Digital {
    //PDF, WORD, etc
    protected String formato;

    public Ebook(String titulo, String autor, String anio, String formato, double precio) {
        super(TipoMaterial.EBOOK, titulo, autor, anio, precio);
        this.formato = formato;
    }

    @Override
    public void narrarTexto() {
        System.out.println("narrando texto");
    }

    @Override
    public void narrarParrafo() {
        System.out.println("narrando parrafo");
    }

    @Override
    public void cambiarFormato() {
        System.out.println("formato cambiado");
    }

    @Override
    public void descargar() {
        System.out.println("se descargo con exito");
    }

    @Override
    public void leer() {
        System.out.println("leyendo");
    }
}
