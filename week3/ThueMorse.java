package week3;

public class ThueMorse {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        // create the Thue-Morse sequence
        // first compute the minimum power of 2 that's greater than n
        double power;
        int fold;
        for (int i=0;;i++) {
            power = Math.pow(2, i);
            if (power >= n) {
                fold = i;
                break;
            } else {
                continue;
            }
        }
        // generate a ThueMorse sequence of n folds
        int[] ThueMorseSeq = new int[(int) Math.pow(2, fold)];
        ThueMorseSeq[0] = 0;
        for (int i=0; i<fold; i++) {
            // first compute neg bits based on current array
            int curArrLen = (int) Math.pow(2,i);
            for(int j=0; j<curArrLen; j++) {
                int curBit;
                if (ThueMorseSeq[j] == 0) curBit = 1;
                else curBit = 0;
                ThueMorseSeq[curArrLen+j] = curBit;
            }
        }    
        // create the matrix
        for (int rowIdx=0; rowIdx<n; rowIdx++) {
            for (int colIdx=0; colIdx<n; colIdx++) {
                if(ThueMorseSeq[rowIdx] == ThueMorseSeq[colIdx]) {
                    System.out.print("+");
                } else {
                    System.out.print("-");
                }

                if(colIdx != (n-1)) {
                    System.out.print("  ");
                } else {
                    System.out.print("\n");
                }
            }
        }
    }

}
