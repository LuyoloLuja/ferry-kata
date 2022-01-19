package exceptions;

public class FerryIsFullException extends Exception {
    public FerryIsFullException(String errorMessage) {
        super(errorMessage);
    }
}
