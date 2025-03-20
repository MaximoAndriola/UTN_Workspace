public class Empleado {
    String nombre;
    String apellido;
    double salario;

    //Builder
    public Empleado(String nombre, String apellido, int salario) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.salario = salario;
    }


    //metodos

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public double calcularSalarioAnual(){
        return salario * 12;
    }

    public double aumentarSalario(double aumento){
        return salario * (1 + (aumento / 100));
    }

    @Override
    public String toString() {
        return "Empleado:" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", salario=" + salario;
    }
}
