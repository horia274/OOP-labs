package task0;

public class Test {
    public static void main(String[] args) {
        Car car = new Car();

        Car.OttoEngine firstEngine = car.getEngine();
        Car.OttoEngine secondEngine = car.new OttoEngine(10);

        System.out.println(firstEngine.getFuelCapacity());
        System.out.println(secondEngine.getFuelCapacity());

        CarAnonymous carAnonymous = new CarAnonymous();
        Engine engine = carAnonymous.getEngine(100);
        System.out.println(engine.getFuelCapacity());
    }
}
