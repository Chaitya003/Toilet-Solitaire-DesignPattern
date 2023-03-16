import java.util.ArrayList;

public class ResultObserver extends Observer {
//    ArrayList<String> deck, hand;
//    int cnt;
//    ResultObserver(ArrayList<String> deck, ArrayList<String> hand, int cnt){
//        this.deck = deck;
//        this.hand = hand;
//        this.cnt = cnt;
//    }

    @Override
    public boolean update(ArrayList<String> deck, ArrayList<String> hand, int cnt) {
        int score = deck.size() + hand.size();
//        System.out.println();
        System.out.print("\nYour Current Score is: ");
        System.out.print(score);

        if(deck.isEmpty() && hand.size()==cnt){
            if(score==0){
                System.out.println("\nSuper Win.....");
                System.out.println("Your final Score is ");
                System.out.print(score);
            }
            else if(score<5){
                System.out.println("\nCongratulations You Won...");
                System.out.println("Your final Score is ");
                System.out.print(score);
            }
            else if(score>=5){
                System.out.println("\nSorry You Lost Better luck next time.");
                System.out.println("Your final Score is ");
                System.out.print(score);
            }
            return false;
        }
        else{
            return true;
        }
    }
}
