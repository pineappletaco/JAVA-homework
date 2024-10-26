
public class HW3_2 {

    private String courseName;
    private String[] students;
    private int numberOfStudents;
    private static final int INITIAL_SIZE = 5;

    public HW3_2(String courseName) {
        this.courseName = courseName;
        students = new String[INITIAL_SIZE];
        numberOfStudents = 0;
    }

    public void addStudent(String student) {
        if (numberOfStudents <= students.length) {
            String[] newstudents = new String[students.length * 2];
            System.arraycopy(students, 0, newstudents, 0, students.length);
            students = newstudents;
        }
        students[numberOfStudents] = student;
        numberOfStudents++;
    }

    public String[] getStudents() {
        String[] actualStudents = new String[numberOfStudents];
        System.arraycopy(students, 0, actualStudents, 0, numberOfStudents);
        return actualStudents;
    }

    public int getNumberOfStudents() {
        return numberOfStudents;
    }
    
    public void dropStudent(String student) {
        for (int i = 0; i < numberOfStudents; i++) {
            if (students[i].equals(student)) {
                for (int j = i; j < numberOfStudents - 1; j++) {
                    students[j] = students[j + 1];
                }
                students[numberOfStudents - 1] = null;
                numberOfStudents--;
                break;
            }
        }
    }

    public void clear() {
        students = new String[INITIAL_SIZE];
        numberOfStudents = 0;
    }

    public static void main(String[] args) {
        HW3_2 course = new HW3_2("Java Programming");

        // 添加學生
        course.addStudent("Alice");
        course.addStudent("Bob");
        course.addStudent("Charlie");

        // 顯示學生
        System.out.println("學生列表: ");
        for (String student : course.getStudents()) {
            System.out.println(student);
        }

        // 移除一個學生
        course.dropStudent("Bob");
        System.out.println("移除Bob後的學生列表: ");
        for (String student : course.getStudents()) {
            System.out.println(student);
        }

        // 清空所有學生
        course.clear();
        System.out.println("清除所有學生後的數量: " + course.getNumberOfStudents());
    }
}
