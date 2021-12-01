package domain.needForSpear;

import domain.body.obstacle.*;

import java.util.Random;


public class BuildGame {
    public final int simpleObstacleReq = 75, firmObstacleReq = 10, explosiveObstacleReq = 5, giftObstacleReq = 10;
    public int simpleObstacle, firmObstacle, explosiveObstacle, giftObstacle;
    public final int gameScreenWidth = 1000, gameScreenHeight = 600;
    public Random randi = new Random();

    //Creates however many obstacles were asked to be created.
    public BuildGame(String[] numOfObstaclesReq){
        setObstacles(numOfObstaclesReq);
        //The GameScreen is divided into cells (size: 25x25) where objects can be put. The objects are put into the
        // empty cells chosen randomly.
        boolean locationCells[][] = new boolean[(gameScreenHeight-100)/25][gameScreenWidth/25];
        for(int i=0; i<simpleObstacle; i++){
            putObstacleInCell(locationCells, "Simple");
        }
        for(int i=0; i<firmObstacle; i++){
            putObstacleInCell(locationCells, "Firm");
        }
        for(int i=0; i<explosiveObstacle; i++){
            putObstacleInCell(locationCells, "Explosive");
        }
        for(int i=0; i<giftObstacle; i++){
            putObstacleInCell(locationCells, "Gift");
        }

    }


    public Obstacle addObstacle(String typeOfObstacle, int x, int y) {
        Obstacle createdObstacle;
        if(typeOfObstacle.equals("Simple")){
            createdObstacle = new SimpleObstacle(x, y, 20, 20, 1);
        }
        else if(typeOfObstacle.equals("Firm")){
            createdObstacle = new FirmObstacle(x, y, 20, 20, 3);
        }
        else if(typeOfObstacle.equals("Explosive")){
            createdObstacle = new ExplosiveObstacle(x, y, 15, 15, 1);
        }
        else {
            createdObstacle = new GiftObstacle(x, y, 20, 20, 1, "chance");
        }
        Statistics.addObstacle(createdObstacle);
        return createdObstacle;
    }
    //Finding an empty cell and creating the obstacle there.
    public void putObstacleInCell(boolean [][]locationCells, String typeOfObstacle){
        int column;
        int row;
        column = randi.nextInt(40);
        row = randi.nextInt(20);
        while(locationCells[row][column]){
            column = randi.nextInt(40);
            row = randi.nextInt(20);
        }
        int x = column*25;
        int y = row*25;
        addObstacle(typeOfObstacle, x, y);
        locationCells[row][column] = true;

    }
    //Gets the number of obstacles entered as input from the user.
    public void setObstacles(String[] numOfObstaclesReq) {
        try {
            simpleObstacle = Math.max(Integer.parseInt(numOfObstaclesReq[0]), simpleObstacleReq);
        }
        catch(NumberFormatException exception) {
            simpleObstacle = simpleObstacleReq;
        }
        try {
            firmObstacle = Math.max(Integer.parseInt(numOfObstaclesReq[1]), firmObstacleReq);
        }
        catch(NumberFormatException exception) {
            firmObstacle = simpleObstacleReq;
        }
        try {
            explosiveObstacle = Math.max(Integer.parseInt(numOfObstaclesReq[2]), explosiveObstacleReq);
        }
        catch(NumberFormatException exception) {
            explosiveObstacle = simpleObstacleReq;
        }
        try {
            giftObstacle = Math.max(Integer.parseInt(numOfObstaclesReq[3]), giftObstacleReq);
        }
        catch(NumberFormatException exception) {
            giftObstacle = simpleObstacleReq;
        }
    }
}
