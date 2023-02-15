package ie.tudublin;

import processing.core.PApplet;
import java.util.ArrayList;
import processing.data.*;

public class StarMap extends PApplet
{

	ArrayList[] stars;

	public void settings()
	{
		size(500, 500);
	}

	public void setup() {
		colorMode(RGB);
		background(0);
		smooth();
		
	}


	public void drawGrid(){
	
		stroke(0, 255, 0);

		float border = 50.0f;
		
		int count = 10;
		float gap = (width - (border * 2.0f))/ (float) count;

		for (int i = -5; i <= 5; i++){

			float x = border + (gap * (i + 5));
			line(x, border, x, height - border);
			line(border, x, width - border, x);
		}
	}

	void loadStars(){

    Table table = loadTable ("HabHYG15ly.csv", "header");
  
    for (TableRow r:table.rows()){
  
      Star s = new Star(r);
      stars.add(s);
    }
  }
		
	public void draw()
	{	
		strokeWeight(5);	
		drawGrid();	


	}
}