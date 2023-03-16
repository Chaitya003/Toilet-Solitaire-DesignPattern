import java.util.ArrayList;

public interface GameStrategy {
    public void checkRule(ArrayList<String> deck, ArrayList<String> hand, int nextMove);
}
