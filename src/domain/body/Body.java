package domain.body;

public class Body {
    protected double x;
    protected double y;
    public double length;
    public double width;

    public Body(double x_coordinates,
                double y_coordinates,
                double length,
                double width) {
        x = x_coordinates;
        y = y_coordinates;
        this.length = length;
        this.width = width;
    }
    
    public double[] getCoordinates(){
        return new double[] {x,y};
    }

    public boolean compareCoordinates(double x, double y, double length, double width) {
        boolean crashingCoordinates = false;
        double x1 = this.x;
        double y1 = this.y;

        double width1 = this.width;
        double length1 = this.length;

        if (Math.abs(x-x1) <= Math.max(width1,width)){
            if (y >= y1){
                if((y-y1) <= length) {
                    crashingCoordinates = true;
                }
            } else {
                if((y1-y) <= length1) {
                    crashingCoordinates = true;
                }
            }
        } else if (Math.abs(y-y1) <= Math.max(length1,length)){
            if (x >= x1){
                if((x-x1) <= width) {
                    crashingCoordinates = true;
                }
            } else {
                if((x1-x) <= width1) {
                    crashingCoordinates = true;
                }
            }
        }
        return crashingCoordinates;
    }

}