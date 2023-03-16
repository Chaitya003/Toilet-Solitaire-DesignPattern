import java.util.ArrayList;

public class CheckWin {
    private ArrayList<Observer> observers = new ArrayList<Observer>();
    private ArrayList<String> deck, hand;
    private int cnt;
    private boolean flag;
//    int cnt;
//    CheckWin(ArrayList<String> deck, ArrayList<String> hand, int cnt){
//        this.deck = deck;
//        this.hand = hand;
//        this.cnt = cnt;
//    }
//
    public boolean getState() {
        return this.flag;
    }

    public void setState(ArrayList<String> deck, ArrayList<String> hand, int cnt) {
        this.deck = deck;
        this.hand = hand;
        this.cnt = cnt;
        this.flag = notifyAllObservers();
    }

    public void attach(Observer observer) {
        observers.add(observer);
    }

    public boolean notifyAllObservers() {
        for (Observer observer : observers) {
            this.flag = observer.update(this.deck, this.hand, this.cnt);
        }
        return this.flag;
    }
}
