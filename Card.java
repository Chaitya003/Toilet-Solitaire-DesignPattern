public class Card {
    public static int value, suit;
    private static Card object;
    char[] suits_map = {'H', 'D', 'C', 'S'};
    Card(int value, int suit){
        this.value = value;
        this.suit = suit;
//        private final Card object = new Card();
    }

    public static Card getObject(int value, int suit){
        if(object==null){
            object = new Card(value, suit);
        }

        return object;
    }

    public String namedValue(){
        String name;
        switch(value){
            case 14:
                name= String.valueOf('A');
                break;

            case 13:
                name= String.valueOf('K');
                break;

            case 12:
                name= String.valueOf('Q');
                break;

            case 11:
                name=String.valueOf('J');;
                break;

            default:
                name=String.valueOf(value);
                break;
        }

        return name;
    }

    public String name(){
        return namedValue()+suits_map[suit];
    }
}
