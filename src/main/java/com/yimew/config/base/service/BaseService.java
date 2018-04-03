package com.yimew.config.base.service;

import com.yimew.config.base.page.BasePage;
import com.yimew.entity.sys.User;

import java.util.List;

public interface BaseService<T,P extends BasePage,K> {
	
	/**
	 * 公共根据Id获取数据
	 * @param id
	 * @return
	 */
	public  T getById(K id) throws  Exception;
	
	/**
	 * 公共获取列表
	 * @param p
	 * @return
	 */
	public List<T> getList(P p)throws  Exception;
	
	/**
	 * 公共统计
	 * @param p
	 * @return
	 */
	public Integer countList(P p)throws  Exception;
	
	/**
	 * 公共部分保存
	 * @param t
	 * @return
	 */
	public Integer insertSelective(T t, User user)throws  Exception;

	/**
	 * 公共全部保存
	 * @param t
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public Integer insert(T t, User user)throws  Exception;

	/**
	 * 公共部分修改
	 * @param t
	 * @return
	 */
	public Integer updateByPrimaryKeySelective(T t, User user)throws  Exception;

	/**
	 * 公共全部修改
	 * @param t
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public Integer updateByPrimaryKey(T t, User user)throws  Exception;

	/**
	 * 公共删除
	 * @param ks
	 * @return
	 */
	public List<String> del(List<K> ks, User user) throws  Exception;
	


}