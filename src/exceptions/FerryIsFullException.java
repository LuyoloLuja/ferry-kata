package exceptions;

public class FerryIsFullException extends Exception {
    FerryIsFullException(String errorMessage) {
        super(errorMessage);
    }
}
