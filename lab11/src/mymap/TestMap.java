package mymap;

import java.util.Objects;

public class TestMap {
    private <K,V> boolean contains(MyHashMap<K,V> map, K key, V value) {
        return map.get(key) != null && map.get(key).equals(value);
    }

    private <K,V> boolean contains(MyHashMap<K,V> map, K key) {
        return map.get(key) != null;
    }

    public boolean passTest() {
        class Drink {
            final String name;
            final int alcoholPercent;
            final double quantity;
            final int price;

            public Drink(String name, int alcoholPercent, double quantity, int price) {
                this.name = name;
                this.alcoholPercent = alcoholPercent;
                this.quantity = quantity;
                this.price = price;
            }

            @Override
            public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;
                Drink drink = (Drink) o;
                return alcoholPercent == drink.alcoholPercent && quantity == drink.quantity && price == drink.price && Objects.equals(name, drink.name);
            }

            @Override
            public int hashCode() {
                return Objects.hash(name, alcoholPercent, quantity, price);
            }
        }

        MyHashMap<Drink, Integer> map = new MyHashMap<>();
        Drink vodka = new Drink("vodka", 40, 2.5,150);
        Drink tequila = new Drink("tequila", 35, 1, 80);
        Drink jager = new Drink("jager", 38, 1.5, 95);
        Drink bere = new Drink("Tuborg", 6, 2, 8);
        Drink vin = new Drink("Cotnari", 13, 1.5, 24);
        Drink absint = new Drink("Absint", 70, 0.5, 75);
        Drink stroh = new Drink ("Stroh", 80, 0.75, 120);

        map.put(vodka, 3);
        map.put(tequila, 1);
        map.put(jager, 2);
        map.put(bere, 10);
        map.put(vin, 5);

        map.put(vodka, 4);
        map.put(bere, 7);

        return contains(map, vodka, 4)
                && contains(map, tequila, 1)
                && contains(map, jager, 2)
                && contains(map, bere, 7)
                && contains(map, vin, 5)
                && !contains(map, absint)
                && !contains(map, stroh)
                && !contains(map, vin, 10)
                && !contains(map, vodka, 3);
    }
}
