package week1;
public class RightTriangle {
    public static void main(String[] args) {
        int a = Integer.parseInt(args[0]);
        int b = Integer.parseInt(args[1]);
        int c = Integer.parseInt(args[2]);

        boolean isTriangle;
        boolean isValidInput;
        isValidInput = a > 0 && b > 0 && c > 0;

        int min_num = Math.min(a, Math.min(b, c));
        int max_num = Math.max(a, Math.max(b, c));
        int mid_num = (a + b + c) - min_num - max_num;
        isTriangle = (Math.pow(min_num,2) + Math.pow(mid_num,2)) == Math.pow(max_num,2);
        System.out.println(isValidInput && isTriangle);
    }
}
