package jsj.hhtc.coursedesign;

import java.util.Scanner;
import java.io.IOException;

public class RunApplication {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        init();
    }


    public static void init() throws IOException {
        BinaryTree.initBinaryTree();
        System.out.println("-----------Welcome To The Employee  Information Control System ---------");
        operationTips();
        while (true)
            functionService();
    }

    public static void operationTips() {
        System.out.println("1.插入成员\n2.查询成员\n3.输出所有成员\n4.修改成员\n5.删除成员\n6.输出二叉排序树\n7.quit");
    }

    public static void functionService() throws IOException {

        switch (scanner.nextInt()) {

            case 1:
                BinaryTree.insertMember();
                operationTips();
                break;

            case 2:
                BinaryTree.findMember();
                operationTips();
                break;

            case 3:
                BinaryTree.printMember();
                operationTips();
                break;

            case 4:
                BinaryTree.updateMember();
                operationTips();
                break;

            case 5:
                BinaryTree.deleteMember();
                operationTips();
                break;

            case 6:
                BinaryTree.printBinaryTree();
                operationTips();
                break;
            default:
                scanner.close();
                System.exit(0);
                break;
        }
    }
}
