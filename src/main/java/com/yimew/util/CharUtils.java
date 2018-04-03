package com.yimew.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CharUtils {
	
	/**
	 * 生成多个符号
	 * @param n 个数
	 * @param mark 符号
	 * @return
	 */
	public static String repeatString(Integer n,String mark) {
		String space="";
		for(int i=0;i<n;i++){
			space+=mark;
		}
		return space;
	}
	
	/**
	 * 获取字符串第N次出现的位置
	 * @param string 
	 * @param string 出现的字符串
	 * @param index  出现的第几次
	 * @return
	 */
    public static int getCharacterPosition(String string,String charCode,Integer index){  
        //这里是获取"/"符号的位置  
        Matcher slashMatcher = Pattern.compile(charCode).matcher(string);  
        int mIdx = 0;  
        while(slashMatcher.find()) {  
           mIdx++;  
           //当"/"符号第三次出现的位置  
           if(mIdx == index){  
              break;  
           }  
        }  
        return slashMatcher.start();  
     }  
    
    /**
     * 将数字转为字符，不足num位的补0
     * @return
     */
    public static String getStrFromInt(int digit,int number){
    		String str = String.valueOf(number);
    		int oNum=digit-str.length();
    		
    		str = repeatString(oNum,"0")+str;
    		return str;
    }
    
}
