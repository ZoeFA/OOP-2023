package ie.tudublin;

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

    p.stroke(c, 255, 255);
    p.line(pos.x - halfSize, pos.y + halfSize, pos.x, pos.y - halfSize);//left line
    p.line(pos.x, pos.y - halfSize, pos.x + halfSize, pos.y + halfSize); //top centre
    p.line(pos.x + halfSize, pos.y + halfSize, pos.x, pos.y);
    p.line(pos.x, pos.y, pos.x -halfSize, pos.y +halfSize);
  }
  
}