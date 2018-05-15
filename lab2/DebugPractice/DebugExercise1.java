/**
 * Exercise for learning how the debug, breakpoint, and step-into
 * feature work.
 */
public class DebugExercise1 {
    public static int divideThenRound(double top, int bottom) {
        double quotient = top / bottom;
        int result = (int) Math.round(quotient);
        return result;
    }

    public static void main(String[] args) {
        double t = 10;
        int b = 2;
        int result = divideThenRound(t, b);
        System.out.println("round(" + (int) t + "/" + b + ")=" + result);

        double t2 = 9;
        int b2 = 4;
        int result2 = divideThenRound(t2, b2);
        System.out.println("round(" + (int) t2 + "/" + b2 + ")=" + result2);

        double t3 = 3;
        int b3 = 4;
        int result3 = divideThenRound(t3, b3);
        System.out.println("round(" + (int) t3 + "/" + b3 + ")=" + result3);
    }
}
