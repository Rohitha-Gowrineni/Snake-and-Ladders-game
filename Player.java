public class Player{
    private String name;
    private int position;
    private boolean won;
    public Player(String name){
        this.name=name;
        this.won=false;
    }
    public int getPositon(){
        return position;
    }
    public void setPosition(int position2){
        position=position2;
    }
    public void setwon(boolean b){
        won=true;
    }
    public String getName(){
        return name;
    }
}
