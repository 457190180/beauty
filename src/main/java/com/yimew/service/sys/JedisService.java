package com.yimew.service.sys;

import redis.clients.jedis.Jedis;


/**
 *
 * @author by 梁新宇
 * @version 2018-01-02
 */
public interface JedisService {

    /**
     * 获取jedis
     * @return
     */
     Jedis getJedis();

    void returnResource(Jedis jedis);
}
