package ae.cyberspeed.game.service;

import ae.cyberspeed.game.data.business.Bet;
import ae.cyberspeed.game.exception.InvalidAmountException;

public class BetService {

    public Bet placeBet(double amount){
        if(amount<=0){
            throw new InvalidAmountException("Bet amount cannot be negative or 0");
        }
     Bet bet = new Bet();
     bet.setBetAmount(amount);
     return bet;
    }

}
