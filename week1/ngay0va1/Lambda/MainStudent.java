
import java.util.*;

class MainStudent{
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student("Phu", 3.5));
        students.add(new Student("Kiet", 4));
        students.add(new Student("Dat", 3));

        // students.sort((s1, s2) -> Double.compare(s2.getGPA(), s1.getGPA()));
        // students.forEach(student -> System.out.println(student.getName()));

        students.sort(Comparator.comparingDouble(s -> s.getGPA()));
        students.forEach(student -> System.out.println(student.getName()));
    }
}