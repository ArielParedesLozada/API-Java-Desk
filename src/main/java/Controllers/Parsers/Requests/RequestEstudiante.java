package Controllers.Parsers.Requests;

import com.google.gson.Gson;

import Models.Estudiante;

public class RequestEstudiante implements RequestParser<Estudiante> {

    private Gson JSON;
    private String body;
    private String params;

    public RequestEstudiante() {
        this.JSON = new Gson();
        this.body = null;
        this.params = null;
    }

    @Override
    public void setObject(Estudiante object) {
        this.body = this.JSON.toJson(object);
    }

    @Override
    public void setParams(Estudiante params, String options) {
        String cedula = params.cedula;
        this.params = "?key=" + cedula;
    }

    @Override
    public String parseObject() {
        return this.body;
    }

    @Override
    public String parseParams() {
        return this.params;
    }
}
