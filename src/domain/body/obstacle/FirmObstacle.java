package domain.body.obstacle;

public class FirmObstacle extends Obstacle{


    public FirmObstacle(double x_coordinates,
                        double y_coordinates,
                        double length,
                        double width,
                        double vx,
                        double vy,
                        String name,
                        boolean moving,
                        double movingProbability,
                        int numberOfHits) {
        super(x_coordinates, y_coordinates, length, width, vx, vy, name, moving, movingProbability, numberOfHits);
    }

    @Override
    public void move() {

    }
}
