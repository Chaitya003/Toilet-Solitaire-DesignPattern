/* Implementation of Strategy Pattern */

import java.util.ArrayList;
import java.util.Scanner;

public class HouseRule implements GameStrategy{
    int cnt;
    @Override
    public ArrayList<String> checkRule(ArrayList<String> deck, ArrayList<String> hand, int nextMove) {
        CardOperation cardoperation = new CardOperation();
        Scanner sc= new Scanner(System.in);
        if(deck.isEmpty()){
            cnt+=1;
        }
        if (nextMove == 1) {
            StrategyController strategy = new StrategyController(new IntermediateRule());
            hand = strategy.executeStrategy(deck, hand, nextMove);
            return hand;
        }
        else if (nextMove == 2) {
            StrategyController strategy = new StrategyController(new IntermediateRule());
            hand = strategy.executeStrategy(deck, hand, nextMove);
            return hand;
        }
        else if (nextMove == 3) {
            StrategyController strategy = new StrategyController(new IntermediateRule());
            hand = strategy.executeStrategy(deck, hand, nextMove);
            return hand;
        }
        else if(nextMove==4){
            String suit_1 = hand.get(hand.size()-4).substring(hand.get(hand.size()-4).length()-1);
            String suit_4 = hand.get(hand.size()-1).substring(hand.get(hand.size()-1).length()-1);

            String rank_3 = hand.get(hand.size()-2).substring(0, hand.get(hand.size()-2).length() - 1);
            String rank_4 = hand.get(hand.size()-1).substring(0, hand.get(hand.size()-1).length() - 1);

            if(suit_1.equals(suit_4) && rank_3.equals(rank_4)){
                cnt = 0;
                int numRemoveCards[] = {1, 3};
                int numRemoveCardsDeck[] = {0, 2};
                int numDrawCards = 3;

                Command drawCard = new DrawCard(deck, hand, numDrawCards);
//                Command removeCardDeck = new RemoveCard(deck, numRemoveCardsDeck, false);
                Command removeCardHand = new RemoveCard(hand, numRemoveCards, true);

                cardoperation.setCommand(removeCardHand);
                hand = cardoperation.cardEvent();

                cardoperation.setCommand(drawCard);
                hand = cardoperation.cardEvent();

                return hand;
            }
            else{
                System.out.println("Take valid move.");
                return hand;
            }
        } else if(nextMove==5){
            String suit_1 = hand.get(hand.size()-4).substring(hand.get(hand.size()-4).length()-1);
            String suit_4 = hand.get(hand.size()-1).substring(hand.get(hand.size()-1).length()-1);

            String rank_1 = hand.get(hand.size()-4).substring(0, hand.get(hand.size()-4).length() - 1);
            String rank_2 = hand.get(hand.size()-3).substring(0, hand.get(hand.size()-3).length() - 1);

            if(suit_1.equals(suit_4) && rank_1.equals(rank_2)){
                cnt = 0;
                int numRemoveCards[] = {0, 2};
                int numDrawCards = 3;

                Command drawCard = new DrawCard(deck, hand, numDrawCards);
                Command removeCardHand = new RemoveCard(hand, numRemoveCards, true);

                cardoperation.setCommand(removeCardHand);
                hand = cardoperation.cardEvent();

                cardoperation.setCommand(drawCard);
                hand = cardoperation.cardEvent();

                return hand;

            }
            else{
                System.out.println("Take valid move.");
                return hand;
            }
        }
        else if(nextMove==9){
            StrategyController strategy = new StrategyController(new IntermediateRule());
            hand = strategy.executeStrategy(deck, hand, nextMove);
            return hand;
        }
        else{
            System.out.println("Take valid move.");
            return hand;
        }
    }
}
