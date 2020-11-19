package jsj.hhtc.base;

import java.util.Scanner;

public class RunApplication {

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
        Scanner scanner = new Scanner(System.in);


        switch (scanner.nextInt()) {

            case 1:
                System.out.println(MemberService.add());
                operationTips();


                break;


            case 2:
                System.out.println(MemberService.delete());
                operationTips();


                break;

            case 3:
                System.out.println(MemberService.change());
                operationTips();


                break;

            case 4:
                System.out.println(MemberService.search());
                operationTips();

                break;

            case 5:
                System.exit(0);
                break;
            default:
                System.exit(0);
                break;
        }
    }
}
