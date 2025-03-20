public class Alumno {
    private String nombre;
    private int edad;
    private Nacionalidades nacionalidad;

    public Alumno(String nombre, int edad, Nacionalidades nacionalidad) {
        this.nombre = nombre;
        this.edad = edad;
        this.nacionalidad = nacionalidad;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public Nacionalidades getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(Nacionalidades nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Alumno{" +
                "nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", nacionalidad=" + nacionalidad +
                '}';
    }
}
