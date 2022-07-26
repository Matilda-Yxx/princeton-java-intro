import java.awt.Color;

public class KernelFilter {

    // Returns a new picture that applies the identity filter to the given picture.
    public static Picture identity(Picture picture) {
        double[][] weights = {{0,0,0}, {0,1,0}, {0,0,0}};
        return kernel(picture, weights);
    }
    
    // Returns a new picture that applies an arbitrary kernel filter to the given picture.
    private static Picture kernel(Picture picture, double[][] weights) {
        // get input parameters
        int width = picture.width();
        int height = picture.height();
        int kernelHeight = weights.length; // num of rows
        int kernelWidth = weights[0].length; // num of cols

        // initialize target object
        Picture target = new Picture(width, height);

        // apply kernel weights
        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {
                // multiply the kernel with cur submatrix
                double redVal = 0.0;
                double greenVal = 0.0;
                double blueVal = 0.0;
                for (int i = -kernelWidth/2; i <= kernelWidth/2; i++) {
                    for (int j = -kernelHeight/2; j <= kernelHeight/2; j++) {
                        redVal +=  weights[i + kernelWidth/2][j + kernelHeight/2] * picture.get((col + i + width) % width, (row + j + height) % height).getRed();
                        greenVal +=  weights[i + kernelWidth/2][j + kernelHeight/2] * picture.get((col + i + width) % width, (row + j + height) % height).getGreen();
                        blueVal +=  weights[i + kernelWidth/2][j + kernelHeight/2] * picture.get((col + i + width) % width, (row + j + height) % height).getBlue();
                    }
                }
                // rounding and clamping
                int red = roundAndClamp(redVal);
                int green = roundAndClamp(greenVal);
                int blue = roundAndClamp(blueVal);
                // assign value
                Color color = new Color(red, green, blue);
                target.set(col, row, color);
            }
        }
        return target;
    }

    private static int roundAndClamp(double a) {
        int b = (int) Math.round(a);
        if(b < 0) return 0;
        else if (b > 255) return 255;
        else return b;
    }
    // Returns a new picture that applies a Gaussian blur filter to the given
    // picture.
    public static Picture gaussian(Picture picture) {
        double[][] weights = {{ 1.0/16, 2.0/16, 1.0/16}, { 2.0/16, 4.0/16, 2.0/16 }, { 1.0/16, 2.0/16, 1.0/16 }};
        return kernel(picture, weights);
    }

    // Returns a new picture that applies a sharpen filter to the given picture.
    public static Picture sharpen(Picture picture) {
        double[][] weights = {{0,-1,0}, {-1,5,-1}, {0,-1,0}};
        return kernel(picture, weights);
    }

    // Returns a new picture that applies an Laplacian filter to the given picture.
    public static Picture laplacian(Picture picture) {
        double[][] weights = {{-1,-1,-1}, {-1,8,-1}, {-1,-1,-1}};
        return kernel(picture, weights);
    }

    // Returns a new picture that applies an emboss filter to the given picture.
    public static Picture emboss(Picture picture) {
        double[][] weights = {{-2,-1,0}, {-1,1,1}, {0,1,2}};
        return kernel(picture, weights);
    }

    // Returns a new picture that applies a motion blur filter to the given picture.
    public static Picture motionBlur(Picture picture) {
        double[][] weights = 
        {{1.0/9,0,0,0,0,0,0,0,0},{0,1.0/9,0,0,0,0,0,0,0}, {0,0,1.0/9,0,0,0,0,0,0},
        {0,0,0,1.0/9,0,0,0,0,0},{0,0,0,0,1.0/9,0,0,0,0},{0,0,0,0,0,1.0/9,0,0,0},
        {0,0,0,0,0,0,1.0/9,0,0},{0,0,0,0,0,0,0,1.0/9,0},{0,0,0,0,0,0,0,0,1.0/9}};
        return kernel(picture, weights);
    }

    // Test client (ungraded).
    public static void main(String[] args) {
        String filename = args[0];
        Picture source = new Picture(filename);

        Picture target = identity(source);
        target.show();
        Picture target2 = gaussian(source);
        target2.show();
        Picture target3 = sharpen(source);
        target3.show();
        Picture target4 = laplacian(source);
        target4.show();
        Picture target5 = emboss(source);
        target5.show();
        Picture target6 = motionBlur(source);
        target6.show();
    }

}