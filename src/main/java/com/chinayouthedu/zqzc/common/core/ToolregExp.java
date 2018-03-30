package com.chinayouthedu.zqzc.common.core;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.codec.binary.Base64;
import org.apache.log4j.Logger;
/**
 * URL组件工具
 * @author chaoqun
 *
 */
public class ToolregExp {

	@SuppressWarnings("unused")
	private static Logger log = Logger.getLogger(ToolregExp.class);

	/**
	 * 常用正则表达式
	 */
	public final static String regExp_integer_1 = "^\\d+$"; // 匹配非负整数（正整数 + 0）
	public final static String regExp_integer_2 = "^[0-9]*[1-9][0-9]*$"; // 匹配正整数
	public final static String regExp_integer_3 = "^((-\\d+) ?(0+))$"; // 匹配非正整数（负整数  + 0）
	public final static String regExp_integer_4 = "^-[0-9]*[1-9][0-9]*$"; // 匹配负整数
	public final static String regExp_integer_5 = "^-?\\d+$"; // 匹配整数

	public final static String regExp_float_1 = "^\\d+(\\.\\d+)?$"; // 匹配非负浮点数（正浮点数 + 0）
	public final static String regExp_float_2 = "^(([0-9]+\\.[0-9]*[1-9][0-9]*) ?([0-9]*[1-9][0-9]*\\.[0-9]+) ?([0-9]*[1-9][0-9]*))$"; // 匹配正浮点数
	public final static String regExp_float_3 = "^((-\\d+(\\.\\d+)?) ?(0+(\\.0+)?))$"; // 匹配非正浮点数（负浮点数 + 0）
	public final static String regExp_float_4 = "^(-(([0-9]+\\.[0-9]*[1-9][0-9]*) ?([0-9]*[1-9][0-9]*\\.[0-9]+) ?([0-9]*[1-9][0-9]*)))$"; // 匹配负浮点数
	public final static String regExp_float_5 = "^(-?\\d+)(\\.\\d+)?$"; // 匹配浮点数

	public final static String regExp_letter_1 = "^[A-Za-z]+$";// 匹配由26个英文字母组成的字符串
	public final static String regExp_letter_2 = "^[A-Z]+$";// 匹配由26个英文字母的大写组成的字符串
	public final static String regExp_letter_3 = "^[a-z]+$";// 匹配由26个英文字母的小写组成的字符串
	public final static String regExp_letter_4 = "^[A-Za-z0-9]+$";// 匹配由数字和26个英文字母组成的字符串
	public final static String regExp_letter_5 = "^\\w+$";// 匹配由数字、26个英文字母或者下划线组成的字符串

	public final static String regExp_email = "^[\\w-]+(\\.[\\w-]+)*@[\\w-]+(\\.[\\w-]+)+$"; // 匹配email地址
	
	public final static String regExp_url_1 = "^[a-zA-z]+://(\\w+(-\\w+)*)(\\.(\\w+(-\\w+)*))*(\\?\\S*)?$"; // 匹配url
	public final static String regExp_url_2 = "[a-zA-z]+://[^\\s]*"; // 匹配url
		
	public final static String regExp_chinese_1 = "[\\u4e00-\\u9fa5]"; // 匹配中文字符
	public final static String regExp_chinese_2 = "[^\\x00-\\xff]"; // 匹配双字节字符(包括汉字在内)

	public final static String regExp_line = "\\n[\\s ? ]*\\r"; // 匹配空行：

	public final static String regExp_html_1 = "/ <(.*)>.* <\\/\\1> ? <(.*) \\/>/"; // 匹配HTML标记
	public final static String regExp_startEndEmpty = "(^\\s*) ?(\\s*$)"; // 匹配首尾空格

	public final static String regExp_accountNumber = "^[a-zA-Z][a-zA-Z0-9_]{4,15}$"; //匹配帐号是否合法(字母开头，允许5-16字节，允许字母数字下划线)
	
	public final static String regExp_telephone = "\\d{3}-\\d{8} ?\\d{4}-\\d{7}"; //匹配国内电话号码，匹配形式如 0511-4405222 或 021-87888822 
	
	public final static String regExp_qq = "[1-9][0-9]{4,}"; // 腾讯QQ号, 腾讯QQ号从10000开始
	
	public final static String regExp_postbody = "[1-9]\\d{5}(?!\\d)"; // 匹配中国邮政编码
	
	public final static String regExp_idCard = "\\d{15} ?\\d{18}"; // 匹配身份证, 中国的身份证为15位或18位

	public final static String regExp_ip = "\\d+\\.\\d+\\.\\d+\\.\\d+";//IP
	
