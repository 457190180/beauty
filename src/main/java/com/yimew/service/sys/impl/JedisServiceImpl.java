package com.yimew.service.sys.impl;

import com.yimew.config.base.service.BaseServiceImpl;
import com.yimew.service.sys.JedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * * @author 作者 E-mail: * @date 创建时间：2017年11月1日 下午1:09:04 * @version 1.0
 * * @parameter * @since * @return
 */
@Service("jedisService")
@Transactional
public class JedisServiceImpl extends BaseServiceImpl implements JedisService {
    // private Jedis jedis = null;

    @Autowired
    private JedisPool jedisPool;

    private Integer index = 1;

    @Override
    public Jedis getJedis() {
        Jedis jedis = null;
        if (jedisPool != null) {
            if (jedis == null) {
                jedis = jedisPool.getResource();
               // jedis.auth(Const.REDIS_PASSWORD);
            }
        }
        return jedis;
    }

    @Override
    public void returnResource(Jedis jedis) {
        if (null != jedis) {
            //System.out.println("第 " +index +"次关闭jedis"+jedis.toString());

            int numActive = jedisPool.getNumActive();
            //System.out.println("活动链接" + numActive);
            int numIdle = jedisPool.getNumIdle();
            //System.out.println(numIdle);
            int numWaiters = jedisPool.getNumWaiters();
            //System.out.println("等待链接" + numWaiters);

            jedis.close();
        }
    }
}
