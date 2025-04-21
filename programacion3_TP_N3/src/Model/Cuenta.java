package Model;

public class Cuenta {
    private int id;
    private int id_usuario;
    private Tipos tipo;
    private double saldo;
    private String fecha_creacion;

    public Cuenta(int id_usuario, Tipos tipo, double saldo) {
        this.id = 0;
        this.id_usuario = id_usuario;
        this.tipo = tipo;
        this.saldo = saldo;
        this.fecha_creacion = null;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public Tipos getTipo() {
        return tipo;
    }

    public void setTipo(Tipos tipo) {
        this.tipo = tipo;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public String getFecha_creacion() {
        return fecha_creacion;
    }

    public void setFecha_creacion(String fecha_creacion) {
        this.fecha_creacion = fecha_creacion;
    }

    @Override
    public String toString() {
        return "Cuenta(" +
                "id: " + id +
                ", id_usuario: " + id_usuario +
                ", tipo: " + tipo +
                ", saldo: " + saldo +
                ", fecha de creacion: " + fecha_creacion +
                ")";
    }
}
