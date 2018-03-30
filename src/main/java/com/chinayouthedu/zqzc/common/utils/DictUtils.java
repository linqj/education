package com.chinayouthedu.zqzc.common.utils;

import com.chinayouthedu.zqzc.config.cache.ForeverEHCacheManager;
import com.chinayouthedu.zqzc.config.constants.Constants;
import com.chinayouthedu.zqzc.entity.paike.Dictionary;

import java.util.ArrayList;
import java.util.List;

/**
 * 字典工具类
 * @Company 中青至诚教育咨询有限公司
 * @author 张超群
 * @Modifier
 * @time   2018年2月2日 下午3:08:59
 * @version 1.0
 */
@SuppressWarnings("unchecked")
public class DictUtils {
	
	private static List<Dictionary> list = null;
	
	static{
		list = (List<Dictionary>) ForeverEHCacheManager.get(Constants.DICT);
	}
	
	/**
	 * 根据字典类型编码获取该类型的所有字典值
	 * @author 张超群 
	 * @Time   2018年2月2日下午3:22:59
	 * @param code
	 * @return
	 */
	public static List<Dictionary> getDictListByTypeCode(String code){
		List<Dictionary> dict_list = new ArrayList<Dictionary>();
		if(list != null && list.size() > 0){//字典不为空
			for (Dictionary dictionary : list) {
				if(code.equals(dictionary.getType())){
					dict_list.add(dictionary);
				}
			}

		}else{//字典为空
			list = (List<Dictionary>) ForeverEHCacheManager.get(Constants.DICT);
			if(list != null && list.size() > 0){
				for (Dictionary dictionary : list) {
					if(code.equals(dictionary.getType())){
						dict_list.add(dictionary);
					}
				}
			}

		}
		return dict_list;
	}
	
	/**
	 * 根据字典code获取该字典项
	 * @Time   2018年3月20日下午6:31:19
	 * @param code
	 * @return
	 */
	public static Dictionary selectByCode(String code){
		if(list != null && list.size() > 0){//字典不为空
			for (Dictionary dictionary : list) {
				if(code.equals(dictionary.getCode())){
					return dictionary;
				}
			}

		}else{//字典为空
			list = (List<Dictionary>) ForeverEHCacheManager.get(Constants.DICT);
			if(list != null && list.size() > 0){
				for (Dictionary dictionary : list) {
					if(code.equals(dictionary.getCode())){
						return dictionary;
					}
				}
			}

		}
		return null;
	}
	
	

}
