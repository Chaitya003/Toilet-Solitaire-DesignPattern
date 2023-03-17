/* Implementation of Command Pattern */

import java.util.ArrayList;
import java.util.Collections;

public class RemoveCard implements Command{

    ArrayList<String> deck;
    int numCards[];
    boolean isHand=false;

    RemoveCard(ArrayList<String> deck, int numCards[], boolean isHand){
        this.deck = deck;
        this.numCards = numCards;
        this.isHand = isHand;
    }

    @Override
    public ArrayList<String> execute() {
        if(isHand){
            for(int i=numCards[0]; i<=numCards[1]; i++) {
                deck.remove((deck.size()-1)-numCards[0]);
            }
        }
        else{
            if(deck.size()>numCards[1]){
                for(int i=numCards[0]; i<=numCards[1]; i++) {
                    deck.remove(0);
                }
            }
            else{
                deck.clear();
            }
        }
        return deck;
    }
}
