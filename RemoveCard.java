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
//        System.out.println(numCards.length);
        if(isHand){
            for(int i=numCards[0]; i<=numCards[1]; i++) {
//                System.out.print("Hand removal ");
//                System.out.print(i);
                deck.remove((deck.size()-1)-numCards[0]);
            }
        }
        else{
            if(deck.size()>numCards[1]){
                System.out.println(deck.size());
//                Collections.sort(deck, Collections.reverseOrder());
                for(int i=numCards[0]; i<=numCards[1]; i++) {
//                    System.out.print("Deck removal ");
//                    System.out.print(i);
                    deck.remove(0);
                }
//                Collections.sort(deck, Collections.reverseOrder());
//                deck.remove(removeCard + numCards[0], removeCard + (numCards[1] + 1));
            }
            else{
                // cout<<"Vector Clear"<<endl;
                deck.clear();
            }
        }
        // }
        return deck;
    }
}
