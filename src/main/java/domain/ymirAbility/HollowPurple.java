package domain.ymirAbility;
import domain.body.*;
import domain.body.obstacle.Obstacle;
import domain.needForSpear.Controller;

import java.util.Random;

public class HollowPurple extends YmirAbility {
    public final double gameScreenWidth = Controller.getInstance().getFrameBorders()[0],
            gameScreenHeight = Controller.getInstance().getFrameBorders()[1],
            hollowPurpleNum = 8;
    private Random randi = new Random();

    public HollowPurple() {
        super();
        name = "Hollow Purple";
        //The GameScreen is divided into cells (size: 10x10) where hollow purple obstacles can be put. The objects are
        // put into the empty cells chosen randomly in a way that they won't clash with already existing obstacles.
        for(int i=0; i<hollowPurpleNum; i++){
            addHollowPurpleObs();
        }
    }

    //Finding an empty cell and creating the obstacle there.
    public void putHPInCell(boolean [][]locationCells){
        int column;
        int row;
        column = randi.nextInt(10);
        row = randi.nextInt(10);
        while(locationCells[row][column]){
            column = randi.nextInt(10);
            row = randi.nextInt(10);
        }
        int x = column*100;
        int y = row*40 + 60;
        Controller.getInstance().getStatistics().addObstacle(BodyFactory.createObstacle("Hollow",x,y,1));
        locationCells[row][column] = true;
    }

    public void addHollowPurpleObs() {
        int x;
        int y;
        x = randi.nextInt(900);
        y = randi.nextInt(392);
        for (Obstacle o: Controller.getInstance().getStatistics().getObstacleList()) {
            if (o.compareCoordinates(x,y, 100, 8)) {
                return;
            }
        }
        Controller.getInstance().getStatistics().addObstacle(BodyFactory.createObstacle("Hollow",x,y,1));
    }
}