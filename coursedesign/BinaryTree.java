package jsj.hhtc.coursedesign;

import java.io.*;
import java.util.Scanner;
import java.nio.channels.FileChannel;

class BinaryTree {
    public static BinaryTreeNode root;
    public static Scanner scanner = new Scanner(System.in);

    /**
     * 将文本文件中的已经存在的员工信息，组织成为一个二叉树
     */
    public static void initBinaryTree() {
        String fileLine;
        BufferedReader inputStream = null;

        try {
            inputStream = new BufferedReader(new FileReader("D:\\Project\\Java_IDEA\\demo\\file\\employeeInformation.txt"));
            while ((fileLine = inputStream.readLine()) != null) {
                String[] content = fileLine.split(" ");
                Employee e = new Employee(Integer.parseInt(content[0]), content[1], content[2].charAt(0), content[3], content[4], content[5]);
                InsertNode.insertMember(BinaryTree.root, e);
            }

        } catch (IOException io) {
            System.out.println("File IO exception" + io.getMessage());
        } finally {

            try {
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (IOException io) {
                System.out.println("Issue closing the Files" + io.getMessage());
            }
        }
    }

    public static void insertMember() throws IOException {
        //FIXME 可以插入工号相同的成员
        InsertNode.insert();
    }

    public static void deleteMember() throws IOException {
        DeleteNode.delete();
    }

    public static void updateMember() throws IOException {
        UpdateNode.update();
    }

    public static void findMember() {
        FindNode.search();
    }

    public static void printBinaryTree() {
        PrintBinaryTree.print();
    }

    public static void copyFile(File source, File dest) throws IOException {
        FileChannel inputChannel = null;
        FileChannel outputChannel = null;
        try {
            inputChannel = new FileInputStream(source).getChannel();
            outputChannel = new FileOutputStream(dest).getChannel();
            outputChannel.transferFrom(inputChannel, 0, inputChannel.size());
        } finally {
            inputChannel.close();
            outputChannel.close();
        }
    }

    public static void printMember() {
        PrintOperation.printInformationOfKeyWords();
    }

    public static boolean binaryTreeIsNull(BinaryTreeNode root) {
        return (root == null) ? true : false;
    }

}
