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
    Vector2 K;
    Vector2 P;

    public Rectangle(Vector2 pos1, Vector2 pos2, Vector2 pos3) {
        double x;
        double y;
        this.A = pos1;
        this.B = pos2;
        this.E = pos3;
        double U = B.y*A.x*A.x+B.y*B.x*A.x-2*B.y*B.x*B.x+B.x*A.y;
        double F = -(A.x*E.x*A.y+B.x*E.x*A.y-E.y*A.y*A.y+A.x*E.x*B.y-B.x*E.x*B.y+E.y*A.y*B.y);
        P = new Vector2((((U-F)/((A.y-B.y)*(A.y-B.y)+(A.x-B.x)*(A.x-B.x)))*(A.x-B.x)+(B.x*A.y-B.y*A.x-2*B.y*B.x))/(A.y-B.y)
                ,
                (U-F)/((A.y-B.y)*(A.y-B.y)+(A.x-B.x)*(A.x-B.x))
        );


        Vector2 lp = pos3.minus(P);
        C = lp.plus(B);
        D = lp.plus(A);

        // Vector2  e=new ;
//        int a;
//        int b;
//        int c;
//        this.C = e;
//        this.D =Math.abs( a*x+b*y+c)/Math.sqrt(a*a+b*b) ;
//        a*x+b*y+c=0;

    }

    public void render(GL2 gl) {

        Figures.renderQuad(gl, A, B, C, D, false);

    }
    //public boolean check(Vector2 pos4){
        //this.L=pos4;
    //}
}



