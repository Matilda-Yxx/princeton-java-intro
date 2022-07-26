package week3;

public class Birthday {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int trials = Integer.parseInt(args[1]);
        int[] countArr = new int[trials];
        // simulation
        for (int trialIdx=0; trialIdx<trials; trialIdx++) {
            int curTrialCount = 0;
            boolean[] found = new boolean[n];
            int curBday;
            while (true) {
                curBday = (int) (Math.random()*n);
                // System.out.print(curBday);
                curTrialCount ++;
                if(found[curBday]) break;
                else found[curBday] = true;
            }
            countArr[trialIdx] = curTrialCount;
            // System.out.println(" " + curTrialCount);
        }
        // statistics
        int curTotalCount=0;
        double cumProb = 0.0;
        while (true) {
            curTotalCount ++;
            int totalCountOccurence = 0;
            for (int trialIdx=0; trialIdx<trials; trialIdx++) {
                if(countArr[trialIdx] == curTotalCount) totalCountOccurence++;
            }
            cumProb += (double)totalCountOccurence/trials;
            String rowFormat = String.format("%d\t%d\t%f", curTotalCount, totalCountOccurence, cumProb);
            System.out.println(rowFormat);
            if(cumProb >= 0.5) break;
        }
    }
}
