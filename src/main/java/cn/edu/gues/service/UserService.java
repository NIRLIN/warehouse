package cn.edu.gues.service;

import cn.edu.gues.pojo.User;

import java.util.List;

/**
 * @author NIRLIN
 * @version 1.0
 * @date 2020/7/13 15:44
 */
public interface UserService {
    /**
     * 功能：查询所有供应商非管理员用户
     * 异常：为SQL异常
     *
     * @return List<User>
     */
    List<User> selectAllUser();

    /**
     * 功能：根据id查询非管理员用户
     * 异常：SQL异常
     *
     * @param id User的id
     * @return User
     */
    User selectUserById(String id);

    /**
     * 功能：非管理员用户插入数据库
     * 异常：SQL异常
     *
     * @param user User
     * @return int
     */
    int insertUser(User user);

    /**
     * 功能：据非管理员用户id修改非管理员用户信息
     * 异常：SQL异常
     *
     * @param user User
     * @return int
     */
    int updateUserById(User user);

    /**
     * 功能：根据id删除非管理员用户
     * 异常：SQL异常
     *
     * @param id User的id
     * @return int
     */
    int deleteUserById(String id);

    /**
     * 功能：用户登录
     * 异常：SQL异常
     *
     * @param jobNo password User的工号
     * @param password User的密码
     * @return int
     */
    int userLogin(String jobNo,String password);

    /**
     * 功能：管理员登录
     * 异常：SQL异常
     *
     * @param jobNo password User的工号
     * @param password User的密码
     * @return int
     */
    int adminLogin(String jobNo,String password);

    /**
     * 用户登录
     * 异常：SQL异常
     * @param jobNo    password User的工号
     * @param password User的密码
     * @return user
     */
    User loginFunction(String jobNo, String password);
}
