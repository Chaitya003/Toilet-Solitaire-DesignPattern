public class CardOperation {
    private Command command;

    public void setCommand(Command command){
        this.command = command;
    }

    public void cardEvent(){
        command.execute();
    }
}
