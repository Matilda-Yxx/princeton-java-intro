package week7;
public class MaximumSquareSubmatrix {

    // Returns the size of the largest contiguous square submatrix
    // of a[][] containing only 1s.
    public static int size(int[][] a) {
        int n = a.length;
        int[][] b = new int[n][n];
        int curMax = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0)
                    b[i][j] = a[i][j];
                else {
                    if (a[i][j] == 0)
                        b[i][j] = 0;
                    else {
                        b[i][j] = Math.min(b[i - 1][j], Math.min(b[i - 1][j - 1], b[i][j - 1])) + 1;
                    }
                }
                // update max
                if (b[i][j] > curMax)
                    curMax = b[i][j];
            }
        }
        // for (int i = 0; i < b.length; i++) {
        //     for (int j = 0; j < b[i].length; j++) {
        //         System.out.print(b[i][j] + " ");
        //     }
        //     System.out.println();
        // }
        return curMax;
    }

    // Reads an n-by-n matrix of 0s and 1s from standard input
    // and prints the size of the largest contiguous square submatrix
    // containing only 1s.
    public static void main(String[] args) {
        int n = StdIn.readInt();
        int[][] a = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = StdIn.readInt();
            }
        }
        System.out.println(size(a));
    }
}