package dao.impl;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import utils.JDBCUtils;

import java.sql.Connection;
import java.util.List;

public abstract class BaseDAO {

    //使用DbUtils操作数据库
    private final QueryRunner queryRunner = new QueryRunner();

    /**
     * update() 方法用来执行:insert/update/delete语句
     * @param sql
     * @param args
     * @return 若返回-1执行失败，其他数值表示影响的行数
     */
    public int update(String sql, Object...args){
        Connection connection = null;
        try {
            connection = JDBCUtils.getConnection();
            return queryRunner.update(connection, sql, args);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.close(connection);
        }
        return -1;
    }

    /**
     * 查询返回一个javaBean的sql语句
     * @param type 返回的对象类型
     * @param sql  执行的sql语句
     * @param args sql对应的参数值（占位符填充）
     * @param <T>  返回的类型的泛型
     * @return
     */
    public <T> T queryForOne(Class<T> type,String sql, Object...args){
        Connection connection = null;
        try {
            connection = JDBCUtils.getConnection();
            return queryRunner.query(connection,sql,new BeanHandler<T>(type),args);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.close(connection);
        }
        return null;
    }

    /**
     * 查询返回多个javaBean的sql语句
     * @param type
     * @param sql
     * @param args
     * @param <T>
     * @return
     */
    public <T> List<T> queryForList(Class<T> type, String sql, Object...args){
        Connection connection = null;
        try {
            connection = JDBCUtils.getConnection();
            return queryRunner.query(connection,sql,new BeanListHandler<T>(type),args);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.close(connection);
        }
        return null;
    }

    /**
     * 执行返回一行一列的sql
     * @param sql
     * @param args
     * @return
     */
    public Object queryForSingleValue(String sql, Object...args){

        Connection connection = null;
        try {
            connection = JDBCUtils.getConnection();
            return queryRunner.query(connection,sql,new ScalarHandler(),args);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.close(connection);
        }
        return null;

    }

}
