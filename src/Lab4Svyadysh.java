/**
 * Created by svyadysh on 8.12.16.
 */

public class Lab4Svyadysh
{
    public static void main(String[] args) {
        int n = 100000;

        SingleIntegralCalculator2 sic = new SingleIntegralCalculator2(n);
        showResults(sic.calculate(), -0.485736);

        DoubleIntegralCalculator2 dic = new DoubleIntegralCalculator2(n);
        showResults(dic.calculate(), 3.333333);
    }

    public static void showResults (double ourAnswer, double correctAnswer) {
        System.out.println("integral results:");
        System.out.println("correct answer = " + correctAnswer);
        System.out.println("our answer = " + ourAnswer);
        System.out.println();
        System.out.println();
    }
}


class SingleIntegralCalculator2 {
    private double a = 0;
    private double b = 5 * Math.PI / 7;
    private int n;

    public SingleIntegralCalculator2() {}

    public SingleIntegralCalculator2(int n) {
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
        return Math.cos(x + Math.sin(x));
    }
}

class DoubleIntegralCalculator2 {

    private double ax = 0;
    private double bx = 2;
    private double ay = 0;
    private double by = 1;
    private int n;

    public DoubleIntegralCalculator2() {}

    public DoubleIntegralCalculator2(int n) {
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
        return x * x + y * y;
    }
}
