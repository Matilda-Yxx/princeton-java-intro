package week7;
import java.util.Arrays;

public class Inversions {

    // Return the number of inversions in the permutation a[].
    public static long count(int[] a) {
        int n = a.length;
        int totalInverted = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(i<j && a[i]>a[j]) totalInverted ++;
            }
        }
        return totalInverted;
    }

    // Return a permutation of length n with exactly k inversions.
    public static int[] generate(int n, long k) {
        int[] finalArr = new int[n];
        int curNum = n-1;
        int curFirstIdx = 0;
        int curLastIdx = n-1;
        while (curNum >= 0) {
            // check if we want to invert the current element
            if (k >= curNum) {
                finalArr[curFirstIdx] = curNum;
                k -= curNum;
                curFirstIdx ++;
            } else {
                finalArr[curLastIdx] = curNum;
                curLastIdx --;
            }
            curNum --;
            // System.out.println(Arrays.toString(finalArr));
        }
        return finalArr;
    }

    // Takes an integer n and a long k as command-line arguments,
    // and prints a permutation of length n with exactly k inversions.
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int k = Integer.parseInt(args[1]);
        // System.err.println(count(generate(n, k)));
        System.out.println(Arrays.toString(generate(n, k)));
    }
}