public class Baravelli extends CandyBox {
    float radius, height;

    public Baravelli() {}

    public Baravelli(String flavor, String origin, float radius, float height) {
        super(flavor, origin);
        this.radius = radius;
        this.height = height;
    }

    @Override
    public float getVolume() {
        return (float) (3.14 * this.radius * this.radius * this.height);
    }

    public void printDim() {
        System.out.println("Dimensions of " + this.getOrigin() + " " + this.getFlavor() + ": " +
                this.radius  + " radius, " + this.height + " height");
    }
}
