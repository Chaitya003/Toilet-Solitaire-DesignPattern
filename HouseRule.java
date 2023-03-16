import java.util.ArrayList;

public class HouseRule implements GameStrategy{
    int cnt;
    @Override
    public void checkRule(ArrayList<String> deck, ArrayList<String> hand, int nextMove) {
        if(nextMove==4){
            String suit_1 = hand.get(hand.size()-4).substring(hand.get(hand.size()-4).length()-1);
            String suit_4 = hand.get(hand.size()-1).substring(hand.get(hand.size()-1).length()-1);

            String rank_3 = hand.get(hand.size()-2).substring(0, hand.get(hand.size()-2).length() - 1);
            String rank_4 = hand.get(hand.size()-1).substring(0, hand.get(hand.size()-1).length() - 1);

            if(suit_1==suit_4 && rank_3==rank_4){
                cnt = 0;
                int numRemoveCards[] = {1, 3};
                hand = removeCards(hand, waste, numRemoveCards, true);
                int numDrawCards = 3;
                hand = drawCards(deck, hand, numDrawCards);
                if(!deck.empty()){
                    int numRemoveCardsDeck[] = {0, 2};
                    deck = removeCards(deck, waste, numRemoveCardsDeck);
                }

                displayMoves(gameRule, deck, hand);
            }
            else{
                cout<<"Take valid move."<<endl;
                displayMoves(gameRule, deck, hand);
            }
        }

    }
}
