import exceptions.CarOverloadedException;
import exceptions.NumberOfCarsFullException;
import exceptions.NumberOfPeopleFullException;

import java.util.ArrayList;
import java.util.List;

public class Ferry {
    private final int numberOfCarsAllowed;
    private final int numberOfPeopleAllowed;
    private int peopleCount;
    private final List<Car> carCount = new ArrayList<>();

    public Ferry(int numberOfCarsAllowed, int numberOfPeopleAllowed) {
        this.numberOfCarsAllowed = numberOfCarsAllowed;
        this.numberOfPeopleAllowed = numberOfPeopleAllowed;
    }

    public void board(Car car, int peopleBoarding) throws NumberOfPeopleFullException, NumberOfCarsFullException {
        checkPassengerCount(car);
        if (isLessThanCars() && isLessThanPeople(peopleBoarding)) {
            peopleCount++;
            carCount.add(car);
            System.out.println("Accepted");
        } else if (!isLessThanCars()){
            throw new NumberOfCarsFullException("Rejected");
        } else if (!isLessThanPeople(peopleBoarding)){
            throw new NumberOfPeopleFullException("Rejected");
        }
        giveFreeRide(car);
        getNumberOfCarsWithSameColor(car);
    }

    private void getNumberOfCarsWithSameColor(Car car) {
        int count = 0;
        String color = "";
        for (int i = 0; i < carCount.size(); i++) {
            String availableCarColor = carCount.get(i).getColor();
            String currentCarColor = car.getColor();

            if (availableCarColor.equals(currentCarColor)) {
                count += 1;
                color = carCount.get(i).getColor();
            }
        }
        System.out.println(color + " cars: " + count);
    }

    private int getNumberOfCarsAllowed() {
        return carCount.size();
    }

    private int getNumberOfPeopleAllowed() {
        return peopleCount;
    }

    private boolean isLessThanCars() {
        return getNumberOfCarsAllowed() < numberOfCarsAllowed;
    }

    private boolean isLessThanPeople(int peopleBoarding) {
        return getNumberOfPeopleAllowed() < numberOfPeopleAllowed && peopleBoarding < numberOfPeopleAllowed;
    }

    private void giveFreeRide(Car car) {
        int count = 0;

        for (int i = 0; i < carCount.size(); i++) {
            if (carCount.get(i) == car) {
                count += 1;
            }
        }

        if (count >= 3 && count <= 7) {
            System.out.println("---------------------------");
            System.out.println("\t\tHalf price!");
            System.out.println("---------------------------");
        } else if(count >= 7) {
            System.out.println("---------------------------");
            System.out.println("\t\tFree Ride!");
            System.out.println("---------------------------");
        }
    }

    private void checkPassengerCount(Car car) throws CarOverloadedException {
        if (car instanceof Sedan) {
            if (car.getPassengerCount() > 5) {
                throw new CarOverloadedException("Car is overloaded");
            }
        } else if (car instanceof SUV) {
            if (car.getPassengerCount() > 10) {
                throw new CarOverloadedException("Car is overloaded");
            }
        }
    }

    public static void main(String[] args) {
        Ferry ferry = new Ferry(6, 6);

        Car car = new Sedan("red", 4);
        Car car2 = new SUV("green", 4);

        try {
            ferry.board(car, 1);
            ferry.board(car, 1);
            ferry.board(car, 2);
            ferry.board(car2, 1);
            ferry.board(car2, 1);
            ferry.board(car2, 2);
//            ferry.board(car2, 2);
//            ferry.board(car2, 2);
        } catch (NumberOfCarsFullException e) {
            e.printStackTrace();
        } catch (NumberOfPeopleFullException e) {
            e.printStackTrace();
        }
    }
}
