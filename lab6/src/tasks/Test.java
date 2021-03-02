package tasks;

import java.util.ArrayList;

public class Test {
    public static void main(String[] args) {
        Car audi = new Car(10000, CarType.AUDI, 2015);
        Car bmw = new Car(20000, CarType.BMW, 2017);
        Car ferrari = new Car(50000, CarType.FERRARI, 2019);
        Dealership dealership = new Dealership();
        ArrayList<Car> cars = new ArrayList<>();
        cars.add(audi);
        cars.add(bmw);
        cars.add(ferrari);

        dealership.negotiate(audi, new Offer() {
            @Override
            public int getDiscount(Car car) {
                return 600;
            }
        });

        dealership.negotiate(bmw, new Offer() {
            @Override
            public int getDiscount(Car car) {
                return 300;
            }
        });

        dealership.negotiate(ferrari, new Offer() {
            @Override
            public int getDiscount(Car car) {
                return 200;
            }
        });

        System.out.println("All Cars:");
        cars.forEach(System.out::println);
        cars.removeIf((car) -> car.price > 20000);
        System.out.println("'Cheap' Cars:");
        cars.forEach(System.out::println);
    }
}
