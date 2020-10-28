package jsj.hhtc.base;

import java.util.Scanner;

public class MemberService {
    private static int pointer = 0;
    private static int size = 0;
    private static String[][] storeInformation = new String[10][5];
    static Scanner scIp = new Scanner(System.in);
    static Scanner scChangeNumber = new Scanner(System.in);
    static Scanner scInformation = new Scanner(System.in);
    static Scanner scAnyInformation = new Scanner(System.in);


    /**
     * 判断基地成员数量达到上限
     *
     * @return true or false
     */
    private static boolean isFull() {
        if (size == 10) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 判断基地是否为空
     *
     * @return true or false
     */
    private static boolean isEmpty() {
        if (size == 0)
            return true;
        else
            return false;

    }

    /**
     * 用来寻找数组中空闲空间
     * 调用此方法说明一定有空闲的空间
     *
     * @return 有空闲的数组行
     */
    private static int searchFreeSpace() {
        int column = 0;
        int temp = 0;
        for (int row = 0; row < 10; row++) {
            if (storeInformation[row][column] == null) {
                temp = row;
                break;
            }

        }
        return temp;
    }

    /**
     * 计算得到所有符合keywords的成员数
     * 遍历二维数组，得到符合keywords的成员数量。
     *
     * @param keywords
     * @return成员数量
     */
    static int numberOfTotalPossibleMember(String keywords) {
        int total = 0;
        for (int row = 0; row < 10; row++) {
            for (int column = 0; column < 5; column++) {
                try {
                    if (storeInformation[row][column].equals(keywords)) {
                        total++;
                    }
                } catch (Exception e) {
                } finally {
                }
            }
        }
        return total;
    }

    /**
     * 输出所有成员
     */
    public static void outputAllMembers() {
        for (int row = 0; row < 10; row++) {

            System.out.println("姓名：" + storeInformation[row][0] + "院系：" + storeInformation[row][1] + "年级：" + storeInformation[row][2] + "班级：" + storeInformation[row][3] + "IP地址：" + storeInformation[row][4]);

        }
    }

    /**
     * 添加新成员
     *
     * @return 是否成功添加新成员
     */
    public static String add() {
        Scanner scAdd = new Scanner(System.in);

        String theWholeString;
        String[] stringSplit = new String[5];
        String name;
        String department;
        String grade;
        String classNumber;
        String ipAddress;

        System.out.println("请输入成员的相关信息：\n按照姓名 院系 年级 班级 ip地址 格式填写\n");

        theWholeString = scAdd.nextLine();
        stringSplit = theWholeString.split("\\ ");
        name = stringSplit[0];
        department = stringSplit[1];
        grade = stringSplit[2];
        classNumber = stringSplit[3];
        ipAddress = stringSplit[4];
        if (!isFull()) {
            Member member = new Member(name, department, grade, classNumber, ipAddress);
            pointer = searchFreeSpace();
            storeInformation[pointer][0] = member.name;
            storeInformation[pointer][1] = member.department;
            storeInformation[pointer][2] = member.grade;
            storeInformation[pointer][3] = member.classNumber;
            storeInformation[pointer][4] = member.ipAddress;
            size++;

            return ("新成员添加成功\n");
        } else {
            return ("人数已满，添加失败\n");
        }

    }

    public static String delete() {
        if (!isEmpty()) {

            int flag = 0;
            String ip;
            System.out.println("输入你想要删除的成员的IP地址");
            ip = scIp.nextLine();

            try {

                for (int row = 0; row < 10; row++) {
                    if (storeInformation[row][4] == null) {
                        continue;
                    }
                    if (storeInformation[row][4].equals(ip)) {
                        flag = 1;
                        pointer = row;
                        break;
                    }
                }

            } catch (Exception e) {

            } finally {

                if (flag == 1) {
                    for (int column = 0; column < 5; column++) {
                        storeInformation[pointer][column] = null;
                    }
                    size--;
                    return ("已移除\n");
                } else {
                    return ("没有找到该用户\n");
                }
            }
        } else {
            return ("基地无成员，不能进行删除操作\n");
        }

    }

    /**
     * 改变基地成员信息
     *
     * @return 信息修改情况
     */
    public static String change() {
        boolean existMember = false;
        String ip;

        if (!isEmpty()) {
            System.out.println("输入想要改变的对象ip");
            ip = scIp.nextLine();

            for (int row = 0; row < 10; row++) { //找到对象
                int column = 4;
                try {
                    if (storeInformation[row][column] == null) {
                        continue;
                    }
                    if (storeInformation[row][column].equals(ip)) {
                        pointer = row;
                        existMember = true;
                        break;
                    }
                } catch (Exception e) {
                } finally {
                }

            }
            if (existMember) {
                System.out.println("输入你想要改变的内容对应的数字\n 1 姓名\n 2 院系 \n 3 年级 \n 4 班级 \n 5 IP地址\n");
                switch (scChangeNumber.nextInt()) {
                    case 1:
                        System.out.println("请输入新的姓名：");
                        storeInformation[pointer][0] = scInformation.nextLine();
                        break;
                    case 2:
                        System.out.println("请输入新的院系：");
                        storeInformation[pointer][1] = scInformation.nextLine();
                        break;
                    case 3:
                        System.out.println("请输入新的年级：");
                        storeInformation[pointer][2] = scInformation.nextLine();
                        break;
                    case 4:
                        System.out.println("请输入新的班级：");
                        storeInformation[pointer][3] = scInformation.nextLine();
                        break;
                    case 5:
                        System.out.println("请输入新的IP地址：");
                        storeInformation[pointer][4] = scInformation.nextLine();
                    default:
                        System.out.println("输入错误，结束输入\n");
                        break;
                }
                return ("姓名：" + storeInformation[pointer][0] + " " + "院系：" + storeInformation[pointer][1] + " " + "年级：" + storeInformation[pointer][2] + " " + "班级：" + storeInformation[pointer][3] + " " + "IP地址：" + storeInformation[pointer][4]);
            } else
                return ("基地没有该成员，修改失败\n");

        } else {
            return ("基地人员为空，不能修改\n");
        }


    }


    public static String search() { //如果基地里面有两个人都是 计算机 院系的，那么输出应该是两个人的信息。
        String keyWords;
        int quantityOfPossibleMember = 0;
        if (!isEmpty()) {
            System.out.println("请输入你想查找的某个成员对应的任何一个信息，比如院系 姓名");
            keyWords = scAnyInformation.next();
            quantityOfPossibleMember = numberOfTotalPossibleMember(keyWords);

            int[] storeOrderOfMember = new int[quantityOfPossibleMember];//用来存放成员的所在行
            try {
                for (int row = 0, temp = 0; row < 10; row++) {
                    for (int column = 0; column < 5; column++) {
                        if (storeInformation[row][column] == null) {
                            continue;
                        }
                        if (storeInformation[row][column].equals(keyWords)) {
                            storeOrderOfMember[temp] = row;
                            temp++;
                        }
                    }
                }
            } catch (Exception e) {
            } finally {
            }

            if (quantityOfPossibleMember != 0) {

                for (int row = 0; row < quantityOfPossibleMember; row++) {
                    System.out.println("姓名：" + storeInformation[storeOrderOfMember[row]][0] + " " + "院系：" + storeInformation[storeOrderOfMember[row]][1] + " " + "年级：" + storeInformation[storeOrderOfMember[row]][2] + " " + "班级：" + storeInformation[storeOrderOfMember[row]][3] + " " + "IP地址：" + storeInformation[storeOrderOfMember[row]][4] + "\n");
                }
                System.out.println("所有符合条件的可能成员数量： " + quantityOfPossibleMember);
                return ("以上为根据你输入的信息，查找到的所有可能成员及其信息\n");

            } else {
                System.out.println("所有符合条件的可能成员数量： " + quantityOfPossibleMember);
                return ("没有查询到与你输入的信息相匹配的成员\n");
            }


        } else {
            return ("基地没有任何成员，查询失败\n");
        }
    }


}
