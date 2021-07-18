package jsj.hhtc.base;

import com.google.util.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class StudentService {

    public static PreparedStatement preparedStatement;
    public static Connection connection;
    public static Scanner scanner = new Scanner(System.in);

    public static void addMember() {
        try {
            connection = JDBCUtils.getConnection();
            System.out.println("请依次输入姓名 , 年龄 , 院系 , 年级 , IP , 学号 并且每个数据之间用空格分开");
            String name = scanner.next();
            int age = scanner.nextInt();
            String department = scanner.next();
            String grade = scanner.next();
            String ipAddress = scanner.next();
            String studentID = scanner.next();
            String sql = "INSERT INTO info(name,age,department,grade,ipAddress,studentID) values(?,?,?,?,?,?)";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, name);
            preparedStatement.setInt(2, age);
            preparedStatement.setString(3, department);
            preparedStatement.setString(4, grade);
            preparedStatement.setString(5, ipAddress);
            preparedStatement.setString(6, studentID);
            int result = preparedStatement.executeUpdate();
            if (result > 0)
                System.out.println("成功插入新成员\n");
            else
                System.out.println("插入操作失败\n");

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {

            try {
                JDBCUtils.close(connection, preparedStatement);
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }

    }

    public static void deleteByStudentID() {
        try {

            connection = JDBCUtils.getConnection();
            System.out.println("请输入你想删除的成员学号：");
            String studentID = scanner.next();
            String sql = "DELETE FROM info where studentID = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, studentID);
            int result = preparedStatement.executeUpdate();
            if (result > 0) {
                System.out.println("成功删除该成员\n");
            } else
                System.out.println("删除操作失败\n");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                JDBCUtils.close(connection, preparedStatement);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

    public static void updateInformation() {
        try {
            connection = JDBCUtils.getConnection();
            boolean isUpdated = false;
            String sql = null;
            String updatedContent;

            System.out.println("请输入待修改成员的学号:");
            String studentID = scanner.next();
            System.out.println("请输入您想要进行修改的内容对应的数字序号：\n 1 name\n 2 age\n 3 department\n 4 grade\n 5 IP\n 6 StudentID");
            int operation = scanner.nextInt();

            if (operation == 1) {
                sql = "UPDATE info set name = ? where studentID = ?";
            } else if (operation == 2) {
                sql = "UPDATE info set age = ? where studentID = ?";
            } else if (operation == 3) {
                sql = "UPDATE info set department = ? where studentID = ?";
            } else if (operation == 4) {
                sql = "UPDATE info set grade = ? where studentID = ?";
            } else if (operation == 5) {
                sql = "UPDATE info set ipAddress = ? where studentID=?";
            } else if (operation == 6) {
                sql = "UPDATE info set studentID =? where studentID=?";
            } else
                System.out.println("请输入正确的操作序号！！\n");
            System.out.println("请输入更新后的内容：");
            updatedContent = scanner.next();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, updatedContent);
            preparedStatement.setString(2, studentID);
            int result = preparedStatement.executeUpdate();
            if (result > 0)
                System.out.println("成功更新成员信息！！\n");
            else
                System.out.println("更新失败！！！\n");

        } catch (SQLException e) {
            e.printStackTrace();
            try {
                connection.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }


    }

    public static void selectByStudentID() {
        try {
            boolean isExist = false;
            connection = JDBCUtils.getConnection();
            String sql = "SELECT * FROM info where studentID = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            System.out.println("请输入查询对象的学号：");
            String studentID = scanner.next();
            preparedStatement.setString(1, studentID);
            ResultSet resultSet = preparedStatement.executeQuery();
            ArrayList<Student> studentArrayList = new ArrayList<>();
            while (resultSet.next()) {
                isExist = true;
                studentArrayList.add(new Student(resultSet.getString(3), resultSet.getString(6), resultSet.getString(2), resultSet.getString(5), resultSet.getString(7), resultSet.getString(4)));
            }
            if (isExist == true) {
                System.out.println(studentArrayList);
                System.out.println("以上为根据条件查找到的所有成员\n");
            } else
                System.out.println("没有找到任何符合条件的成员\n");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }


}