	/** 邮箱正则表达式 */
	public final static String emailRegex = "^([a-zA-Z0-9_\\-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([a-zA-Z0-9\\-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$";
	/** 电话号码正则表达式 */
	public final static String telRegex = "^1[0-9]{10}$";
	/** 登录名正则表达式 */
	public final static String loginRegex = "^(?=.*[a-zA-Z])[a-zA-Z0-9]{6,20}$";
	
	/**
	 * 字符编码
	 */
	public final static String encoding = "UTF-8";
	/**
	* 验证字符串是否匹配指定正则表达式
	* @param content
	* @param regExp
	* @return
	*/
	public static boolean regExpVali(String content, String regExp){
		Pattern pattern = Pattern.compile(regExp);
		Matcher matcher = pattern.matcher(content);
		return matcher.matches();
	}
	/**
	 * Url Base64编码
	 * 
	 * @param data
	 *            待编码数据
	 * @return String 编码数据
	 * @throws Exception
	 */
	public static String encode(String data) throws Exception {
		// 执行编码
		byte[] b = Base64.encodeBase64URLSafe(data.getBytes(encoding));

		return new String(b, encoding);
	}

	/**
	 * Url Base64解码
	 * 
	 * @param data
	 *            待解码数据
	 * @return String 解码数据
	 * @throws Exception
	 */
	public static String decode(String data) throws Exception {
		// 执行解码
		byte[] b = Base64.decodeBase64(data.getBytes(encoding));

		return new String(b, encoding);
	}

