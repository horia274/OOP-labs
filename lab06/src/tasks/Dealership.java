package tasks;

import java.util.Random;

public class Dealership {
    private static class BrandOffer implements Offer {
        public int getDiscount(Car car) {
            if (car.carType == CarType.AUDI) {
                return (int) (car.price / 10);
            }
            else if (car.carType == CarType.BMW) {
                return (int) (car.price / 20);
            }
            else if (car.carType == CarType.FERRARI) {
                return (int) (car.price / 25);
            }
            return 0;
        }
    }

    private static class DealerOffer implements Offer {
        public int getDiscount(Car car) {
            int discount = 0;
            for (int i = car.year; i < 2020; i++) {
                discount += 100;
            }
            return discount;
        }
    }

    private static class SpecialOffer implements Offer {
        public int getDiscount(Car car) {
            return new Random().nextInt(301);
        }
    }

    public void getFinalPrice(Car car) {
        int currentPrice, discount;
        System.out.println("Initial price: " + car.price + " euros");

        currentPrice = car.price;
        BrandOffer brandOffer = new BrandOffer();
        car.reducePrice(brandOffer);
        discount = currentPrice - car.price;
        System.out.println("Applying Brand discount: " + discount + " euros");

        currentPrice = car.price;
        DealerOffer dealerOffer = new DealerOffer();
        car.reducePrice(dealerOffer);
        discount = currentPrice - car.price;
        System.out.println("Applying Dealer discount: " + discount + " euros");

        currentPrice = car.price;
        SpecialOffer specialOffer = new SpecialOffer();
        car.reducePrice(specialOffer);
        discount = currentPrice - car.price;
        System.out.println("Applying Special discount: " + discount + " euros");
        System.out.println("Final price: " + car.price + " euros");
    }

    public void negotiate(Car car, Offer offer) {
        this.getFinalPrice(car);
        System.out.print("Applying Client discount: ");
        if (new Random().nextInt(2) == 1) {
            System.out.println(offer.getDiscount(car) + " euros");
            car.reducePrice(offer);
        } else {
            System.out.println("0 euros");
        }
        System.out.println("Final price after negotiation: " + car.price + " euros");
        System.out.println();
    }
}
