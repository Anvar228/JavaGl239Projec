package problem;

import javax.media.opengl.GL;
import javax.media.opengl.GL2;
import java.util.ArrayList;

public class Polygon {
    ArrayList<Vector2> points;

    public Polygon(ArrayList<Vector2> points) {
        this.points = points;
    }

    public void render(GL2 gl) {
        gl.glBegin(GL.GL_LINE_STRIP);
        for (Vector2 vector2 : points) {
            gl.glVertex2d(vector2.x, vector2.y);
        }
        gl.glEnd();
    }

    public double getS() {
        return 2;
    }
}
