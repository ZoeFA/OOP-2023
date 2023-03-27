package ie.tudublin;
import processing.core.PApplet;
import processing.core.PVector;

public class Bullet {

  PVector pos;
  float rot;
  float speed;
  float c;
  PVector forward;
  PApplet p;
  

  public Bullet (float x, float y, float rot, float c, PApplet p){

    pos = new PVector(x, y);
    forward = new PVector(0, -1);
    speed = 5;
    this.p = p;
    this.rot = rot;
    this.c = c;


    /*PVector a = new PVector(10, 10);
    PVector b = new PVector(20, 20);
    
    b = a;
    b.x = 30;
    b.y = 30;


    p.println(a);
    //why does 30, 30 get printed out?

    a -> 10, 10 //the arrows mean "object references"
    b-> 20,20
    "b = a" we expect the values of b to copy to the values of a
    but what actually happens is b -> 10,10 (b's arrow points to the block of memory 10,10)


    */
  }

  void render(){

    p.pushMatrix();
    p.stroke(c, 255, 255);
    p.translate(pos.x, pos.y);
    p.rotate(rot);
    p.line(0, -5, 0 ,5);
    p.popMatrix();
  }

  void move(){

    forward.x = PApplet.sin(rot);
    forward.y = - PApplet.cos(rot);
    //cartesian circle

    pos.add(PVector.mult(forward, speed));

    //to remove bullets

    if (pos.x < 0 || pos.x > p.width || pos.y < 0 || pos.y > p.height){

      ((YASC)p).bullets.remove(this); //removing this element fromt the arraylist
    }


  }
}
