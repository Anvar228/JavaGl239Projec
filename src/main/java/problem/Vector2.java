package problem;

public class Vector2 {
    double x;
    double y;


    public Vector2(double x1, double y1) {
        x = x1;
        y = y1;

    }

    public Vector2 plus(Vector2 v) {
        return new Vector2(this.x + v.x, this.y + v.y);
    }

    public Vector2 minus(Vector2 v) {
        return new Vector2(this.x + v.x, this.y + v.y);
    }
}
