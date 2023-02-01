package ie.tudublin;

import processing.core.PApplet;

public class HelloProcessing extends PApplet
{

	public void settings()
	{
		size(500, 500);
		
	}

	public void setup() {
		//colorMode(HSB);
		background(255, 0, 0);

		
	}

	
	
	public void draw()
	{	
		/*
		stroke(255);
		line(10, 10, 100, 100); // x1, y1, x2, y2
		circle(300, 250, 70); //cx, cy, d
		fill(0, 255, 0);
		rect(10, 300, 20, 100);//tlx, tly, w, h
		stroke(127);
		fill(255, 255, 0);
		noStroke();
		noFill();
		strokeWeight(1);
		triangle(40, 90, 300, 20, 80, 70);
		fill(0, 0, 255);
		*/

		//excercise
		//red background, yellow circle, light blue triangle, grey oval, black circle

		fill(255, 255, 0);
		stroke(255, 255, 0);
		circle(250, 250, 440);
		

		fill(0, 255, 255);
		stroke(0, 255, 255);
		triangle(250, 0, 50, 440, 440, 440 );
		
		
		fill(200);
		stroke(200);
		ellipse(250, 190, 168, 75);

		fill(0);
		stroke(0);
		circle(250, 190, 50);



		//circle that follows mouse
		background(255, 0, 0);
		fill(250);
		noStroke();
		fill(mouseX, 0, mouseY);
		circle(mouseX, mouseY, 10);

	}
}
