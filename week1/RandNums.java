package week1;
public class RandNums {
    public static void main(String[] args) {
        int num1 = Integer.parseInt(args[0]);
        int num2 = Integer.parseInt(args[1]);
        int num3 = Integer.parseInt(args[2]);
        
        int num_min = Math.min(num1, num2);
        num_min = Math.min(num_min, num3);
        int num_max = Math.max(num1, num2);
        num_max = Math.max(num_max, num3);
        int mid = (num1 + num2 + num3) - num_min - num_max;

        System.out.println(num_min + " " + num_max + " " + mid);;
    }
}
