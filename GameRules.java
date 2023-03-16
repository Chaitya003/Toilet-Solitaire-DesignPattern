/* Singleton Pattern Class Implementation */


public class GameRules {
//    public static int gameRule;
    private static GameRules object;

    private GameRules(){
//        this.gameRule = gameRule;
    }

    public static GameRules getObject(){
        if(object==null){
            object = new GameRules();
        }

        return object;
    }

    void displayGameRules(){
        System.out.println();
        System.out.println("Decide the Rule you want to play \n");
        System.out.println("1. Basic: 1st & 4th same Suit --> remove middle two, 1st & 4th same rank --> remove all 4");
        System.out.println("2. Intermediate: Neighbors are same rank --> remove pair");
        System.out.println("3. House Rule: 1st & 4th same Suit AND 3rd & 4th same rank --> remove last 3");
    }

    void displayBasicMoves(){
        System.out.println();
        System.out.println("1. Remove middle two cards");
        System.out.println("2. Remove all four cards");
        System.out.println("8. Shuffle Cards");
        System.out.println("9. Draw a new card.");
    }

    void displayIntermediateMoves(){
        System.out.println();
        System.out.println("1. Remove middle two cards");
        System.out.println("2. Remove all four cards");
        System.out.println("3. Remove neighbouring pair of cards with same rank.");
        System.out.println("8. Shuffle Cards");
        System.out.println("9. Draw a new card.");
    }

    void displayHouseMoves(){
        System.out.println();
        System.out.println("1. Remove middle two cards");
        System.out.println("2. Remove all four cards");
        System.out.println("3. Remove neighbouring pair of cards with same rank.");
        System.out.println("4. Remove last 3 cards.");
        System.out.println("5. Remove first 3 cards.");
        System.out.println("8. Shuffle Cards");
        System.out.println("9. Draw a new card.");
    }
}

