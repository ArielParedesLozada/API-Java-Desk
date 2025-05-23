package Controllers.APIs;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse.BodyHandlers;

import Controllers.Parsers.Requests.RequestParser;
import Models.Estudiante;

public class APIEstudiantes extends APIRest<Estudiante> {
    public APIEstudiantes(String apiPath) {
        this.URL = apiPath;
        this.client = HttpClient.newHttpClient();
        this.request = null;
        this.response = null;
    }

    @Override
    public void GET() throws Exception {
        this.request = HttpRequest.newBuilder()
                .uri(new URI(this.URL))
                .header("Content-Type", "application/json")
                .GET()
                .build();
        this.response = this.client.send(this.request, BodyHandlers.ofString());

    }

    @Override
    public void GET(RequestParser<Estudiante> req) throws Exception {
        String params = req.parseParams();
        this.request = HttpRequest.newBuilder()
                .uri(new URI(this.URL + params))
                .header("Content-Type", "application/json")
                .GET()
                .build();
        this.response = this.client.send(this.request, BodyHandlers.ofString());
    }

    @Override
    public void POST(RequestParser<Estudiante> req) throws Exception {
        String body = req.parseObject();
        this.request = HttpRequest.newBuilder()
                .uri(new URI(this.URL))
                .header("Content-Type", "application/json")
                .POST(BodyPublishers.ofString(body))
                .build();
        this.response = this.client.send(this.request, BodyHandlers.ofString());
    }

    @Override
    public void PUT(RequestParser<Estudiante> req) throws Exception {
        String params = req.parseParams();
        String body = req.parseObject();
        this.request = HttpRequest.newBuilder()
                .uri(new URI(this.URL + params))
                .header("Content-Type", "application/json")
                .PUT(BodyPublishers.ofString(body))
                .build();
        this.response = this.client.send(this.request, BodyHandlers.ofString());
    }

    @Override
    public void DELETE(RequestParser<Estudiante> req) throws Exception {
        String params = req.parseParams();
        this.request = HttpRequest.newBuilder()
                .uri(new URI(this.URL + params))
                .header("Content-Type", "application/json")
                .DELETE()
                .build();
        this.response = this.client.send(this.request, BodyHandlers.ofString());
    }

    @Override
    public String fetchRawData() {
        if (this.response.body() == null) {
            return null;
        }
        return this.response.body();
    }
}
