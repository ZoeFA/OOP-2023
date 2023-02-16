package ie.tudublin;

import processing.core.PApplet;
import java.util.ArrayList;
import processing.data.*;

public class StarMap extends PApplet
{
	
	ArrayList<Star> stars = new ArrayList<Star>();

	public void settings()
	{
		size(500, 500);
	}

	public void setup() {
		colorMode(RGB);
		background(0);
		smooth();

		loadStars();
		printStars();
		
	}


	public void drawGrid(){
	
		stroke(0, 255, 255);

		float border = width * 0.1f;
		
		int count = 10;
		float gap = (width - (border * 2.0f))/ (float) count;

		for (int i = -5; i <= 5; i++){

			

			float x = map(i, -5, 5, border, width - border);
			line(x, border, x, height - border);
			line(border, x, width - border, x);

			textAlign(CENTER, CENTER);
			text(i, x, border * 0.5f );

			text(i, x, height * 0.5f );

		}

		//float f = map(5, 0, 20, 100, 200);
		//float f = map1(a:5, b:0, c:10, d:100, e:200);

	}

	float map1(float a, float b, float c, float d, float e){

		float r1 = c - b;
		float r2 = e - d;

		float howfar = a - b;

		return d + (howfar / r1) + r2;//how far into range one you are

	}

	void printStars(){

		for (int i = 0; i < stars.size(); i++){
			
			println(stars.get(i))
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