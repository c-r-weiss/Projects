/**
 * FIlename: Trap.java
 * @author Corey Weiss, Jorden Tracey, Colin Davis
 * @version 20170427 
 */

import java.util.Random;
public class Trap {

    public Trap() {
        System.out.println(".");
    }

    public int getTrap() {
    Random rand = new Random();
    int x = rand.nextInt(7)+1;
    return x;
    }
    
}
