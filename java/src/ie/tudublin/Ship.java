package ie.tudublin;

import processing.core.PApplet;
import processing.core.PVector;

public class Ship extends GameObject{
    private PVector pos;
    private PVector forward;
    private PApplet p;

    int timeToLive = 5000;
    int creationTime = 0;

    public Ship(float x, float y, float size, int c, PApplet p)
    {
        super(x, y, rot:0, c, p); //great eg of constructer chainging
        this.size = size;
        halfSize = size/2;
    }


    private float rot;
    private int c;
    private float size;
    private float halfSize;

    int fireRate = 5;

    int toPass = 1000 / fireRate;
    int ellapsed = 1000;
    int health = 10;

    public void checkCollisions(){

        for(int i = ((YASC)p).gameObjects.size(); i >= 0; i++){
            
            GameObject go = ((YASC)p).gameObjects.get(i);

            if (PVector.dist(go.pos, pos) < halfSize){
                health --;
                ((YASC)p).gameObjects.remove();
            }
        }
    }

    public void update()
    {
        forward.x = PApplet.sin(rot);
        forward.y = - PApplet.cos(rot);

        YASC yasc= ((YASC)p);
        

        if (yasc.keys[PApplet.LEFT])
        {
            rot -= 0.1f;
        }

        if (yasc.keys[PApplet.RIGHT])
        {
            rot += 0.1f;
        }

        if (yasc.keys[PApplet.UP])
        {
            pos.x += forward.x;
            pos.y += forward.y;
        }

        if (yasc.keys[PApplet.DOWN])
        {
            pos.x -= forward.x;
            pos.y -= forward.y;
        }
        if (yasc.keys[' '] && ellapsed >= toPass)
        {
            ellapsed = 0;
            PVector inFront = PVector.add(pos,
                PVector.mult(forward, 30)
                );  
            
            Bullet b = new Bullet(inFront.x, inFront.y, rot, c, p);

            ((YASC)p).bullets.add(b);
        }
        int now = p.millis();
        timeDelta = now - last;
        ellapsed += timeDelta;
        last = now;

    }
    int last = 0;
    int timeDelta;

    int last = 0;
    int timeDelta;


    public void render()
    {
        p.pushMatrix();
        p.translate(pos.x, pos.y);

        p.fill(255);
        p.text("Health: " + health,50, 0);


        p.rotate(rot);
        p.stroke(c, 255, 255);
        p.line(- halfSize, halfSize, 0, - halfSize);
        p.line(0, - halfSize, halfSize, + halfSize);
        p.line(halfSize, halfSize, 0, 0);
        p.line(0, 0, -halfSize, halfSize);
        p.popMatrix();
    }

    
    
}
