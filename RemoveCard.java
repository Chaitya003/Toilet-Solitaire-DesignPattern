import java.util.ArrayList;
import java.util.Collections;

public class RemoveCard implements Command{

    ArrayList<String> deck;
    int numCards[];
    boolean isHand;

    RemoveCard(ArrayList<String> deck, int numCards[], boolean isHand){
        this.deck = deck;
        this.numCards = numCards;
        this.isHand = isHand;
    }

    @Override
    public void execute() {
        if(isHand){
            for(int i=deck.size()-numCards[1]; i>deck.size()-numCards[0]; i--) {
                deck.remove(i);
            }
        }
        else{
            if(deck.size()>numCards[1]){
                Collections.sort(deck, Collections.reverseOrder());
                for(int i=deck.size(); i>deck.size()-numCards[0]; i--) {
                    deck.remove(i);
                }
                Collections.sort(deck, Collections.reverseOrder());
//                deck.remove(removeCard + numCards[0], removeCard + (numCards[1] + 1));
            }
            else{
                // cout<<"Vector Clear"<<endl;
                deck.clear();
            }
        }
        // }
//        return deck;
    }
}
