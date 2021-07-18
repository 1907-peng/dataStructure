package jsj.hhtc.coursedesign;

import java.util.*;
import java.text.Collator;

public class PrintOperation {
    public static void printInformationOfKeyWords() {
        System.out.println("请输入排序方式\n1.按照工号\n2.按照姓名\n3.按照部门");
        switch (BinaryTree.scanner.nextInt()) {
            case 1:
                printInformationOfJobNum(BinaryTree.root);
                break;
            case 2:
                printInformationOfName();
                break;
            case 3:
                printInformationOfDepartment();
                break;
        }
    }

    /**
     * 按照员工工号，从小到大输出所有员工信息
     *
     * @param root 二叉树根节点
     */
    private static void printInformationOfJobNum(BinaryTreeNode root) {
        if (root != null) {
            printInformationOfJobNum(root.left);
            System.out.println(root.e.toString());
            printInformationOfJobNum(root.right);
        }
    }

    /**
     * 按照姓名排序输出所有员工
     */
    private static void printInformationOfName() {
        List<Employee> list = new ArrayList<>();
        addMemberToList(BinaryTree.root, list);
        Collections.sort(list, new Comparator<Employee>() {
            @Override
            public int compare(Employee t1, Employee t2) {
                return Collator.getInstance(Locale.CHINESE).compare(t1.name, t2.name);
            }
        });
        for (int i = 0; i < list.size(); i++)
            System.out.println(list.get(i));
    }

    /**
     * 按照员工所属院系排序输出所有员工
     */
    private static void printInformationOfDepartment() {
        List<Employee> list = new ArrayList<>();
        addMemberToList(BinaryTree.root, list);
        Collections.sort(list, new Comparator<Employee>() {
            @Override
            public int compare(Employee t1, Employee t2) {
                return Collator.getInstance(Locale.CHINESE).compare(t1.department, t2.department);
            }
        });
        for (int i = 0; i < list.size(); i++)
            System.out.println(list.get(i));
    }

    /**
     * 将二叉树中所有节点的员工放入列表
     *
     * @param node 二叉树结点
     * @param list 存放员工的队列
     */
    private static void addMemberToList(BinaryTreeNode node, List list) {
        if (node != null) {
            list.add(node.e);
            addMemberToList(node.left, list);
            addMemberToList(node.right, list);
        }
    }
}
