
//2x^2+y^2=1
//x-12 +(y-1)2=14
public class Rownanie {
    private static double Funkcja1(double x, double y) {
        return 2 * x * x + y * y - 1;
    }
    private static double Funkcja2(double x, double y) {
        return (x - 0.5) * (x - 0.5) + (y - 1) * (y - 1) - 0.25;
    }
    public static void main(String[] args) {
        metodaNewtona();
    }
    private static void metodaNewtona() {
        double x = 0.1;
        double y = 0.1;
        double f;
        double h;
        final double E = 0.005;
        double lastFunkcja1 = 150, lastFunkcja2 = 150;
        boolean end = true;
        while (end) {
            f = Funkcja1(x, y);
            h = Funkcja2(x, y);
            if (f > lastFunkcja1 + 10 && h > lastFunkcja2 + 10) {
                System.out.println("Rozbieżne równanie");
                break;
            }
            if (Math.abs(f) < E && Math.abs(h) < E) {
                System.out.println("x = " + x);
                System.out.println("y = " + y);
                break;
            }
            double K11 = 4 * x;
            double K12 = 2 * y;
            double K21 = 2 * x - 1;
            double K22 = 2 * y - 2;
            double a = (h - K22 * f) / (K21 * K12 - K11 * K22);
            double b = (f - K11 * a) / K21;
            x -= a;
            y -= b;
            lastFunkcja1 = f;
            lastFunkcja2 = h;
        }
    }
}

