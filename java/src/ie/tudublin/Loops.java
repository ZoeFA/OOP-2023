package ie.tudublin;

import processing.core.PApplet;

public class Loops extends PApplet {

	int mode = 0;

	public void settings() {
		size(1000, 1000);

	}

	public void setup() {
		colorMode(HSB);
	}

	public void keyPressed() {

		mode = key - '0';
		println(mode);
	}

	public void draw() {

		background(0);
		fill(255);
		noStroke();

		switch (mode) {

			case 0:

				int numCircles = 10;
				float d = width / numCircles;

				for (int j = 0; j < numCircles; j++) {

					for (int i = 0; i < numCircles; i++) {

						float x = (d * 0.5f) + (d * i);
						float y = (d * 0.5f) + (d * j);

						float c = (i + j) / (numCircles * 2.0f) * 255;
						fill(c, 255, 255);
						
						circle(x, y, d);

					}
				}
				break;
			case 1:
				break;
			default:
				break;
		}

	}
}
