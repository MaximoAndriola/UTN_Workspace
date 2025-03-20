package JSONUtiles;

import Clases.Curso;
import Clases.Persona;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JSONUtiles {

    public static void grabar(JSONObject object, String nombreArchivo) {
        try {
            FileWriter file = new FileWriter(nombreArchivo);
            file.write(object.toString());
            file.flush();
            file.close();
        } catch (IOException e) {

            e.printStackTrace();
        }
    }


    public static JSONTokener leer(String archivo) {
        JSONTokener tokener = null;

        try {
            tokener = new JSONTokener(new FileReader(archivo));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return tokener;
    }

    //Utiles mios

    public static void convertirAObjetoJson(ArrayList<Persona> curso){
        JSONObject jobject = new JSONObject(curso);

        JSONUtiles.grabar(jobject, "persona.json");
    }

}