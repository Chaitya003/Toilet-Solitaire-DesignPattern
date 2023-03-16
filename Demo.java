import java.util.ArrayList;
import java.util.Scanner;

public class Demo {
    public static void main(String[] args){
//        ArrayList<String> deck;
//        public static ArrayList<String> hand;
        GameRules rules = GameRules.getObject();
//        GameRules new_card = GameRules.getObject();
        rules.displayGameRules();
        System.out.println();
        Scanner sc= new Scanner(System.in);
        int gameRule = sc.nextInt();

        Deck deck = Deck.getObject();
        ArrayList<String> cardDeck = new ArrayList<>();
        ArrayList<String> hand = new ArrayList<>();
        cardDeck = deck.createDeck();
        cardDeck = deck.shuffleDeck(cardDeck);
        deck.printDeck(cardDeck);

        if(gameRule==1){
            rules.displayBasicMoves();
            int nextMove = sc.nextInt();

            StrategyController strategy = new StrategyController(new BasicRule());
            strategy.executeStrategy(cardDeck, hand, nextMove);
        }

//        card.displayBasicMoves();
//        System.out.println();
//        card.displayIntermediateMoves();
//        System.out.println();
//        card.displayHouseMoves();
//        System.out.println();

    }
}
