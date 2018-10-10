package Game;

public class Player {

    private int points = 0;
    private String name;
    private boolean lastTurnPairSix = false;

    public Player(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public int getPoints(){
        return points;
    }
    public void addToPoints(int points){
        this.points += points;
    }

    public boolean getLastTurnPairSix(){
        return lastTurnPairSix;
    }
    public void setLastTurnPairSix(boolean lastTurnPairSix){
        this.lastTurnPairSix = lastTurnPairSix;
    }

}
