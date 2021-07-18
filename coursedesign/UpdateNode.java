package jsj.hhtc.coursedesign;

import java.io.*;

public class UpdateNode {
    public static void update() throws IOException {
        boolean existMember = false;
        BinaryTreeNode current = BinaryTree.root;
        BinaryTreeNode waitedForUpdateMember = null;
        if (BinaryTree.binaryTreeIsNull(BinaryTree.root)) {
            System.out.println("二叉树为空，无法进行更新");
            return;
        }
        System.out.println("请输入员工的工号");
        int jobNumber = BinaryTree.scanner.nextInt();
        while (current != null) {
            if (current.e.jobNumber > jobNumber) {
                current = current.left;
            } else if (current.e.jobNumber < jobNumber) {
                current = current.right;
            } else if (current.e.jobNumber == jobNumber) {
                existMember = true;
                waitedForUpdateMember = current;
                break;
            }
        }
        if (existMember) {
            System.out.println("请输入你想要修改的员工的内容\n1.所在部门\n2.电话号码\n3.职务");
            switch (BinaryTree.scanner.nextInt()) {
                case 1:
                    updateDepartment(waitedForUpdateMember);
                    break;
                case 2:
                    updateTelephoneNum(waitedForUpdateMember);
                    break;
                case 3:
                    updatePosition(waitedForUpdateMember);
                    break;
                default:
                    System.out.println("请输入规定的修改内容对应的编号");
                    break;
            }

        } else
            System.out.println("更新失败，没有找到该工号对应的员工");

    }
    private static void updateDepartment(BinaryTreeNode member) throws IOException {
        String formerDepartment;
        formerDepartment = member.e.department;
        System.out.println("请输入新的系部名:");
        String newDepartment = BinaryTree.scanner.next();
        member.e.department = newDepartment;
        System.out.println("修改完成！！！");
        updateTxtDepartment(member.e.jobNumber, formerDepartment, newDepartment);//同时修改文本文件中的内容

    }

    private static void updateTelephoneNum(BinaryTreeNode member) throws IOException {
        String formerTelephoneNum;
        formerTelephoneNum = member.e.telephoneNumber;
        System.out.println("请输入新的电话号码：");
        String newTelephoneNum = BinaryTree.scanner.next();
        member.e.telephoneNumber = newTelephoneNum;
        System.out.println("修改完成");
        updateTxtTelephoneNum(member.e.jobNumber, formerTelephoneNum, newTelephoneNum);//修改文本中的电话号码
    }

    private static void updatePosition(BinaryTreeNode member) throws IOException {
        String formerPosition;
        formerPosition = member.e.position;
        System.out.println("请输入新的职位");
        String newPosition = BinaryTree.scanner.next();
        member.e.position = newPosition;
        System.out.println("修改完成");
        updateTxtPosition(member.e.jobNumber, formerPosition, newPosition);//修改文本中的职位
    }

    private static void updateTxtPosition(int destJobNum, String formerPosition, String newPosition) throws IOException {
        int jobNum;
        String line;
        File source = new File("D:\\Project\\Java_IDEA\\demo\\file\\temp.txt");
        File destination = new File("D:\\Project\\Java_IDEA\\demo\\file\\employeeInformation.txt");
        BufferedReader in = new BufferedReader(new FileReader("D:\\Project\\Java_IDEA\\demo\\file\\employeeInformation.txt"));
        PrintWriter out = new PrintWriter(new FileWriter("D:\\Project\\Java_IDEA\\demo\\file\\temp.txt"));
        while ((line = in.readLine()) != null) {
            String[] splitArray = line.split(" ");
            jobNum = Integer.parseInt(splitArray[0]);
            if (jobNum == destJobNum) {
                out.println(line.replace(formerPosition, newPosition));
            } else
                out.println(line);
        }
        in.close();
        out.close();
        BinaryTree.copyFile(source, destination);
    }

    private static void updateTxtDepartment(int destJobNum, String formerDepartment, String newDepartment) throws IOException {
        int jobNum;
        String line;
        File source = new File("D:\\Project\\Java_IDEA\\demo\\file\\temp.txt");
        File dest = new File("D:\\Project\\Java_IDEA\\demo\\file\\employeeInformation.txt");
        BufferedReader in = new BufferedReader(new FileReader("D:\\Project\\Java_IDEA\\demo\\file\\employeeInformation.txt"));
        PrintWriter out = new PrintWriter(new FileWriter("D:\\Project\\Java_IDEA\\demo\\file\\temp.txt"));
        while ((line = in.readLine()) != null) {
            String[] splitArray = line.split(" ");
            jobNum = Integer.parseInt(splitArray[0]);
            if (jobNum == destJobNum) {
                out.println(line.replace(formerDepartment, newDepartment));
            } else
                out.println(line);
        }
        in.close();
        out.close();
        BinaryTree.copyFile(source, dest);
    }

    private static void updateTxtTelephoneNum(int destJobNum, String formerTelephoneNum, String newTelephoneNum) throws IOException {
        int jobNum;
        String line;
        File source = new File("D:\\Project\\Java_IDEA\\demo\\file\\temp.txt");
        File dest = new File("D:\\Project\\Java_IDEA\\demo\\file\\employeeInformation.txt");
        BufferedReader in = new BufferedReader(new FileReader("D:\\Project\\Java_IDEA\\demo\\file\\employeeInformation.txt"));
        PrintWriter out = new PrintWriter(new FileWriter("D:\\Project\\Java_IDEA\\demo\\file\\temp.txt"));
        while ((line = in.readLine()) != null) {
            String[] splitArray = line.split(" ");
            jobNum = Integer.parseInt(splitArray[0]);
            if (jobNum == destJobNum) {
                out.println(line.replace(formerTelephoneNum, newTelephoneNum));
            } else
                out.println(line);
        }
        in.close();
        out.close();
        BinaryTree.copyFile(source, dest);
    }
}
