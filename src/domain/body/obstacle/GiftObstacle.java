package domain.body.obstacle;

public class GiftObstacle extends Obstacle{
    public String giftType;
    private String name;
    public GiftObstacle(double x_coordinates,
                        double y_coordinates,
                        double length,
                        double width,
                        int numberOfHits,
                        String giftType) {
        super(x_coordinates, y_coordinates, length, width, numberOfHits);
        this.giftType=giftType;
        this.moving = false;
        name = "Gift";
    }

    @Override
    public void move() {

    }
    public void createGift(){

    }
}