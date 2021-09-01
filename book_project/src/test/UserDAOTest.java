package test;

import dao.UserDAO;
import dao.impl.UserDAOImpl;
import org.junit.Test;
import pojo.User;

import static org.junit.Assert.*;

public class UserDAOTest {

    @Test
    public void queryUserByUsername() {
        UserDAO userDAO = new UserDAOImpl();
//        if(userDAO.queryUserByUsername("admin")==null){
//            System.out.println("用户名可用！");
//        }
//        else {
//            System.out.println("用户名已存在！");
//        }
        User user = userDAO.queryUserByUsername("admin");
        System.out.println(user);
    }

    @Test
    public void queryUserByUsernameAndPassword() {
        UserDAO userDAO = new UserDAOImpl();
        if(userDAO.queryUserByUsernameAndPassword("admin","admin")==null){
            System.out.println("用户密码错误！");
        }
        else {
            System.out.println("可登录！");
        }
    }

    @Test
    public void savaUser() {
        UserDAO userDAO = new UserDAOImpl();
        User user = new User(null,"nebula","nebula","nebula@163.com");
        System.out.println(userDAO.savaUser(user));
    }
}