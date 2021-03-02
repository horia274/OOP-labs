package task0;

public class CarAnonymous {
    public Engine getEngine(int fuelCapacity) {
//        return new Engine () {
//            public int getFuelCapacity() {
//                return fuelCapacity;
//            }
//        };

        return () -> fuelCapacity;
    }
}
