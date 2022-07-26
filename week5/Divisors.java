package week5;
public class Divisors {

    // Returns the greatest common divisor of a and b.
    public static int gcd(int a, int b) {
        if (a == 0 || b == 0) return Math.abs(a + b);
        else {
            // use Euclid's algorithm
            a = Math.abs(a);
            b = Math.abs(b);
            while(true) {
                int b_temp = b;
                b = a % b;
                a = b_temp;
                if (b == 0) return a;
            }
        }
    }

    // Returns the least common multiple of a and b.
    public static int lcm(int a, int b) {
        if (a * b == 0) return 0;
        else {
            a = Math.abs(a);
            b = Math.abs(b);
            return a / gcd(a, b) * b;
        }
    }

    // Returns true if a and b are relatively prime; false otherwise.
    public static boolean areRelativelyPrime(int a, int b) {
        return gcd(a,b) == 1;
    }

    // Returns the number of integers between 1 and n that are
    // relatively prime with n.
    public static int totient(int n) {
        int counter = 0;
        for (int i = 1; i <= n; i++){
            if(areRelativelyPrime(i, n)) counter++;
        }
        return counter;
    }

    // Takes two integer command-line arguments a and b and prints
    // each function, evaluated in the format (and order) given below.
    public static void main(String[] args) {
        int a = Integer.parseInt(args[0]);
        int b = Integer.parseInt(args[1]);

        System.out.println("gcd(" + a + ", " + b + ") = " + gcd(a, b));
        System.out.println("lcm(" + a + ", " + b + ") = " + lcm(a, b));
        System.out.println("areRelativelyPrime(" + a + ", " + b + ") = " + areRelativelyPrime(a, b));
        System.out.println("totient(" + a + ") = " + totient(a));
        System.out.println("totient(" + b + ") = " + totient(b));
    }
}