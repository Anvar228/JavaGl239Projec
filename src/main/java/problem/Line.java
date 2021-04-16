package problem;

public class Line {
    public Vector2 a;
    public Vector2 b;

    public double A;
    public double B;
    public double C;

    public Line(Vector2 a, Vector2 b) {
        this.a = a;
        this.b = b;
    }

    public Vector2 getIntersection(Line l) {
        return new Vector2(0, 0);
    }
}
