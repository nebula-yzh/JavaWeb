package utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.apache.commons.dbutils.DbUtils;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.util.Properties;

public class JDBCUtils {
    public static void main(String[] args) {
        Connection jdbc=null;
        try {
            jdbc = JDBCUtils.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(jdbc);

    }
    private static DataSource druidSource = null;
    static {
        Properties properties = new Properties();
        try {
            //读取jdbc.properties属性配置文件,类加载器
            InputStream is = JDBCUtils.class.getClassLoader().getResourceAsStream("jdbc.properties");
            properties.load(is);
            //创建数据库连接池
            druidSource = DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
     * 获取数据库连接池中的连接
     * @return 返回null，连接不成功，有值就是成功
     */
    public static Connection getConnection() throws Exception {
        Connection connection = druidSource.getConnection();
        return connection;
    }

    /**
     * 关闭连接
     * @param conn
     */
    public static void close(Connection conn){
        DbUtils.closeQuietly(conn);
    }


}
