package task2;
import java.util.ArrayList;

public class Course {
    private String title;
    private String description;
    private Student[] students = new Student[4];

    public Course(String title, String description, Student[] students) {
        this.title = title;
        this.description = description;
        this.students = students;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Student[] getStudents() {
        return students;
    }

    public void setStudents(Student[] students) {
        this.students = students;
    }

    public ArrayList<Student> filterYear(Integer year) {
        ArrayList<Student> ans = new ArrayList<Student>();
        for(int i = 0; i < 4; i++) {
            if(students[i].getYear().equals(year)){
                ans.add(students[i]);
            }
        }
        return ans;
    }
}
