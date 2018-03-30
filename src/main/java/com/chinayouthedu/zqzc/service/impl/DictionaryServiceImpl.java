package com.chinayouthedu.zqzc.service.impl;

import com.chinayouthedu.zqzc.common.core.WebUtils;
import com.chinayouthedu.zqzc.common.utils.DictUtils;
import com.chinayouthedu.zqzc.common.utils.UploadConfig;
import com.chinayouthedu.zqzc.config.cache.ForeverEHCacheManager;
import com.chinayouthedu.zqzc.config.constants.Constants;
import com.chinayouthedu.zqzc.config.core.BaseResponse;
import com.chinayouthedu.zqzc.entity.paike.DataDictionary;
import com.chinayouthedu.zqzc.entity.paike.DataDictionaryExample;
import com.chinayouthedu.zqzc.entity.paike.Dictionary;
import com.chinayouthedu.zqzc.entity.paike.DictionaryExample;
import com.chinayouthedu.zqzc.entity.vo.DictionaryVo;
import com.chinayouthedu.zqzc.mapper.paike.DataDictionaryMapper;
import com.chinayouthedu.zqzc.mapper.paike.DictionaryMapper;
import com.chinayouthedu.zqzc.service.DictionaryService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * 数据字典
 * @author 张超群
 * @time   2018年3月12日上午10:44:48
 */
@Service
public class DictionaryServiceImpl implements DictionaryService {
	
	@Autowired
	private DataDictionaryMapper zczx;
	
	@Autowired
	private DictionaryMapper sys;


	/**
	 * 根据字典类型获取字典值
	 */
	@Override
	public List<Dictionary> selectDictBySystemTypeCode(String code) {
		DictionaryExample dictionaryExample = new DictionaryExample();
		dictionaryExample.createCriteria().andTypeEqualTo(code);
		return sys.selectByExample(dictionaryExample);
	}


	/**
	 * 条件查询字典
	 */
	@Override
	public List<Dictionary> selectByExample(DictionaryExample dictionaryExample) {
		return sys.selectByExample(dictionaryExample);
	}


	@Override
	public Map<String, String> selectMapByCode(String string) {
		
		Map<String, String> map = new HashMap<>();
		
		List<Dictionary> dicList = selectDictBySystemTypeCode(string );
		
		if(dicList!=null){
			dicList.forEach(dic->{
				String code = dic.getCode();
				String name = dic.getName();
				if(StringUtils.isNotBlank(code)&&StringUtils.isNotBlank(name)){
					map.put(code, name);
				}
			});
		}
		
		return map;
	}


	/**
	 * 根据字典编码获取字典值
	 */
	@Override
	public Dictionary selectByCode(String code) {
//		return sys.selectByCode(code)==null?null:sys.selectByCode(code);
		return DictUtils.selectByCode(code);
	}


	/**
	 * 获取字典tree
	 */
	@Override
	public BaseResponse<PageInfo<DataDictionary>> selectDictList(int pageNum, int pageSize) {
		BaseResponse<PageInfo<DataDictionary>> response = new BaseResponse<PageInfo<DataDictionary>>();
		String zczx_code = UploadConfig.getSystemDictByZczx();
		if(!"".equals(zczx_code)){
			DataDictionaryExample example = new DataDictionaryExample();
			example.createCriteria().andDictionaryCodeEqualTo(zczx_code);
			List<DataDictionary> zczx_dict = zczx.selectByExample(example);
			if(zczx_dict.size() > 0){
				PageHelper.startPage(pageNum, pageSize);
				DataDictionaryExample example2 = new DataDictionaryExample();
				example2.createCriteria().andDictionarySourceEqualTo(zczx_dict.get(0).getId());
				List<DataDictionary> zczx_dict_type = zczx.selectByExample(example2);
				for (DataDictionary dataDictionary : zczx_dict_type) {
					DictionaryExample dictionaryExample = new DictionaryExample();
					dictionaryExample.createCriteria().andTypeEqualTo(dataDictionary.getDictionaryCode());
					List<Dictionary> list = sys.selectByExample(dictionaryExample);
					dataDictionary.setChildlist(list);
				}
				PageInfo<DataDictionary> pageInfo = new PageInfo<DataDictionary>(zczx_dict_type);
				response.setData(pageInfo);
			}
		}
		return response;
	}


