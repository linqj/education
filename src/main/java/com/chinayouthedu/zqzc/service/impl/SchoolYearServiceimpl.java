package com.chinayouthedu.zqzc.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chinayouthedu.zqzc.common.core.WebUtils;
import com.chinayouthedu.zqzc.config.core.BaseResponse;
import com.chinayouthedu.zqzc.config.exception.WebException;
import com.chinayouthedu.zqzc.entity.paike.SchoolYear;
import com.chinayouthedu.zqzc.entity.paike.SchoolYearExample;
import com.chinayouthedu.zqzc.entity.paike.Semester;
import com.chinayouthedu.zqzc.entity.paike.SemesterExample;
import com.chinayouthedu.zqzc.entity.vo.SchoolYearVo;
import com.chinayouthedu.zqzc.mapper.paike.SchoolYearMapper;
import com.chinayouthedu.zqzc.mapper.paike.SemesterMapper;
import com.chinayouthedu.zqzc.service.SchoolYearService;
import com.chinayouthedu.zqzc.service.SemesterService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class SchoolYearServiceimpl implements SchoolYearService {

	@Autowired
	private SchoolYearMapper mapper;
	
	@Autowired
	private SemesterMapper xqmapper;
	
	@Autowired
	private SemesterService xqService;
	
	
	@Override
	public long countByExample(SchoolYearExample example) {
		return mapper.countByExample(example);
	}

	@Override
	public int deleteByExample(SchoolYearExample example) {
		return mapper.deleteByExample(example);
	}

	@Override
	public int deleteByPrimaryKey(Long id) {
		return mapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(SchoolYear record) {
		return mapper.insert(record);
	}

	@Override
	public int insertSelective(SchoolYear record) {
		return mapper.insertSelective(record);
	}

	@Override
	public List<SchoolYear> selectByExample(SchoolYearExample example) {
		return mapper.selectByExample(example);
	}

	@Override
	public SchoolYear selectByPrimaryKey(Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateByExampleSelective(SchoolYear record, SchoolYearExample example) {
		return mapper.updateByExampleSelective(record, example);
	}

	@Override
	public int updateByExample(SchoolYear record, SchoolYearExample example) {
		return mapper.updateByExample(record, example);
	}

	@Override
	public int updateByPrimaryKeySelective(SchoolYear record) {
		return mapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(SchoolYear record) {
		return mapper.updateByPrimaryKey(record);
	}

	  /**
     * 查询所有学年,返回List
     * @author  梁建
     * @Time   2018年3月7日上午9:24:32
     * @return
     */
	@Override
	public List<SchoolYear> selectAll() {
		SchoolYearExample example = new SchoolYearExample();
		List<SchoolYear> list = mapper.selectByExample(example);
		return list;
	}

	
	 /**
     * 获取id学年下的所有学期
     * @author  梁建
     * @Time   2018年3月7日上午9:57:49
     * @param id
     * @return
     */
	@Override
	public List<Semester> selectBySyid(Long id) {
		SemesterExample example = new SemesterExample();
		example.createCriteria().andSchoolYearIdEqualTo(id);
		List<Semester> list = xqmapper.selectByExample(example);
		return list;
	}

	/***
	 * 更新学年信息
	 * Long xnId : 学年Id
	 * SchoolYearVo vo : 前台传递的业务对象
	 */
	@Override
	public int updateSchoolYear(SchoolYearVo vo, Long xnId) {
		SchoolYear schoolYear = mapper.selectByPrimaryKey(xnId);
		schoolYear.setSchoolYearCode(vo.getSchoolYearCode());
		schoolYear.setSchoolYearName(vo.getSchoolYearName());
		schoolYear.setUpdateTime(new Date());
		int i = mapper.updateByPrimaryKey(schoolYear);
		return i;
	}

	/**
	 * 进入学年学期列表 ,以及分页
	 */
	@Override
	public BaseResponse<Map<String, Object>> toList(HttpServletRequest request) {
		BaseResponse<Map<String, Object>> res = new BaseResponse<Map<String, Object>>();
		
		String pageNum = request.getParameter("pageNum") == null ? "1" : request.getParameter("pageNum");// 第几页
		String pageSize = request.getParameter("pageSize") == null ? "10" : request.getParameter("pageSize");// 显示几条
		if (!"".equals(pageNum) && pageNum.length() <= 0) {
			pageNum = "1";
		}
		if (!"".equals(pageSize) && pageSize.length() <= 0) {
			pageSize = "10";
		}
		PageHelper.startPage(Integer.parseInt(pageNum),Integer.parseInt(pageSize)); //开始分页
		//获取所有的学年信息,List
		List<SchoolYear> syList = selectAll();
		PageInfo<SchoolYear> info = new PageInfo<SchoolYear>(syList);
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("total", info.getTotal());		//总共多少条
		map.put("totalPages", info.getPages());  //总共多少页
		map.put("pageNum", pageNum);		//第几页
		map.put("pageSize", pageSize);		//每页显示几条
		if (syList.size() > 0) {
			//遍历学年中的学期(子结构)
			for (SchoolYear schoolYear : syList) {
				schoolYear.setChildren(selectBySyid(schoolYear.getId()));
			}
		}
		map.put("list", syList);
		res.setData(map);
		return res;
	}

	/**
	 * 学年学期父子List 不含分页
	 */
	@Override
	public List<SchoolYear> SchoolYearList() {
		//先获取所有的学年
		List<SchoolYear> syList = selectAll();
		if (syList.size() > 0) {
			//遍历学年中的学期(子结构)
			for (SchoolYear schoolYear : syList) {
				schoolYear.setChildren(selectBySyid(schoolYear.getId()));
			}
		}
		return syList;
	}

	/**
	 * 进入编辑学期页面
	 */
	@Override
	public BaseResponse<Map<String, Object>> toEdit(HttpServletRequest request) {
		BaseResponse<Map<String, Object>> res = new BaseResponse<Map<String, Object>>();
		//获取前台参数
		String xnId = request.getParameter("xnId");
		
		Map<String,Object> map = new HashMap<String,Object>();
		//根据xnId查询出对应的学年
		SchoolYear schoolYear = selectByPrimaryKey(Long.parseLong(xnId));
		//学年下的学期
		schoolYear.setChildren(selectBySyid(schoolYear.getId()));
		
		map.put("schoolYear", schoolYear);
		
		
		res.setData(map);
		return res;
	}

	/**
	 * 保存/编辑新的学年,学期
	 */
	@Override
	@Transactional("paikeTransactionManager")
	public BaseResponse<Map<String, Object>> saveSemester(SchoolYearVo vo, HttpServletRequest request) {
		BaseResponse<Map<String, Object>> res = new BaseResponse<Map<String, Object>>();
		//获取前台传递的学年id,用于判断
		String xnId = request.getParameter("xnId");
		Long xnid = StringUtils.isNotBlank(xnId)?Long.parseLong(xnId):null;
		
		if (xnid == null) {   //学年id为空,说明是新增
			SchoolYear schoolYear = new SchoolYear();
			schoolYear.setSchoolYearName(vo.getSchoolYearName());
			schoolYear.setSchoolYearCode(vo.getSchoolYearCode());
			schoolYear.setCreateTime(new Date());
			//先插入学年信息,返回主键.
			int i = insert(schoolYear);
			if (i > 0) {
				//学年信息添加成功的情况下.再添加学期信息数据
				int all = xqService.insertAll(schoolYear.getId(), vo);
				if (all > 1) {
					WebUtils.Success(res, "保存成功!");
					return res;
				}else{
					//回滚抛异常
					throw new WebException(404,"保存失败!");
				}
			}else{
				throw new WebException(404,"保存失败!");
			}
//			return res;
		}else{ //学年id不为空,说明是编辑
			//先更新学年信息
			int i = updateSchoolYear(vo, xnid);
			if (i > 0) {
				int j = xqService.updateFirstAndLast(xnid, vo);
				if (j > 1) {
					WebUtils.Success(res, "编辑成功!");
					return res;
				}else{
					throw new WebException(404,"编辑失败!");
				}
			}else{
				throw new WebException(404,"编辑失败!");
			}
//			return res;
		}
	}

	/**
	 * 删除学年及学期
	 */
	@Override
	@Transactional("paikeTransactionManager")
	public BaseResponse<Map<String, Object>> delSemester(Long xnid) {
		BaseResponse<Map<String, Object>> res = new BaseResponse<Map<String, Object>>();
		
		//先删除选中学年下的学期
		int i = xqService.deleteFirstAndLast(xnid);
		if (i > 1) {
			//学期删除成功后,再删除对应xnid下的学年
			int j = deleteByPrimaryKey(xnid);
			if (j > 0) {
				WebUtils.Success(res, "删除成功!");
				return res;
			}else{
				throw new WebException(404,"删除失败!");
			}
		}else{
			throw new WebException(404,"删除失败!");
		}
	}


}
