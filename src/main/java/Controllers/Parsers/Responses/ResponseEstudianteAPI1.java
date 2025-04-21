package Controllers.Parsers.Responses;

import java.lang.reflect.Type;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import Controllers.APIs.APIRest;
import Models.Estudiante;

public class ResponseEstudianteAPI1 implements ResponseParser<Estudiante> {

    private APIRest<Estudiante> api;

    public ResponseEstudianteAPI1(APIRest<Estudiante> api) {
        this.api = api;
    }

    @Override
    public ArrayList<Estudiante> parseResponses() {
        String body = this.api.fetchRawData();
        Gson JSON = new Gson();
        Type listType = new TypeToken<ArrayList<Estudiante>>() {
        }.getType();
        return JSON.fromJson(body, listType);
    }

    @Override
    public Estudiante parseResponse() {
        String body = this.api.fetchRawData();
        Gson JSON = new Gson();
        return JSON.fromJson(body, Estudiante.class);
    }

    @Override
    public boolean parseSuccess() throws Exception {
        String response = this.api.fetchRawData();
        if (response.equals("1") || response.equals("true")) {
            return true;
        } else if (response.equals("0") || response.equals("false") ) {
            return false;
        }
        throw new Exception("Respuesta inesperada de la API "+response);
    }
}
