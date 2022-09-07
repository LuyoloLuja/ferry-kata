public class Car {
    private String color;
    private final int passengerCount;

    public Car(String color, int passengerCount) {
        this.color = color;
        this.passengerCount = passengerCount;
    }

    public String getColor() {
        color = color.substring(0, 1).toUpperCase() + color.substring(1).toLowerCase();
        return color;
    }

    public int getPassengerCount() {
        return passengerCount;
    }
}
