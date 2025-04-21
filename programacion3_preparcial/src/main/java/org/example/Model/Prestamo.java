package org.example.Model;

import java.time.LocalTime;

public class Prestamo {
    private int id;
    private int libro_id;
    private int usuario_id;
    private LocalTime fecha_prestamo;
    private LocalTime fecha_devolucion;

    public Prestamo(int libro_id, int usuario_id, LocalTime fecha_prestamo, LocalTime fecha_devolucion) {
        this.id = 0;
        this.libro_id = libro_id;
        this.usuario_id = usuario_id;
        this.fecha_prestamo = fecha_prestamo;
        this.fecha_devolucion = fecha_devolucion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLibro_id() {
        return libro_id;
    }

    public void setLibro_id(int libro_id) {
        this.libro_id = libro_id;
    }

    public int getUsuario_id() {
        return usuario_id;
    }

    public void setUsuario_id(int usuario_id) {
        this.usuario_id = usuario_id;
    }

    public LocalTime getFecha_prestamo() {
        return fecha_prestamo;
    }

    public void setFecha_prestamo(LocalTime fecha_prestamo) {
        this.fecha_prestamo = fecha_prestamo;
    }

    public LocalTime getFecha_devolucion() {
        return fecha_devolucion;
    }

    public void setFecha_devolucion(LocalTime fecha_devolucion) {
        this.fecha_devolucion = fecha_devolucion;
    }

    @Override
    public String toString() {
        return "Prestamo(" +
                "id: " + id +
                ", libro_id: " + libro_id +
                ", usuario_id: " + usuario_id +
                ", fecha_prestamo: " + fecha_prestamo +
                ", fecha_devolucion: " + fecha_devolucion +
                ")";
    }
}