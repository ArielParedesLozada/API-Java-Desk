package Controllers;

import java.lang.reflect.Type;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import Models.Estudiante;

public class ResponseEstudiantes {
    private Gson JSON;

    public ResponseEstudiantes() {
        this.JSON = new Gson();
    }

    public ArrayList<Estudiante> parseEstudiantes(String data){
        Type listType = new TypeToken<ArrayList<Estudiante>>(){}.getType();
        return this.JSON.fromJson(data, listType);
    }

    public boolean success(String data){
        if (data.equals("1") || data.equals("true")) {
            return true;
        }
        return this.JSON.fromJson(data, boolean.class);
    }
}
