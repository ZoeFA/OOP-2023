package ie.tudublin;

//player extend core object
//arraylist
//taking damage -> instance of
//poserup interfect -> health
//                  -> ammo
//                  -> trials
//physics


import processing.core.PApplet;
import processing.core.PVector;
public class GameObject {
  
  //protected means
  protected PVector pos;
  protected float rot;
  protected float speed;
  protected PVector forward;
  protected PApplet p;
  protected
   int c;
  
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

  public float getSpeed() {
    return speed;
  }

  public void setSpeed(float speed) {
    this.speed = speed;
  }

  public PVector getForward() {
    return forward;
  }

  public void setForward(PVector forward) {
    this.forward = forward;
  }

  public PApplet getP() {
    return p;
  }

  public void setP(PApplet p) {
    this.p = p;
  }

  public int getC() {
    return c;
  }

  public void setC(int c) {
    this.c = c;
  }

}

public GameObject(float x, float y, float rot, int c, PApplet p ){

  pos = new PVector (x, y);
  forward = new Pvector(o, -1);
  this.p = p;
  this.rot = rot;
  this.c = c;

}


public abstract void update();
public abstract void render();