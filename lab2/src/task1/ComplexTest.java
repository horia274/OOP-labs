package task1;

public class ComplexTest {
    public static void main(String[] args) {
        Complex complex1 = new Complex(1, 2);
        Complex complex2 = new Complex();
        Complex complex3 = new Complex(complex1);
        Complex complex4 = new Complex(1, -2);
        Complex complex5 = new Complex(4, 0);

        complex1.showNumber();
        complex2.showNumber();
        complex3.showNumber();
        complex4.showNumber();
        complex5.showNumber();

        complex1.addWithComplex(complex4);
        complex1.showNumber();
    }
}
