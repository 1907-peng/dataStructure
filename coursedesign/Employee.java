package jsj.hhtc.coursedesign;

public class Employee {
    char sex;
    String name;
    int jobNumber;
    String position;
    String department;
    String telephoneNumber;


    public Employee(int jobNumber, String name, char sex, String department, String telephoneNumber, String position) {
        this.jobNumber = jobNumber;
        this.name = name;
        this.sex = sex;
        this.department = department;
        this.telephoneNumber = telephoneNumber;
        this.position = position;
    }

    public String toString() {
        return "JobNumber:" + this.jobNumber + '\t' + "Name:" + this.name + '\t' + "Sex:" + this.sex + '\t' + "Department:" + this.department + '\t' + "TelephoneNumber:" + this.telephoneNumber + '\t' + "Position:" + this.position;
    }

    public String getString() {
        return this.jobNumber + " " + this.name + " " + this.sex + " " + this.department + " " + this.telephoneNumber + " " + this.position + "\n";
    }

}
