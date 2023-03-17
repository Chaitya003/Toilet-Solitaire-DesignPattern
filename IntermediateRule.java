/* Implementation of Strategy Pattern */

import java.util.ArrayList;
import java.util.Scanner;

public class IntermediateRule implements GameStrategy {

    int cnt;

    @Override
    public ArrayList<String> checkRule(ArrayList<String> deck, ArrayList<String> hand, int nextMove) {
        CardOperation cardoperation = new CardOperation();
        Scanner sc = new Scanner(System.in);
        if (deck.isEmpty()) {
            cnt += 1;
        }
        if (nextMove == 1) {
            StrategyController strategy = new StrategyController(new BasicRule());
            hand = strategy.executeStrategy(deck, hand, nextMove);
            return hand;
        } else if (nextMove == 2) {
            StrategyController strategy = new StrategyController(new BasicRule());
            hand = strategy.executeStrategy(deck, hand, nextMove);
            return hand;
        } else if (nextMove == 3) {
            int pairCards[] = {0, 0};
            boolean flag = false;
            for (int i = hand.size() - 4; i < hand.size() - 1; i++) {
                String rank_1 = hand.get(i).substring(0, hand.get(i).length() - 1);
                String rank_2 = hand.get(i + 1).substring(0, hand.get(i + 1).length() - 1);
                if (rank_1.equals(rank_2)){
                    System.out.println(rank_1+rank_2);
                    System.out.println(i);
                    System.out.println(hand.size());
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
                Command drawCard = new DrawCard(deck, hand, numDrawCards);
                Command removeCardHand = new RemoveCard(hand, pairCards, true);

                cardoperation.setCommand(removeCardHand);
                hand = cardoperation.cardEvent();

                cardoperation.setCommand(drawCard);
                hand = cardoperation.cardEvent();

            } else {
                System.out.println("Take valid move.");
            }
            return hand;
        } else if (nextMove == 9) {
            StrategyController strategy = new StrategyController(new BasicRule());
            hand = strategy.executeStrategy(deck, hand, nextMove);
            return hand;
        }
        return hand;
    }
}
