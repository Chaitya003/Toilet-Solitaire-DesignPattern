/* Strategy Design pattern controller class */

import java.util.ArrayList;

public class StrategyController {
    private GameStrategy strategy;

    StrategyController(GameStrategy strategy){
        this.strategy = strategy;
    }

    public void executeStrategy(ArrayList<String> deck, ArrayList<String> hand, int nextMove){
        strategy.checkRule(deck, hand, nextMove);
    }
}
