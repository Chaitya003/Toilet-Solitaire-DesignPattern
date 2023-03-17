/* Use of Facade Pattern */

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;

public class SolitaireGUI extends JFrame {
    private JPanel mainPanel, cardPanel, basicPanel, intermediatePanel, housePanel;
    private JButton basicRule, intermediateRule, houseRule, Remove2Cards, Remove4Cards, drawCard, RemovePairCards, RemoveFirst3, RemoveLast3;
    private JLabel statusLabel;
    private ArrayList<Cards> deck;
    private ArrayList<String> cardDeck;
    private int cnt=0, gameRule=0;

    public SolitaireGUI(ArrayList<String> cardDeck) {
        super("Card Game");
        this.cardDeck = cardDeck;

        // Initialize the deck of cards
        ArrayList<String> hand = new ArrayList<>();

        CardOperation cardoperation = new CardOperation();
        Command handCommand = new Hand(cardDeck, hand);
        cardoperation.setCommand(handCommand);
        hand = cardoperation.cardEvent();

        int numRemoveCardsDeck[] = {0, 3};
        Command removeCardDeck = new RemoveCard(cardDeck, numRemoveCardsDeck, false);
        cardoperation.setCommand(removeCardDeck);
        this.cardDeck = cardoperation.cardEvent();

        // Create the GUI components
        mainPanel = new JPanel();
        cardPanel = new JPanel();
        basicPanel = new JPanel();
        basicRule = new JButton("Basic Rule");
        intermediateRule = new JButton("Intermediate Rule");
        houseRule = new JButton("House Rule");
        statusLabel = new JLabel("Click \"Any Rule\" to start a new game");
        Remove2Cards = new JButton("Remove Middle 2 Cards");
        Remove4Cards = new JButton("Remove All Four Cards");
        RemovePairCards = new JButton("Remove Pair of Cards");
        RemoveFirst3 = new JButton("Remove First 3 Cards");
        RemoveLast3 = new JButton("Remove Last 3 Cards");
        drawCard = new JButton("Draw A New Card");

        cardPanel.add(basicRule);
        cardPanel.add(intermediateRule);
        cardPanel.add(houseRule);

        setLayout(new BorderLayout());
        add(cardPanel, BorderLayout.CENTER);
        add(statusLabel, BorderLayout.NORTH);

        // Add the event listener to the deal button
        ArrayList<String> finalHand = hand;

        basicRule.addActionListener(e -> {
            gameRule = 1;
            // Deal a card and update the status label
            Cards card = new Cards();
            for(int i = 0; i< finalHand.size(); i++){
                cardPanel.add(new JLabel(card.getImage(finalHand.get(i))));
            }

            basicPanel.add(Remove2Cards);
            basicPanel.add(Remove4Cards);
            basicPanel.add(drawCard);

            cardPanel.add(basicPanel);
            setLayout(new BorderLayout());
            add(cardPanel, BorderLayout.SOUTH);
            basicRule.getParent().remove(basicRule);
            intermediateRule.getParent().remove(intermediateRule);
            houseRule.getParent().remove(houseRule);

            pack();
        });


        intermediateRule.addActionListener(e -> {
            gameRule = 2;
            // Deal a card and update the status label
            Cards card = new Cards();
            for(int i = 0; i< finalHand.size(); i++){
                cardPanel.add(new JLabel(card.getImage(finalHand.get(i))));
            }

            intermediatePanel = new JPanel();

            intermediatePanel.add(Remove2Cards);
            intermediatePanel.add(Remove4Cards);
            intermediatePanel.add(RemovePairCards);
            intermediatePanel.add(drawCard);

            cardPanel.add(intermediatePanel);
            setLayout(new BorderLayout());
            add(cardPanel, BorderLayout.SOUTH);
            basicRule.getParent().remove(basicRule);
            intermediateRule.getParent().remove(intermediateRule);
            houseRule.getParent().remove(houseRule);

            pack();
        });

        houseRule.addActionListener(e -> {
            gameRule = 3;
            // Deal a card and update the status label
            Cards card = new Cards();
            for(int i = 0; i< finalHand.size(); i++){
                cardPanel.add(new JLabel(card.getImage(finalHand.get(i))));
            }

            housePanel = new JPanel();
            Remove2Cards = new JButton("Remove Middle 2 Cards");
            Remove4Cards = new JButton("Remove All Four Cards");
            RemovePairCards = new JButton("Remove Pair of Cards");
            RemoveFirst3 = new JButton("Remove First 3 Cards");
            RemoveLast3 = new JButton("Remove Last 3 Cards");
            drawCard = new JButton("Draw A New Card");

            housePanel.add(Remove2Cards);
            housePanel.add(Remove4Cards);
            housePanel.add(RemovePairCards);
            housePanel.add(RemoveFirst3);
            housePanel.add(RemoveLast3);
            housePanel.add(drawCard);

            cardPanel.add(housePanel);
            setLayout(new BorderLayout());
            add(cardPanel, BorderLayout.SOUTH);
            basicRule.getParent().remove(basicRule);
            intermediateRule.getParent().remove(intermediateRule);
            houseRule.getParent().remove(houseRule);

            pack();
        });

        /* Operations of Card Draw and Removal */

        ArrayList<String> finalHand1 = hand;
        Remove2Cards.addActionListener(e -> {
            int nextMove = 1;
            if(this.cardDeck.isEmpty()){
                cnt+=1;
            }
            StrategyController strategy = new StrategyController(new BasicRule());
            ArrayList<String> new_hand = strategy.executeStrategy(this.cardDeck, finalHand1, nextMove);

            int numRemoveCardsDeckRule[] = {0, 1};
            Command removeCardDeckRule = new RemoveCard(this.cardDeck, numRemoveCardsDeckRule, false);
            cardoperation.setCommand(removeCardDeckRule);
            this.cardDeck = cardoperation.cardEvent();
            cardPanel.getParent().remove(cardPanel);
            for(int i=0; i<4; i++){
                cardPanel.remove(0);
            }
            // Deal a card and update the status label
            Cards card = new Cards();
            for(int i = new_hand.size()-4; i< new_hand.size(); i++){
                cardPanel.add(new JLabel(card.getImage(new_hand.get(i))));
            }

            CheckWin checkWin = new CheckWin();
            ResultObserver resultObserver = new ResultObserver();
            checkWin.attach(resultObserver);
            checkWin.setState(this.cardDeck, new_hand, cnt);
            boolean flag = checkWin.getState();
            if (!flag) {
                System.exit(0);
            }

            basicPanel.add(Remove2Cards);
            basicPanel.add(Remove4Cards);
            basicPanel.add(drawCard);


            cardPanel.add(basicPanel);

            setLayout(new BorderLayout());
            add(cardPanel, BorderLayout.SOUTH);
            pack();
        });

        Remove4Cards.addActionListener(e -> {
            int nextMove = 2;
            if(this.cardDeck.isEmpty()){
                cnt+=1;
            }
            StrategyController strategy = new StrategyController(new BasicRule());
            ArrayList<String> new_hand = strategy.executeStrategy(this.cardDeck, finalHand1, nextMove);
            // Deal a card and update the status label
            int numRemoveCardsDeckRule[] = {0, 3};
            Command removeCardDeckRule = new RemoveCard(this.cardDeck, numRemoveCardsDeckRule, false);
            cardoperation.setCommand(removeCardDeckRule);
            this.cardDeck = cardoperation.cardEvent();

            cardPanel.getParent().remove(cardPanel);
            for(int i=0; i<4; i++){
                cardPanel.remove(0);
            }
            Cards card = new Cards();
            for(int i = new_hand.size()-4; i< new_hand.size(); i++){
                cardPanel.add(new JLabel(card.getImage(new_hand.get(i))));
            }
            CheckWin checkWin = new CheckWin();
            ResultObserver resultObserver = new ResultObserver();
            checkWin.attach(resultObserver);
            checkWin.setState(this.cardDeck, new_hand, cnt);
            boolean flag = checkWin.getState();
            if (!flag) {
                System.exit(0);
            }

            basicPanel.add(Remove2Cards);
            basicPanel.add(Remove4Cards);
            basicPanel.add(drawCard);

            cardPanel.add(basicPanel);
            setLayout(new BorderLayout());
            add(cardPanel, BorderLayout.SOUTH);
            pack();
        });

        drawCard.addActionListener(e -> {
            int nextMove = 9;
            ArrayList<String> new_hand = new ArrayList<String>();
            if(this.cardDeck.isEmpty()){
                cnt+=1;
            }
            if(gameRule==1) {
                StrategyController strategy = new StrategyController(new BasicRule());
                new_hand = strategy.executeStrategy(this.cardDeck, finalHand1, nextMove);
                basicPanel.add(Remove2Cards);
                basicPanel.add(Remove4Cards);
                basicPanel.add(drawCard);

                cardPanel.add(basicPanel);
            } else if (gameRule==2) {
                StrategyController strategy = new StrategyController(new IntermediateRule());
                new_hand = strategy.executeStrategy(this.cardDeck, finalHand1, nextMove);
                intermediatePanel.add(Remove2Cards);
                intermediatePanel.add(Remove4Cards);
                intermediatePanel.add(RemovePairCards);
                intermediatePanel.add(drawCard);


                cardPanel.add(intermediatePanel);
            }
            else{
                StrategyController strategy = new StrategyController(new HouseRule());
                new_hand = strategy.executeStrategy(this.cardDeck, finalHand1, nextMove);
                housePanel.add(Remove2Cards);
                housePanel.add(Remove4Cards);
                housePanel.add(RemovePairCards);
                housePanel.add(RemoveLast3);
                housePanel.add(RemoveFirst3);
                housePanel.add(drawCard);


                cardPanel.add(housePanel);
            }
            int numRemoveCardsDeckRule[] = {0, 0};
            Command removeCardDeckRule = new RemoveCard(this.cardDeck, numRemoveCardsDeckRule, false);
            cardoperation.setCommand(removeCardDeckRule);
            this.cardDeck = cardoperation.cardEvent();

            cardPanel.getParent().remove(cardPanel);

            for(int i=0; i<4; i++){
                cardPanel.remove(0);
            }

            Cards card = new Cards();
            for(int i = new_hand.size()-4; i< new_hand.size(); i++){
                System.out.println(i);
                cardPanel.add(new JLabel(card.getImage(new_hand.get(i))));
            }

            CheckWin checkWin = new CheckWin();
            ResultObserver resultObserver = new ResultObserver();
            checkWin.attach(resultObserver);
            checkWin.setState(this.cardDeck, new_hand, cnt);
            boolean flag = checkWin.getState();
            if (!flag) {
                System.exit(0);
            }

            add(cardPanel, BorderLayout.SOUTH);
            pack();
        });

        RemovePairCards.addActionListener(e -> {
            int nextMove = 3;
            if(this.cardDeck.isEmpty()){
                cnt+=1;
            }
            StrategyController strategy = new StrategyController(new IntermediateRule());
            ArrayList<String> new_hand = strategy.executeStrategy(this.cardDeck, finalHand1, nextMove);

            int numRemoveCardsDeckRule[] = {0, 1};
            Command removeCardDeckRule = new RemoveCard(this.cardDeck, numRemoveCardsDeckRule, false);
            cardoperation.setCommand(removeCardDeckRule);
            this.cardDeck = cardoperation.cardEvent();
            cardPanel.getParent().remove(cardPanel);
            for(int i=0; i<4; i++){
                cardPanel.remove(0);
            }
            // Deal a card and update the status label
            Cards card = new Cards();
            for(int i = new_hand.size()-4; i< new_hand.size(); i++){
                cardPanel.add(new JLabel(card.getImage(new_hand.get(i))));
            }

            CheckWin checkWin = new CheckWin();
            ResultObserver resultObserver = new ResultObserver();
            checkWin.attach(resultObserver);
            checkWin.setState(this.cardDeck, new_hand, cnt);
            boolean flag = checkWin.getState();
            if (!flag) {
                System.exit(0);
            }

            intermediatePanel.add(Remove2Cards);
            intermediatePanel.add(Remove4Cards);
            intermediatePanel.add(RemovePairCards);
            intermediatePanel.add(drawCard);


            cardPanel.add(intermediatePanel);
            setLayout(new BorderLayout());
            add(cardPanel, BorderLayout.SOUTH);
            pack();
        });

        RemoveLast3.addActionListener(e -> {
            int nextMove = 4;
            if(this.cardDeck.isEmpty()){
                cnt+=1;
            }
            StrategyController strategy = new StrategyController(new HouseRule());
            ArrayList<String> new_hand = strategy.executeStrategy(this.cardDeck, finalHand1, nextMove);

            int numRemoveCardsDeckRule[] = {0, 2};
            Command removeCardDeckRule = new RemoveCard(this.cardDeck, numRemoveCardsDeckRule, false);
            cardoperation.setCommand(removeCardDeckRule);
            this.cardDeck = cardoperation.cardEvent();
            cardPanel.getParent().remove(cardPanel);
            for(int i=0; i<4; i++){
                cardPanel.remove(0);
            }
            // Deal a card and update the status label
            Cards card = new Cards();
            for(int i = new_hand.size()-4; i< new_hand.size(); i++){
                cardPanel.add(new JLabel(card.getImage(new_hand.get(i))));
            }

            CheckWin checkWin = new CheckWin();
            ResultObserver resultObserver = new ResultObserver();
            checkWin.attach(resultObserver);
            checkWin.setState(this.cardDeck, new_hand, cnt);
            boolean flag = checkWin.getState();
            if (!flag) {
                System.exit(0);
            }

            housePanel.add(Remove2Cards);
            housePanel.add(Remove4Cards);
            housePanel.add(RemovePairCards);
            housePanel.add(RemoveLast3);
            housePanel.add(RemoveFirst3);
            housePanel.add(drawCard);


            cardPanel.add(housePanel);
            setLayout(new BorderLayout());
            add(cardPanel, BorderLayout.SOUTH);
            pack();
        });

        RemoveFirst3.addActionListener(e -> {
            int nextMove = 5;
            if(this.cardDeck.isEmpty()){
                cnt+=1;
            }
            StrategyController strategy = new StrategyController(new HouseRule());
            ArrayList<String> new_hand = strategy.executeStrategy(this.cardDeck, finalHand1, nextMove);

            int numRemoveCardsDeckRule[] = {0, 2};
            Command removeCardDeckRule = new RemoveCard(this.cardDeck, numRemoveCardsDeckRule, false);
            cardoperation.setCommand(removeCardDeckRule);
            this.cardDeck = cardoperation.cardEvent();
            cardPanel.getParent().remove(cardPanel);
            for(int i=0; i<4; i++){
                cardPanel.remove(0);
            }
            // Deal a card and update the status label
            Cards card = new Cards();
            for(int i = new_hand.size()-4; i< new_hand.size(); i++){
                cardPanel.add(new JLabel(card.getImage(new_hand.get(i))));
            }

            CheckWin checkWin = new CheckWin();
            ResultObserver resultObserver = new ResultObserver();
            checkWin.attach(resultObserver);
            checkWin.setState(this.cardDeck, new_hand, cnt);
            boolean flag = checkWin.getState();
            if (!flag) {
                System.exit(0);
            }

            housePanel.add(Remove2Cards);
            housePanel.add(Remove4Cards);
            housePanel.add(RemovePairCards);
            housePanel.add(RemoveLast3);
            housePanel.add(RemoveFirst3);
            housePanel.add(drawCard);


            cardPanel.add(housePanel);
            setLayout(new BorderLayout());
            add(cardPanel, BorderLayout.SOUTH);
            pack();
        });




        // Set some default settings for the main window
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        Deck deck = Deck.getObject();
        ArrayList<String> cardDeck = new ArrayList<>();
        ArrayList<String> hand = new ArrayList<>();
//        ArrayList<String> new_hand = new ArrayList<>();
        cardDeck = deck.createDeck();
        cardDeck = deck.shuffleDeck(cardDeck);

        new SolitaireGUI(cardDeck);
    }
}

class Cards {
    private int suit;
    private int rank;
    public ImageIcon getImage(String cardName) {
        String filename = cardName + ".gif";
        System.out.println(filename);
        return new ImageIcon(getClass().getResource("cards/" + filename));
    }
}
