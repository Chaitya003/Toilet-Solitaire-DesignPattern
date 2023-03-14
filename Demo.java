public class Demo {
    public static void main(String[] args){
        GameRules card = GameRules.getObject(0);
        GameRules new_card = GameRules.getObject(1);

        new_card.displayGameRules();
//        card.displayGameRules();
        System.out.println(card.gameRule);
        System.out.println(new_card.gameRule);
    }
}
