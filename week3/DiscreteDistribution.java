package week3;

public class DiscreteDistribution {
    public static void main(String[] args) {
        int m = Integer.parseInt(args[0]);
        int n = args.length - 1;
        int[] cumSum = new int[n+1]; // first entry is given by 0
        cumSum[0] = 0;
        for (int i=1; i<(n+1); i++) {
            cumSum[i] = cumSum[i-1] + Integer.parseInt(args[i]);
        }
        // System.out.println(Arrays.toString(cumSum));
        for (int j=0; j<m; j++) {
            // pick rand num
            double M = Math.random() * cumSum[n];
            // System.out.print(M + " ");
            for (int k=0; k<(n+1); k++) {
                if (M > cumSum[k]) {
                    continue;
                } else {
                    System.out.print(k);
                    break;
                }
            }
            if(j != (m-1)) {
                System.out.print(" ");
            } else {
                System.out.println();
            }
        }
    }
}
