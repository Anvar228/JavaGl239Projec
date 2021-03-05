package problem;

import java.util.Vector;
import javax.media.opengl.GL;
import javax.media.opengl.GL2;
import javax.media.opengl.GL2GL3;

public class Figures {
    public static void renderPoint(GL2 gl, Vector2 pos, float size) {


        gl.glPointSize(size);
        gl.glBegin(GL.GL_POINTS);
        gl.glColor3d(0,1,0);
        gl.glVertex2d( pos.x, pos.y);
        gl.glEnd();
    }
    public static void renderLine(GL2 gl, Vector2 pos,Vector2 pos2, float width){
        gl.glLineWidth(width);
        gl.glBegin(GL.GL_LINES);
        gl.glColor3d(0,1,0);
        gl.glVertex2d( pos.x, pos.y);
        gl.glColor3d(0.4,1,0.5);
        gl.glVertex2d( pos2.x, pos2.y);
        gl.glEnd();
    }
    public static void renderTriangle(GL2 gl,Vector2  pos1, Vector2 pos2, Vector2 pos3,boolean filled){
       if (filled){
        gl.glBegin(GL.GL_TRIANGLE_FAN);
        gl.glColor3d(0,1,0);
        gl.glVertex2d( pos1.x, pos1.y);
        gl.glColor3d(0.4,1,0.5);
        gl.glVertex2d( pos2.x, pos2.y);
        gl.glColor3d(0.6,0.7,0.5);
        gl.glVertex2d( pos3.x, pos3.y);
        gl.glEnd();}
       else {
           gl.glBegin(GL.GL_LINE_STRIP);
           gl.glColor3d(0,0.7,0);
           gl.glVertex2d( pos1.x, pos1.y);
           gl.glColor3d(0.4,1,0.5);
           gl.glVertex2d( pos2.x, pos2.y);
           gl.glColor3d(0.6,0.7,0.5);
           gl.glVertex2d( pos3.x, pos3.y);
           gl.glColor3d(0,0.7,0);
           gl.glVertex2d( pos1.x, pos1.y);
           gl.glEnd();}
       }
       public static void renderQuad(GL2 gl,Vector2  pos1, Vector2 pos2, Vector2 pos3, Vector2 pos4,boolean filled){
           if (filled==true){
               gl.glBegin(GL2GL3.GL_QUADS);
               gl.glColor3d(0,1,0);
               gl.glVertex2d( pos1.x, pos1.y);
               gl.glColor3d(0.4,1,0.5);
               gl.glVertex2d( pos2.x, pos2.y);
               gl.glColor3d(0.6,0.7,0.5);
               gl.glVertex2d( pos3.x, pos3.y);
               gl.glColor3d(0.6,0.7,0.5);
               gl.glVertex2d( pos4.x, pos4.y);
               gl.glColor3d(0,1,0);
               gl.glVertex2d( pos1.x, pos1.y);
               gl.glEnd();}
           else {
               gl.glBegin(GL.GL_LINE_STRIP);
               gl.glColor3d(0,0.7,0);
               gl.glVertex2d( pos1.x, pos1.y);
               gl.glColor3d(0.4,1,0.5);
               gl.glVertex2d( pos2.x, pos2.y);
               gl.glColor3d(0.6,0.7,0.5);
               gl.glVertex2d( pos3.x, pos3.y);
               gl.glColor3d(0,0.7,0);
               gl.glVertex2d( pos4.x, pos4.y);
               gl.glColor3d(0,1,0);
               gl.glVertex2d( pos1.x, pos1.y);
               gl.glEnd();}
       }
    public static void renderCircle(GL2 gl,Vector2  pos, double r, boolean filled){
        if(filled==true){
        gl.glBegin(GL.GL_TRIANGLE_FAN);
        gl.glVertex2d(pos.x,pos.y);
        int n=3600;
        for (int i = 0; i <=n; i++) {
           double a=(2*Math.PI/n)*i;
           double x=r*Math.cos(a);
           double y=r*Math.sin(a);
           gl.glVertex2d(x,y);
           }
        gl.glEnd();
        }
        else{
            gl.glBegin(GL.GL_TRIANGLE_FAN);
            gl.glVertex2d(pos.x,pos.y);
            int n=10000;
            for (int i = 0; i <=n; i++) {
                double a=(2*Math.PI/n)*i;
                double x=r*Math.cos(a);
                double y=r*Math.sin(a);
                gl.glVertex2d(x,y);
            }
            gl.glEnd();
    }

    }}


