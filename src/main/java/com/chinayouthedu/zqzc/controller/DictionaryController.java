package com.chinayouthedu.zqzc.controller;

import java.util.List;
import java.util.Map;

import com.chinayouthedu.zqzc.common.utils.DictUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.chinayouthedu.zqzc.config.core.BaseController;
import com.chinayouthedu.zqzc.config.core.BaseResponse;
import com.chinayouthedu.zqzc.entity.paike.DataDictionary;
import com.chinayouthedu.zqzc.entity.paike.Dictionary;
import com.chinayouthedu.zqzc.entity.vo.DictionaryVo;
import com.chinayouthedu.zqzc.service.DictionaryService;
import com.github.pagehelper.PageInfo;

/**
 * 字典管理
 * @Company 中青至诚教育咨询有限公司
 * @author 张超群
 * @Modifier
 * @time  2018年3月24日   下午8:30:57 
 * @version 1.0
 */
@RestController
public class DictionaryController extends BaseController {

	@Autowired
	private DictionaryService dictService;
	
	/**
	 * 根据字典类型获取字典值
	 * @author 张超群 
	 * @Time   2018年3月12日上午11:27:44
	 * @param   code	字典类型
	 * @return	json
	 */
	@GetMapping("/dictionary/{code}")
	@ResponseBody
	public BaseResponse<List<Dictionary>> getPaikeDictionary(@PathVariable(value="code",required=true) String code){
		BaseResponse<List<Dictionary>> response = new BaseResponse<List<Dictionary>>();
		List<Dictionary> list = DictUtils.getDictListByTypeCode(code);
//		List<Dictionary> list = dictService.selectDictBySystemTypeCode(code);
		response.setData(list);
		return response;
	}
	
	/**
	 * 获取注册中心授权给本系统的字典类型
	 * @author  张超群	2018年3月24日 下午9:31:51
	 * @return
	 */
	@GetMapping("/dict/type")
	@ResponseBody
	public BaseResponse<List<DataDictionary>> getZczxDictionaryType(){
		BaseResponse<List<DataDictionary>> response = dictService.getZczxDictionaryType();
		return response;
	}
	
	/**
	 * 获取字典展示页的tree
	 * @author  张超群	2018年3月24日 下午9:29:12
	 * @param pageNum	int	第几页
	 * @param pageSize	int	每页显示条数
	 * @return json tree
	 */
	@GetMapping("/dict/list")
	@ResponseBody
	public BaseResponse<PageInfo<DataDictionary>> getPaikeDictionaryList(@RequestParam(value="pageNum",required=true,defaultValue="1") int pageNum,
			@RequestParam(value="pageSize",required=true,defaultValue="10") int pageSize){
		BaseResponse<PageInfo<DataDictionary>> response = dictService.selectDictList(pageNum,pageSize);
		return response;
	}
	
	/**
	 * 创建一个字典值
	 * @author  张超群	2018年3月24日 下午9:31:17
	 * @param dictionaryVo	字典VO
	 * @return
	 */
	@PostMapping("/dict/save")
	@ResponseBody
	public BaseResponse<Map<String,Object>> createPaikeDictionary(DictionaryVo dictionaryVo){
		BaseResponse<Map<String,Object>> response = dictService.createDict(dictionaryVo);
		return response;
	}
	
	/**
	 * 编辑一个字典值
	 * @author  张超群	2018年3月24日 下午9:31:36
	 * @param dictionaryVo	字典VO
	 * @return
	 */
	@PostMapping("/dict/edit")
	@ResponseBody
	public BaseResponse<Map<String,Object>> editPaikeDictionary(DictionaryVo dictionaryVo){
		BaseResponse<Map<String,Object>> response = dictService.editDict(dictionaryVo);
		return response;
	}
	
	/**
	 * 删除一个字典值
	 * @author  张超群	2018年3月24日 下午9:31:44
	 * @param id	long	字典id
	 * @return
	 */
	@DeleteMapping("/dict/del/{id}")
	@ResponseBody
	public BaseResponse<Map<String,Object>> delPaikeDictionary(@RequestParam(value="id",required=true,defaultValue="1") long id){
		BaseResponse<Map<String,Object>> response = dictService.delDict(id);
		return response;
	}
	
	

}
