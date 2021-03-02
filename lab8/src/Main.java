import java.util.*;

public class Main {

    public static void main(String[] args) {
        Student student1 = new Student("Horia", "Ignat", 1, 10);
        Student student2 = new Student("Madalin", "Dobrita", 2, 8.5);
        Student student3 = new Student("Sebastian", "Pitur", 3, 9.74);
        Student student4 = new Student("Ioan", "Dobrita", 4, 8.5);
        Student student5 = new Student("Gigi", "Ganesanu", 5, 8.5);
        List<Student> students = new ArrayList<>(Arrays.asList(student1, student2, student3, student4, student5));

        System.out.println("Sort students using Comparable");
        Collections.sort(students);
        for (Student student : students) {
            System.out.println(student);
        }
        System.out.println();

        System.out.println("Sort students by average grade using lambda");
        students.sort((o1, o2) -> Double.compare(o2.averageGrade, o1.averageGrade));
        for (Student student : students) {
            System.out.println(student);
        }
        System.out.println();

        System.out.println("Priority Queue");
        PriorityQueue<Student> priorityQueue = new PriorityQueue<>((o1, o2) -> Long.compare(o1.id, o2.id));
        priorityQueue.addAll(students);
        for (Student student : priorityQueue) {
            System.out.println(student);
        }
        System.out.println();

        System.out.println("Map student -> subjects");
        Map<Student, LinkedList<String>> subjects = new HashMap<>() {{
            put(student1, new LinkedList<>() {{ add("IOCLA"); add("OOP"); add("SD"); }});
            put(student2, new LinkedList<>() {{ add("Mate3"); add("PC"); add("Fizica"); }});
            put(student3, new LinkedList<>() {{ add("Engleza"); add("AA"); add("Mate2"); }});
            put(student4, new LinkedList<>() {{ add("USO"); add("PL"); add("PA"); }});
            put(student4, new LinkedList<>() {{ add("Mate1"); add("ELTH"); add("EEA"); }});
        }};
        for (Map.Entry<Student, LinkedList<String>> entry : subjects.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
        System.out.println();

        List<Integer> numbers = new ArrayList<>(Arrays.asList(4, 5, 2, 7, 3, 10, 15, 1, 20, 12));

        System.out.println("LinkedHashSet for even numbers");
        ParityLinkedHashSet parityLinkedHashSet = new ParityLinkedHashSet();
        parityLinkedHashSet.addAll(numbers);
        System.out.println(parityLinkedHashSet);

        System.out.println("HashSet for even numbers");
        ParityHashSet parityHashSet = new ParityHashSet();
        parityHashSet.addAll(numbers);
        System.out.println(parityHashSet);

        System.out.println("TreeSet for even numbers");
        ParityTreeSet parityTreeSet = new ParityTreeSet();
        parityTreeSet.addAll(numbers);
        System.out.println(parityTreeSet);
    }
}
