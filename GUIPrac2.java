package org.yourorghere;
import java.lang.Math;
import javax.media.opengl.GL;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLCanvas;
import javax.media.opengl.GLCapabilities;
import javax.media.opengl.GLEventListener;
import javax.media.opengl.GLCapabilities;
import javax.media.opengl.glu.GLU;
import javax.swing.JFrame;

class ThirdGLEventListene implements GLEventListener {
    private GLU glu;
    public void init(GLAutoDrawable gld) {
        GL gl = gld.getGL();
        glu = new GLU();
        gl.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
        gl.glViewport(0, 0, 640, 480);
        gl.glMatrixMode(GL.GL_PROJECTION);
        gl.glLoadIdentity();
        glu.gluOrtho2D(0, 640, 0, 480);
    }
    public void display(GLAutoDrawable drawable) {
        GL gl = drawable.getGL();
        gl.glClear(GL.GL_COLOR_BUFFER_BIT);
        gl.glColor3f(1.0f, 0.0f, 0.0f);
        drawFigure(gl);
    }

    public void reshape(GLAutoDrawable drawable, int x, int y, int width,
            int height) {
    }

    public void displayChanged(GLAutoDrawable drawable,
            boolean modeChanged, boolean deviceChanged) {
    }

    private void drawFigure(GL gl) {
        gl.glPointSize(1.5f);
        circle(300,300,100,gl);
        ellipse(60,80,300,120,gl);
        circle(265,325,25,gl);
        circle(335,325,25,gl);
        ellipse(60,30,300,250,gl);
       
    }

    public void circle(int h,int k,int r,GL gl)
    {
        int x=0;
        int y=r;
        int i=2*(1-r);
        int limit =0;
        int del,deld;
       
        while(y>=limit){
            gl.glBegin(GL.GL_POINTS);
            System.out.println("this is x and y"+x+" "+y);
            gl.glVertex2i(x+h, y+k);
            gl.glVertex2i(-x+h, -y+k);
            gl.glVertex2i(x+h, -y+k);
            gl.glVertex2i(-x+h, y+k);    
            gl.glEnd();
            if(i<0){
                del=2*i+2*y-1;
                if(del<=0){
                    x=x+1;
                    i=i+2*x+1;
                }
                else{
                    x=x+1;
                    y=y-1;
                    i=i+2*(x-y+1);
                }
               
            }
            else{
                deld=2*(i-x)-1;
                if(deld<=0){
                    x=x+1;
                    y=y-1;
                    i=i+2*(x-y+1);
                }
                else{
                    y=y-1;
                    i=i-2*y+1;
                }
               
            }
        }
       
       
    }
    public void ellipse(int a,int b,int h,int k,GL gl){
        int x=0;
        int y=b;
        int i=a*a+b*b-(2*b*a*a);
        int limit =0;
        int del,deld;
       
        while(y>=limit){
            gl.glBegin(GL.GL_POINTS);
            System.out.println("this is x and y"+x+" "+y);
            gl.glVertex2i(x+h, y+k);
            gl.glVertex2i(-x+h, -y+k);
            gl.glVertex2i(x+h, -y+k);
            gl.glVertex2i(-x+h, y+k);    
            gl.glEnd();
            if(i<0){
                del=2*i+2*y-1;
                if(del<=0){
                    x=x+1;
                    i=i+2*x*b*b+b*b;
                }
                else{
                    x=x+1;
                    y=y-1;
                    i=i+(2*x*b*b)-(2*y*a*a)+a*a+b*b;
                }
               
            }
            else{
                deld=2*(i-x)-1;
                if(deld<=0){
                    x=x+1;
                    y=y-1;
                    i=i+2*(x-y+1);
                }
                else{
                    y=y-1;
                    i=i-2*y*a*a+a*a;
                }
               
            }
        }
       
    }
    public void dispose(GLAutoDrawable arg0) {
    }


   
   
}

public class GUIPrac2 {

    public static void main(String args[]) {      //getting the capabilities object of GL2 profile
        //final GLProfile profile=GLProfile.get(GLProfile.GL);
        GLCapabilities capabilities = new GLCapabilities();
        // The canvas
        final GLCanvas glcanvas = new GLCanvas(capabilities);
        ThirdGLEventListene b = new ThirdGLEventListene();
        glcanvas.addGLEventListener(b);
        glcanvas.setSize(400, 400);
        //creating frame
        final JFrame frame = new JFrame("Basic frame");
        //adding canvas to frame
        frame.add(glcanvas);
        frame.setSize(1000, 1000);
        frame.setVisible(true);
    }
}



