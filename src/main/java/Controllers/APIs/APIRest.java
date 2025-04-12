package Controllers.APIs;

import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import Controllers.Parsers.Requests.RequestParser;

public abstract class APIRest<T> {
    protected String URL;
    protected HttpRequest request;
    protected HttpResponse<String> response;
    protected HttpClient client;
    public abstract void GET() throws Exception;
    public abstract void GET(RequestParser<T> req) throws Exception;
    public abstract void POST(RequestParser<T> req) throws Exception;
    public abstract void PUT(RequestParser<T> req) throws Exception;
    public abstract void DELETE(RequestParser<T> req) throws Exception;
    public abstract String fetchRawData();
}