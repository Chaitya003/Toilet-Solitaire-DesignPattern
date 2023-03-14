public class GameRules {
    public static int gameRule;
    private static GameRules object;

    GameRules(int gameRule){
        this.gameRule = gameRule;
    }

    public static GameRules getObject(int gameRule){
        if(object==null){
            object = new GameRules(gameRule);
        }

        return object;
    }

    void displayGameRules(){
        switch(gameRule){
//            System.out.println(gameRule);
            case 0:
                System.out.println("Decide the Rule you want to play \n");
                System.out.println("1. Basic: 1st & 4th same Suit --> remove middle two, 1st & 4th same rank --> remove all 4");
                System.out.println("2. Intermediate: Neighbors are same rank --> remove pair");
                System.out.println("3. House Rule: 1st & 4th same Suit AND 3rd & 4th same rank --> remove last 3");
                break;
            case 1:
                System.out.println("1. Remove middle two cards");
                System.out.println("2. Remove all four cards");
                System.out.println("8. Shuffle Cards");
                System.out.println("9. Draw a new card.");
                break;
            default:
                System.out.println("Break");
        }
    }
}

