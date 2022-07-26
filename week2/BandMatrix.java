package week2;

public class BandMatrix {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int width = Integer.parseInt(args[1]);
        for (int rowIdx = 0; rowIdx < n; rowIdx++) {
            for (int colIdx = 0; colIdx < n; colIdx++) {
                // print the symbol
                if(Math.abs(rowIdx - colIdx) <= width) {
                    System.out.printf("*");
                } else {
                    System.out.printf("0");
                }
                // print space/new line
                if(colIdx != (n-1)) {
                    System.out.printf("  ");
                } else {
                    System.out.printf("\n");
                }
            }
        }
    }
}
