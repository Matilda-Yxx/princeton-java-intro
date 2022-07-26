package week3;

public class Minesweeper {
    public static void main(String[] args) {
        int m = Integer.parseInt(args[0]);
        int n = Integer.parseInt(args[1]);
        int k = Integer.parseInt(args[2]);

        // generate the mine field with the shuffling algorithm from the lecture
        int[] mineFieldRow = new int[m * n];
        for (int i = 0; i < k; i++) {
            mineFieldRow[i] = 1;
        }
        // shuffling the mines
        for (int i = 0; i < m * n; i++) {
            int r = i + (int) (Math.random() * (m * n - i)); // any item followin the i-th item
            int t = mineFieldRow[r];
            mineFieldRow[r] = mineFieldRow[i];
            mineFieldRow[i] = t;
        }
        // construct mine field with padding of zeros
        int[][] mineField = new int[m + 2][n + 2];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                mineField[i][j] = mineFieldRow[(i-1) * n + (j-1)];
            }
        }
        // verification
        // for (int i=0;i<m+2;i++) {
        //     for (int j=0;j<n+2; j++) {
        //         System.out.print(mineField[i][j] + " ");
        //     }
        //     System.out.println();
        // }
        // // print the minefield
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                // print the number of mines
                if (mineField[i][j] == 1)
                    System.out.print("*");
                else {
                    int sumNborMines = mineField[i - 1][j - 1] + mineField[i - 1][j] + mineField[i - 1][j + 1]
                            + mineField[i][j - 1] + mineField[i][j] + mineField[i][j + 1]
                            + mineField[i + 1][j - 1] + mineField[i + 1][j] + mineField[i + 1][j + 1];
                    System.out.print(sumNborMines);
                }
                // print space or new line
                if(j != n) System.out.print("  ");
                else System.out.println();
            }
        }
    }
}
