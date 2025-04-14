package Controllers.Facades;

import java.util.ArrayList;

import Controllers.APIs.APIEstudiantes;
import Controllers.APIs.APIRest;
import Controllers.Parsers.Requests.RequestEstudiante;
import Controllers.Parsers.Requests.RequestParser;
import Controllers.Parsers.Responses.ResponseEstudiante;
import Controllers.Parsers.Responses.ResponseParser;
import Models.Estudiante;

public class FacadeEstudiante {
    private ResponseParser<Estudiante> responseParser;
    private RequestParser<Estudiante> requestParser;
    private APIRest<Estudiante> apiRest;

    public FacadeEstudiante(String path) {
        this.apiRest = new APIEstudiantes(path);
        this.requestParser = new RequestEstudiante();
        this.responseParser = new ResponseEstudiante(this.apiRest);
    }

    public ArrayList<Estudiante> getEstudiantes() {
        try {
            this.apiRest.GET();
        } catch (Exception e) {
            System.out.println("Error " + e.getMessage());
            return new ArrayList<Estudiante>();
        }
        return this.responseParser.parseResponses();
    }

    public boolean postEstudiante(Estudiante est) {
        boolean result = false;
        this.requestParser.setObject(est);
        try {
            this.apiRest.POST(this.requestParser);
            result = this.responseParser.parseSuccess();
        } catch (Exception e) {
            System.out.println("Error " + e.getMessage());
            return false;
        }
        return result;
    }

    public boolean putEstudiante(Estudiante est) {
        boolean result = false;
        this.requestParser.setObject(est);
        this.requestParser.setParams(est, null);
        try {
            this.apiRest.PUT(this.requestParser);
            result = this.responseParser.parseSuccess();
        } catch (Exception e) {
            System.out.println("Error " + e.getMessage());
            return false;
        }
        return result;
    }

    public boolean deleteEstudiante(Estudiante est) {
        boolean result = false;
        this.requestParser.setParams(est, null);
        try {
            this.apiRest.DELETE(this.requestParser);
            result = this.responseParser.parseSuccess();
        } catch (Exception e) {
            System.out.println("Error " + e.getMessage());
            return false;
        }
        return result;
    }
}
