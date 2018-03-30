package com.chinayouthedu.zqzc.service;

import java.util.List;
import java.util.Map;

import com.chinayouthedu.zqzc.config.core.BaseResponse;
import com.chinayouthedu.zqzc.entity.paike.DataDictionary;
import com.chinayouthedu.zqzc.entity.paike.Dictionary;
import com.chinayouthedu.zqzc.entity.paike.DictionaryExample;
import com.chinayouthedu.zqzc.entity.vo.DictionaryVo;
import com.github.pagehelper.PageInfo;

/**
 * 字典管理
 * @Company 中青至诚教育咨询有限公司
 * @author 张超群
 * @Modifier
 * @time  2017年12月8日   下午11:28:53 
 * @version 1.0
 */
public interface DictionaryService {
	

	/**
	 * 根据字典类型编码获取字典值(本系统)
	 * @author 张超群 
	 * @Time   2018年3月12日上午10:48:38
	 * @param code
	 * @return
	 */
	List<Dictionary> selectDictBySystemTypeCode(String code);

	/**
	 * 条件查询字典
	 * @author 张超群 
	 * @Time   2018年3月16日下午5:42:16
	 * @param dictionaryExample
	 * @return
	 */
	List<Dictionary> selectByExample(DictionaryExample dictionaryExample);

	/**
	 * 根据字典code查<code,name>的Map
	 * @param string 字典code
	 * @return
	 */
	Map<String, String> selectMapByCode(String string);
	
	/**
	 * 根据code查询该条字典
	 * @Time   2018年3月20日下午6:28:12
	 * @param code
	 * @return
	 */
	Dictionary selectByCode(String code);

	/**
	 * 获取字典展示页的tree
	 * @author  张超群	2018年3月24日 下午9:29:12
	 * @param pageNum	int	第几页
	 * @param pageSize	int	每页显示条数
	 * @return json tree
	 */
	BaseResponse<PageInfo<DataDictionary>> selectDictList(int pageNum, int pageSize);

	/**
	 * 创建一个字典值
	 * @author  张超群	2018年3月24日 下午9:31:17
	 * @param dictionaryVo	字典VO
	 * @return
	 */
	BaseResponse<Map<String, Object>> createDict(DictionaryVo dictionaryVo);

	/**
	 * 编辑一个字典值
	 * @author  张超群	2018年3月24日 下午9:31:36
	 * @param dictionaryVo	字典VO
	 * @return
	 */
	BaseResponse<Map<String, Object>> editDict(DictionaryVo dictionaryVo);

	/**
	 * 删除一个字典值
	 * @author  张超群	2018年3月24日 下午9:31:44
	 * @param id	long	字典id
	 * @return
	 */
	BaseResponse<Map<String, Object>> delDict(long id);

	/**
	 * 获取注册中心授权给本系统的字典类型
	 * @author  张超群	2018年3月24日 下午9:31:51
	 * @return
	 */
	BaseResponse<List<DataDictionary>> getZczxDictionaryType();
	
	
}
