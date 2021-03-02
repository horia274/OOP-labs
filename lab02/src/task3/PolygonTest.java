package task3;

public class PolygonTest {
    public static void main(String[] args) {
        Point point1 = new Point(1, 2);
        Point point2 = new Point(2.5f, 2.4f);

        point1.showPoint();
        point2.showPoint();

        Polygon polygon = new Polygon(new float[]{1, 2.5f, 1.4f, 10.2f, 3.2f, 2});
        polygon.showPolygon();
    }
}
