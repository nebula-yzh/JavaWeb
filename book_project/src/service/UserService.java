package service;

import pojo.User;

public interface UserService {

    /**
     * 注册用户
     * @param user
     */
    public void registerUser(User user);


    /**
     * 用户登陆
     * @param user
     * @return 返回null 登陆失败，返回有值登陆成功
     */
    public User login(User user);

    /**
     * 检查 用户名是否可用
     * @param username
     * @return 返回true表示用户名已存在、不可用，返回false表示用户名不存在、可用
     */
    public boolean existsUsername(String username);
}
