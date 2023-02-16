package ie.tudublin;
import processing.core.PApplet;
import processing.data.*;
//import java.util.ArrayList;


public class Star {

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
  
  public void render(PApplet p){
    
    float border = p.width * 0.1f;
    float x = PApplet.map(x6, -5, 5, border, p.width - border);
    float y = PApplet.map(y6, -5, 5, border, p.height - border);

    p.stroke(255, 255, 0);
    p.line(x, y - 5, x, y + 5);
    p.line(x - 5, y, x + 5, y);
    p.stroke(255, 0, 0);

    p.circle(x, y, absMag);
    p.fill(255);

    p.textAlign(PApplet.LEFT);
    p.textSize(12);
    p.text(displayName, x + 20, y);
    p.noFill();
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



  @Override
  public String toString(){

    return "Star";
  }

  void printStars(){

		for (int i = 0; i < stars.size(); i++){
			
			println(stars.get(i))
		}
	}
  

}


