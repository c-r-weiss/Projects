/**
 * FIlename: Game.java
 * @author Corey Weiss, Jorden Tracey, Colin Davis
 * @version 20170427 
 */

import java.io.IOException;


public class Game {
   
public static void main(String args[])throws IOException{
    beginGame();

}
    public static void beginGame(){
        Board1 pr = new Board1();
        pr.getBoard1();
    }  
    public void Level2(){
        Board2 tr = new Board2();
        tr.getBoard2();
    }  
    public void Level3(){
        Board3 tr = new Board3();
        tr.getBoard3();
    }  
    public void youWon(){
        System.out.println("You got Peter out of the Garden. Great Job! Thank you for playing!");
        System.exit(0);
    }

}

