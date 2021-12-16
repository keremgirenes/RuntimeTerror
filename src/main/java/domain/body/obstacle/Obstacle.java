package domain.body.obstacle;
import domain.needForSpear.Controller;
import domain.body.Body;

import java.util.Random;

public abstract class Obstacle extends Body {
    protected boolean moving;
    private int movingProbability;
    private int numberOfHits;
    protected int vx;
    protected String name;
    public Random randi = new Random();

    public Obstacle(int x_coordinates,
                    int y_coordinates,
                    int width,
                    int height,
                    int numberOfHits){
        super(x_coordinates,y_coordinates, width, height);
        movingProbability = randi.nextInt(10);
        moving = movingProbability > 7;
        this.numberOfHits=numberOfHits;
    }
    public abstract void move();
    public int getVx(){
        return vx;
    }
    public void setVx(int vx) {
        this.vx = vx;
    }

    public String getName(){
        return name;
    }

    public int getNumberOfHits(){
        return numberOfHits;
    }
    public void setNumberOfHits(int x){
        numberOfHits = Math.max(x, 0);
    }

    public boolean isMoving() {
        return moving;
    }

    public abstract void doWhenDestroyed();
}