import java.util.ArrayList;
import java.util.Scanner;

public class HouseRule implements GameStrategy{
    int cnt;
    @Override
    public void checkRule(ArrayList<String> deck, ArrayList<String> hand, int nextMove) {
        CardOperation cardoperation = new CardOperation();
        Scanner sc= new Scanner(System.in);
        if(deck.isEmpty()){
            cnt+=1;
        }
        if (nextMove == 1) {
            String suit_1 = hand.get(hand.size() - 4).substring(hand.get(hand.size() - 4).length() - 1);
            String suit_4 = hand.get(hand.size() - 1).substring(hand.get(hand.size() - 1).length() - 1);
//            String suit_4 = hand[hand.size()-1]->name()[hand[hand.size()-1]->name().size()-1];
            if (suit_1.equals(suit_4)) {
//                System.out.println(suit_1 + suit_4);
                cnt = 0;
                int numRemoveCards[] = {1, 2};
                int numRemoveCardsDeck[] = {0, 1};
                int numDrawCards = 2;

                Command drawCard = new DrawCard(deck, hand, numDrawCards);
                Command removeCardDeck = new RemoveCard(deck, numRemoveCardsDeck, false);
                Command removeCardHand = new RemoveCard(hand, numRemoveCards, true);

                cardoperation.setCommand(removeCardHand);
                hand = cardoperation.cardEvent();

                cardoperation.setCommand(drawCard);
                hand = cardoperation.cardEvent();
//                hand = removeCards(hand, waste, numRemoveCards, true);

//                hand = drawCards(deck, hand, numDrawCards);
                if (!deck.isEmpty()) {
//                    deck = removeCards(deck, waste, numRemoveCardsDeck);
                    cardoperation.setCommand(removeCardDeck);
                    deck = cardoperation.cardEvent();
                }
                Hand handCommand = new Hand(deck, hand);
                System.out.print("\nYour Hand: ");
                handCommand.printHand(hand);

                CheckWin checkWin = new CheckWin();
                ResultObserver resultObserver= new ResultObserver();
                checkWin.attach(resultObserver);
                checkWin.setState(deck, hand, cnt);
                boolean flag = checkWin.getState();
                if (flag) {
                    GameRules rules = GameRules.getObject();
                    System.out.println();
                    rules.displayHouseMoves();
                    int nextNextMove = sc.nextInt();
                    checkRule(deck, hand, nextNextMove);
//                displayMoves(gameRule, deck, hand);
                }
            }
            else{
                System.out.println("Take valid move.");
                GameRules rules = GameRules.getObject();
                System.out.println();
                rules.displayHouseMoves();
                int nextNextMove = sc.nextInt();
                checkRule(deck, hand, nextNextMove);
//            displayMoves(gameRule, deck, hand);
            }
        } else if (nextMove == 2) {
            String rank_1 = hand.get(hand.size() - 4).substring(0, hand.get(hand.size() - 4).length() - 1);
            String rank_4 = hand.get(hand.size() - 1).substring(0, hand.get(hand.size() - 1).length() - 1);
            if (rank_1.equals(rank_4)) {
                System.out.println(rank_1 + rank_4);
                cnt = 0;
                int numRemoveCards[] = {0, 3};  //{0, 1, 2, 3};
                int numDrawCards = 4;
                int numRemoveCardsDeck[] = {0, 3};

                Command drawCard = new DrawCard(deck, hand, numDrawCards);
                Command removeCardDeck = new RemoveCard(deck, numRemoveCardsDeck, false);
                Command removeCardHand = new RemoveCard(hand, numRemoveCards, true);

                cardoperation.setCommand(removeCardHand);
                hand = cardoperation.cardEvent();

                cardoperation.setCommand(drawCard);
                hand = cardoperation.cardEvent();
//                hand = removeCards(hand, waste, numRemoveCards, true);

//                hand = drawCards(deck, hand, numDrawCards);
                if (!deck.isEmpty()) {
//                    deck = removeCards(deck, waste, numRemoveCardsDeck);
                    cardoperation.setCommand(removeCardDeck);
                    deck = cardoperation.cardEvent();
                }
                Hand handCommand = new Hand(deck, hand);
                System.out.print("\nYour Hand: ");
                handCommand.printHand(hand);

                CheckWin checkWin = new CheckWin();
                ResultObserver resultObserver= new ResultObserver();
                checkWin.attach(resultObserver);
                checkWin.setState(deck, hand, cnt);
                boolean flag = checkWin.getState();
                if (flag) {
                    GameRules rules = GameRules.getObject();
                    System.out.println();
                    rules.displayHouseMoves();
                    int nextNextMove = sc.nextInt();
                    checkRule(deck, hand, nextNextMove);
                }
            }
            else{
                System.out.println("Take valid move.");
                GameRules rules = GameRules.getObject();
                System.out.println();
                rules.displayHouseMoves();
                int nextNextMove = sc.nextInt();
                checkRule(deck, hand, nextNextMove);
//            displayMoves(gameRule, deck, hand);
            }
        }
        else if (nextMove == 3) {
            int pairCards[] = {0, 0};
            boolean flag = false;
            for (int i = hand.size() - 4; i < hand.size() - 1; i++) {
                if (hand.get(i).substring(0, hand.get(i).length() - 1).equals(hand.get(i + 1).substring(0, hand.get(i + 1).length() - 1))) {
                    flag = true;
                    pairCards[0] = i - (hand.size() - 4);
                    pairCards[1] = (i - (hand.size() - 4)) + 1;
                    break;
                }
            }

            if (flag) {
                cnt = 0;
                int numDrawCards = 2;
                int numRemoveCardsDeck[] = {0, 1};

                Command drawCard = new DrawCard(deck, hand, numDrawCards);
                Command removeCardDeck = new RemoveCard(deck, numRemoveCardsDeck, false);
                Command removeCardHand = new RemoveCard(hand, pairCards, true);

                cardoperation.setCommand(removeCardHand);
                hand = cardoperation.cardEvent();

                cardoperation.setCommand(drawCard);
                hand = cardoperation.cardEvent();

                if (!deck.isEmpty()) {
                    cardoperation.setCommand(removeCardDeck);
                    deck = cardoperation.cardEvent();
//                    deck = removeCards(deck, waste, numRemoveCardsDeck);
                }
                Hand handCommand = new Hand(deck, hand);
                System.out.print("\nYour Hand: ");
                handCommand.printHand(hand);

                CheckWin checkWin = new CheckWin();
                ResultObserver resultObserver= new ResultObserver();
                checkWin.attach(resultObserver);
                checkWin.setState(deck, hand, cnt);
                flag = checkWin.getState();
                if (flag) {
                    GameRules rules = GameRules.getObject();
                    System.out.println();
                    rules.displayHouseMoves();
                    int nextNextMove = sc.nextInt();
                    checkRule(deck, hand, nextNextMove);
                }
            }
            else {
                System.out.println("Take valid move.");
                GameRules rules = GameRules.getObject();
                System.out.println();
                rules.displayHouseMoves();
                int nextNextMove = sc.nextInt();
                checkRule(deck, hand, nextNextMove);
//            displayMoves(gameRule, deck, hand);
            }
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
                Command removeCardDeck = new RemoveCard(deck, numRemoveCardsDeck, false);
                Command removeCardHand = new RemoveCard(hand, numRemoveCards, true);

                cardoperation.setCommand(removeCardHand);
                hand = cardoperation.cardEvent();

                cardoperation.setCommand(drawCard);
                hand = cardoperation.cardEvent();

                if(!deck.isEmpty()){
                    cardoperation.setCommand(removeCardDeck);
                    deck = cardoperation.cardEvent();
                }
                Hand handCommand = new Hand(deck, hand);
                System.out.print("\nYour Hand: ");
                handCommand.printHand(hand);

                CheckWin checkWin = new CheckWin();
                ResultObserver resultObserver= new ResultObserver();
                checkWin.attach(resultObserver);
                checkWin.setState(deck, hand, cnt);
                boolean flag = checkWin.getState();
                if (flag) {
                    GameRules rules = GameRules.getObject();
                    System.out.println();
                    rules.displayHouseMoves();
                    int nextNextMove = sc.nextInt();
                    checkRule(deck, hand, nextNextMove);
                }
            }
            else{
                System.out.println("Take valid move.");
                GameRules rules = GameRules.getObject();
                System.out.println();
                rules.displayHouseMoves();
                int nextNextMove = sc.nextInt();
                checkRule(deck, hand, nextNextMove);
            }
        } else if(nextMove==5){
            String suit_1 = hand.get(hand.size()-4).substring(hand.get(hand.size()-4).length()-1);
            String suit_4 = hand.get(hand.size()-1).substring(hand.get(hand.size()-1).length()-1);

            String rank_1 = hand.get(hand.size()-4).substring(0, hand.get(hand.size()-4).length() - 1);
            String rank_2 = hand.get(hand.size()-3).substring(0, hand.get(hand.size()-3).length() - 1);

            if(suit_1.equals(suit_4) && rank_1.equals(rank_2)){
                cnt = 0;
                int numRemoveCards[] = {0, 2};
                int numRemoveCardsDeck[] = {0, 2};
                int numDrawCards = 3;

                Command drawCard = new DrawCard(deck, hand, numDrawCards);
                Command removeCardDeck = new RemoveCard(deck, numRemoveCardsDeck, false);
                Command removeCardHand = new RemoveCard(hand, numRemoveCards, true);

                cardoperation.setCommand(removeCardHand);
                hand = cardoperation.cardEvent();

                cardoperation.setCommand(drawCard);
                hand = cardoperation.cardEvent();

                if(!deck.isEmpty()){
                    cardoperation.setCommand(removeCardDeck);
                    deck = cardoperation.cardEvent();
                }
                Hand handCommand = new Hand(deck, hand);
                System.out.print("\nYour Hand: ");
                handCommand.printHand(hand);

                CheckWin checkWin = new CheckWin();
                ResultObserver resultObserver= new ResultObserver();
                checkWin.attach(resultObserver);
                checkWin.setState(deck, hand, cnt);
                boolean flag = checkWin.getState();
                if (flag) {
                    GameRules rules = GameRules.getObject();
                    System.out.println();
                    rules.displayHouseMoves();
                    int nextNextMove = sc.nextInt();
                    checkRule(deck, hand, nextNextMove);
                }
            }
            else{
                System.out.println("Take valid move.");
                GameRules rules = GameRules.getObject();
                System.out.println();
                rules.displayHouseMoves();
                int nextNextMove = sc.nextInt();
                checkRule(deck, hand, nextNextMove);
            }
        }
        else if(nextMove==9){
            int numDrawCards = 1;
            int numRemoveCardsDeck[] = {0, 0};

            Command drawCard = new DrawCard(deck, hand, numDrawCards);
            Command removeCardDeck = new RemoveCard(deck, numRemoveCardsDeck, false);
//            Command removeCardHand = new RemoveCard(hand, numRemoveCards, true);

            cardoperation.setCommand(drawCard);
            hand = cardoperation.cardEvent();
            if(!deck.isEmpty()){
                cardoperation.setCommand(removeCardDeck);
                deck = cardoperation.cardEvent();
            }
            Hand handCommand = new Hand(deck, hand);
            System.out.print("\nYour Hand: ");
            handCommand.printHand(hand);

            CheckWin checkWin = new CheckWin();
            ResultObserver resultObserver= new ResultObserver();
            checkWin.attach(resultObserver);
            checkWin.setState(deck, hand, cnt);
            boolean flag = checkWin.getState();
            if (flag) {
                GameRules rules = GameRules.getObject();
                System.out.println();
                rules.displayHouseMoves();
                int nextNextMove = sc.nextInt();
                checkRule(deck, hand, nextNextMove);
            }
        }
        else{
            System.out.println("Take valid move.");
            GameRules rules = GameRules.getObject();
            System.out.println();
            rules.displayHouseMoves();
            int nextNextMove = sc.nextInt();
            checkRule(deck, hand, nextNextMove);
        }

    }
}
