import java.util.ArrayList;

public class BasicRule implements GameStrategy{
    int cnt;
    @Override
    public void checkRule(ArrayList<String> deck, ArrayList<String> hand, int nextMove) {
        CardOperation cardoperation = new CardOperation();
        if (nextMove == 1) {
            String suit_1 = hand.get(hand.size() - 4).substring(hand.get(hand.size() - 4).length() - 1);
            String suit_4 = hand.get(hand.size() - 1).substring(hand.get(hand.size() - 1).length() - 1);
//            String suit_4 = hand[hand.size()-1]->name()[hand[hand.size()-1]->name().size()-1];
            if (suit_1 == suit_4) {
                cnt = 0;
                int numRemoveCards[] = {1, 2};
                int numRemoveCardsDeck[] = {0, 1};
                int numDrawCards = 2;

                Command drawCard = new DrawCard(deck, hand, numDrawCards);
                Command removeCardDeck = new RemoveCard(deck, numRemoveCardsDeck, false);
                Command removeCardHand = new RemoveCard(hand, numRemoveCards, true);

                cardoperation.setCommand(removeCardHand);
                cardoperation.cardEvent();

                cardoperation.setCommand(drawCard);
                cardoperation.cardEvent();
//                hand = removeCards(hand, waste, numRemoveCards, true);

//                hand = drawCards(deck, hand, numDrawCards);
                if (!deck.isEmpty()) {
//                    deck = removeCards(deck, waste, numRemoveCardsDeck);
                    cardoperation.setCommand(removeCardDeck);
                    cardoperation.cardEvent();
                }
//                displayMoves(gameRule, deck, hand);
            }
        } else if (nextMove == 2) {
            String rank_1 = hand.get(hand.size() - 4).substring(0, hand.get(hand.size() - 4).length() - 1);
            String rank_4 = hand.get(hand.size() - 1).substring(0, hand.get(hand.size() - 1).length() - 1);
            if (rank_1 == rank_4) {
                cnt = 0;
                int numRemoveCards[] = {0, 3};  //{0, 1, 2, 3};
                int numDrawCards = 4;
                int numRemoveCardsDeck[] = {0, 3};

                Command drawCard = new DrawCard(deck, hand, numDrawCards);
                Command removeCardDeck = new RemoveCard(deck, numRemoveCardsDeck, false);
                Command removeCardHand = new RemoveCard(hand, numRemoveCards, true);

                cardoperation.setCommand(removeCardHand);
                cardoperation.cardEvent();

                cardoperation.setCommand(drawCard);
                cardoperation.cardEvent();
//                hand = removeCards(hand, waste, numRemoveCards, true);

//                hand = drawCards(deck, hand, numDrawCards);
                if (!deck.isEmpty()) {
//                    deck = removeCards(deck, waste, numRemoveCardsDeck);
                    cardoperation.setCommand(removeCardDeck);
                    cardoperation.cardEvent();
                }
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
