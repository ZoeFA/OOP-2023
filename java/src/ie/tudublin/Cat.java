package ie.tudublin;

public class Cat{

  int numLives;
  String name;
	
	public void setLives(int numLives)
	{
		this.numLives = numLives;
	}
	
	public Cat(String name)
	{
    numLives = 9;
	}
	
	public void kill(){

    System.out.println(numLives);
    numLives -= 1;

    if (numLives > 0){
      System.out.println("Ouch!");
    }
    
    else if(numLives == 0){
      System.out.println("Dead");
    }
    }

	}

  
}