package com.yimew.service.demo.impl;

import com.yimew.config.base.page.BasePage;
import com.yimew.config.base.service.BaseServiceImpl;
import com.yimew.entity.demo.Demo;
import com.yimew.entity.demo.DemoQuery;
import com.yimew.entity.exception.AuthorityException;
import com.yimew.entity.sys.User;
import com.yimew.entity.sys.UserQuery;
import com.yimew.service.demo.DemoService;
import com.yimew.service.sys.UserService;
import com.yimew.util.PageUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import redis.clients.jedis.exceptions.JedisException;

import java.util.List;


@Service("demoService")
@Transactional(readOnly = false,
        propagation = Propagation.REQUIRED,
        rollbackFor = {Throwable.class})
public class DemoServiceImpl extends BaseServiceImpl implements DemoService {

    private static final Logger logger = LoggerFactory.getLogger(DemoServiceImpl.class);


    @Override
    public DemoQuery getQuery(BasePage basePage) throws Exception {
        // 分页
        Integer limit = basePage.getLimit();
        Integer offset = basePage.getOffset();
        Integer pageNo = PageUtils.getPage(offset, limit);

        DemoQuery q = new DemoQuery();
        q.setPageNo(pageNo);
        q.setPageSize(limit);
        q.setStartRow(offset);
        //排序
        q.setOrderByClause(basePage.getSort()+" "+basePage.getOrder());

        //查询条件如下
        //......
        return q;
    }

    @Override
    public Demo getById(String id) throws Exception {
        return demoDao.selectByPrimaryKey(id);
    }

    @Override
    public List<Demo> getList(DemoQuery demoQuery) throws Exception {
        return demoDao.selectByExample(demoQuery);
    }

    @Override
    public Integer countList(DemoQuery demoQuery) throws Exception {
        return demoDao.countByExample(demoQuery);
    }

    @Override
    public Integer insertSelective(Demo demo, User user) throws Exception {
        //demo.setCreateBy(user.get);
        return demoDao.insertSelective(demo);
    }

    @Override
    public Integer insert(Demo demo, User user) throws Exception {
        return null;
    }

    @Override
    public Integer updateByPrimaryKeySelective(Demo demo, User user) throws Exception {
        return null;
    }

    @Override
    public Integer updateByPrimaryKey(Demo demo, User user) throws Exception {
        return null;
    }

    @Override
    public List<String> del(List<String> strings, User user) throws Exception {
        return null;
    }
}
