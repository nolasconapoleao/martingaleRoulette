# martingaleRoulette
The matingale betting system consists of:
  - doubling a bet if the player loses 
  - reseting the bet if the player wins
It's a strategy used in betting games, such as coin toss. 
It's used to balance the odds of losing by covering the accumulated loss with a higher bet.

Roulette is a game where a spinner rolls a ball placed on top of it. 
Once the ball stops, the position and colour where it lands determines the winning bet.
The original version has 37 positions, and the american has 38 positions.

Assuming that a player always plays the safest bet (red) with a probability of 18/37 (or 18/38 for the american version).
What is the probability of doubling his money?
How much money does he need, to have at least a half probability of not going bust?

Assuming a strategy where the player:
  - stops playing if his balance is smaller than a percentage of the highest balance achieved
  - resets the bet if his bet is higher than a percentage of the current balance
  
What is the optimal value for kBetVsBalance and kBalanceVsMaxBalance for different starting balances?
