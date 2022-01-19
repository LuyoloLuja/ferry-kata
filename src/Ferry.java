import exceptions.FerryIsFullException;
import exceptions.NumberOfCarsFullException;
import exceptions.NumberOfPeopleFullException;

import java.util.ArrayList;
import java.util.List;

public class Ferry {
    private final int numberOfCarsAllowed;
    private final int numberOfPeopleAllowed;
    private final List<Car> carCount = new ArrayList<>();
    private int peopleCount;

    public Ferry(int numberOfCarsAllowed, int numberOfPeopleAllowed) {
        this.numberOfCarsAllowed = numberOfCarsAllowed;
        this.numberOfPeopleAllowed = numberOfPeopleAllowed;
    }

    public void board(Car car, int peopleBoarding) {
        try {

            if (getNumberOfCarsAllowed() < numberOfCarsAllowed && getNumberOfPeopleAllowed() < numberOfPeopleAllowed && peopleBoarding < numberOfPeopleAllowed) {
                peopleCount++;
                carCount.add(car);
                System.out.println("Accepted");
            } else {
                throw new FerryIsFullException("Rejected");
            }
            giveFreeRide(car);
        }catch (NumberOfCarsFullException e) {
            e.printStackTrace();
        } catch (NumberOfPeopleFullException e) {
            e.printStackTrace();
        } catch (FerryIsFullException e) {
            e.printStackTrace();
        }
    }

    public int getNumberOfCarsAllowed() {
        return carCount.size();
    }

    public int getNumberOfPeopleAllowed() {
        return peopleCount;
    }

    public void giveFreeRide(Car car) {
        int count = 0;

        for (int i = 0; i < carCount.size(); i++) {
            if (carCount.get(i) == car) {
                count += 1;
            }
        }

        if (count >= 3 && count < 7) {
            System.out.println("Half price!");
        } else if(count > 7) {
            System.out.println("Free Ride!");
        }
    }

    public static void main(String[] args) throws FerryIsFullException {
        Ferry ferry = new Ferry(10, 10);

        Car car = new Car("red", 4);
        Car car2 = new Car("red", 4);
        Car car3 = new Car("red", 4);

        ferry.board(car, 1);
        ferry.board(car, 1);
        ferry.board(car, 1);
        ferry.board(car, 1);
        ferry.board(car, 1);
        ferry.board(car, 1);
        ferry.board(car, 1);
        ferry.board(car, 1);
    }
}
