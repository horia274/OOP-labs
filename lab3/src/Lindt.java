public class Lindt extends CandyBox {
    float length, width, height;

    public Lindt() {}

    public Lindt(String flavor, String origin, float length, float width, float height) {
        super(flavor, origin);
        this.length = length;
        this.width = width;
        this.height = height;
    }

    @Override
    public float getVolume() {
        return this.length * this.width * this.height;
    }

    public void printDim() {
        System.out.println("Dimensions of " + this.getOrigin() + " " + this.getFlavor() + ": " +
                this.length + " length, " + this.width + " width, " + this.height + " height");
    }
}
