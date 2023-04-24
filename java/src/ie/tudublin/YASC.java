package ie.tudublin;

import java.util.ArrayList;

import processing.core.PApplet;
import processing.core.PVector;


/*yasc class keeps track of player class, which keeps track of bullet class
player is a field in yasc
yasc is a subclass of PApplet
1 to many relationship from yasc to gameobject
gameobject will be the superclass of player and bullet
move position,rotation and methods: render and update, from bullet to gameobject
now any subclasses og gameobject will have position,rotation,render,update whether these are public or private

game object is abstract class
abstract:
	-> cannot be instantiated
	-> any class that extends game object will also be abstract unless they implement abstract methods
	-> abstract methods are empty body methods
*/


public class YASC extends PApplet
{

	public boolean[] keys = new boolean[1024]; 

	public void keyPressed()
	{
		keys[keyCode] = true;
	}

	public void keyReleased()
	{
		keys[keyCode] = false;
	}

	// Generic
	public ArrayList<GameObject> gameObjects = new ArrayList<GameObject>();


	public void settings()
	{
		size(500, 500);

		PVector a = new PVector(10, 10);
    PVector b = new PVector(20, 20);

		b = a;
		
		b.x = 30;
		b.y = 30;

		println(a);
		
	}

	String s3 = "Hello";

	public void setup() {
		ship = new Ship(width / 2, height / 2, 50, 70, this);
		ship1 = new Ship(100, 50, 80, 6, this);
		colorMode(HSB);

		String s = "I love Star Trek";

		s += " & 200AD";

		String s1 = s.substring(2, 6);

		println(s.substring(7, 11));

		println(s.indexOf("Trek"));

		println(s.startsWith("Ilove"));

		String ss3 = "Hell";
		String temp = "o";
		String s2 = "Hello";
		
		String s4 = ss3 + temp;

		println(s4 == s2);
		println(s4.equals(s2));
		


		println();

		/*startsWith
		endsWidth
		substring
		indexOf
		s1.chatAt
		s1.lastIndexOf
		s1.toUpperCase()
		s1.compareTo(s)
		s1.equals
		s1.

		println(s1);
		*/
	}

	public void draw()
	{	background(0);
		ship.render();
		ship.move();

		ship1.render();
		ship1.move();

		for(int i = bullets.size() - 1 ; i >= 0 ; i --)
		{
			Bullet b = bullets.get(i);
			b.render();
			b.move();
		}
		

		fill(255);
		text("Bullets: " + bullets.size(), 50, 50);

	}
}
