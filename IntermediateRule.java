import java.util.ArrayList;

public class IntermediateRule implements GameStrategy{

    @Override
    public void checkRule(ArrayList<String> deck, ArrayList<String> hand, int nextMove) {


        if (nextMove == 3) {
            int pairCards[] = new int[1];
            boolean flag = false;
            for (int i = hand.size() - 4; i < hand.size() - 1; i++) {
                if (hand.get(i).substring(0, hand.get(i).length() - 1) == hand.get(i + 1).substring(0, hand.get(i + 1).length() - 1)) {
                    // cout<<"Same Pairs"<<endl;
                    flag = true;
                    // cout<<i<<"Pair rank";
                    pairCards[0] = i - (hand.size() - 4);
                    pairCards[1] = (i - (hand.size() - 4)) + 1;
                    break;
                }
            }

            if (flag) {
                cnt = 0;
                hand = removeCards(hand, waste, pairCards, true);
                int numDrawCards = 2;
                hand = drawCards(deck, hand, numDrawCards);
                if (!deck.empty()) {
                    int numRemoveCardsDeck[] = {0, 1};
                    deck = removeCards(deck, waste, numRemoveCardsDeck);
                }

                displayMoves(gameRule, deck, hand);
            } else {
                cout << "Take valid move." << endl;
                displayMoves(gameRule, deck, hand);
            }
        }
    }
}
