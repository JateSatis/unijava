package pract7;

public class MathFunc implements MathCalculable {
    @Override
    public int pow(int num1, int num2) {
        int result = 1;
        for (int i = 0; i < num2; i++) {
            result *= num1;
        }
        return result;
    }

    @Override
    public double moduleComplex(int x, int y) {
        return Math.sqrt(this.pow(x, 2) + this.pow(y, 2));
    }

    public double circleSquare(int radius) {
        return PI * this.pow(radius, 2);
    }
}
