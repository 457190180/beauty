package com.yimew.service.sys.impl;

import com.yimew.config.base.page.BasePage;
import com.yimew.config.base.service.BaseServiceImpl;
import com.yimew.entity.exception.AuthorityException;
import com.yimew.entity.sys.User;
import com.yimew.entity.sys.UserQuery;
import com.yimew.service.sys.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import redis.clients.jedis.exceptions.JedisException;

import java.util.List;

/**
 * * @author 作者 E-mail: * @date 创建时间：2017年11月1日 下午1:09:  * @version 1.0
 * * @parameter * @since * @return
 */
@Service("userService")
@Transactional(readOnly = false,
        propagation = Propagation.REQUIRED,
        rollbackFor = {Throwable.class})
public class UserServiceImpl  extends BaseServiceImpl implements UserService {


    @Override
    public User getUserByRedis(String userCode) throws JedisException {
        return null;
    }

    @Override
    public void checkAuthority(User user, String collegeId, String departmentId) throws AuthorityException {

    }

    @Override
    public void checkAuthority(User user, String collegeId) throws AuthorityException {

    }

    @Override
    public User getById(String id) throws Exception {
        return null;
    }

    @Override
    public List<User> getList(BasePage basePage) throws Exception {

        return userDao.selectByExample(new UserQuery());
    }

    @Override
    public Integer countList(BasePage basePage) throws Exception {
        return null;
    }

    @Override
    public Integer insertSelective(User user, User user2) throws Exception {
        return null;
    }

    @Override
    public Integer insert(User user, User user2) throws Exception {
        return null;
    }

    @Override
    public Integer updateByPrimaryKeySelective(User user, User user2) throws Exception {
        return null;
    }

    @Override
    public Integer updateByPrimaryKey(User user, User user2) throws Exception {
        return null;
    }

    @Override
    public List<String> del(List<String> strings, User user) throws Exception {
        return null;
    }
}