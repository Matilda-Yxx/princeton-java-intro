package week4;
public class WorldMap {
    public static void main(String[] args) {
        // width and height
        int width = StdIn.readInt();
        int height = StdIn.readInt();
        // create the canvas
        StdDraw.setCanvasSize(width, height);
        StdDraw.setXscale(0, width);
        StdDraw.setYscale(0, height);
        
        // initialization
        String cityName;
        int numOfDots;

        while (!StdIn.isEmpty()) {
            cityName = StdIn.readString();
            numOfDots = StdIn.readInt();
            double[] x = new double[numOfDots];
            double[] y = new double[numOfDots];
            for(int i =0; i<numOfDots; i++) {
                x[i] = StdIn.readDouble();
                y[i] = StdIn.readDouble();
            }
            // draw the polygons
            StdDraw.polygon(x, y);
        }
    }
}
