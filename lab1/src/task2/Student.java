package task2;

import java.io.ObjectStreamException;

public class Student {
    private String name;
    private Integer year;

    public Student(String name, Integer year) {
        this.name = name;
        this.year = year;
    }

    /* task4 */
    public String getName() {
        return name;
    }

    public Integer getYear() {
        return year;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", year=" + year +
                '}';
    }

    public boolean equals(Student student) {
        if(name.equals(student.name) && year.equals(student.year)) {
            return true;
        }
        return false;
    }
}