	/**
	 * 创建一个字典值
	 */
	@Override
	public BaseResponse<Map<String, Object>> createDict(DictionaryVo dictionaryVo) {
		BaseResponse<Map<String,Object>> response = new BaseResponse<Map<String,Object>>();
		DictionaryExample dictionaryExample = new DictionaryExample();
		dictionaryExample.createCriteria().andNameEqualTo(dictionaryVo.getName());
		List<Dictionary> selectByExample = sys.selectByExample(dictionaryExample);
		int insert = 0;
		if(selectByExample.size() > 0){//已存在
			WebUtils.Error(response, "该字典已存在!");
			return response;
		}else{
			Dictionary dictionary = new Dictionary();
			BeanUtils.copyProperties(dictionaryVo, dictionary);
			insert = sys.insert(dictionary);
		}
		if(insert > 0){
			//查询新数据更新缓存
			DictionaryExample all = new DictionaryExample();
			List<Dictionary> all_dicts = sys.selectByExample(all);
			ForeverEHCacheManager.remove(Constants.DICT);
			ForeverEHCacheManager.set(Constants.DICT,all_dicts);
			WebUtils.Success(response, "保存成功!");
		}else{
			WebUtils.Error(response, "保存失败!");
		}
		return response;
	}


	/**
	 * 编辑一个字典值
	 */
	@Override
	public BaseResponse<Map<String, Object>> editDict(DictionaryVo dictionaryVo) {
		BaseResponse<Map<String,Object>> response = new BaseResponse<Map<String,Object>>();
		if(dictionaryVo.getId() != null){
			DictionaryExample dictionaryExample = new DictionaryExample();
			dictionaryExample.createCriteria().andNameEqualTo(dictionaryVo.getName());
			List<Dictionary> selectByExample = sys.selectByExample(dictionaryExample);
			int edit = 0;
			if(selectByExample.size() > 0){//已存在
				WebUtils.Error(response, "该字典已存在!");
				return response;
			}else{
				Dictionary dictionary = new Dictionary();
				BeanUtils.copyProperties(dictionaryVo, dictionary);
				edit = sys.updateByPrimaryKeySelective(dictionary);
			}
			if(edit > 0){
				//查询新数据更新缓存
				DictionaryExample all = new DictionaryExample();
				List<Dictionary> all_dicts = sys.selectByExample(all);
				ForeverEHCacheManager.remove(Constants.DICT);
				ForeverEHCacheManager.set(Constants.DICT,all_dicts);
				WebUtils.Success(response, "编辑成功!");
			}else{
				WebUtils.Error(response, "编辑失败!");
			}
		}else{
			WebUtils.Error(response, "数据出错!");
		}
		return response;
	}


	/**
	 * 删除一个字典值
	 */
	@Override
	public BaseResponse<Map<String, Object>> delDict(long id) {
		BaseResponse<Map<String,Object>> response = new BaseResponse<Map<String,Object>>();
		if(id > 0){
			int del = sys.deleteByPrimaryKey(id);
			if(del > 0 ){
				WebUtils.Success(response, "删除成功!");
				return response;
			}
		}
		WebUtils.Error(response, "删除失败!");
		return response;
	}


	/**
	 * 获取注册中心授权给本系统的字典类型
	 */
	@Override
	public BaseResponse<List<DataDictionary>> getZczxDictionaryType() {
		BaseResponse<List<DataDictionary>> response = new BaseResponse<List<DataDictionary>>();
		String zczx_code = UploadConfig.getSystemDictByZczx();
		if(!"".equals(zczx_code)){
			DataDictionaryExample example = new DataDictionaryExample();
			example.createCriteria().andDictionaryCodeEqualTo(zczx_code);
			List<DataDictionary> zczx_dict = zczx.selectByExample(example);
			if(zczx_dict.size() > 0){
				DataDictionaryExample example2 = new DataDictionaryExample();
				example2.createCriteria().andDictionarySourceEqualTo(zczx_dict.get(0).getId());
				List<DataDictionary> zczx_dict_type = zczx.selectByExample(example2);
				response.setData(zczx_dict_type);
			}
		}
		return response;
	}
	
	
}
