import java.util.Objects;

public class CandyBox {
    private String flavor;
    private String origin;

    public CandyBox() {}

    public CandyBox(String flavor, String origin) {
        this.flavor = flavor;
        this.origin = origin;
    }

    public float getVolume() { return 0; }

    public String getFlavor() {
        return flavor;
    }

    public String getOrigin() {
        return origin;
    }

    @Override
    public String toString() {
        return "The " + this.getOrigin() +
                " " + this.getFlavor() +
                " has volume " + this.getVolume();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CandyBox)) return false;
        CandyBox candyBox = (CandyBox) o;
        return Objects.equals(flavor, candyBox.flavor) &&
                Objects.equals(origin, candyBox.origin);
    }

    public void printDim() {}
}
