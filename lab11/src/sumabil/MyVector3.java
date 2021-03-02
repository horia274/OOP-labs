package sumabil;

import java.util.Arrays;

public class MyVector3 implements Sumabil {
    int[] vector;

    public MyVector3(int[] vector) {
        if (checkInput(vector)) {
            this.vector = vector;
        } else {
            this.vector = new int[3];
        }
    }

    public MyVector3() {
        vector = new int[3];
    }

    private boolean checkInput(int[] vector) {
        return vector.length == 3;
    }

    public int getNumberFromIndex(int i) {
        return vector[i];
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyVector3 myVector3 = (MyVector3) o;
        return Arrays.equals(vector, myVector3.vector);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(vector);
    }

    @Override
    public void addValue(Sumabil value) {
        if (value.getClass() == getClass()) {
            MyVector3 newVector = (MyVector3) value;
            for (int i = 0; i < 3; i++) {
                vector[i] += newVector.getNumberFromIndex(i);
            }
        }
    }
}
