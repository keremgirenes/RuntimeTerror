package domain.body.obstacle;
import domain.body.fallingBody.Remains;
import domain.needForSpear.*;
public class ExplosiveObstacle extends Obstacle {

    //The coordinates and the radius of the circle that the obstacle will move around.
    private final int circleRadius = 3*25/2;
    private final int circleCenterX = this.x + width/2;
    private final int circleCenterY = this.y + height + circleRadius;
    //The degree between the circle's center and the obstacle.
    private double degree = 90;
    public ExplosiveObstacle(int x_coordinates,
                             int y_coordinates,
                             int width,
                             int height,
                             int numberOfHits) {
        super(x_coordinates, y_coordinates, width, height, numberOfHits);
        name = "Explosive";
        vx = 100/(4*Controller.ticksPerSecond);
    }

    public double getDegree() {
        return degree;
    }

    public void setDegree(double degree) {
        this.degree = degree;
    }
    //Doesn't move with the correct speed yet. Needs testing.
    @Override
    public void move() {
        if(moving){
            double rads = Math.toRadians(degree + 1 + 90); // 0 becomes the top
            int newX = Math.round((float) (circleCenterX + Math.cos(rads) * circleRadius));
            int newY = Math.round((float) (circleCenterY + Math.sin(rads) * circleRadius));
            /*boolean canMove = true;
            //Compares with every obstacle.
            for (Obstacle obstacle : Statistics.obstacleList){
                //Doesn't check whether it crashes with itself.
                if(!(obstacle.getCoordinates()[0] == this.x && obstacle.getCoordinates()[1] == this.y)){
                    canMove &= !(obstacle.compareCoordinates(newX, newY, this.width, this.height));
                }
            }
            //Compares with every frame border.
            if(!Controller.getInstance().hitFrame(newX, newY, this.width, this.height).equals("None")){
                canMove = false;
            }
            if(canMove) {*/
                this.x = newX;
                this.y = newY;
                degree += 1;
            //}
        }
    }

    @Override
    public void doWhenDestroyed() {
        explode();
        //NewScore = OldScore + 300/(CurrentTime-GameStartingTime)
    }

    public void explode() {
        Statistics.addRemains(new Remains(this.getCoordinates()[0]+16, this.getCoordinates()[1]+16, 32, 32, 1));
    }
}