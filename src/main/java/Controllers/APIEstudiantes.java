package Controllers;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse.BodyHandlers;

import com.google.gson.Gson;

import Models.Estudiante;

public class APIEstudiantes extends APIRest<Estudiante> {
    private static APIEstudiantes instance;

    private APIEstudiantes(String apiPath) {
        this.JSON = new Gson();
        this.URL = apiPath;
        this.client = HttpClient.newHttpClient();
        this.request = null;
        this.response = null;
    }

    public static APIEstudiantes getInstance(String apiPath) {
        if (instance == null) {
            instance = new APIEstudiantes(apiPath);
        }
        return instance;
    }

    @Override
    public void GET() throws Exception {
        this.request = HttpRequest.newBuilder()
                .uri(new URI(this.URL))
                .header("Content-Type", "application/json")
                .GET()
                .build();
        this.response = this.client.send(request, BodyHandlers.ofString());

    }

    @Override
    public void GET(String params) throws Exception {
        this.request = HttpRequest.newBuilder()
                .uri(new URI(this.URL))
                .header("Content-Type", "application/json")
                .GET()
                .build();
        this.response = this.client.send(request, BodyHandlers.ofString());
    }

    @Override
    public void POST(Estudiante body) throws Exception {
        String req = this.JSON.toJson(body);
        this.request = HttpRequest.newBuilder()
                .uri(new URI(this.URL))
                .header("Content-Type", "application/json")
                .POST(BodyPublishers.ofString(req))
                .build();
        this.response = this.client.send(this.request, BodyHandlers.ofString());
    }

    @Override
    public void PUT(String key, Estudiante body) throws Exception {
        String req = this.JSON.toJson(body);
        this.request = HttpRequest.newBuilder()
                .uri(new URI(this.URL + "?key=" + key))
                .header("Content-Type", "application/json")
                .PUT(BodyPublishers.ofString(req))
                .build();
        this.response = this.client.send(this.request, BodyHandlers.ofString());
    }

    @Override
    public void DELETE(String key) throws Exception {
        this.request = HttpRequest.newBuilder()
                .uri(new URI(this.URL + "?key=" + key))
                .header("Content-Type", "application/json")
                .DELETE()
                .build();
        this.response = this.client.send(this.request, BodyHandlers.ofString());
    }

    @Override
    public String fetchData() {
        if (this.response.body() == null) {
            return null;
        }
        return this.response.body();
    }
}
