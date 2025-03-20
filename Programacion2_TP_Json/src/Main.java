import Clases.Curso;
import Clases.Persona;
import JSONUtiles.JSONUtiles;
import org.json.JSONObject;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Persona persona = new Persona("Juan", 21, "46420271", "Masculino");
        Persona persona1 = new Persona("Maxi", 19, "12333123", "Masculino");

        Curso curso = new Curso();
        curso.agregarPersona(persona);
        curso.agregarPersona(persona1);

        JSONUtiles.convertirAObjetoJson(curso.getCurso());

        Curso cursoJson = Curso.convertirAAregloPersonas("persona.json");

    }
}