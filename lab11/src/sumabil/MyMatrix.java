package sumabil;

import java.util.Arrays;

public class MyMatrix implements Sumabil {
    int[][] matrix;

    public MyMatrix(int[][] matrix) {
        if (checkInput(matrix)) {
            this.matrix = matrix;
        }
        else {
            this.matrix = new int[4][4];
        }
    }

    public MyMatrix() {
        matrix = new int[4][4];
    }

    private boolean checkInput(int[][] matrix) {
        return matrix.length == 4 && matrix[0].length == 4;
    }

    public int getNumberFromIndexes(int i, int j) {
        return matrix[i][j];
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyMatrix myMatrix = (MyMatrix) o;
        return Arrays.deepEquals(matrix, myMatrix.matrix);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(matrix);
    }

    @Override
    public void addValue(Sumabil value) {
        if (value.getClass() == getClass()) {
            MyMatrix newMatrix = (MyMatrix) value;
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    matrix[i][j] += newMatrix.getNumberFromIndexes(i, j);
                }
            }
        }
    }
}
