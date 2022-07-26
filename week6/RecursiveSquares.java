package week6;
public class RecursiveSquares {

    // Draws a square centered on (x, y) of the given side length
    // with a light gray background and a black border.
    public static void drawSquare(double x, double y, double length) {
        double halfLength = length/2.0;
        StdDraw.setPenColor(StdDraw.LIGHT_GRAY);
        StdDraw.filledSquare(x, y, halfLength);
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.square(x, y, halfLength);
    }

    // Draws a recursive square pattern of order n, centered on (x, y)
    // of the given side length.
    public static void draw(int n, double x, double y, double length) {
        if(n==0) return;
        double halfLength = length/2.0;
        // left top
        draw(n-1, x-halfLength, y+halfLength, halfLength);
        // right top
        draw(n-1, x+halfLength, y+halfLength, halfLength);
        // centre
        drawSquare(x, y, length);
        // left bottom
        draw(n-1, x-halfLength, y-halfLength, halfLength);
        // right bottom
        draw(n-1, x+halfLength, y-halfLength, halfLength);
    }

    // Takes an integer command-line argument n and draws a recursive
    // square pattern of order n, centered on (0.5, 0.5) with side length 0.5.
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        draw(n, .5, .5, .5);
    }
}