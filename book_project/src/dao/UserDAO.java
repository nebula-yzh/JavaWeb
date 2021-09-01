package dao;

import pojo.User;

public interface UserDAO{

    /**
     * 根据用户名查询用户信息
     * @param username 用户名
     * @return 若返回null无该用户
     */
    public User queryUserByUsername(String username);

    /**
     * 根据用户名和密码查询用户
     * @param username
     * @param password
     * @return 若返回null，用户名或密码错误
     */
    public User queryUserByUsernameAndPassword(String username, String password);

    /**
     * 保存用户信息
     * @param user
     * @return 返回-1保存错误(用户名已存在)，否则返回受影响的行数
     */
    public int savaUser(User user);


}
