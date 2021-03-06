package com.yimew.config.converter;

import org.springframework.core.convert.converter.Converter;

/**
 * 去掉前后空格
 * @author lx
 *
 */
public class TrimConverter implements Converter<String, String>{
	@Override
	public String convert(String source) {
		try {
			if(null != source){
				source = source.trim();
				if(!"".equals(source)){
					return source;
				}
			}
		} catch (Exception e) {
		}
		return null;
	}

}
