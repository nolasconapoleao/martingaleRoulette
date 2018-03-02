package roullete;
import java.util.Random;

/**
 *
 * @author nolasco
 */

public class Roullete {
       
    public static void main(String[] args) {
        int initialBalance =50;
        float betQuitThresh =0.8f;
        float gameQuitThresh =0.1f;
        
        player p1 = new player(initialBalance, gameQuitThresh, betQuitThresh);
        //Length of the game
        int betsPlaced=0;
        int betsWon=0;
        spinner Spinner = new spinner();
        
        while(p1.wantsToPlay() && betsPlaced<200) {
            betsPlaced++;
            
            //Updates all variables for player
            if(Spinner.evaluateSpin()) {
                p1.updateBalance(true);
            } else {
                p1.updateBalance(false);
            }
        }
        
        //System.out.println("################### SPIN ###################");
        System.out.println("Number of Bets Placed: " + p1.getBetsPlaced());
        System.out.println("Number of Bets Won: " + p1.getBetsWon());
        System.out.println("Number of Bets Lost: " + (p1.getBetsPlaced()-p1.getBetsWon()) );
        System.out.println("Longest Loosing Streak: " + p1.getLongestLosingStreak());
        System.out.println("Max Balance Achieved: " + p1.getMaxBalance());
        System.out.println("Current Balance: " + p1.getBalance());
        System.out.println("Max Bet Made: " + p1.getMaxBet());
        System.out.println("Current Bet: " + p1.getBet());
        
    }
    
}
