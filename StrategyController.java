/* Strategy Design pattern controller class */

import java.util.ArrayList;

public class StrategyController {
    private GameStrategy strategy;

    StrategyController(GameStrategy strategy){
        this.strategy = strategy;
    }

    public ArrayList<String> executeStrategy(ArrayList<String> deck, ArrayList<String> hand, int nextMove){
        return strategy.checkRule(deck, hand, nextMove);
    }
}
