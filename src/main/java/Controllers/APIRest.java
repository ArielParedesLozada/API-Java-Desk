package Controllers;

import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import com.google.gson.Gson;

public abstract class APIRest<T> {
    protected Gson JSON;
    protected String URL;
    protected HttpRequest request;
    protected HttpResponse<String> response;
    protected HttpClient client;
    public abstract void GET() throws Exception;
    public abstract void GET(String params) throws Exception;
    public abstract void POST(T body) throws Exception;
    public abstract void PUT(String key, T body) throws Exception;
    public abstract void DELETE(String key) throws Exception;
    public abstract String fetchData();
}