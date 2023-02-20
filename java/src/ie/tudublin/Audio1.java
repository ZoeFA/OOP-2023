package ie.tudublin;

import ddf.minim.AudioBuffer;
import ddf.minim.AudioInput;
import ddf.minim.AudioPlayer;
import ddf.minim.Minim;
import processing.core.PApplet;

public class Audio1 extends PApplet
{

  Minim minim;
  AudioInput ai; //reading from micorphone
  AudioPlayer ap; 
  AudioBuffer ab; 

	public void settings()
	{
		size(500, 500);
	}


  int frameSize = 1024;


	public void setup() {
		colorMode(HSB);
		background(0);

    minim = new Minim(this); //

    ai = minim.getLineIn(Minim.MONO, frameSize, 44100, 16);
    ab = ai.mix;


    smooth();
		
	}

	public void draw()
	{	
		background(0);
    stroke(255);

    float half = height / 2;
    float cgap = 255 / (float)ab.size();

    float total = 0;


    //interate over audio buffer like an array
    for (int i = 0; i < ab.size(); i++){


      total += abs(ab.get(i));
      stroke(cgap * i, 255, 255);
      line(i, half,i, half + ab.get(i) * half);
    }

    //calculate the average size of the buffer = est of loud the audio is
    //--> average or absolute value abs
    float average = total / (float)ab.size();
    float r = average * 200;//radius
    
    lerpedR = lerp(lerpedR, r, 0.1f); //bring lerpedR 10% closer to r

    circle(100, 200, r);



    //lerp(a:10, b:20, t:0.1); //linear interpalation


	}

    float lerpedR = 0;


/*
    float lerp (float a, float b, float t){

      return a + (b - a) * t;
    }*/
	}
