package domain.body.fallingBody;

import domain.body.Body;

public abstract class FallingBody extends Body {


    public FallingBody(double x_coordinates,
                       double y_coordinates,
                       double length,
                       double width) {
        super(x_coordinates, y_coordinates, length, width);
    }
    public abstract void fall();

}