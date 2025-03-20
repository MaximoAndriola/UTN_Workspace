import java.util.ArrayList;

public class Colegio {
    ArrayList<Alumno> curso = new ArrayList<>();


    public void agregarAlumno(Alumno a){
        curso.add(a);
    }

    public void verNacionalidad (Nacionalidades nacionalidad) {
        ArrayList<Alumno> listaNacionalidad = new ArrayList<>();

        for (int i = 0; i < curso.size(); i++) {
            Alumno a = curso.get(i);
            if (nacionalidad.equals(a.getNacionalidad())){
                listaNacionalidad.add(a);
            }
        }

        System.out.println(listaNacionalidad);
    }

    public void contarNacionalidades (){
        int contador = 0;
        int encontrado;
        ArrayList<Nacionalidades> nacionalidadesEncontradas = new ArrayList<>();
        nacionalidadesEncontradas.add(curso.getFirst().getNacionalidad());

        for (Alumno a : curso){
            encontrado = 0;
            for (int i = 0; i < nacionalidadesEncontradas.size(); i++){
                if (!nacionalidadesEncontradas.get(i).equals(a.getNacionalidad())){
                    encontrado = 1;
                }
            }
            if(encontrado == 1) {
                nacionalidadesEncontradas.add(a.getNacionalidad());
                System.out.println(a.getNacionalidad());
                contador++;
            }
        }
        System.out.println(contador);
    }

    public void verTodos(){
        ArrayList<Nacionalidades> nacionalidades = new ArrayList<>();

        nacionalidades.add(Nacionalidades.PERUANO);
        nacionalidades.add(Nacionalidades.ESPAÑOL);
        nacionalidades.add(Nacionalidades.ARGENTINO);

        for(Nacionalidades n : nacionalidades){
            ArrayList<Alumno> aux = new ArrayList<>();

            for (Alumno a : curso){
                if (a.getNacionalidad().equals(n)){
                    aux.add(a);
                }
            }
            System.out.println(n + ": " + aux);
        }
    }

    public void borrarAlumno (String nombre){
        for (int i = 0; i < curso.size(); i++){
            Alumno a = curso.get(i);
            if (nombre.equals(a.getNombre())){
                curso.remove(a);
            }
        }
    }
}
