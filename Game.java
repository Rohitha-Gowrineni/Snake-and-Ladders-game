public class Game{
    private int snakesno;
    private int laddersno;

    private Queue<Player>players;
    private List<Snake> snakes;
    private List<Ladder> ladders;
    
    private Board board;
    private Dice dice;

    public Game(int laddersno,int snakesno,int bs){
        this.laddersno=laddersno;
        this.snakesno=snakesno;
        this.players=new ArrayDeque<>():
        snakes=new ArrayList<>(snakesno);
        ladders=new ArrayList<>(laddersno);
        board=new Board(bs);
        dice=new Dice();
        initBoard();
    }

    private void initBoard(){
        Set<String> s1Set=new HashSet<>();
        for(int i=0;i<snakesno;i++){
            while(true){
                Rnadom ran=new Random();
                int snakeStart=ran.nextInt(board.getStart(),board.getSize());
                int snakeEnd=ran.nextInt(board.getStart(),board.getSize());
                if(snakeEnd<=snakeStart)
                   continue;
                String startEndPair=String.valueOf(snakeStart)+snakeEnd;
                if(!s1Set.contains(startEndPair)){
                    Snake snake=new Snake(snakeStart,snakeEnd);
                    snakes.add(snake);
                    s1Set.add(startEndPair);
                    break;
                }
            }
        }
        for(inti=0;i<laddersno;i++){
            while(true){
                Rnadom ran=new Random();
                int ladderStart=ran.nextInt(board.getStart(),board.getSize());
                int ladderEnd=ran.nextInt(board.getStart(),board.getSize());
                if(ladderEnd<=ladderStart)
                   continue;
                String startEndPair=String.valueOf(ladderStart)+ladderEnd;
                if(!s1Set.contains(startEndPair)){
                    Ladder ladder=new Ladder(ladderStart,ladderEnd);
                    ladders.add(ladder);
                    s1Set.add(startEndPair);
                    break;
                }
            }
        }
    }
    public void addPlayer(Player player){
        players.add(player);
    }

    public void playGame(){
        while(true){
            Player player=players.poll();
            int val=dice.roll();
            System.out.println(val);
            int newPosition=player.getPositon()+val;
            if(newPosition>board.getEnd()){
                player.setPosition(player.getPositon());
                players.offer(player);
            }
            else{
                player.setPosition(getNewPosition(newPosition));
                if(player.getPositon()==board.getEnd()){
                    player.setwon(true);
                    System.out.println("player"+player.getName()+"WON");
                }
                else{
                    Sytem.out.println("Setting"+player.getName()+"'s new position to"+player.getPositon());
                    players.offer(player);
                }
            }
            if(pls.size()<2){
                break;
            }
        }
    }
    private int getNewPosition(int newPosition){
        for(Snake snake:snakes){
            if(snake.getHead()==newPosition){
                System.out.println("SNAKE BIT");
                return snake.getTail();
            }
        }
        for(Ladder ladder:ladders){
            if(ladder.getStart()==newPosition){
                System.out.println("CLIMBED LADDER");
                return snake.getEnd();
            }
        }
        return newPosition;
    }
}
