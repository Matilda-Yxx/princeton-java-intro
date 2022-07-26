package week4;
public class ShannonEntropy {
    public static void main(String[] args) {
        int m = Integer.parseInt(args[0]);
        int[] counter = new int[m];    
        int totalInputCount = 0;
        
        // read std input
        while (!StdIn.isEmpty()) {
            int x = StdIn.readInt();
            // accumulate the counter
            counter[x-1] ++;
            totalInputCount ++;
        }
        // compute entropy
        double ShannonEnt = 0.0;
        for (int i=0;i<m;i++) {
            double prop = (double) counter[i]/totalInputCount;
            if(prop != 0) {
                ShannonEnt -= prop * (Math.log(prop) / Math.log(2));
            }
        }
        System.out.printf("%.4f\n",ShannonEnt);
    }
}
