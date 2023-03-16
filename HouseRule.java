import java.util.ArrayList;

public class HouseRule implements GameStrategy{
    int cnt;
    @Override
    public void checkRule(ArrayList<String> deck, ArrayList<String> hand, int nextMove) {
        CardOperation cardoperation = new CardOperation();

        if(nextMove==4){
            String suit_1 = hand.get(hand.size()-4).substring(hand.get(hand.size()-4).length()-1);
            String suit_4 = hand.get(hand.size()-1).substring(hand.get(hand.size()-1).length()-1);

            String rank_3 = hand.get(hand.size()-2).substring(0, hand.get(hand.size()-2).length() - 1);
            String rank_4 = hand.get(hand.size()-1).substring(0, hand.get(hand.size()-1).length() - 1);

            if(suit_1==suit_4 && rank_3==rank_4){
                cnt = 0;
                int numRemoveCards[] = {1, 3};
                int numRemoveCardsDeck[] = {0, 2};
                int numDrawCards = 3;

                Command drawCard = new DrawCard(deck, hand, numDrawCards);
                Command removeCardDeck = new RemoveCard(deck, numRemoveCardsDeck, false);
                Command removeCardHand = new RemoveCard(hand, numRemoveCards, true);

                cardoperation.setCommand(removeCardHand);
                cardoperation.cardEvent();

                cardoperation.setCommand(drawCard);
                cardoperation.cardEvent();

                if(!deck.isEmpty()){
                    cardoperation.setCommand(removeCardDeck);
                    cardoperation.cardEvent();
                }
            }
            else{
                System.out.println("Take valid move.");
            }
        } else if(nextMove==5){
            String suit_1 = hand.get(hand.size()-4).substring(hand.get(hand.size()-4).length()-1);
            String suit_4 = hand.get(hand.size()-1).substring(hand.get(hand.size()-1).length()-1);

            String rank_1 = hand.get(hand.size()-4).substring(0, hand.get(hand.size()-4).length() - 1);
            String rank_2 = hand.get(hand.size()-3).substring(0, hand.get(hand.size()-3).length() - 1);

            if(suit_1==suit_4 && rank_1==rank_2){
                cnt = 0;
                int numRemoveCards[] = {0, 2};
                int numRemoveCardsDeck[] = {0, 2};
                int numDrawCards = 3;

                Command drawCard = new DrawCard(deck, hand, numDrawCards);
                Command removeCardDeck = new RemoveCard(deck, numRemoveCardsDeck, false);
                Command removeCardHand = new RemoveCard(hand, numRemoveCards, true);

                cardoperation.setCommand(removeCardHand);
                cardoperation.cardEvent();

                cardoperation.setCommand(drawCard);
                cardoperation.cardEvent();

                if(!deck.isEmpty()){
                    cardoperation.setCommand(removeCardDeck);
                    cardoperation.cardEvent();
                }
            }
            else{
                System.out.println("Take valid move.");
            }
        }
        else if(nextMove==9){
            int numDrawCards = 1;
            int numRemoveCardsDeck[] = {0, 0};

            Command drawCard = new DrawCard(deck, hand, numDrawCards);
            Command removeCardDeck = new RemoveCard(deck, numRemoveCardsDeck, false);
//            Command removeCardHand = new RemoveCard(hand, numRemoveCards, true);

            cardoperation.setCommand(drawCard);
            cardoperation.cardEvent();
            if(!deck.isEmpty()){
                cardoperation.setCommand(removeCardDeck);
                cardoperation.cardEvent();
            }
        }
        else{
            System.out.println("Take valid move.");
        }

    }
}
