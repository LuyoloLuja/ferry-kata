package exceptions;

public class NumberOfCarsFullException extends FerryIsFullException {
    public NumberOfCarsFullException(String errorMessage) {
        super(errorMessage);
    }
}