	/**
	 * URL编码（utf-8）
	 * 
	 * @param source
	 * @return
	 */
	public static String urlEncode(String source) {
		String result = source;
		try {
			result = java.net.URLEncoder.encode(source, encoding);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * 根据内容类型判断文件扩展名
	 * 
	 * @param contentType
	 *            内容类型
	 * @return
	 */
	public static String getFileExt(String contentType) {
		String fileExt = "";
		if ("image/jpeg".equals(contentType))
			fileExt = ".jpg";
		else if ("audio/mpeg".equals(contentType))
			fileExt = ".mp3";
		else if ("audio/amr".equals(contentType))
			fileExt = ".amr";
		else if ("video/mp4".equals(contentType))
			fileExt = ".mp4";
		else if ("video/mpeg4".equals(contentType))
			fileExt = ".mp4";
		return fileExt;
	}

	/**
	 * 获取bean名称
	 * 
	 * @param bean
	 * @return
	 */
	public static String beanName(Object bean) {
		String fullClassName = bean.getClass().getName();
		String classNameTemp = fullClassName.substring(fullClassName.lastIndexOf(".") + 1, fullClassName.length());
		return classNameTemp.substring(0, 1) + classNameTemp.substring(1);
	}
	
	/**
	 * 数组转字符串
	 * 用|分割
	 * @param arrs
	 * @return
	 */
	public static String arrayToString(String[] arrs) {
		return arrayToString(arrs, "|");
	}
	
	/**
	 * 数组转字符串
	 * 用自定义 分割
	 * @param arrs
	 * @return
	 */
	public static String arrayToString(String[] arrs, String excision) {
		StringBuffer str = new StringBuffer();
		if(arrs.length>0){
			for (String arr : arrs) {
				str.append(arr + excision);
			}
			str.deleteCharAt(str.length() - 1 );
		}
		return str.toString();
	}
	
	/**
	 * 去掉小数后面多余的0
	 * @param s
	 * @return
	 */
	public static String subZeroAndDot(String number){  
        if(number.indexOf(".") > 0){  
            number = number.replaceAll("0+?$", "");//去掉多余的0  
            number = number.replaceAll("[.]$", "");//如最后一位是.则去掉  
        }  
        return number;  
    } 
	
	/**
	 * 计算采用utf-8编码方式时字符串所占字节数
	 * 
	 * @param content
	 * @return
	 */
	public static int getByteSize(String content) {
		int size = 0;
		if (null != content) {
			try {
				// 汉字采用utf-8编码时占3个字节
				size = content.getBytes("utf-8").length;
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}
		return size;
	}
	
	
	
	/**
	 * 方法描述：判断字符串是否为空
	 * 
	 * @author YongLiang.Wang
	 * @time 2011-4-9 上午11:11:25
	 * @param str
	 * @return
	 */
	public static boolean isNull(String str) {
		if (str == null || "".equals(str) || "null".equalsIgnoreCase(str)) {
			return true;// 为空返回true
		} else {
			return false;// 不为空返回false
		}
	}

	/**
	 * 判断是否为int
	 * 
	 * @param expression
	 * @return
	 */
	public static boolean isInteger(Object expression) {
		if (expression != null) {
			try {
				Integer.parseInt(expression.toString());
			} catch (Exception e) {
				return false;
			}
		}
		return true;
	}

	/**
	 * 判读是否为DOUBLE
	 * 
	 * @param expression
	 * @return
	 */
	public static boolean isDouble(Object expression) {
		if (expression != null) {
			try {
				Double.parseDouble(expression.toString());
			} catch (Exception e) {
				return false;
			}
		}
		return true;
	}

	/**
	 * 判断给定的字符串数组中的数据是不是都为数值型
	 * 
	 * @param array
	 *            字符串数组
	 * @return 是否成功
	 */
	public static boolean isNumArray(String[] array) {
		if (array == null) {
			return false;
		}
		if (array.length < 1) {
			return false;
		}
		for (String string : array) {
			if (isInteger(string) || isDouble(string)) {
				continue;
			} else {
				return false;
			}
		}
		return true;
	}

	/**
	 * 方法描述：判断字符串是否为数字
	 * 
	 * @author YongLiang.Wang
	 * @time Apr 16, 2011 1:22:17 PM
	 * @param str
	 * @return
	 */
	public static boolean isNum(String str) {
		if (isInteger(str) || isDouble(str)) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 方法描述：判断是否为正整数
	 * 
	 * @author YongLiang.Wang
	 * @time 2011-5-11 下午03:05:59
	 * @param s
	 * @return
	 */
	public static boolean isPositiveInt(String s) {
		boolean b = true;
		try {
			while (b) {
				for (int j = 0; j < s.length(); j++) {
					if (!(s.charAt(j) >= 48 && s.charAt(j) <= 57)) {
						return false;
					} else {
						b = false;
					}
				}
				if (!b) {
					int i = Integer.parseInt(s);
					if (i == 0) {
						return false;
					}
					return true;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	/**
	 * 版本比较
	 * @author 张超群 
	 * @Time   2017年12月28日下午2:15:09
	 * @param versionA
	 * @param versionB
	 * @param versionSplit
	 * @return
	 */
	public static Integer compareVersion(String versionA, String versionB, String versionSplit) {

		if (versionA.equals("") || versionB.equals(""))
			return versionA.compareTo(versionB);

		if (!Pattern.compile(versionSplit, Pattern.LITERAL).matcher(versionA + versionB).replaceAll("").matches("\\d+")) {
			// throw new RuntimeException( "Version format error: " + versionA +
			// ", " + versionB );
			return null;
		}
		String[] volumnsA = Pattern.compile(versionSplit, Pattern.LITERAL).split(versionA);
		String[] volumnsB = Pattern.compile(versionSplit, Pattern.LITERAL).split(versionB);

		int aVolSize = volumnsA.length;
		int bVolSize = volumnsB.length;

		int aIndex = -1;
		int bIndex = -1;
		while (++aIndex < aVolSize && ++bIndex < bVolSize) {
			int vA = Integer.parseInt(volumnsA[bIndex]);
			int vB = Integer.parseInt(volumnsB[bIndex]);
			System.out.println(vA + "-" + vB);

			if (vA != vB)
				return vA - vB;
		}
		return aVolSize - bVolSize;
	}

	/**
	 * 去空
	 * @author 张超群 
	 * @Time   2017年12月28日下午2:16:07
	 * @param str
	 * @return
	 */
	public static String replaceBlank(String str) {
        String dest = "";
        if (str!=null) {
            Pattern p = Pattern.compile("\\s*|\t|\r|\n");
            Matcher m = p.matcher(str);
            dest = m.replaceAll("");
        }
        return dest;
    }
	
	/**
	 * list转字符串
	 * @param list
	 * @param separator:分隔符，默认为“,”
	 * @return
	 */
	public static String listToString(List<Integer> list, String separator) {
		if (list==null||list.size()==0) {
            return null;
        }
		if(separator==null)
			separator=",";
        StringBuilder result=new StringBuilder();
        for (Integer str : list) {
            result.append(str);
            result.append(separator);
        }
        result.deleteCharAt(result.length()-1);
        return result.toString();
	}
	

	/**去除两端的空格
	 * 半角和全角空格都可以去除
	 * @param  原始字符串
	 * @return 新字符串
	 */
	public static String removeSpace(String textContent) {
		if (textContent == null)
			return textContent;
		textContent = textContent.trim();
		while (textContent.startsWith("　")) {// 这里判断是不是全角空格
			textContent = textContent.substring(1, textContent.length()).trim();
		}
		while (textContent.endsWith("　")) {
			textContent = textContent.substring(0, textContent.length() - 1).trim();
		}
		return textContent;
	}
	
}
