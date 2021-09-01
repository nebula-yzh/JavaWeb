package test;

import org.junit.Test;
import utils.JDBCUtils;

import java.sql.Connection;

public class JDBCUtilsTest {
    @Test
    public void testJDBCUtils() {
        for (int i = 0; i < 20; i++){
            Connection connection = null;
            try {
                connection = JDBCUtils.getConnection();
                System.out.println(connection);
            } catch (Exception e) {
                e.printStackTrace();
            }finally {
                JDBCUtils.close(connection);
            }

        }
    }
}
