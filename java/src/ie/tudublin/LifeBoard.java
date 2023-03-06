package ie.tudublin;

import processing.core.PApplet;

public class LifeBoard{

  boolean[][] board;//arrays in java are objects
  private int size;
  //right click, -> source action -> tick getters and setters -> ok
  PApplet p;
  float cellWidth;

  //count how many cells alive around
  public boolean getCell(int row, int col){//getter function
    
    if(row >= 0 && row < size && col >= 0 && col < size){

      return board[row][col];
    }
    else{

      return false; //like Grace's pregnancy test
    }
  }

  public int countCells(int row, int col){

    int count = 0;

    for(int i = -1; i <=1; i++){
      for(int j = -1; j <= 1; j++){

        if (!(i == 0) && (j== 0)){
          if(getCell(i, j)){

            count ++;
          }
        }
      }

    }
    return  count;
  }

  
  public void applyRules(){

    for(int row = 0; row < size; row++){

      for (int col = 0; col < size; col++){

        int count = countCells(row, col);

        //< 2 > 3 dies
        //2 -3 survives
        if(board[row][col]){
          if(count == 2 || count == 3){

            next[row][col] = true;
          }
          else{
            next[row][col] = false;
          }
        }
        else{//dead with 3 neighbours come to life
          if (count == 3){
            next[row][col] = true;
          }
          else{
            next[row][col] = false;
          }
        }
      }
    }

    boolean [][] temp = board;
    board = next;
    next = temp;
  }

  public LifeBoard(int size, PApplet p){

    this.size = size;//assigns private param to size
    board = new boolean[size][size];
    this.p = p; //pass papplet as a  parameter
    cellWidth = p.width/ (float) size;
  }

//literally hitting the griddy XD
  public void randomise(){

    for(int row = 0; row < size; row++){
      //create a grid
      //fill in sqaures by calculating x,y to make rectangles

      for(int col = 0; col < size; col++){
        

        //can use java library to gen random nums
        //we will use processing library

        float dice = p.random(0.0f, 1.0f);//random function is a method on the p class
        board[row][col] = (dice <= 0.5f);//row|col
      }
    }
  }


  public void render(){

    for(int row = 0; row < size; row++){
     
      p.stroke(255);
      for(int col = 0; col < size; col++){
      
        float x = col * cellWidth;
        float y = row * cellWidth;

        
        if (board[row][col]){

          p.fill(0, 255, 0);
        }
        else{
          p.noFill();
        }

        p.rect(x, y, cellWidth, cellWidth);
      }
    }
  }


  public int getSize() {
    return size;
  }
  public void setSize(int size) {
    this.size = size;
  }

}

//can convert int to float, not vice versa