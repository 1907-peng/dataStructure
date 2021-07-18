package jsj.hhtc.coursedesign;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class InsertNode {
    protected static boolean existSameJobNum = false;
    /**
     * 通过键盘进行输入成员信息，并保存在文件中
     *
     * @throws IOException
     */
    public static void insert() throws IOException {
        char sex;
        String name;
        int jobNumber;
        String position;
        String department;

        String telephoneNumber;
        System.out.println("请按照工号" + " " + "姓名" + " " + "性别" + " " + "所在部门" + " " + "电话" + " " + "职务\n" + "各个字段之间用空格分开");
        jobNumber = BinaryTree.scanner.nextInt();
        name = BinaryTree.scanner.next();
        sex = BinaryTree.scanner.next().charAt(0);
        department = BinaryTree.scanner.next();
        telephoneNumber = BinaryTree.scanner.next();
        position = BinaryTree.scanner.next();
        Employee e = new Employee(jobNumber, name, sex, department, telephoneNumber, position);
        insertMember(BinaryTree.root, e);
        writeInTxt(e);
    }

    /**
     * 将新员工插入二叉树中
     * @param node 根节点
     * @param e 员工对象
     */
    public static void insertMember(BinaryTreeNode node, Employee e) {
        if (BinaryTree.root == null) {
            BinaryTree.root = new BinaryTreeNode(e, null, null);

        } else {
            if (e.jobNumber > node.e.jobNumber) {
                if (node.right == null)
                    node.right = new BinaryTreeNode(e, null, null);
                else
                    insertMember(node.right, e);
            } else if (e.jobNumber < node.e.jobNumber) {
                if (node.left == null)
                    node.left = new BinaryTreeNode(e, null, null);
                else
                    insertMember(node.left, e);
            } else {
                existSameJobNum = true;
                System.out.println("插入失败,存在有相同工号的员工！！！");
            }

        }


    }


    /**
     * 将新插入员工的信息存入文本文件中
     * @param e 员工对象
     * @throws IOException
     */
    private static void writeInTxt(Employee e) throws IOException {
        if (existSameJobNum) {
            existSameJobNum = false;
            return;
        }
        BufferedWriter outputStream = new BufferedWriter(new FileWriter("D:\\Project\\Java_IDEA\\demo\\file\\employeeInformation.txt", true));
        outputStream.write(e.getString());
        outputStream.close();
    }
}
