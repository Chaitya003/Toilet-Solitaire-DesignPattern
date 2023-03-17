/* Implementation of Strategy Pattern */

import java.util.ArrayList;

public interface GameStrategy {
    public ArrayList<String> checkRule(ArrayList<String> deck, ArrayList<String> hand, int nextMove);
}
