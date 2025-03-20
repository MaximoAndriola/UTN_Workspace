package Clases;

import JSONUtiles.JSONUtiles;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Curso {
    private ArrayList<Persona> curso = new ArrayList<>();

    public void agregarPersona(Persona persona){
        curso.add(persona);
    }

    /*
    public static Curso convertirAAregloPersonas(String nombreArchivo){
        Curso curso = new Curso();

        try {
            JSONArray jcursos = new JSONArray(JSONUtiles.leer(nombreArchivo));

            for (int i = 0; i < jcursos.length(); i++) {
                JSONArray jcurso = new JSONArray(jcursos.get(i));

                for (int c = 0; c < jcurso.length(); c++){
                    JSONObject jpersona = jcurso.getJSONObject(c);
                    Persona persona = new Persona();

                    persona.setNombre(jpersona.getString("Nombre"));
                    persona.setDni(jpersona.getString("dni"));
                    persona.setEdad(jpersona.getInt("edad"));
                    persona.setGenero(jpersona.getString("genero"));

                    curso.agregarPersona(persona);
                }
                //cursos.add(curso);
            }

        } catch (JSONException e) {
            throw new RuntimeException(e);
        }

        return curso;
    }

     */

    public ArrayList<Persona> getCurso() {
        return curso;
    }

    public static Curso convertirAAregloPersonas(String nombreArchivo) {
        Curso curso = new Curso();

        try {
            // Leer el archivo como un JSONObject, no un JSONArray
            JSONObject jsonObject = new JSONObject(JSONUtiles.leer(nombreArchivo));

            for (int c = 0; c < jsonObject.length(); c++) {
                JSONObject jpersona = jsonObject.getJSONObject(c);
                Persona persona = new Persona();

                persona.setNombre(jpersona.getString("Nombre"));
                persona.setDni(jpersona.getString("dni"));
                persona.setEdad(jpersona.getInt("edad"));
                persona.setGenero(jpersona.getString("genero"));

                // Agregar la persona al curso
                curso.agregarPersona(persona);
            }

        } catch (JSONException e) {
            throw new RuntimeException(e);
        }

        return curso;
    }

    @Override
    public String toString() {
        return "Curso{" +
                "curso=" + curso +
                '}';
    }
}
