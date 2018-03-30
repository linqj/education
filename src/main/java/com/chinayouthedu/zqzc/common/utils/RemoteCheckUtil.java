package com.chinayouthedu.zqzc.common.utils;

import java.util.Map;
import java.util.Set;
import javax.servlet.http.HttpServletRequest;

public class RemoteCheckUtil {

	/**
	 * 从request中提取需要远程校验的key和value
	 * 
	 * @param request
	 * @return
	 */
	public static String[] getRemoteCheckString(HttpServletRequest request) {

		String[] result = { "", "" };

		// 1.验证数据是否正常
		Map<String, String[]> parameterMap = request.getParameterMap();
		if (parameterMap == null || parameterMap.size() == 0 || parameterMap.size() > 1) {
			// 数据异常
		}

		// 2.获取key和value
		Set<String> keySet = parameterMap.keySet();

		for (String key : keySet) {
			String[] values = parameterMap.get(key);
			result[0] = key;
			result[1] = values[0];
		}

		// 3.返回数据
		return result;
	}

	/**
	 * 转成数据库字段
	 * 
	 * @param s
	 * @return
	 */
	public static String paremeterName2DBField(String name) {

		// 1.转成charArray类型
		char[] charArray = name.toCharArray();
		// 2.计算长度
		int length = charArray.length;
		// 3.将大写字母找出来,转成小写,并记录位置
		int num = 0;
		for (int x = 1; x < length; x++) {
			char c = charArray[x];
			if (c >= 'A' && c <= 'Z') {
				// 转成小写
				charArray[x] = Character.toLowerCase(c);
				// 记录位置
				num = x;
			}
		}
		if (num == 0) {
			return name;
		}
		String s1 = String.valueOf(charArray, 0, num);
		String s2 = String.valueOf(charArray, num, length - num);
		String s3 = s1 + "_" + s2;
		return s3;
	}

	/**
	 * 首字母大写
	 * 
	 * @param string
	 * @return
	 */
	public static String toUpperFristChar(String string) {

		char[] charArray = string.toCharArray();
		charArray[0] = Character.toUpperCase(charArray[0]);
		return String.valueOf(charArray);

	}

}