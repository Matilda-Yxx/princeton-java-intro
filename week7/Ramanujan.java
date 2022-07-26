package week7;
public class Ramanujan {

    // Is n a Ramanujan number?
    public static boolean isRamanujan(long n) {
        long numPairs = 0;
        long maxPosbCbrt = (long) Math.floor(Math.cbrt(0.5 * n));
        // System.out.println(maxPosbCbrt);
        for (long i = 1; i <= maxPosbCbrt; i++) {
            long a = i*i*i;
            double cbrt = Math.cbrt(n-a);
            // System.out.println(a + " " + cbrt);
            if(cbrt == (long) Math.floor(cbrt)) {
                // System.out.println(a + " " + cbrt);
                numPairs ++;
            }
        }
        if (numPairs >= 2) return true;
        else return false;
    }

    // Takes a long integer command-line arguments n and prints true if
    // n is a Ramanujan number, and false otherwise.
    public static void main(String[] args) {
        long n = Long.parseLong(args[0]);
        System.out.println(isRamanujan(n));
    }
}