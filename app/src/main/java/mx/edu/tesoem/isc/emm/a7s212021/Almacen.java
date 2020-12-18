package mx.edu.tesoem.isc.emm.a7s212021;

import android.app.Activity;
import android.content.Context;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class Almacen {

    private final String NomArch="Datos.txt";
    List<Datos> datos = new ArrayList<>();

    public boolean Existe(Context context){
        String[] archivos = context.fileList();
        for (String archivo : archivos)
            if (archivo.equals(NomArch)) return true;
            return false;
    }


    public boolean Escribir(Context context, List<Datos> datos){
        try{
            OutputStreamWriter archivo = new OutputStreamWriter(context.openFileOutput(NomArch, Activity.MODE_PRIVATE));
            for (Datos dato : datos)
                archivo.write(ConveritJson(dato) + "\n");
            archivo.flush();
            archivo.close();
        }catch (Exception ex){ return false; }
        return true;
    }

    public boolean Leer(Context context){
        try{
            InputStreamReader archivo = new InputStreamReader(context.openFileInput(NomArch));
            BufferedReader br = new BufferedReader(archivo);
            String linea="";
            while ((linea = br.readLine())!= null)
                datos.add();
        } catch (Exception ex){ return false; }
        return true;
    }

    private String ConveritJson(Datos dato){
        Gson gson = new Gson();
        return gson.toJson(dato);
    }

    private Datos CoveritClase(String json){
        Gson gson = new Gson();
        return gson.fromJson(json, Datos.class);
    }

}
