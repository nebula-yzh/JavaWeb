package test;

import org.junit.Test;
import pojo.User;
import service.UserService;
import service.impl.UserServiceImpl;

import static org.junit.Assert.*;

public class UserServiceTest {

    @Test
    public void registerUser() {
        UserService userService = new UserServiceImpl();
        userService.registerUser(new User(null,"yzh","yzh","yzh@qq.com"));
    }

    @Test
    public void login() {
        UserService userService = new UserServiceImpl();
        User user = userService.login(new User(null,"nebula","nebula",null));
        System.out.println(user);
    }

    @Test
    public void existsUsername() {
        UserService userService = new UserServiceImpl();
        boolean flag = userService.existsUsername("admin");
        System.out.println(flag);
    }
}