import java.util.ArrayList;

public class Test {
    public static void main(String[] args) {
        Lindt lindt = new Lindt("Chocolate", "French", 2.4f, 3.2f, 4f);
        Baravelli baravelli = new Baravelli("Caramel", "German", 2.4f, 3);
        ChocAmor chocAmor = new ChocAmor("Vanilla", "Mexican", 3.5f);

        Lindt lindt1 = new Lindt("Chocolate", "French", 2.4f, 3.2f, 4f);
        System.out.println("Check equality of lindt and lindt1");
        System.out.println(lindt.equals(lindt1) + "\n");

        ArrayList<CandyBox> candyBoxes = new ArrayList<CandyBox>();
        candyBoxes.add(lindt);
        candyBoxes.add(baravelli);
        candyBoxes.add(chocAmor);

        CandyBag candyBag = new CandyBag(candyBoxes);
        Area area = new Area(candyBag, 3, "Victory");
        area.getBirthdayCard();
        area.printCandiesVolume();
        area.printCandiesDim();
    }
}
