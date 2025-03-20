package JSONUtiles;

import Clases.*;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class GestionJSON {
    public static Tienda mapeoTienda (){
        Tienda tienda = new Tienda();

        try {
            JSONObject jobject = new JSONObject(JSONUtiles.leer("tienda.json"));

            JSONObject jtienda = jobject.getJSONObject("tienda");

            tienda.setNombre(jtienda.getString("nombre"));
            tienda.setUbicacion(jtienda.getString("ubicacion"));

            JSONArray jproductos = jtienda.getJSONArray("productos");
            ArrayList<Producto> productos = new ArrayList<>();

            for (int i = 0; i < jproductos.length(); i++){
                JSONObject jproducto = jproductos.getJSONObject(i);

                JSONArray jespecificaciones = jproducto.getJSONArray("especificaciones");
                ArrayList<Especificaciones> especificaciones = new ArrayList<>();
                for (int x = 0; x < jespecificaciones.length(); x++){
                    JSONObject jespecificacion = jespecificaciones.getJSONObject(x);
                    Especificaciones especificacion = new Especificaciones(
                            jespecificacion.getString("nombre"),
                            jespecificacion.getString("valor"));
                    especificaciones.add(especificacion);
                }

                JSONArray jembalajes = jproducto.getJSONArray("embalajesDisponibles");
                ArrayList<Embalaje> embalajes = new ArrayList<>();
                for(int x = 0; x < jembalajes.length(); x++){
                    JSONObject jembalaje = jembalajes.getJSONObject(x);
                    Embalaje embalaje = new Embalaje(
                            jembalaje.getString("tipo")
                            , jembalaje.getString("resistencia")
                            , jembalaje.getString("dimensiones")
                    );
                    embalajes.add(embalaje);
                }

                String tipoProducto = jproducto.getString("tipo");

                if(tipoProducto.equalsIgnoreCase("portatil")){
                    Portatil portatil = new Portatil(
                            jproducto.getString("tipo")
                            , jproducto.getString("nombre")
                            , jproducto.getString("marca")
                            , jproducto.getDouble("precio")
                            , jproducto.getInt("cantidadDisponible")
                            , jproducto.getString("seccionTienda")
                            , especificaciones
                            , embalajes);
                    productos.add(portatil);
                }else if(tipoProducto.equalsIgnoreCase("DispositivoMovil")){
                    DispositivoMovil movil = new DispositivoMovil(
                            jproducto.getString("tipo")
                            , jproducto.getString("nombre")
                            , jproducto.getString("marca")
                            , jproducto.getDouble("precio")
                            , jproducto.getInt("cantidadDisponible")
                            , jproducto.getString("seccionTienda")
                            , especificaciones
                            , embalajes);
                    productos.add(movil);
                }else{
                    Accesorio accesorio = new Accesorio(
                            jproducto.getString("tipo")
                            , jproducto.getString("nombre")
                            , jproducto.getString("marca")
                            , jproducto.getDouble("precio")
                            , jproducto.getInt("cantidadDisponible")
                            , jproducto.getString("seccionTienda")
                            , especificaciones
                            , embalajes);
                    productos.add(accesorio);
                }
            }
            tienda.setProductos(productos);

        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
        return tienda;
    }
}
