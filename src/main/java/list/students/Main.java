package list.students;

public class Main {
    public static void main(String[] args) {
        Student jane = new Student(1, "Jane", "Doe");
        Student john = new Student(2, "John", "Doe");
        Student mary = new Student(3, "Mary", "Doe");

        School school = new School();
        school.addStudent(jane);
        school.addStudent(john);
        school.addStudent(mary);
        System.out.println(school);

        school.removeStudent(jane);
        System.out.println(school);

        System.out.println(school.findStudentById(2));
        System.out.println(school.findStudentById(1));
    }
}
