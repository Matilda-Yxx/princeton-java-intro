package week2;

public class RandomWalkers {

    public static void main(String[] args) {
        int r = Integer.parseInt(args[0]);
        int trials = Integer.parseInt(args[1]);

        double totalSteps = 0.0;

        for (int trialIdx = 1; trialIdx <= trials; trialIdx++) {
            int steps = 0;
            int x = 0;
            int y = 0;
            int manhDist;
            while (true) {
                // check if already met the distance r (in case r = 0)
                manhDist = Math.abs(x) + Math.abs(y);
                if (manhDist == r) break;
                // if not met, continue random walk
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
                //print current coordinate
                steps++;
                
            }
            //System.out.println(steps);
            totalSteps += steps;
        }
        
        System.out.println("average number of steps = " + totalSteps/trials);
    }
}
