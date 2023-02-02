package ie.tudublin;

import processing.core.PApplet;

public class BugZap extends PApplet
{

	float playerX, playerY, playerWidth;
	float bugX, bugY, bugWidth;
	float halfPlayer, halfBug;

	int score = 0;

	public void settings()
	{
		size(500, 500);
	}

	public void setup() {
		//colorMode(HSB);
		background(0);
		smooth();


		playerX = width * 0.5f;
		playerY = height - 100;

		playerWidth = 50;
		halfPlayer = playerWidth * 0.5f;

		resetBug();
	}


	void resetBug(){

		bugY = 50;
		bugWidth = 50;
		halfBug = bugWidth * 0.5f;
		bugX = random(halfBug, width - halfBug);
	}

	public void drawPlayer(float x, float y, float w){
		
		background(0);
		stroke(255);
		noFill();
		rectMode(CENTER);
		rect(x, y, w, w);
		line(x, y - halfPlayer, x, y - halfPlayer * 2);

	}
	
	public void draw()
	{	
		
		drawPlayer(playerX, playerY, playerWidth);
		
		
	}

	public void keyPressed(){
		
		//polymorphism: the type is of a superclass, 
		//but the instance is of one of the subclasses

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

		/*
		if (keyCode == UP){

			if (playerY < height){
			//System.out.println("Left arrow pressed");
			playerY--;
			}
		}

		if (keyCode == DOWN){

			if (playerY < width){
			//System.out.println("Right arrow pressed");
			playerY++;
			}
		}*/

		if (key == ' '){
			//System.out.println("SPACE key pressed");
			line(playerX, playerY - halfPlayer, playerX, 0);
		}
	}

}
