public class Snake{
    private int head;
    private int tail;

    public Snake(int snakeStart,int snakeEnd){
        snakeStart=head;
        snakeEnd=tail;
    }
    public int getHead(){
        return head;
    }
    public  int getTail(){
        return tail;
    }
}
