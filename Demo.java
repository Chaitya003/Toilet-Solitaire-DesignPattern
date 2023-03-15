import java.util.ArrayList;

public class Demo {
    public static void main(String[] args){
        GameRules card = GameRules.getObject();
        GameRules new_card = GameRules.getObject();
        card.displayGameRules();
        System.out.println();
        card.displayBasicMoves();
        System.out.println();
        card.displayIntermediateMoves();
        System.out.println();
        card.displayHouseMoves();
        System.out.println();

        Deck deck = Deck.getObject();
        ArrayList<String> c = new ArrayList<>();
        c = deck.createDeck();
        c = deck.shuffleDeck(c);
        deck.printDeck(c);
    }
}
