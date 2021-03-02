package task2;

public class Test {
    public static void main(String[] args) {
        /* task2 */
        Student[] students = new Student[4];
        students[0] = new Student("Horia", 2020);
        students[1] = new Student("Sebi", 2019);
        students[2] = new Student("Madalin", 2018);
        students[3] = new Student("Ioan", 2020);

        Course course = new Course("POO", "super misto", students);
        System.out.println(course.getTitle() + " este " + course.getDescription() + "\n\nCursantii sunt");
        for (int i = 0; i < students.length; i++) {
            System.out.println(course.getStudents()[i]);
        }

        if (args.length == 1) {
            Integer currentYear = Integer.valueOf(args[0]);
            System.out.println("\nIn anul " + currentYear + " avem studentii\n" + course.filterYear(currentYear));
        }

        /* task3 */
        Student student1 = new Student("Mos Craciun", 2000);
        Student student2 = new Student("Mos Craciun", 2000);
        System.out.println("\nCele 2 obiecte sunt identice?\n" + student1.equals(student2));
    }
}
