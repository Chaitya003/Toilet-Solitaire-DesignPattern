/* Implementation of Command Pattern */

import java.util.ArrayList;

public class Hand implements Command{
    ArrayList<String> deck, hand;

    Hand(ArrayList<String> deck, ArrayList<String> hand){
        this.deck = deck;
        this.hand = hand;
    }

    public void printHand(ArrayList<String> hand){
        // int cnt=0;
        System.out.println();
        for(int i=hand.size()-4; i<hand.size(); i++){
            System.out.print(hand.get(i));
            System.out.print(",");

        }
    }

    @Override
    public ArrayList<String> execute() {
        CardOperation cardoperation = new CardOperation();
        int numDrawCards = 4 - hand.size();
        Command drawCard = new DrawCard(deck, hand, numDrawCards);

        cardoperation.setCommand(drawCard);
        hand = cardoperation.cardEvent();
        return hand;
    }
}
