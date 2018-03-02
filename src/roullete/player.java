package roullete;

/**
 *
 * @author nolasco
 */
public class player {
    private int balance;
    private int bet;
    private int maxBalance;
    private int maxBet;
    private float k1; //Relative threshold for reseting bet
    private float k2; //Relative threshold for quiting game
    private int betsPlaced;
    private int betsWon;
    private int currentLosingStreak;
    private int longestLosingStreak;
    
    //Player constructor class
    public player(int balance, float k1, float k2) {
        this.balance=balance;
        this.maxBalance=this.balance;
        this.bet=1;
        this.maxBet=this.bet;
        this.k1=k1;
        this.k2=k2;
        this.betsPlaced=0;
        this.betsWon=0;
        this.currentLosingStreak=0;
        this.longestLosingStreak=0;
    }
    
    //Returns number of bets made by player
    public int getBetsPlaced() {
        return this.betsPlaced;
    }
    
    //Returns number of bets won by player
    public int getBetsWon() {
        return this.betsWon;
    }
    
    //Returns player's bet
    public int getBet() {
        return this.bet;
    }
    
    //Returns player's max bet
    public int getMaxBet() {
        return this.maxBet;
    }
    
    //Returns player's current balance
    public int getBalance() {
        return this.balance;
    }
    
    //Returns player's bet
    public int getMaxBalance() {
        return this.maxBalance;
    }
    
    //Returns player's longest losing streak
    public int getLongestLosingStreak() {
        return this.longestLosingStreak;
    }
    
    //Updates player balance and maxBalance
    public void setBalance(int gains) {
        this.balance+=gains;
        
        //Update highest balance score
        if(this.balance > this.maxBalance) {
            this.maxBalance = this.balance;
        }
    }
    
    //Update bet according to strategic constant
    public void updateBet(boolean victory) {
        if(victory || (this.bet*2 > this.balance*k1)) {
            //Reset bet if victory is achieved or if bet threshold is exceeded
            this.bet=1;
        } else {
            //Increase bet for the remaining cases
            this.bet*=2;
            //Update highest bet made
            if(this.bet > this.maxBet) {
                this.maxBet = this.bet;
            }
        }
    }
    
    //Update balance
    public void updateBalance(boolean victory) {
        this.betsPlaced++;
        if(victory) {
            this.setBalance(this.bet);
            this.updateBet(true);
            this.betsWon++;
            this.currentLosingStreak=0;
        } else {
            this.setBalance(-this.bet);
            this.updateBet(false);
            this.currentLosingStreak++;
            //Update longest losing streak
            if(this.currentLosingStreak > this.longestLosingStreak) {
                this.longestLosingStreak = this.currentLosingStreak;
            }
        }
    }

    //Evaluate will to play
    public boolean wantsToPlay() {
        //Continue to play as long as balance is bigger than 0 and balance has not decreased very much
        if(this.balance > k2*this.maxBalance && this.balance>0) {
            return true;
        } else {
            return false;
        }
    }
    
}
