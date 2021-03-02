package task3;

public class Polygon {
    int numberPoints;
    Point[] points;

    public Polygon(int n) {
        numberPoints = n;
        points = new Point[n];
    }

    public Polygon(float[] coordinates) {
        this(coordinates.length / 2);
        for(int i = 0; i < coordinates.length / 2; i++) {
            points[i] = new Point(coordinates[2*i], coordinates[2*i+1]);
        }
    }

    public void showPolygon() {
        for(int i = 0; i < this.numberPoints; i++) {
            this.points[i].showPoint();
        }
    }
}
