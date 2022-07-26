package week6;
/**
 * The hardest part about DP is to extract the base cases!
 * You need to find out which are the edge cases
 * and how to represent the intermediate results using for ex, a matrix
 */

public class TrinomialDP {

    // Returns the trinomial coefficient T(n, k).
    public static long trinomial(int n, int k) {
        // if edge case can return immediately
        if (k < -n || k > n)
            return 0;
        else if (k == 0 && n == 0)
            return 0;
        else if (Math.abs(k) == n)
            return 1;
        else {
            int totalRows = n + 1;
            int totalCol = 2 * n + 1;
            long[][] coeffMat = new long[totalRows][totalCol];

            // initialize the left triangle
            for (int rowIdx = 0; rowIdx <= n; rowIdx++) {
                for (int colIdx = 0; colIdx <= n; colIdx++) {
                    if (rowIdx == colIdx) {
                        coeffMat[rowIdx][colIdx + n] = 1;
                        coeffMat[rowIdx][-colIdx + n] = 1;
                    } else if (rowIdx < colIdx) {
                        coeffMat[rowIdx][colIdx + n] = 0;
                        coeffMat[rowIdx][-colIdx + n] = 0;
                    } else
                        continue;
                }
            }
            // compute the rest of the matrix
            for (int rowIdx = 0; rowIdx <= n; rowIdx++) {
                for (int colIdx = 0; colIdx <= n; colIdx++) {
                    if (rowIdx > colIdx) {
                        coeffMat[rowIdx][colIdx + n] = coeffMat[rowIdx - 1][colIdx + n - 1]
                                + coeffMat[rowIdx - 1][colIdx + n] + coeffMat[rowIdx - 1][colIdx + n + 1];
                        coeffMat[rowIdx][-colIdx + n] = coeffMat[rowIdx - 1][-colIdx + n - 1]
                                + coeffMat[rowIdx - 1][-colIdx + n] + coeffMat[rowIdx - 1][-colIdx + n + 1];
                    }
                }
            }
            // // debug
            // for (int i = 0; i < coeffMat.length; i++) {
            //     for (int j = 0; j < coeffMat[i].length; j++) {
            //         System.out.print(coeffMat[i][j] + " ");
            //     }
            //     System.out.println();
            // }

            // return the final result
            return coeffMat[n][k + n];
        }

    }

    // Takes two integer command-line arguments n and k and prints T(n, k).
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int k = Integer.parseInt(args[1]);
        System.out.println(trinomial(n, k));
    }
}