package Controllers.Parsers.Responses;

import java.util.ArrayList;

public interface ResponseParser<T> {
    public ArrayList<T> parseResponses();

    public T parseResponse();

    public boolean parseSuccess() throws Exception;
}
