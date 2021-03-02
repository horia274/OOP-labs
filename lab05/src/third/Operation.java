package third;

public class Operation implements Minus, Plus, Mult, Div {
    public float x;

    public Operation(float x) {
        this.x = x;
    }

    public float getNumber() {
        return x;
    }

    public void minus(float y) {
        x -= y;
    }

    public void plus(float y) {
        x += y;
    }

    public void mult(float y) {
        x *= y;
    }

    public void div(float y) {
        if (y == 0) {
            return;
        }
        x /= y;
    }
}
