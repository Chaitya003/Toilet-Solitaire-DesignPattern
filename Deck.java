import java.util.ArrayList;
import java.util.Vector;

import static java.lang.Math.floor;
import java.util.Collections;


public class Deck {
    private static Deck object;
    int suit, value;
    public static ArrayList<String> deck = new ArrayList<>();

    public static Deck getObject(){
        if(object==null){
            object = new Deck();
        }

        return object;
    }
    public ArrayList<String> createDeck(){
        for(int i=0; i<52; i++){
            suit = (int) floor(i/13);
            value = i%13+2;
            Card cardObject = new Card(value, suit);
            deck.add(cardObject.name());
        }

        return deck;
    }

    public void printDeck(ArrayList<String> deck){
        // int cnt=0;
        for(int i=0; i<deck.size(); i++){
            System.out.print(deck.get(i));
            System.out.print(",");

        }
    }

    public ArrayList<String> shuffleDeck(ArrayList<String> deck){
        Collections.shuffle(deck);
        return deck;
    }

}
