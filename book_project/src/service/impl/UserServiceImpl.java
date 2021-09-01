package service.impl;

import dao.UserDAO;
import dao.impl.UserDAOImpl;
import pojo.User;
import service.UserService;

public class UserServiceImpl implements UserService {

    private UserDAO userDAO = new UserDAOImpl();

    @Override
    public void registerUser(User user) {
        userDAO.savaUser(user);
    }

    @Override
    public User login(User user) {
        return userDAO.queryUserByUsernameAndPassword(user.getUsername(), user.getPassword());
    }

    @Override
    public boolean existsUsername(String username) {
        if (userDAO.queryUserByUsername(username) == null){
            //等于null 未查询到，表示可用
            return false;
        }
        return true;

    }
}
