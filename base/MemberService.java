package jsj.hhtc.base;

import java.util.Scanner;

/**
 * 双链表实现数据的存储
 */
public class MemberService {
    private static int totalNumber = 0;
    private static Member theHeadPointer;       //用来指向链表的第一个元素
    private static Member theLastMemberPointer;
    private static Member theTraversalPointer;  //用来遍历整个链表的指针

    public static Scanner scInformation = new Scanner(System.in);


    public static String add() {
        String name;
        String department;
        String grade;
        String classNumber;
        String ipAddress;
        System.out.println("请输入成员的相关信息：\n按照姓名 院系 年级 班级 ip地址 格式填写");
        name = scInformation.next();
        department = scInformation.next();
        grade = scInformation.next();
        classNumber = scInformation.next();
        ipAddress = scInformation.next();

        if (!existSameIpAddress(ipAddress)) {
            Member newMember = new Member(name, department, grade, classNumber, ipAddress);

            if (totalNumber > 0) {
                newMember.former = theLastMemberPointer;
                theLastMemberPointer.next = newMember;
                theLastMemberPointer = newMember;
                totalNumber++;
            }

            if (totalNumber == 0) {
                theHeadPointer = newMember;
                theLastMemberPointer = newMember;
                theTraversalPointer = newMember;
                totalNumber++;
            }
            return "新成员添加成功\n";
        } else {
            recoverTheTraversalPointer();
            return "此ip已经有人使用，添加失败\n";
        }


    }


    public static String delete() {
        System.out.println("请输入你想删除的成员ipAddress");
        String ipAddress = scInformation.next();
        if (totalNumber == 1 && theHeadPointer.ipAddress.equals(ipAddress)) {
            theHeadPointer = null;
            theTraversalPointer = null;
            theLastMemberPointer = null;
            totalNumber--;
            return "成功删除该成员\n";
        }

        if (totalNumber == 1 && !theHeadPointer.ipAddress.equals(ipAddress)) {
            return "删除失败，没有该成员\n";
        }

        if (totalNumber > 1) {
            do {
                //若遍历指针在头节点
                if (theTraversalPointer.ipAddress.equals(ipAddress) && theTraversalPointer == theHeadPointer) {
                    theHeadPointer = theTraversalPointer.next;
                    theTraversalPointer.next.former = null;
                    theTraversalPointer = theTraversalPointer.next;
                    totalNumber--;
                    return "删除成功\n";
                }
                if (theTraversalPointer.ipAddress.equals(ipAddress) && theTraversalPointer != theLastMemberPointer) {
                    theTraversalPointer.former.next = theTraversalPointer.next; //Here is a problem
                    theTraversalPointer.next.former = theTraversalPointer.former;
                    totalNumber--;
                    recoverTheTraversalPointer();
                    return "删除成功\n";
                }

                //若遍历指针在最后一个节点
                if (theTraversalPointer.ipAddress.equals(ipAddress) && theTraversalPointer == theLastMemberPointer) {
                    theTraversalPointer.former.next = theTraversalPointer.next;
                    totalNumber--;
                    recoverTheTraversalPointer();
                    return "删除成功\n";
                }

            } while ((theTraversalPointer = theTraversalPointer.next) != null);
            recoverTheTraversalPointer();

        }

        return "删除失败，没有找到该成员\n";
    }


    public static String change() {
        String ipAddress;
        int numberOfOperation;
        String newInformation;
        System.out.println("请输入你想要改变成员的ipAddress");
        ipAddress = scInformation.next();

        while (true) {
            if (theTraversalPointer == null) {
                recoverTheTraversalPointer();
                return "没有找到你想要改变的成员";
            }

            if (theTraversalPointer.ipAddress.equals(ipAddress)) {
                break;
            }

            theTraversalPointer = theTraversalPointer.next;
        }

        while (true) {

            System.out.println("1.姓名\n2.院系\n3.年级\n4.班级\n5.ip地址\n6.结束更改");
            System.out.println("请输入你想要改变对象信息对应的数字");
            numberOfOperation = scInformation.nextInt();
            System.out.println("请输入新的信息：");
            newInformation = scInformation.next();

            if (numberOfOperation == 1)
                theTraversalPointer.name = newInformation;
            if (numberOfOperation == 2)
                theTraversalPointer.department = newInformation;
            if (numberOfOperation == 3)
                theTraversalPointer.grade = newInformation;
            if (numberOfOperation == 4)
                theTraversalPointer.classNumber = newInformation;
            if (numberOfOperation == 5)
                theTraversalPointer.ipAddress = newInformation;
            if (numberOfOperation == 6)
                break;
        }
        recoverTheTraversalPointer();
        return "成员信息已更改";

    }


    public static String search() {  //根据某一个信息，找到所有符合条件的成员
        int flag = 0;
        String information;
        System.out.println("请输入一条你想要寻找的成员对应的信息，如姓名，ipAddress");
        information = scInformation.next();

        while (theTraversalPointer != null) {
            if (theTraversalPointer.name.equals(information) || theTraversalPointer.department.equals(information) || theTraversalPointer.grade.equals(information) || theTraversalPointer.classNumber.equals(information) || theTraversalPointer.ipAddress.equals(information)) {
                flag = 1;
                System.out.println(theTraversalPointer.toString());
            }
            theTraversalPointer = theTraversalPointer.next;
        }
        recoverTheTraversalPointer();

        if (flag == 0)
            return "没有找到任何符合条件的成员\n";
        else
            return "以上为所有符合查找条件的成员\n";


    }

    /**
     * 判断是否存在有相同ipAdress的两个人
     *
     * @param ipAddress
     * @return true or false
     */
    private static boolean existSameIpAddress(String ipAddress) {

        while (theTraversalPointer != null) {
            if (theTraversalPointer.ipAddress.equals(ipAddress)) {
                recoverTheTraversalPointer();
                return true;
            }
            theTraversalPointer = theTraversalPointer.next;
        }
        recoverTheTraversalPointer();
        return false;
    }

    private static void recoverTheTraversalPointer() {
        theTraversalPointer = theHeadPointer;
    }
}



