package Controllers.Parsers.Responses;

import java.lang.reflect.Type;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import Controllers.APIs.APIRest;
import Models.Estudiante;
import Models.Response;

public class ResponseEstudiante implements ResponseParser<Estudiante> {

    private APIRest<Estudiante> api;

    public ResponseEstudiante(APIRest<Estudiante> api) {
        this.api = api;
    }

    @Override
    public ArrayList<Estudiante> parseResponses(){
        String body = this.api.fetchRawData();
        Gson JSON = new Gson();
        Type listType = new TypeToken<ArrayList<Estudiante>>() {}.getType();
        return JSON.fromJson(body, listType);
    }

    @Override
    public Estudiante parseResponse(){
        String body = this.api.fetchRawData();
        Gson JSON = new Gson();
        return JSON.fromJson(body, Estudiante.class);
    }

    @Override
    public boolean parseSuccess() throws Exception {
        String res = this.api.fetchRawData();
        Response response = (new Gson()).fromJson(res, Response.class);
        if (response.error == null) {
            return response.success;
        }
        throw new Exception("Respuesta inesperada de la API "+response.error);
    }
}
