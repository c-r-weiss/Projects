
/**
 * FIlename: Board.java
 * @author Corey Weiss, Jorden Tracey, Colin Davis
 * @version 20170419
 * This is Peter Rabbit. See description of game in comment below. 
 */  

public class Board {


//    Written by Weiss; Reviewed by Davis and Tracey
   private final int boardWidth=8;
   private final int boardHeight=8;
   
   int[][] board;
    
//    Written by Tracey; Reviewed by Weiss and Davis
    public Board(){
        board=new int[boardHeight][boardWidth];
        board[6][6] = 5;
        board[0][0] = 1;

        
    }

   
//          Written by Davis; Reviewed by Weiss and Tracey
    public void printBoard(){
       for (int[] board1 : board) {
           for (int j = 0; j<board[0].length; j++) {
               switch (board1[j]) {
                   case 0:
                       System.out.print("_  ");
                       break;
                   case 7:
                   case 5:
                       System.out.print("C  ");
                       break;
                   case 1:
                       System.out.print("R  ");
                       break;
                   default:
                       System.out.print(board1[j] + "  ");
                       break;
               }
           }
           System.out.println();
       }
        
        
        for(int i=0;i<boardWidth;i++)
            System.out.print("*  ");
        System.out.println();
        
        for(int i=0;i<boardWidth;i++)
            System.out.print((i)+"  ");
        System.out.println();
        
        
    }
//    Written by Davis; Reviewed by Tracey and Weiss
    
    public boolean playMove(int row, int column){
        int i;
        for(i=0;i<boardHeight;i++){
            if(board[row][column] == 1){
                board[row][column]= 1;
                break;
            }
        }
        if(i == boardHeight)
            board[row][column]=1;
        
        
        return reachedEnd(row,column);
    }
// Written by Weiss; Reviewed by Davis and Tracey
    public boolean isPlayable(int row,int column){

                return board[row][column] ==0;

    }          
            
    
//   Written by Weiss, Tracey; Reviewed by Davis
    public boolean reachedEnd(int g, int h){
        try {int num=board[g][h];
        int count;
 
        count=0;
        int j=6;
        int k=6;        
        if(board[j][k] == num){
            count = 1;
            
        }
        } catch(ArrayIndexOutOfBoundsException e){
            System.out.println("You cannot go in that direction!");
        }
        return false;
        
    } 
}
