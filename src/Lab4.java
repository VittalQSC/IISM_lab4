/**
 * Created by vittal on 8.12.16.
 */

public class Lab4 {
    public static void main(String[] args) {
        int n = 100000;

        SingleIntegralCalculator sic = new SingleIntegralCalculator(n);
        showResults(sic.calculate(), 8.506555930307984);

        DoubleIntegralCalculator dic = new DoubleIntegralCalculator(n);
        showResults(dic.calculate(), 1.55843327777055);
    }

    public static void showResults (double ourAnswer, double correctAnswer) {
        System.out.println("integral results:");
        System.out.println("correct answer = " + correctAnswer);
        System.out.println("our answer = " + ourAnswer);
        System.out.println();
        System.out.println();
    }
}


class SingleIntegralCalculator {
    private double a = 3.0;
    private double b = 3.5;
    private int n;

    public SingleIntegralCalculator() {}

    public SingleIntegralCalculator(int n) {
        this.n = n;
    }

    public double calculate() {
        double integral = 0.0;
        for (int i = 0; i < n; i++) {
            integral += function(random(a, b));
        }
        integral = integral * (b-a) / n;
        return integral;
    }

    double random(double a, double b) {
        return Math.random() * (b-a) + a;
    }

    private double function(double x) {
        return Math.pow(x, x) * (1.0 + Math.log(x)) * Math.tan(x);
    }
}

class DoubleIntegralCalculator {

    private double ax = Math.exp(2.0);
    private double bx = Math.PI * Math.PI;
    private double ay = Math.exp(1.0);
    private double by = Math.PI;
    private int n;

    public DoubleIntegralCalculator() {}

    public DoubleIntegralCalculator(int n) {
        this.n = n;
    }

    public double calculate() {
        double integral = 0.0;
        for (int i = 0; i < n; i++) {
            integral += function(random(ax, bx), random(ay, by));
        }
        integral = integral * (bx - ax) * (by - ay) / n;
        return integral;
    }


    double random(double a, double b) {
        return Math.random() * (b-a) + a;
    }

    public double function(double x, double y) {
        return Math.atan(x + y);
    }
}
