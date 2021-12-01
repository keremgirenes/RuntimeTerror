package domain.body.obstacle;

import domain.needForSpear.Controller;
import domain.needForSpear.Statistics;

public class FirmObstacle extends Obstacle{
    private double vx;
    private String name;
    public FirmObstacle(double x_coordinates,
                        double y_coordinates,
                        double length,
                        double width,
                        int numberOfHits) {
        super(x_coordinates, y_coordinates, length, width, numberOfHits);
        vx = Controller.getInstance().getPlayer().getNoblePhantasm().width/(4*Controller.ticksPerSecond);
        name = "Firm";
    }

    @Override
    public void move() {
        if(moving){
            boolean canMoveRight = true;
            boolean canMoveLeft = true;
            for (Obstacle obstacle : Statistics.obstacleList){
                canMoveRight &= obstacle.compareCoordinates(this.x + this.vx, this.y, this.length, this.width);
                canMoveLeft &= obstacle.compareCoordinates(this.x - this.vx, this.y, this.length, this.width);
            }
            if(!Controller.getInstance().hitFrame(this.x + this.vx, this.y, this.length, this.width).equals("None")){
                canMoveRight = false;
            }
            if(!Controller.getInstance().hitFrame(this.x - this.vx, this.y, this.length, this.width).equals("None")){
                canMoveLeft = false;
            }
            if(canMoveRight){
                this.x += this.vx;
            } else if(canMoveLeft){
                this.x -= this.vx;
            }
        }
    }
}
