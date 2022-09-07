package exceptions;

public class CarOverloadedException extends NumberOfCarsFullException {
    public CarOverloadedException(String errorMessage) {
        super(errorMessage);
    }
}
