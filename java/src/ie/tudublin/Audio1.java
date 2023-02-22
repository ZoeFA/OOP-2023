package ie.tudublin;

import ddf.minim.AudioBuffer;
import ddf.minim.AudioInput;
import ddf.minim.AudioPlayer;
import ddf.minim.Minim;
import processing.core.PApplet;

public class Audio1 extends PApplet
{
    Minim minim;
    AudioPlayer ap;
    AudioInput ai;
    AudioBuffer ab;

    int mode = 0;

    float y = 0;
    float smoothedY = 0;
    float smoothedAmplitude = 0;
    float lerpedA = 0;

    public void keyPressed() {
		if (key >= '0' && key <= '9') {
			mode = key - '0';
		}
		if (keyCode == ' ') {
            if (ap.isPlaying()) {
                ap.pause();
            } else {
                ap.rewind();
                ap.play();
            }
        }
	}

    public void settings()
    {
        size(1024, 1000, P3D);
        
        //fullScreen(P3D, SPAN);
    }

    public void setup()
    {
        minim = new Minim(this);
        // Uncomment this to use the microphone
        // ai = minim.getLineIn(Minim.MONO, width, 44100, 16);
        // ab = ai.mix; 

        // And comment the next two lines out
        ap = minim.loadFile("heroplanet.mp3", 1024);
        ap.play();
        ab = ap.mix;
        colorMode(HSB);

        y = height / 2;
        smoothedY = y;

    }

    float off = 0;

    public void draw()
    {
        //background(0);
        float halfH = height / 2;
        float average = 0;
        float sum = 0;
        off += 1;
        // Calculate sum and average of the samples
        // Also lerp each element of buffer;
        for(int i = 0 ; i < ab.size() ; i ++)
        {
            sum += abs(ab.get(i));
        }

        average= sum / (float) ab.size();

        smoothedAmplitude = lerp(smoothedAmplitude, average, 0.1f);
        float r = average * 200;//radius
        lerpedA = lerp(lerpedA, r, 0.1f); //bring lerpedR 10% closer to r

        
        float cx = width / 2;
        float cy = height / 2;

        switch (mode) {
			case 0://when 0 key is pressed, wavy lines
                background(0);
                for(int i = 0 ; i < ab.size() ; i ++)
                {
                    //float c = map(ab.get(i), -1, 1, 0, 255);
                    float c = map(i, 0, ab.size(), 0, 255);
                    stroke(c, 255, 255);
                    float f = ab.get(i) * halfH;    
                    
                }
                break;
            
            case 1: //when 1 key is pressed, waveform
                background(0);
                for(int i = 0 ; i < ab.size() ; i ++)
                {
                    float c = map(i, 0, ab.size(), 0, 255);
                    stroke(c, 255, 255);
                    float f = ab.get(i) * halfH;
                    line(i, halfH + f, i, halfH - f);                    
                }            
                break;
            
            case 2: //2 key is pressed, 4 waveform on perimeter
                background(0);
                for(int i = 0 ; i < ab.size() ; i ++)
                {
                    float c = map(i, 0, ab.size(), 0, 255);
                    stroke(c, 255, 255);
                    float f = ab.get(i) * halfH;
                    
                    line(i, height + f, i, height - f);//bottom
                    line(i, 0 + f, i, 0 - f);//top
                    //line(i, height + f, i + height, height - f); no working
                    
                }
                break;
                
            case 3: //3 key is pressed, circle
                background(0);
                {
                    colorMode(RGB);
                    stroke(255, 150, 10);
                    strokeWeight(6);
                    fill(0);        
                    
                    circle(cy, halfH, lerpedA * 10);
                }
                break;

            case 4://4 key is pressed, square
                background(0);
                {
                    colorMode(RGB);
                    stroke(255, 150, 10);
                    strokeWeight(6);
                    fill(0);        
                    
                    circle(cy, halfH, lerpedA * 10);
                }
                break;
            
            case 5://5 key is pressed, custom, weird prism design
                background(0);
                for(int i = 0 ; i < ab.size() ; i ++)
                {
                    float c = map(i, 0, ab.size(), 0, 255);
                    stroke(c, 255, 255);
                    float f = ab.get(i) * halfH;
                    line(0, 0 + f, height, height - f);
                    //line(0, i + f, height, i - f); another custom design 
                    //line(0, i + f, i, i - f);                   
                }
                break;
        }
        


        
        // Other examples we made in the class
        /*
        stroke(255);
        fill(100, 255, 255);        
        
        circle(width / 2, halfH, lerpedA * 100);

        circle(100, y, 50);
        y += random(-10, 10);
        smoothedY = lerp(smoothedY, y, 0.1f);        
        circle(200, smoothedY, 50);
        */

    }        
}
