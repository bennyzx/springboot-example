package cn.eggnetech.eggnetechmybatis.dao.impl;

import cn.eggnetech.eggnetechmybatis.dao.UserDao;
import cn.eggnetech.eggnetechmybatis.pojo.User;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @name:
 * @description: Created by Benny Zhou on 2020/3/30
 */
@Repository("userDao")
public class UserDaoImpl extends SqlSessionDaoSupport implements UserDao {

    @Autowired
    @Override
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        super.setSqlSessionFactory(sqlSessionFactory);
    }

    @Override
    public List<User> list() {
        return getSqlSession().selectList("cn.eggnetech.eggnetechmybatis.user.mapper.list");
    }
}
