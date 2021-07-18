package jsj.hhtc.coursedesign;

import java.io.*;

public class DeleteNode {
    public static void delete() throws IOException {
        int jobNum;
        String line;
        boolean existJobNum = false;
        System.out.println("请输入您要删除的员工的工号");
        int destJobNum = BinaryTree.scanner.nextInt();
        File source = new File("D:\\Project\\Java_IDEA\\demo\\file\\temp.txt");
        File destination = new File("D:\\Project\\Java_IDEA\\demo\\file\\employeeInformation.txt");
        BufferedReader in = new BufferedReader(new FileReader("D:\\Project\\Java_IDEA\\demo\\file\\employeeInformation.txt"));
        PrintWriter out = new PrintWriter(new FileWriter("D:\\Project\\Java_IDEA\\demo\\file\\temp.txt"));
        while ((line = in.readLine()) != null) {
            String[] splitArray = line.split(" ");
            jobNum = Integer.parseInt(splitArray[0]);
            if (jobNum == destJobNum) {
                existJobNum = deleteNode(jobNum);
                out.print("");
                System.out.println("成功删除该成员！");
            } else
                out.println(line);
        }
        if (!existJobNum)
            System.out.println("没有该工号对应的员工，删除失败");
        in.close();
        out.close();
        BinaryTree.copyFile(source, destination);
    }

    public static boolean deleteNode(int key) {
        BinaryTreeNode parent = BinaryTree.root;
        BinaryTreeNode current = BinaryTree.root;
        boolean isLeftChild = true;

        while (current.e.jobNumber != key) {
            parent = current;
            if (key < current.e.jobNumber) {
                isLeftChild = true;
                current = current.left;
            } else {
                isLeftChild = false;
                current = current.right;
            }
            if (current == null)
                return false;
        }

        if (current.left == null && current.right == null) {  // 表示要删除的节点是叶子节点，没有左右孩子
            if (current == BinaryTree.root)
                BinaryTree.root = null;
            else if (isLeftChild)    // 表示要删除的节点是左叶子节点
                parent.left = null;
            else   // 表示要删除的节点是右叶子节点
                parent.right = null;


        } else if (current.right == null) { // 表示要删除的节点只有左孩子
            if (current == BinaryTree.root)
                BinaryTree.root = current.left;
            else if (isLeftChild)  // 表示要删除的结点是左子节点
                parent.left = current.left;
            else  // 表示要删除的结点是右子节点
                parent.right = current.left;


        } else if (current.left == null) { // 表示要删除的节点只有右孩子
            if (current == BinaryTree.root)
                BinaryTree.root = current.right;
            else if (isLeftChild)  // 表示要删除的结点是右子节点
                parent.left = current.right;
            else  // 表示要删除的结点是右子节点
                parent.right = current.right;
        } else {
            BinaryTreeNode successor = getSuccessor(current);
            if (current == BinaryTree.root)
                BinaryTree.root = successor;
            else if (isLeftChild)
                parent.left = successor; // 把current从它父节点的leftChild字段移除，把这个字段置为successor
            else
                parent.right = successor; // 把current从它父节点的rightChild字段移除，把这个字段置为successor

            successor.left = current.left; // 把current的左子节点从current移除,successor的左子节点指向的位置设为current的左子节点
        }
        return true;
    }

    private static BinaryTreeNode getSuccessor(BinaryTreeNode delNode) {
        BinaryTreeNode successorParent = delNode;
        BinaryTreeNode successor = delNode;
        BinaryTreeNode current = delNode.right;

        while (current != null) {
            successorParent = successor;
            successor = current;
            current = current.left;
        }
        if (successor != delNode.right) {  // 如果后继节点是delNode右子节点的左后代
            successorParent.left = successor.right; // 把后继父节点的leftChild字段设置为successor的右子节点
            successor.right = delNode.right; // 把successor的rightChild字段置为要删除节点的右子节点
        }
        return successor;

    }
}
