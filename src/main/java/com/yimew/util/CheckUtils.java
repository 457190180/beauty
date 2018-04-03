package com.yimew.util;

public class CheckUtils {
	/**
	 * 判断属性是否为空或者空串
	 * @param propertys
	 * @return
	 */
	public static final Boolean checkPropertysIsNull(String ...propertys){
		for (String property : propertys) {
			if(property==null||"".equals(property.trim())){
				return true;
			}
		}
		
		return false;
	}
	public static final Boolean checkPropertysIsNull(Double ...propertys){
		for (Double property : propertys) {
			if(property==0d){
				return true;
			}
		}
		
		return false;
	}
	public static final Boolean checkPropertysIsNull(Boolean isZero,Integer ...propertys){
		for (Integer property : propertys) {
			if(isZero){
				if(property==null || property==0 ){
					return true;
				}
			}else{
				if(property==null){
					return true;
				}
			}
		}
		
		return false;
	}
	
}
