package com.yimew.util;

import com.yimew.config.web.ReturnData;

import java.util.Date;
import java.util.List;

public class ReturnUtils {
	
	private ReturnUtils(){
		
	}

	/**
	 * 根据Id是否为空判断是否存储或操作成功
	 */
	public static final ReturnData checkById(List<String> ids) {
		ReturnData returnData = new ReturnData();
		for (String id : ids) {
			if (id == null || "".equals(id.trim())) {
				//setData(returnData, null,Const.MSG.FAIL, Const.CODE.FAIL);
				return returnData;
			}
		}
		//setData(returnData,ids, Const.MSG.SUCCESS,  Const.CODE.SUCCESS);
		return returnData;

	}
	
	public static void setData(ReturnData returnData, Object data, String msg, int code) {
		returnData.setDate(new Date());
		returnData.setData(data);
		returnData.setCode(code);
		returnData.setMsg(msg);
	}

	public static ReturnData checkById(String id) {
		ReturnData returnData = new ReturnData();
		if (id == null || "".equals(id.trim())) {
			//setData(returnData, null,Const.MSG.FAIL, Const.CODE.FAIL);
			return returnData;
		}
		//setData(returnData,id, Const.MSG.SUCCESS,  Const.CODE.SUCCESS);
		return returnData;
	}

	
	

}
