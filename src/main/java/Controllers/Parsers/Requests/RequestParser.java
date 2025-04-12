package Controllers.Parsers.Requests;

public interface RequestParser<T> {
    public void setObject(T object);
    public void setParams(T params, String option);
    public String parseObject();
    public String parseParams();
}
