package jsj.hhtc.base;

import java.util.Scanner;

public class RunApplication {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        init();
    }

    public static void init() {

        System.out.println("-----------Welcome To The XueYa Base Information Control System ---------");

        operationTips();
        while (true) {
            functionService();
        }
    }

    public static void operationTips() {
        System.out.println("1.增加成员\n2.删除成员\n3.改变成员的信息\n4.查找成员\n5.quit");
    }


    public static void functionService() {


        switch (scanner.nextInt()) {

            case 1:
                StudentService.addMember();
                operationTips();
                break;

            case 2:
                StudentService.deleteByStudentID();
                operationTips();
                break;

            case 3:
                StudentService.updateInformation();
                operationTips();
                break;

            case 4:
                StudentService.selectByStudentID();
                operationTips();
                break;

            case 5:
                scanner.close();
                System.exit(0);
                break;
            default:
                scanner.close();
                System.exit(0);
                break;
        }
    }
}
