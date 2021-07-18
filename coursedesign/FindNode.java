package jsj.hhtc.coursedesign;

public class FindNode {
    public static boolean existName = false;
    public static boolean existDepartment = false;
    public static void search() {
        System.out.println("1.通过工号查找\n2.通过姓名查找\n3.通过院系查找");
        switch (BinaryTree.scanner.nextInt()) {
            case 1:
                searchByJobNumber();
                break;
            case 2:
                searchByName();
                break;
            case 3:
                searchByDepartment();
                break;
            default:
                break;
        }
    }

    private static void findNodeByJobNumber(int jobNumber) {
        BinaryTree.binaryTreeIsNull(BinaryTree.root);
        BinaryTreeNode current = BinaryTree.root;
        while (current != null) {
            if (current.e.jobNumber > jobNumber) {
                current = current.left;
            } else if (current.e.jobNumber < jobNumber) {
                current = current.right;
            } else if (current.e.jobNumber == jobNumber) {
                System.out.println(current.e.toString());
                return;
            }
        }
        System.out.println("没有找到该工号对应的员工");
    }

    private static void searchByJobNumber() {
        System.out.println("请输入员工的工号");
        int jobNumber = BinaryTree.scanner.nextInt();
        findNodeByJobNumber(jobNumber);
    }

    private static void searchByName() {
        System.out.println("请输入员工的姓名");
        String name = BinaryTree.scanner.next();
        if (BinaryTree.binaryTreeIsNull(BinaryTree.root)) {
            System.out.println("当前二叉树为空");
            return;
        }
        postOrderForName(BinaryTree.root, name);
        if (!existName)
            System.out.println("没有找到该姓名对应的员工\n");
        existName = false;
    }

    private static void searchByDepartment() {
        System.out.println("请输入员工的院系");
        String department = BinaryTree.scanner.next();
        if (BinaryTree.binaryTreeIsNull(BinaryTree.root)) {
            System.out.println("当前二叉树为空");
            return;
        }
        postOrderForDepartment(BinaryTree.root, department);
        if (!existDepartment)
            System.out.println("没有找到该院系对应的员工\n");
        existDepartment = false;

    }

    /**
     * 后序遍历二叉树，来检查是否含有指定姓名的成员
     *
     * @param current 当前所处的节点位置
     * @param name    查找姓名对应的员工
     */
    private static void postOrderForName(BinaryTreeNode current, String name) {
        if (current != null) {
            if (current.left != null)
                postOrderForName(current.left, name);

            if (current.right != null)
                postOrderForName(current.right, name);

            if (current.e.name.equals(name)) {
                System.out.println(current.e.toString());
                existName = true;
            }
        }

    }

    /**
     * 后续遍历二叉树，查找是否有在该院系的员工
     *
     * @param current    遍历二叉树当前所在的节点位置
     * @param department 查找该院系对应的员工
     */
    private static void postOrderForDepartment(BinaryTreeNode current, String department) {
        if (current != null) {
            if (current.left != null)
                postOrderForDepartment(current.left, department);

            if (current.right != null)
                postOrderForDepartment(current.right, department);

            if (current.e.department.equals(department)) {
                System.out.println(current.e.toString());
                existDepartment = true;
            }
        }
    }
}
