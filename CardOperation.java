/* Controller class of Command Pattern */

import java.util.ArrayList;

public class CardOperation {
    private Command command;

    public void setCommand(Command command){
        this.command = command;
    }

    public ArrayList<String> cardEvent(){
        ArrayList<String> arr = new ArrayList<String>();
        arr = command.execute();

        return arr;
    }
}
