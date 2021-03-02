package sumabil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestSumabil {
    private boolean areEquals(Sumabil value1, Sumabil value2) {
        if (value1.getClass() != value1.getClass()) {
            return false;
        }
        if (value1.getClass() == MyVector3.class) {
            MyVector3 vector1 = (MyVector3) value1;
            MyVector3 vector2 = (MyVector3) value2;
            return vector1.equals(vector2);
        }
        if (value1.getClass() == MyMatrix.class) {
            MyMatrix matrix1 = (MyMatrix) value1;
            MyMatrix matrix2 = (MyMatrix) value2;
            return matrix1.equals(matrix2);
        }
        return false;
    }

    public boolean passTest() {
        SumOfSumabils sumOfSumabils = new SumOfSumabils();
        Sumabil vector1 = new MyVector3(new int[] { 1, 2, 3 });
        Sumabil vector2 = new MyVector3(new int[] { 2, 3, 4 });
        Sumabil vector2Copy = new MyVector3(new int[] { 2, 3, 4 });
        Sumabil vector3 = new MyVector3(new int[] { 1, 2, 3, 4 });
        Sumabil vectorSum = new MyVector3(new int[] { 3, 5, 7 });

        MyVector3 vector4 = new MyVector3(new int[] { 1, 2, 3 });
        MyVector3 vector5 = new MyVector3(new int[] { 2, 3, 4 });
        MyVector3 sumV = new MyVector3();
        List<MyVector3> vectors = new ArrayList<>(Arrays.asList(vector4, vector5));

        Sumabil matrix1 = new MyMatrix(new int[][] { { 1, 2, 3, 4 }, { 5, 2, 1, 7 }, { 7, 2, 1, 5 }, { 4, 7, 6, 0 } });
        Sumabil matrix2 = new MyMatrix(new int[][] { { 5, 2, 1, 7 }, { 4, 7, 6, 0 }, { 1, 2, 3, 4 }, { 7, 2, 1, 5 } });
        Sumabil matrixSum = new MyMatrix(new int[][] { { 6, 4, 4, 11}, { 9, 9, 7, 7 }, { 8, 4, 4, 9 }, { 11, 9, 7, 5 } });

        MyMatrix matrix3 = new MyMatrix(new int[][] { { 1, 2, 3, 4 }, { 5, 2, 1, 7 }, { 7, 2, 1, 5 }, { 4, 7, 6, 0 } });
        MyMatrix matrix4 = new MyMatrix(new int[][] { { 5, 2, 1, 7 }, { 4, 7, 6, 0 }, { 1, 2, 3, 4 }, { 7, 2, 1, 5 } });
        MyMatrix sumM = new MyMatrix();
        List<MyMatrix> matrices = new ArrayList<>(Arrays.asList(matrix3, matrix4));

        vector1.addValue(vector2);
        vector2.addValue(vector3);

        matrix2.addValue(matrix1);

        vector1.addValue(matrix1);
        matrix2.addValue(vector2);

        sumOfSumabils.sumOfSumabils(vectors, sumV);
        sumOfSumabils.sumOfSumabils(matrices, sumM);

        return areEquals(vector1, vectorSum)
                && areEquals(vector2, vector2Copy)
                && areEquals(matrix2, matrixSum)
                && areEquals(sumV, vectorSum)
                && areEquals(sumM, matrixSum);
    }
}
