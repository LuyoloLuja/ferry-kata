import exceptions.FerryIsFullException;
import exceptions.NumberOfCarsFullException;
import exceptions.NumberOfPeopleFullException;

import java.util.ArrayList;
import java.util.List;

public class Ferry {
    private final int numberOfCarsAllowed;
    private final int numberOfPeopleAllowed;
    private final List<Car> carCount = new ArrayList<>();
    private final List<Integer> peopleCount = new ArrayList<>();
    private final List<Car> carTrips = new ArrayList<>();

    public Ferry(int numberOfCarsAllowed, int numberOfPeopleAllowed) {
        this.numberOfCarsAllowed = numberOfCarsAllowed;
        this.numberOfPeopleAllowed = numberOfPeopleAllowed;
    }

    public void board(Car car, int peopleBoarding) {
        try {
            if (getNumberOfCarsAllowed() < numberOfCarsAllowed) {
                carCount.add(car);
                System.out.println("Car Accepted");
            } else {
                throw new NumberOfCarsFullException("Car Rejected");
            }

            if (getNumberOfPeopleAllowed() < numberOfPeopleAllowed && peopleBoarding < numberOfPeopleAllowed) {
                peopleCount.add(peopleBoarding);
                System.out.println("Person/People Accepted");
            } else {
                throw new NumberOfPeopleFullException("Person/People Rejected");
            }
            System.out.println("trips: " + getCarTrips(car));
        }catch (NumberOfCarsFullException e) {
            e.printStackTrace();
        } catch (NumberOfPeopleFullException e) {
            e.printStackTrace();
        }
    }

    public int getNumberOfCarsAllowed() {
        return carCount.size();
    }

    public int getNumberOfPeopleAllowed() {
        int count = 0;
        for (int i = 0; i < peopleCount.size(); i++) {
            count += peopleCount.get(i);
        }
        return count;
    }

    public int getCarTrips(Car car) {
//        TO DO -- FIX THIS METHOD WHEN I GET HOME
//        ADD NESTED LOOP TO LOOP THROUGH carTrips TO FIGURE OUT HOW MANY CARS ON EACH FERRY TRIP
        int count = 0;

        for (int i = 0; i < carCount.size(); i++) {
            if (carCount.get(i) == car) {
                carTrips.add(car);
                count += carTrips.size();
            }
        }
        return count;
    }

    public static void main(String[] args) throws FerryIsFullException {
        Car car = new Car("red", 4);
        Ferry ferry = new Ferry(5, 5);

        ferry.board(car, 2);
        ferry.board(car, 3);
    }
}
