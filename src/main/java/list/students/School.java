package list.students;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class School {
    Map<Integer, Student> students = new HashMap<>();

    public void addStudent(Student student) {
        students.put(student.getStudentId(), student);
    }

    public void removeStudent(Student student) {
        students.remove(student.getStudentId());
    }

    public Student findStudentById(int id) {
        return students.get(id);
    }

    public List<Course> getCoursesByStudentId(int id) {
        Student student = findStudentById(id);

        if (student == null) {
            return new ArrayList<>();
        } else {
            return student.getCourses();
        }
    }

    public void printAllStudents() {
        students.forEach((_, student) -> System.out.println(student));
    }

    @Override
    public String toString() {
        return "School{" +
                "students=" + students +
                '}';
    }
}
