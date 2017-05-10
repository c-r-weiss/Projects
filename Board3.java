/**
 * FIlename: Board3.java
 * @author Corey Weiss, Jorden Tracey, Colin Davis
 * @version 20170427 
 */


import java.util.Random;
import java.util.Scanner;


public class Board3 extends Board {
   

    public Board3() {
        super();
    }

    public void getBoard3(){
      Game overOrNext = new Game();
      Trap trap = new Trap();
        int x = trap.getTrap();
        int y = trap.getTrap();
        int a = trap.getTrap();
        int b = trap.getTrap();
        int c = trap.getTrap();
        int f = trap.getTrap();
        board[x][y] = 7;
        board[a][b] = 7;
        board[c][f] = 7;
        int row = 0;
        int column = 0;
        int lives = 3;
        Random rand = new Random();
        
       Scanner br=new Scanner(System.in);
        System.out.println("Hi Peter. You're almost done. "
                + "If you can find the carrot this time, and not die you made it out of the garden!"
                + "\nYou got the idea of the rules now. You can do this!");
                
        printBoard();
        outer:
        while(true){


            while(true){
            char direction;
            String input;
            System.out.println("Type in the direction using: ");
            input = br.next().toLowerCase();
            direction = input.charAt(0);
              System.out.println(direction);
              char r,l,u,d;
             
              switch (direction){
                  case 'r': column++;
                            break;
                  case 'l': column--;
                            break;
                  case 'u': row--;
                            break;
                  case 'd': row++;
                            break;
                           
              }  
            
                try{
                
                if(isPlayable(row,column)){
                    if(playMove(row,column)){
                        printBoard();
                        
                        break outer;
                    }
                    break;
                }
                
                else if(board[row][column] == 7){
                    
                    while(true){
                        Scanner hl = new Scanner(System.in);

                        System.out.println("You ran into a trap. Let's play a game.\nThe game is high or low. "
                        + "\nChoose whether the next number will be higher or lower than the first number given by typing the word\n'High' or 'Low'.");

                        int firstNum = rand.nextInt(10)+1;
                        System.out.println("The first number is " + firstNum);

                        int secondNum = rand.nextInt(10)+1;
                        System.out.println("The second number has been generated. What is your guess?\nHigh or Low?");

                        String guess = hl.nextLine();
                        guess = guess.toUpperCase();

                        System.out.println("The second number was "+ secondNum);


                        if(secondNum < firstNum && "LOW".equals(guess)){
                        System.out.println("You got past the trap. Continue on to find the carrot.");
                            board[row][column] = 1;    
                            printBoard();   
                            break;    
                        }
                        else if(secondNum> firstNum && "HIGH".equals(guess)){
                        System.out.println("You got past the trap. Continue on to find the carrot.");
                            board[row][column] = 1;    
                            printBoard();   
                            break;      
                        }  


                       else {
                             System.out.println("Try again.");
                             lives--;
                             System.err.println("You have " + lives + " chances left!");      
                             if(lives ==0 ){
                                 System.out.println("You lost and must start the game over from the beginning of the level!");    
                                 overOrNext.Level3();
                        }


                                    }
                        }
                        
                }
            
                else{
                    System.out.println("You got the carrot!");
                    overOrNext.youWon();
                }    
                }catch(ArrayIndexOutOfBoundsException e){
                    System.err.println("You cannot make that move and fell off the board!"
                            + "Start again, but this time be careful!");
                           overOrNext.Level3();
                
                }
                
            }
            printBoard();

   
        }
    }
}