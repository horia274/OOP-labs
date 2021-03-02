public class ChocAmor extends CandyBox {
    float length;

    public ChocAmor() {}

    public ChocAmor(String flavor, String origin, float length) {
        super(flavor, origin);
        this.length = length;
    }

    @Override
    public float getVolume() {
        return this.length * this.length * this.length;
    }

    public void printDim() {
        System.out.println("Dimensions of " + this.getOrigin() + " " + this.getFlavor() + ": " +
                this.length + " length");
    }
}
