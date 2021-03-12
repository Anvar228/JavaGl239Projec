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
    Vector2 E;
    Vector2 L;

    public Rectangle(Vector2 pos1, Vector2 pos2,Vector2 pos3) {
        double x;
        double y;
        this.A = pos1;
        this.B = pos2;
        this.E = pos3;
        L = new Vector2(
               L.x=(pos2.y-pos1.y)*(x-pos3.x)+(pos1.x-pos2.x)*(y-pos3.y);
               L.y=
        );
        Vector2 lp = pos3.minus(L);
        Vector2 C = lp.plus(B);
        Vector2 D = lp.plus(A);

       // Vector2  e=new ;
//        int a;
//        int b;
//        int c;
//        this.C = e;
//        this.D =Math.abs( a*x+b*y+c)/Math.sqrt(a*a+b*b) ;
//        a*x+b*y+c=0;

    }

    public void render(GL2 gl) {

        Figures.renderQuad(gl,A,B,C,D,false){

        }
        }

    }



