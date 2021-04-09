package problem;

import javax.media.opengl.GL;
import javax.media.opengl.GL2;
import javax.media.opengl.GL2GL3;
import java.util.Random;
import java.util.Vector;

public class Rectangle {
    Vector2 A;
    Vector2 B;
    Vector2 C;
    Vector2 D;
    Vector2 E;
    Vector2 L;
    Vector2 P;

    public Rectangle(Vector2 pos1, Vector2 pos2, Vector2 pos3) {
        double x;
        double y;
        this.A = pos1;
        this.B = pos2;
        this.E = pos3;
        double U = B.y * A.x * A.x + B.y * B.x * A.x - 2 * B.y * B.x * B.x + B.x * A.y;
        double F = -(A.x * E.x * A.y + B.x * E.x * A.y - E.y * A.y * A.y + A.x * E.x * B.y - B.x * E.x * B.y + E.y * A.y * B.y);
        P = new Vector2((((U - F) / ((A.y - B.y) * (A.y - B.y) + (A.x - B.x) * (A.x - B.x))) * (A.x - B.x) + (B.x * A.y - B.y * A.x - 2 * B.y * B.x)) / (A.y - B.y)
                ,
                (U - F) / ((A.y - B.y) * (A.y - B.y) + (A.x - B.x) * (A.x - B.x))
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

    static Rectangle getRandomRectangle() {
        Random r = new Random();
        double nx = (double) r.nextDouble() * 2 - 1;
        double ny = (double) r.nextDouble() * 2 - 1;

        double nx2 = (double) r.nextDouble() * 2 - 1;
        double ny2 = (double) r.nextDouble() * 2 - 1;

        double nx3 = (double) r.nextDouble() * 2 - 1;
        double ny3 = (double) r.nextDouble() * 2 - 1;
        return new Rectangle(new Vector2(nx, ny), new Vector2(nx2, ny2), new Vector2(nx3, ny3));
    }

    public boolean contains(Vector2 K) {
        double p1 = Math.sqrt((C.x - K.x) * (C.x - K.x) + (C.y - K.y) * (C.y - K.y)) + Math.sqrt((C.x - D.x) * (C.x - D.x) + (C.y - D.y) * (C.y - D.y)) + Math.sqrt((D.x - K.x) * (D.x - K.x) + (C.y - D.y) * (C.y - D.y));
        double a = Math.sqrt((C.x - D.x) * (C.x - D.x) + (C.y - D.y) * (C.y - D.y));
        double c = Math.sqrt((D.x - K.x) * (D.x - K.x) + (C.y - D.y) * (C.y - D.y));
        double d = Math.sqrt((C.x - K.x) * (C.x - K.x) + (C.y - K.y) * (C.y - K.y));
        double S1 = Math.sqrt(p1 / 2 * (p1 / 2 - a) * (p1 / 2 - c) * (p1 / 2 - d));
        double b = Math.sqrt((B.x - C.x) * (B.x - C.x) + (B.y - C.y) * (B.y - C.y));
        double e = Math.sqrt((K.x - A.x) * (K.x - A.x) + (K.y - A.y) * (K.y - A.y));
        double f = Math.sqrt((B.x - K.x) * (B.x - K.x) + (B.y - K.y) * (B.y - K.y));
        double p2 = (e + c + b) / 2;
        double p3 = (e + f + a) / 2;
        double p4 = (b + f + d) / 2;
        double S2 = Math.sqrt(p2 * (p2 - e) * (p2 - c) * (p2 - b));
        double S3 = Math.sqrt(p3 * (p3 - e) * (p3 - f) * (p3 - a));
        double S4 = Math.sqrt(p4 * (p4 - b) * (p4 - f) * (p4 - d));
        double S = a * b;
        return Math.abs(S - (S1 + S2 + S3 + S4)) < 0.01;


    }
    public   Rectangle(Vector N){

    }
    //public boolean check(Vector2 pos4){
    //this.L=pos4;
    //}
}



