import java.util.ArrayList;

public abstract class Observer {
    protected CheckWin checkWin;
    private ArrayList<String> deck, hand;
    private int cnt;
    public abstract boolean update(ArrayList<String> deck, ArrayList<String> hand, int cnt);
}
