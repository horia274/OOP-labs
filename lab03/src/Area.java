public class Area {
    CandyBag candyBag;
    int number;
    String street;

    public Area() {}

    public Area(CandyBag candyBag, int number, String street) {
        this.candyBag = candyBag;
        this.number = number;
        this.street = street;
    }

    public void getBirthdayCard() {
        System.out.println("Address: " + this.street + " street; no. " + this.number);
        System.out.println("Happy Birthday!\n");
    }

    public void printCandiesVolume() {
        for(CandyBox candyBox : candyBag.candyBoxes) {
            System.out.println(candyBox);
        }
        System.out.println();
    }

    public void printCandiesDim() {
        for(CandyBox candyBox : candyBag.candyBoxes) {
            candyBox.printDim();
        }
    }
}
