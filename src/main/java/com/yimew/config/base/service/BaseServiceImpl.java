package com.yimew.config.base.service;

import com.yimew.dao.sys.LogDao;
import com.yimew.dao.sys.UserDao;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class BaseServiceImpl {

	@Autowired
	protected UserDao userDao;
	@Autowired
	protected LogDao logDao;

}
