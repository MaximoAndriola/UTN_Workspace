import com.sun.management.UnixOperatingSystemMXBean;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Libro {
    private String titulo;
    private String autor;
    private double precio;
    private int anio;

    public Libro() {}

    public Libro(String titulo, String autor, double precio, int anio) {
        this.titulo = titulo;
        this.autor = autor;
        this.precio = precio;
        this.anio = anio;
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

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    //Metods
    public void addLibro(Scanner scanner) {

        System.out.printf("TITULO: ");
        titulo = scanner.nextLine();

        System.out.printf("\nAUTOR: ");
        autor = scanner.nextLine();

        System.out.printf("\nAnio: ");
        anio = scanner.nextInt();
        scanner.nextLine();

        System.out.println("\nPrecio: ");
        precio = scanner.nextDouble();

        System.out.println("Libro añadido exitosamente!!!");
    }

    public boolean deleteLibro(List<Libro> libros, String titulo){
        Libro libro = new Libro();
        for(int i = 0; i < libros.size(); i++){
            libro = libros.get(i);
            if(libro.titulo.equals(titulo)){
                libros.remove(i);
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "Libro{" +
                "titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", precio=" + precio +
                ", anio=" + anio +
                '}';
    }
}