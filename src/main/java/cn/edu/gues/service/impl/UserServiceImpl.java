package cn.edu.gues.service.impl;

import cn.edu.gues.mapper.UserMapper;
import cn.edu.gues.pojo.User;
import cn.edu.gues.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 * @author NIRLIN
 * @version 1.0
 * @date 2020/7/13 15:44
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;
    @Override
    public List<User> selectAllUser() {
        return userMapper.selectAllUser();
    }

    @Override
    public User selectUserById(String id) {
        return userMapper.selectUserById(id);
    }

    @Override
    public int insertUser(User user) {
        user.setId(String.valueOf(UUID.randomUUID()));
        return userMapper.insertUser(user);
    }

    @Override
    public int updateUserById(User user) {
        return userMapper.updateUserById(user);
    }

    @Override
    public int deleteUserById(String id) {
        return userMapper.deleteUserById(id);
    }

    @Override
    public int userLogin(String jobNo, String password) {
        return userMapper.userLogin(jobNo, password);
    }

    @Override
    public int adminLogin(String jobNo, String password) {
        return userMapper.adminLogin(jobNo, password);
    }

    @Override
    public User loginFunction(String jobNo, String password) {
        return userMapper.loginFunction(jobNo, password);
    }
}
