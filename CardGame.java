//import javax.swing.*;
//import java.awt.*;
//import java.util.ArrayList;
//import java.util.Collections;
//
//public class CardGame extends JFrame {
//    private JPanel cardPanel;
//    private JButton dealButton;
//    private JLabel statusLabel;
//    private ArrayList<Cards> deck;
//
//    public CardGame() {
//        super("Card Game");
//
//        // Initialize the deck of cards
//        deck = new ArrayList<Cards>();
//        for (int suit = 0; suit < 4; suit++) {
//            for (int rank = 1; rank <= 13; rank++) {
//                deck.add(new Cards(suit, rank));
//            }
//        }
//        Collections.shuffle(deck);
//
//        // Create the GUI components
//        cardPanel = new JPanel();
//        dealButton = new JButton("Deal");
//        statusLabel = new JLabel("Click \"Deal\" to start a new game");
//
//        // Set the layout of the main window
//        setLayout(new BorderLayout());
//        add(cardPanel, BorderLayout.CENTER);
//        add(dealButton, BorderLayout.SOUTH);
//        add(statusLabel, BorderLayout.NORTH);
//
//        // Add the event listener to the deal button
//        dealButton.addActionListener(e -> {
//            // Deal a card and update the status label
//            Cards card = deck.remove(0);
//            cardPanel.add(new JLabel(card.getImage()));
//            statusLabel.setText("You drew a " + card.getRankName() + " of " + card.getSuitName() + "s");
//            pack();
//        });
//
//        // Set some default settings for the main window
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        setSize(800, 600);
//        setLocationRelativeTo(null);
//        setVisible(true);
//    }
//
//    public static void main(String[] args) {
//        new CardGame();
//    }
//}
//
//class Cards {
//    private int suit;
//    private int rank;
//
//    public Cards(int suit, int rank) {
//        this.suit = suit;
//        this.rank = rank;
//    }
//
//    public String getSuitName() {
//        String[] suitNames = {"s", "h", "d", "c"};
//        return suitNames[suit];
//    }
//
//    public String getRankName() {
//        String[] rankNames = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
////        String[] rankNames = {"Ace", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King"};
//        return rankNames[rank - 1];
//    }
//
//    public ImageIcon getImage() {
//        String name;
//        switch(rank){
//            case 14:
//                name= String.valueOf('A');
//                break;
//
//            case 13:
//                name= String.valueOf('K');
//                break;
//
//            case 12:
//                name= String.valueOf('Q');
//                break;
//
//            case 11:
//                name=String.valueOf('J');;
//                break;
//
//            default:
//                name=String.valueOf(rank);
//                break;
//        }
//        String[] suitNames = {"s", "h", "d", "c"};
//        String filename = name + suitNames[suit] + ".gif";
//        System.out.println(filename);
//        return new ImageIcon(getClass().getResource("cards/" + filename));
//    }
//}
