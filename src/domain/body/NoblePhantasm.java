package domain.body;

import domain.needForSpear.*;

public class NoblePhantasm extends Body {

    public double normalAngle;
    public boolean hasMagicalHex;

    public NoblePhantasm(int x_coordinates,
                         int y_coordinates,
                         int length,
                         int width){
        super(x_coordinates, y_coordinates, length, width);
        normalAngle=90;
        hasMagicalHex =false;
    }

    public void updateX(int x) {
        if(Controller.getInstance().hitFrame(x, this.y, this.length, this.width).equals("None")){
            this.x = x;
        }
    }

    //This is called ticksPerSecond times per second.
    public void moveRight() {
        updateX(x + (width / Controller.ticksPerSecond));
    }

    public void moveLeft() {
        updateX(x - (width / Controller.ticksPerSecond));
    }

    public void slideRight() {
        updateX(x + (2*width / Controller.ticksPerSecond));
    }

    public void slideLeft() {
        updateX(x - (2*width / Controller.ticksPerSecond));
    }

    public void rotateRight() {
        normalAngle -= 0.1;
        if(normalAngle < 45) normalAngle = 45;
    }

    public void rotateLeft() {
        normalAngle += 0.1;
        if(normalAngle > 135) normalAngle = 135;
    }
    
    public void activateMagicalHex(){
        
    }
    
    public void doubleNP(){
        
    }
}
