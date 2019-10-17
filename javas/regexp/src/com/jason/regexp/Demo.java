package com.jason.regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Assert;
import org.junit.Test;

/**
 * 正则
 * @author Administrator
 *
 */
public class Demo {

	/**
	 * 使用正则表达式：匹配
	 */
	@Test
	public void demo01(){
		Assert.assertEquals("匹配失败...", "IF", matcherCode("IF001"));
		Assert.assertEquals("匹配失败...", "IF", matcherCode("iF001"));
		Assert.assertEquals("匹配失败...", "IF", matcherCode("If001"));
		Assert.assertEquals("匹配失败...", "IF", matcherCode("if001"));
		Assert.assertEquals("匹配失败...", "", matcherCode("001"));
		Assert.assertEquals("匹配失败...", "", matcherCode(""));
		Assert.assertEquals("匹配失败...", "", matcherCode(null));
	}
	
	/**
	 * 匹配期货代码的字母
	 * @param futuresCode 期货代码：字母+数字
	 * @return
	 */
	private String matcherCode(String futuresCode){
		//匹配格式：字母+数字
		String pattern="(\\D+)(\\d*)";
		Pattern compile = Pattern.compile(pattern);
		//将字母统一为大写
		String code=futuresCode==null?"":futuresCode.toUpperCase();
		Matcher matcher = compile.matcher(code);
		if(matcher.find()){
			//如果匹配，返回期货代码的字母部分
			return matcher.group(1);
		}else{
			//未匹配，返回""
			return "";
		}
	}
}
