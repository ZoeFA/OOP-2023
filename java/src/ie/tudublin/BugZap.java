package ie.tudublin;

import processing.core.PApplet;

public class BugZap extends PApplet
{

	float playerX, playerY, playerWidth;
	//float x1dir, x2dir, y1dir, y2dir;
	//float c = 0;

	public void settings()
	{
		size(500, 500);
	}

	public void setup() {
		//colorMode(HSB);
		background(0);
	}

	public void drawPlayer(float x, float y, float w){
		
		background(0);
		stroke(0, 0, 255);
		fill(0, 0, 255);
		circle(x, y, w);

	}
	
	public void draw()
	{	
		
		drawPlayer(playerX, playerY, 100);
		
		
	}

	public void keyPressed(){
		

		if (keyCode == LEFT){

			if (playerX > 0){
			//System.out.println("Left arrow pressed");
			playerX--;
			}	
		}

		if (keyCode == RIGHT){

			if (playerX < width){
			//System.out.println("Right arrow pressed");
			playerX++;
			}
		}


		if (keyCode == UP){

			if (playerY < height){
			//System.out.println("Left arrow pressed");
			playerX--;
			}
		}

		if (keyCode == DOWN){

			if (playerX < width){
			//System.out.println("Right arrow pressed");
			playerX++;
			}
		}

		if (key == ' '){
			//System.out.println("SPACE key pressed");
			line(playerX, playerY, width/10, width/5);
		}
	}

}
