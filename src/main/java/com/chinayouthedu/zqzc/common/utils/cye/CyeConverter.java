package com.chinayouthedu.zqzc.common.utils.cye;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import org.apache.commons.lang3.StringUtils;

public class CyeConverter {

	/**
	 * 将一个字符串按照某个分隔符分割成字符串集合
	 * @param arrayStr 待分割成集合的字符串
	 * @param separator 分割符
	 * @return 分割后的字符串集合,如果字符串为空(包括null,""," ")or分割符为空(包括null,"",不包括" "),返回空集合
	 */
	public static List<String> toList(String arrayStr, String separator) {
		
		// 2.处理参数
		if (StringUtils.isNotBlank(arrayStr)&&null!=separator&&!"".equals(separator)) {
			List<String> list = new ArrayList<>();
			arrayStr = arrayStr.trim();
			separator = separator.trim();
			String[] split = arrayStr.split(separator);
			if (split != null && split.length > 0) {
				for (String string : split) {
					if (StringUtils.isNotBlank(string)) {
						list.add(string.trim());
					}
				}
			}
			return list;
		}else{
			return new ArrayList<>();
		}
		
	}

	/**
	 * 将一个字符串数组通过间隔符连接成一个字符串
	 * @param strList    字符串集合[建议在传入之前去除集合中的所有null值]
	 * @param separator  分割符
	 * @return 如果是一个空集合,返回""
	 * @return 如果separator为空(null或者""),集合中的所有字符串将无缝拼接
	 * @return strList不为空且separator不为空时,返回的字符串为:strList.get(0)+separator+strList.get(1)+...+strList.get(strList.size()-1)
	 */
	public static String toString(final List<String> strList,final String separator){

	    // 1.处理分隔符，若为null,将null转为""
		final String sep = separator==null?"":separator;

		// 2.如果为空集合,返回""
		if(strList==null){
			return "";
		}else{
            strList.remove(null);       // 去除null
            if(strList.size()==0){
                return "";
            }
        }


		// 3.将集合通过字符串拼接起来
		StringBuilder sb = new StringBuilder();
		strList.forEach(str->{
		    if(str!=null){
                sb.append(str).append(sep);
            }
		});

		// 4.去除最后一个拼接符
        String s1 = sb.toString();
        if(!"".equals(sep)){
            s1 = s1.substring(0,s1.lastIndexOf(sep));
        }

        // 5.返回结果
        return s1;

	}


}