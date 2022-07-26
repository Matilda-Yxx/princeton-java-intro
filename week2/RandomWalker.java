package week2;

/**
 * RandomWalker
 */
public class RandomWalker {

    public static void main(String[] args) {
        int r = Integer.parseInt(args[0]);
        int x = 0;
        int y = 0;
        int steps = 0;
        int manhDist;
        while (true) {
            // print current coordinate
            System.out.println("(" + x + ", " + y + ")");
            // check if dist is already met (in case r = 0)
            manhDist = Math.abs(x) + Math.abs(y);
            if ( manhDist == r ) break;
            // random walk
            double randNum = Math.random();
            if (randNum < 1.0/4) {
                y += 1;
            } else if(randNum < 2.0/4) {
                y -= 1;
            } else if(randNum < 3.0/4) {
                x += 1;
            } else {
                x -= 1;
            }
            // update step
            steps ++;
        }
        // print last step coordinates
        System.out.println("steps = " + steps);
    }
}