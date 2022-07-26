package week1;
public class GreatCircle {
    public static void main(String[] args) {
        double x1 = Math.toRadians(Double.parseDouble(args[0]));
        double y1 = Math.toRadians(Double.parseDouble(args[1]));
        double x2 = Math.toRadians(Double.parseDouble(args[2]));
        double y2 = Math.toRadians(Double.parseDouble(args[3]));
        double r = 6371.0;
        double first_term = Math.pow(Math.sin(0.5*(x2 - x1)),2);
        double second_term = Math.cos(x1)*Math.cos(x2)*Math.pow(Math.sin(0.5*(y2-y1)),2);
        double distance = 2*r*Math.asin(Math.sqrt(first_term + second_term));
        System.out.println(distance + " kilometers");
    }
}
