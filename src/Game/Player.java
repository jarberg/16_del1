package Game;

public class Player {

    private int points = 0;
    private String name = "Guest";
    private boolean lastTurnPairSix = false;

    public Player(String name){
        this.name = name;
    }

    public int getPoints(){
        return points;
    }

    public boolean getLastTurnPairSix(){
        return lastTurnPairSix;
    }

    public String getName(){
        return this.name;
    }

    public void setLastTurnPairSix(boolean lastTurnPairSix){
        this.lastTurnPairSix = lastTurnPairSix;
    }

    public void addToPoints(int points){
        this.points += points;
    }


}
