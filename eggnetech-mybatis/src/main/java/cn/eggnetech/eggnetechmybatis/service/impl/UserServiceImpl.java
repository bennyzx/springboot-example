package cn.eggnetech.eggnetechmybatis.service.impl;

import cn.eggnetech.eggnetechmybatis.dao.UserDao;
import cn.eggnetech.eggnetechmybatis.pojo.User;
import cn.eggnetech.eggnetechmybatis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @name:
 * @description: Created by Benny Zhou on 2020/3/30
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public List<User> list() {
        return userDao.list();
    }
}
