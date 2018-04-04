package com.yimew.service.sys.impl;

import com.yimew.config.base.page.BasePage;
import com.yimew.config.base.service.BaseServiceImpl;
import com.yimew.entity.sys.Log;
import com.yimew.entity.sys.LogQuery;
import com.yimew.entity.sys.User;
import com.yimew.service.sys.LogService;
import com.yimew.util.UUIDUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("logService")
@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
public class LogServiceImpl extends BaseServiceImpl implements LogService {


	@Override
	public LogQuery getQuery(BasePage basePage) throws Exception {
		return null;
	}

	@Override
	public Log getById(String id) throws Exception {
		return null;
	}

	@Override
	public List<Log> getList(LogQuery logQuery) throws Exception {
		return null;
	}

	@Override
	public Integer countList(LogQuery logQuery) throws Exception {
		return null;
	}


	@Override
	public Log insertSelective(Log log, User user) throws Exception {
		log.setLogId(UUIDUtils.getUUID());
		logDao.insertSelective(log);
		return log ;
	}

	@Override
	public Log insert(Log log, User user) throws Exception {
		return null;
	}

	@Override
	public Log updateByPrimaryKeySelective(Log log, User user) throws Exception {
		return null;
	}

	@Override
	public Log updateByPrimaryKey(Log log, User user) throws Exception {
		return null;
	}

	@Override
	public Integer del(List<String> strings, User user) throws Exception {
		return null;
	}
}
