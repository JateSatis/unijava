package pract20;

import java.util.Arrays;

class SquareGenericMatrix<T extends Number> {
    private T[] matrix;

    public SquareGenericMatrix(T[] matrix) {
        this.matrix = matrix;
    }

    public T[] getMatrix() {
        return matrix;
    }

    public void setMatrix(T[] matrix) {
        this.matrix = matrix;
    }

    public SquareGenericMatrix<Double> addition(SquareGenericMatrix<T> other) {
        Double[] addedNums = new Double[9];
        for (int i = 0; i < matrix.length; i++) {
            addedNums[i] = matrix[i].doubleValue();
        }

        for (int i = 0; i < matrix.length; i++) {
            addedNums[i] += other.matrix[i].doubleValue();
        }

        return new SquareGenericMatrix<Double>(addedNums);
    }

    public SquareGenericMatrix<Double> subtraction(SquareGenericMatrix<T> other) {
        Double[] addedNums = new Double[9];
        for (int i = 0; i < matrix.length; i++) {
            addedNums[i] = matrix[i].doubleValue();
        }

        for (int i = 0; i < matrix.length; i++) {
            addedNums[i] -= other.matrix[i].doubleValue();
        }

        return new SquareGenericMatrix<Double>(addedNums);
    }

    public SquareGenericMatrix<Double> multiplication(SquareGenericMatrix<T> other) {
        Double[] addedNums = new Double[9];
        for (int i = 0; i < matrix.length; i++) {
            addedNums[i] = matrix[i].doubleValue();
        }

        for (int i = 0; i < matrix.length; i++) {
            addedNums[i] *= other.matrix[i].doubleValue();
        }

        return new SquareGenericMatrix<Double>(addedNums);
    }

    public SquareGenericMatrix<Double> division(SquareGenericMatrix<T> other) {
        Double[] addedNums = new Double[9];
        for (int i = 0; i < matrix.length; i++) {
            addedNums[i] = matrix[i].doubleValue();
        }

        for (int i = 0; i < matrix.length; i++) {
            addedNums[i] /= other.matrix[i].doubleValue();
        }

        return new SquareGenericMatrix<Double>(addedNums);
    }

    public double determinant() {
        Double[] nums = new Double[9];
        for (int i = 0; i < matrix.length; i++) {
            nums[i] = matrix[i].doubleValue();
        }

        return nums[0]*nums[4]*nums[8] + nums[1]*nums[5]*nums[6] + nums[2]*nums[3]*nums[7];
    }

    @Override
    public String toString() {
        return
                matrix[0].toString() + " " + matrix[1].toString() + " " + matrix[2].toString() + "\n" +
                matrix[3].toString() + " " + matrix[4].toString() + " " + matrix[5].toString() + "\n" +
                matrix[6].toString() + " " + matrix[7].toString() + " " + matrix[8].toString() + "\n";
    }
}

public class ex3 {
    public static void main(String[] args) {
        Integer[] numbers = {1,2,3,4,5,6,7,8,9};
        SquareGenericMatrix<Integer> first = new SquareGenericMatrix<>(numbers);
        SquareGenericMatrix<Integer> second = new SquareGenericMatrix<>(numbers);
        System.out.println(first.multiplication(second));
    }
}
