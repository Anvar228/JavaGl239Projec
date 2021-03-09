package problem;

import javax.media.opengl.GL;
import javax.media.opengl.GL2;
import javax.media.opengl.GL2GL3;
import java.util.Vector;

public class Rectangle {
    Vector2 A;
    Vector2 B;
    Vector2 C;
    Vector2 D;

    public Rectangle(Vector2 pos1, Vector2 pos2,Vector2 pos3) {
        double x;
        double y;
        this.A = pos1;
        this.B = pos2;
        Vector2  e;
        int a;
        int b;
        int c;
        this.C = e;
        this.D =Math.abs( a*x+b*y+c)/Math.sqrt(a*a+b*b) ;
        a*x+b*y+c=0;

    }

    public void render(GL2 gl) {

        Figures.renderQuad(gl,A,B,C,D,false){

        }
        }

    }



