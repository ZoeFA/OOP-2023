package ie.tudublin;

import processing.core.PApplet;
import processing.core.PVector;

public class Bullet extends GameObject {
    PVector pos;
    float rot;
    private float speed;
    PVector forward;
    PApplet p;
    int c;

    int timeToLive = 5000;
    int creationTime = 0; 

    public Bullet(float x, float y, float rot, int c, PApplet p)
    {
        super(x, y, rot, c, p);
        speed = 5;
        creationTime = p.millis();

    }

    void render()
    {
        p.pushMatrix();
        p.stroke(c, 255, 255);
        p.translate(pos.x, pos.y);
        p.rotate(rot);
        p.line(0, -5, 0, 5);
        p.popMatrix();
    }

    void update()
    {
        forward.x = PApplet.sin(rot);
        forward.y = - PApplet.cos(rot);

        pos.add(PVector.mult(forward, speed));

        // if (pos.x < 0 || pos.x > p.width || pos.y < 0 || pos.y > p.height)
        // {
        //    z ((YASC)p).bullets.remove(this);
        // }

        if (pos.x < 0)
        {
            pos.x = p.width;
        }
        if (pos.y < 0)
        {
            pos.y = p.height;
        }
        if (pos.x > p.width)
        {
            pos.x = 0;
        }

        if (pos.y > p.height)
        {
            pos.y = 0;
        }
        
        int now = p.millis();
        if (now - creationTime > timeToLive)
        {
            ((YASC)p).bullets.remove(this);
        }

<<<<<<< HEAD
        if (pos.x <0){
            pos.x = p.width;

        }
        //if(pos.y )


=======
>>>>>>> d1af8cf42076566858f7fc2350fd9581150f2cd1
    }



}
