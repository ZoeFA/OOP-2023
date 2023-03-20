package ie.tudublin;

import com.jogamp.common.net.asset.Handler;

import processing.core.PApplet;
import processing.core.PVector;

public class Ship{

  private PVector pos;
  PApplet p;

  private float rot;
  private int c;
  private float size;
  private float halfSize;

//constructer
  public Ship(float x, float y, float size, int c, PApplet p){
    //assigning the private fields
//missing code

    pos = new PVector(x, y); //instanciate new class, otherwise null pointers

    this.size = size; //disambiguation by using this.
    this.halfSize = size/2;
    this.c = c;
    this.p = p;

  }


//getters and setters
  public PVector getPos() {
    return pos;
  }
  public void setPos(PVector pos) {
    this.pos = pos;
  }
  public float getRot() {
    return rot;
  }
  public void setRot(float rot) {
    this.rot = rot;
  }
  public int getC() {
    return c;
  }
  public void setC(int c) {
    this.c = c;
  }
  public float getSize() {
    return size;
  }
  public void setSize(float size) {
    this.size = size;
  }


  public void render(){

    p.rotate(rot);
    p.stroke(c, 255, 255);
    //p.line(pos.x - halfSize, pos.y + halfSize, pos.x, pos.y - halfSize);//left line
    //p.line(pos.x, pos.y - halfSize, pos.x + halfSize, pos.y + halfSize); //top centre
    //p.line(pos.x + halfSize, pos.y + halfSize, pos.x, pos.y);
    //p.line(pos.x, pos.y, pos.x -halfSize, pos.y +halfSize);

    p.line(- halfSize, halfSize, 0, -halfSize);
    p.line(0, - halfSize, halfSize, +halfSize);
    p.line(halfSize, halfSize, 0, 0);
    p.line(0, 0, - halfSize, halfSize);
  }
  

  public void move(){//method

    forward.x = PApplet.sin(rot);
    forward.y = - PApplet.cos(rot);

    if (p.keyPressed){
      if (p.keyCode == PApplet.LEFT){
        
        //pos.x --;
        rot -= 0.1f;
      }

      if(p.keyCode == PApplet.RIGHT){
        
        //pos.x ++;
        rot += 0.1f;
      }

      if (p.keyCode == PApplet.UP){
        
        //pos.y --;
        pos.x += foward.x;
        pos.y += forward.y;
      }

      if(p.keyCode == PApplet.DOWN){

        //pos.y ++;
        pos.x -= forword.x;
        pos.y -=forward.y;
      }
    }
  }
}

//making the ship move forward or backwards based on where its facing