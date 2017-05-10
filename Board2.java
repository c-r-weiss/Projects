/**
 * FIlename: Board2.java
 * @author Corey Weiss, Jorden Tracey, Colin Davis
 * @version 20170427 
 */


import java.util.Random;
import java.util.Scanner;


public class Board2 extends Board {

    public Board2() {
        super();
    }
    
    public void getBoard2() {
    Game overOrNext = new Game();
      
    Trap trap = new Trap();
        int x = trap.getTrap();
        int y = trap.getTrap();
        int a = trap.getTrap();
        int b = trap.getTrap();
        board[x][y] = 7;
        board[a][b] = 7;
        int lives = 3;
        Random rand = new Random();
      
     int row = 0;
     int column = 0;
        Scanner br=new Scanner(System.in);
        System.out.println("Hi Peter. Welcome to level 2. The rules are the same, but there are more traps. Good Luck!");
                
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
                  default: System.err.println("You cant make that move");          
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
                                 overOrNext.Level2();
                        }


                                    }
                    }
                        
                }
            
                else{
                    System.out.println("You got the carrot! Now on to the next level!");
                    overOrNext.Level3();
                } 
                }catch(ArrayIndexOutOfBoundsException e){
                    System.err.println("You cannot make that move and fell off the board!"
                            + "Start again, but this time be careful!");
                           overOrNext.Level2();
                }
                
            }
            printBoard();

        }
    }
}