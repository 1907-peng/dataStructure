package jsj.hhtc.base;

public class Student {

    private String ip;
    private String age;
    private String name;
    private String grade;
    private String studentID;
    private String department;

    public Student(String age, String ip, String name, String grade, String studentID, String department) {
        this.age = age;
        this.ip = ip;
        this.name = name;
        this.grade = grade;
        this.studentID = studentID;
        this.department = department;
    }

    @Override
    public String toString() {
        return '\n' + "Name:" + this.name + '\t' + "Age:" + this.age + '\t' + "IP:" + this.ip + '\t' + "Grade:" + this.grade + '\t' + "StudentID:" + this.studentID + '\t' + "Department:" + this.department + '\n';
    }
}
