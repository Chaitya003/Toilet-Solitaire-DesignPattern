import java.util.ArrayList;
import java.util.Scanner;

public class Game {
    public static void main(String[] args){
        while(true) {
            GameRules rules = GameRules.getObject();
            rules.displayGameRules();
            System.out.println();
            Scanner sc = new Scanner(System.in);
            int gameRule = sc.nextInt();

            Deck deck = Deck.getObject();
            ArrayList<String> cardDeck = new ArrayList<>();
            ArrayList<String> hand = new ArrayList<>();
            cardDeck = deck.createDeck();
            cardDeck = deck.shuffleDeck(cardDeck);
//            deck.printDeck(cardDeck);

            CardOperation cardoperation = new CardOperation();
            Command handCommand = new Hand(cardDeck, hand);
            cardoperation.setCommand(handCommand);
            hand = cardoperation.cardEvent();

            int numRemoveCardsDeck[] = {0, 3};
            Command removeCardDeck = new RemoveCard(cardDeck, numRemoveCardsDeck, false);
            cardoperation.setCommand(removeCardDeck);
            cardDeck = cardoperation.cardEvent();
            System.out.println();
//            deck.printDeck(cardDeck);
//            System.out.println(cardDeck.size());

            Hand handOperation = new Hand(cardDeck, hand);
            System.out.print("\nYour Hand: ");
            handOperation.printHand(hand);

            if (gameRule == 1) {
                System.out.println();
                rules.displayBasicMoves();
                int nextMove = sc.nextInt();
                StrategyController strategy = new StrategyController(new BasicRule());
                strategy.executeStrategy(cardDeck, hand, nextMove);
            } else if (gameRule == 2) {
                System.out.println();
                rules.displayIntermediateMoves();
                int nextMove = sc.nextInt();
                StrategyController strategy = new StrategyController(new IntermediateRule());
                strategy.executeStrategy(cardDeck, hand, nextMove);
            } else if (gameRule == 3) {
                System.out.println();
                rules.displayHouseMoves();
                int nextMove = sc.nextInt();
                StrategyController strategy = new StrategyController(new HouseRule());
                strategy.executeStrategy(cardDeck, hand, nextMove);
            } else {
                System.out.println("Select Valid Rules");
            }
        }
    }
}
