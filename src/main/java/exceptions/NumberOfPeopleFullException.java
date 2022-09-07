package exceptions;

public class NumberOfPeopleFullException extends FerryIsFullException {
    public NumberOfPeopleFullException(String errorMessage) {
        super(errorMessage);
    }
}
