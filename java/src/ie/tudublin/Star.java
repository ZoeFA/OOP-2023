package ie.tudublin;
import processing.data.*;
import java.util.ArrayList;


public class Star {

  ArrayList<Star> stars = new ArrayList<Star>();

  private boolean hab;
  private String displayName;
  private float distance, absMag;
  private float xG, yG, zG;

  
  public Star(TableRow tr){
  
    this(
          tr.getInt("Hab?") == 1,
          tr.getString("Display Name"),
          tr.getFloat("Distance"),
          tr.getFloat("Xg"),
          tr.getFloat("Yg"),
          tr.getFloat("Zg"),
          tr.getFloat("AbsMag")
  
    );
  }
  
  public Star(boolean hab, String displayName, float distance, float xG, float yG, float zG, float absMag){
  
    this.hab = hab;
    this.displayName = displayName;
    this.distance = distance;
    this.xG = xG;
    this.yG = yG;
    this.zG = zG;
    this.absMag = absMag;
  }
  

}


