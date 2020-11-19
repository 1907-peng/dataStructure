package jsj.hhtc.base;

public class Member {
    String name;
    String department;
    String grade;
    String classNumber;
    String ipAddress;
    Member next;
    Member former;


    public Member(String name, String department, String grade, String classNumber, String ipAddress) {
        this.name = name;
        this.department = department;
        this.grade = grade;
        this.classNumber = classNumber;
        this.ipAddress = ipAddress;
        this.next = null;
        this.former = null;

    }

    @Override
    public String toString() {
        return "Member{" +
                "name='" + name + '\'' +
                ", department='" + department + '\'' +
                ", grade='" + grade + '\'' +
                ", classNumber='" + classNumber + '\'' +
                ", ipAddress='" + ipAddress + '\'' +
                '}'+"\n";
    }
}
