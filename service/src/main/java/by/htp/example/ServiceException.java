package by.htp.example;

public class ServiceException extends Exception {

    public ServiceException() {}

    public ServiceException(String message) {
        super(message);
    }

    public ServiceException(Exception e, String message) {
        super(message, e);
    }

    public ServiceException(Exception e) {
        super(e);
    }

}
