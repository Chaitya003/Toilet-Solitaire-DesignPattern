import java.util.ArrayList;

public class IntermediateRule implements GameStrategy{

    int cnt;
    @Override
    public void checkRule(ArrayList<String> deck, ArrayList<String> hand, int nextMove) {
        CardOperation cardoperation = new CardOperation();

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
                int numDrawCards = 2;
                int numRemoveCardsDeck[] = {0, 1};

                Command drawCard = new DrawCard(deck, hand, numDrawCards);
                Command removeCardDeck = new RemoveCard(deck, numRemoveCardsDeck, false);
                Command removeCardHand = new RemoveCard(hand, pairCards, true);

                cardoperation.setCommand(removeCardHand);
                cardoperation.cardEvent();

                cardoperation.setCommand(drawCard);
                cardoperation.cardEvent();

                if (!deck.isEmpty()) {
                    cardoperation.setCommand(removeCardDeck);
                    cardoperation.cardEvent();
//                    deck = removeCards(deck, waste, numRemoveCardsDeck);
                }

//                displayMoves(gameRule, deck, hand);
            }
            else {
                System.out.println("Take valid move.");
//            displayMoves(gameRule, deck, hand);
            }
        } else if(nextMove==9){
            int numDrawCards = 1;
            int numRemoveCardsDeck[] = {0, 0};

            Command drawCard = new DrawCard(deck, hand, numDrawCards);
            Command removeCardDeck = new RemoveCard(deck, numRemoveCardsDeck, false);
//            Command removeCardHand = new RemoveCard(hand, numRemoveCards, true);

            cardoperation.setCommand(drawCard);
            cardoperation.cardEvent();
//
////
//            hand = drawCards(deck, hand, numDrawCards);
//
            if(!deck.isEmpty()){
                cardoperation.setCommand(removeCardDeck);
                cardoperation.cardEvent();
//                deck = removeCards(deck, waste, numRemoveCardsDeck);
            }
//            displayMoves(gameRule, deck, hand);
        }
        else{
            System.out.println("Take valid move.");
//            displayMoves(gameRule, deck, hand);
        }
    }
}
