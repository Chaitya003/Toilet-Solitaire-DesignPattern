/* Implementation of Command Pattern */

import java.util.ArrayList;
import java.util.Collections;

public class DrawCard implements Command{

    ArrayList<String> deck, hand;
    int numDrawCards, cnt;

    DrawCard(ArrayList<String> deck, ArrayList<String> hand, int numDrawCards) {
        this.deck = deck;
        this.hand = hand;
        this.numDrawCards = numDrawCards;
    }
    @Override
    public ArrayList<String> execute() {
        for(int i=0; i<numDrawCards; i++){
            if(!deck.isEmpty()){
                hand.add(deck.get(i));
            }
            else{
                /* Add the logic for rotation of hand*/
                cnt+=1;
                Collections.rotate(hand, hand.size()-1);//(hand.begin(), hand.begin()+1, hand.end());
            }
        }

        return hand;
    }
}
