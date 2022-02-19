import com.google.util.JDBCUtils;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCTest {
    @Test
    void test() throws SQLException, ClassNotFoundException {

        String sql = "select user_name , user_password from teacher";
        Connection connection = JDBCUtils.getConnection();

        PreparedStatement statement = connection.prepareStatement(sql);

        ResultSet rs = statement.executeQuery(sql);
        System.out.println(rs == null);


    }

}
