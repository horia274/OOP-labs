package tasks;

public class Car {
    public int price;
    public CarType carType;
    public int year;

    public Car(int price, CarType carType, int year) {
        this.price = price;
        this.carType = carType;
        this.year = year;
    }

    public void reducePrice(Offer offer) {
        this.price -= offer.getDiscount(this);
    }

    @Override
    public String toString() {
        return "Car{" +
                "price=" + price +
                ", carType=" + carType +
                ", year=" + year +
                '}';
    }
}
