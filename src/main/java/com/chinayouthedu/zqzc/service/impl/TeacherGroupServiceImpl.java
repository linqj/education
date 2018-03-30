package com.chinayouthedu.zqzc.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chinayouthedu.zqzc.common.core.WebUtils;
import com.chinayouthedu.zqzc.config.core.BaseResponse;
import com.chinayouthedu.zqzc.config.exception.WebException;
import com.chinayouthedu.zqzc.entity.paike.CourseTgroup;
import com.chinayouthedu.zqzc.entity.paike.CourseTgroupExample;
import com.chinayouthedu.zqzc.entity.paike.Teacher;
import com.chinayouthedu.zqzc.entity.paike.TeacherExample;
import com.chinayouthedu.zqzc.entity.paike.TeacherExample.Criteria;
import com.chinayouthedu.zqzc.entity.paike.TeacherGroup;
import com.chinayouthedu.zqzc.entity.paike.TeacherGroupExample;
import com.chinayouthedu.zqzc.entity.vo.TeacherGroupVo;
import com.chinayouthedu.zqzc.entity.vo.TeacherVo;
import com.chinayouthedu.zqzc.mapper.paike.CourseMapper;
import com.chinayouthedu.zqzc.mapper.paike.CourseTgroupMapper;
import com.chinayouthedu.zqzc.mapper.paike.TeacherGroupMapper;
import com.chinayouthedu.zqzc.mapper.paike.TeacherMapper;
import com.chinayouthedu.zqzc.service.TeacherGroupService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class TeacherGroupServiceImpl extends BaseServiceImpl implements TeacherGroupService {

	@Autowired
	private TeacherGroupMapper mapper;
	@Autowired
	private TeacherMapper tmapper;
	@Autowired
	private CourseTgroupMapper ctmapper;
	@Autowired
	private CourseMapper cmapper;

	/**
	 * 查询出所有的教研组
	 */
	@Override
	public BaseResponse<Map<String, Object>> selectAll(HttpServletRequest request) {
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
		//获取教研组信息,List
		TeacherGroupExample example = new TeacherGroupExample();
		List<TeacherGroup> list = mapper.selectByExample(example);
		PageInfo<TeacherGroup> info = new PageInfo<TeacherGroup>(list);
		
		for (TeacherGroup teacherGroup : list) {  //计算教研组人数
			TeacherExample example2 = new TeacherExample();
			example2.createCriteria().andTeacherGroupIdEqualTo(teacherGroup.getId());
			List<Teacher> list2 = tmapper.selectByExample(example2);
			teacherGroup.setTgTeacherNumber(list2.size());
			
			List<CourseTgroup> list3 = new ArrayList<>();

			CourseTgroupExample example3 = new CourseTgroupExample();
			example3.createCriteria().andTgroupIdEqualTo(teacherGroup.getId());
			List<CourseTgroup> list4 = ctmapper.selectByExample(example3);
			for (CourseTgroup courseTgroup : list4) {
				list3.add(courseTgroup);
			}

			teacherGroup.setCtList(list3);
			if (teacherGroup.getTgLeaderId() != null) {
				teacherGroup.setTgLeader(tmapper.selectByPrimaryKey(teacherGroup.getTgLeaderId()).getTeacherName());
			}
		}
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("total", info.getTotal());		//总共多少条
		map.put("totalPages", info.getPages());  //总共多少页
		map.put("pageNum", pageNum);		//第几页
		map.put("pageSize", pageSize);		//每页显示几条
		map.put("list", list);
		
		
		res.setData(map);
		return res;
	}

	/**
	 * 根据教研组id删除对应的教研组
	 */
	@Override
	public BaseResponse<Map<String, Object>> delTG(Long tgId) {
		BaseResponse<Map<String, Object>> res = new BaseResponse<Map<String, Object>>();
		int i = mapper.deleteByPrimaryKey(tgId);
		if (i > 0) {
			CourseTgroupExample example = new CourseTgroupExample();
			example.createCriteria().andTgroupIdEqualTo(tgId);
			List<CourseTgroup> list = ctmapper.selectByExample(example);
			int j = ctmapper.deleteByExample(example);
			if (j == list.size()) {
				WebUtils.Success(res, "删除成功!");
				return res;
			}else{
				WebUtils.Error(res, "删除失败!");
				return res;
			}
		}else{
			WebUtils.Error(res, "删除失败!");
			return res;
		}
	}

	/**
	 * 根据id查询出对应的教研组
	 */
	@Override
	public BaseResponse<Map<String, Object>> selectTgById(Long tgId) {
		BaseResponse<Map<String, Object>> res = new BaseResponse<Map<String, Object>>();
		
		Map<String,Object> map = new HashMap<String,Object>();
		TeacherGroup teacherGroup = mapper.selectByPrimaryKey(tgId);
		map.put("teacherGroup", teacherGroup);
		
		res.setData(map);
		return res;
	}

	/**
	 * 新增教研组
	 */
	@Override
	@Transactional("paikeTransactionManager")
	public BaseResponse<Map<String, Object>> saveTG(TeacherGroupVo vo, Long[] courseIds) {
		BaseResponse<Map<String, Object>> res = new BaseResponse<Map<String, Object>>();
		TeacherGroup teacherGroup = new TeacherGroup();
		teacherGroup.setCreateTime(new Date());
		teacherGroup.setTgName(vo.getTgName());
		teacherGroup.setTgCode(vo.getTgCode());
//		teacherGroup.setCourseDiscipline(vo.getCourseDiscipline());
		//先添加一个教研组,返回主键
		int i = mapper.insert(teacherGroup);
		if (i > 0) {
			if (courseIds == null || courseIds.length == 0) {
				WebUtils.Success(res, "保存成功!");
				return res;
			}
			int j = 0;
			for (Long courseId : courseIds) {
				CourseTgroup courseTgroup = new CourseTgroup();
				courseTgroup.setCourseId(courseId);
				courseTgroup.setCourseName(cmapper.selectByPrimaryKey(courseId).getCourseName());
				courseTgroup.setTgroupId(teacherGroup.getId());
				courseTgroup.setTgroupName(vo.getTgName());
				j += ctmapper.insert(courseTgroup);
			}
			if (j == courseIds.length) {
				WebUtils.Success(res, "保存成功!");
				return res;
			}else{
				throw new WebException(404,"保存失败!");
			}
		}else{
			throw new WebException(404,"保存失败!");
		}
	}

	/**
	 * 更新教研组
	 */
	@Override
	@Transactional("paikeTransactionManager")
	public BaseResponse<Map<String, Object>> updateTG(Long tgId, TeacherGroupVo vo, Long[] courseIds) {
		BaseResponse<Map<String, Object>> res = new BaseResponse<Map<String, Object>>();
		
		TeacherGroup teacherGroup = mapper.selectByPrimaryKey(tgId);
		teacherGroup.setTgName(vo.getTgName());
		teacherGroup.setTgCode(vo.getTgCode());
		teacherGroup.setUpdateTime(new Date());
		
		int i = mapper.updateByPrimaryKey(teacherGroup);
		if (i > 0) {
			CourseTgroupExample example = new CourseTgroupExample();
			example.createCriteria().andTgroupIdEqualTo(tgId);
			int j = ctmapper.deleteByExample(example);
			int k = 0;
			for (Long courseId : courseIds) {
				CourseTgroup courseTgroup = new CourseTgroup();
				courseTgroup.setCourseId(courseId);
				courseTgroup.setCourseName(cmapper.selectByPrimaryKey(courseId).getCourseName());
				courseTgroup.setTgroupId(teacherGroup.getId());
				courseTgroup.setTgroupName(vo.getTgName());
				k += ctmapper.insert(courseTgroup);
			}
			if (k == courseIds.length) {
				WebUtils.Success(res, "编辑成功!");
				return res;
			}else{
				throw new WebException(404,"编辑失败!");
			}
		}else{
			throw new WebException(404,"编辑失败!");
		}
		
	}

	/**
	 * 查询所有教研组列表,不分页 
	 */
	@Override
	public List<TeacherGroup> selectTg(){
		TeacherGroupExample teacherGroupExample = new TeacherGroupExample();
		List<TeacherGroup> list = mapper.selectByExample(teacherGroupExample);
		return list;
	}
	
	/**
	 * 根据教研组id查询出该教研组所有成员(List)
	 */
	@Override
	public BaseResponse<Map<String, Object>> selectTeacherByTgid(HttpServletRequest request, Long tgId, String search) {
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
		//获取教研组信息,List
		TeacherExample example = new TeacherExample();
		Criteria criteria = example.createCriteria();
		criteria.andTeacherGroupIdEqualTo(tgId);
		if (StringUtils.isNotBlank(search)) {
			criteria.andTeacherNameLike("%" + search + "%");
		}
		
		List<Teacher> teacherList = tmapper.selectByExample(example); //教研组下的所有教师List
		
		String leaderName ="";
		String leaderTwoName ="";
		
		TeacherExample example2 = new TeacherExample();
		example2.createCriteria().andTeacherGroupIdEqualTo(tgId).andIsLeaderEqualTo(true);
		List<Teacher> leaderList = tmapper.selectByExample(example2);
		if (leaderList.size() == 1) {
			leaderName = leaderList.get(0).getTeacherName();
		}
		TeacherExample example3 = new TeacherExample();
		example3.createCriteria().andTeacherGroupIdEqualTo(tgId).andIsLeaderTwoEqualTo(true);
		List<Teacher> leaderTwoList = tmapper.selectByExample(example3);
		if (leaderTwoList.size() == 1) {
			leaderTwoName = leaderTwoList.get(0).getTeacherName();
		}
		
		
		PageInfo<Teacher> info = new PageInfo<Teacher>(teacherList);
		
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("total", info.getTotal());		//总共多少条
		map.put("totalPages", info.getPages());  //总共多少页
		map.put("pageNum", pageNum);		//第几页
		map.put("pageSize", pageSize);		//每页显示几条
		map.put("list", teacherList);
		map.put("leaderName", leaderName);
		map.put("leaderTwoName", leaderTwoName);
		res.setData(map);
		return res;
		
		
		
		
		//???
	/*	TeacherExample example2 = new TeacherExample();
		example2.createCriteria().andTeacherGroupIdEqualTo(tgId).andIsLeaderEqualTo(true);
		List<Teacher> leaderList = tmapper.selectByExample(example2);
		if (leaderList.size() == 1) {
			for (Teacher leader : leaderList) {
				map.put("leader", leader);
			}
		}
		
		TeacherExample example3 = new TeacherExample();
		example3.createCriteria().andTeacherGroupIdEqualTo(tgId).andIsLeaderTwoEqualTo(true);
		List<Teacher> leadertwoList = tmapper.selectByExample(example3);
		if (leadertwoList.size() == 1) {
			for (Teacher leadertwo : leadertwoList) {
				map.put("leadertwo", leadertwo);
			}
		}*/
	}

	/**
	 * 查询所有没加入教研组的教师列表(List)
	 */
	@Override
	public BaseResponse<Map<String, Object>> selectNotTg() {
		BaseResponse<Map<String, Object>> res = new BaseResponse<Map<String, Object>>();
		TeacherExample example = new TeacherExample();
		example.createCriteria().andTeacherGroupIdIsNull()
								.andTeacherGroupNameIsNull();
								
		List<Teacher> teacherList = tmapper.selectByExample(example);
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("teacherList", teacherList);
		res.setData(map);
		return res;
	}

	
	/**
	 * 保存教师进入教研组
	 */
	@Override
	@Transactional("paikeTransactionManager")
	public BaseResponse<Map<String, Object>> saveTeacherToTg(Long[] tIds, Long tgId) {
		BaseResponse<Map<String, Object>> res = new BaseResponse<Map<String, Object>>();
		String tgName = mapper.selectByPrimaryKey(tgId).getTgName();
		int i = 0;
		for (Long tId : tIds) {
			Teacher teacher = tmapper.selectByPrimaryKey(tId);
			teacher.setTeacherGroupId(tgId);
			teacher.setTeacherGroupName(tgName);
			teacher.setUpdateTime(new Date());
			i += tmapper.updateByPrimaryKey(teacher);
		}
		if (i == tIds.length) {
			WebUtils.Success(res, "保存成功!");
			return res;
		}else{
			throw new WebException(404,"保存失败!");
		}
	}
	
	
	/**
	 * 查询除了教研组长外的教师列表
	 */
	@Override
	public BaseResponse<Map<String, Object>> selectTgLeader(Long tgId) {
		BaseResponse<Map<String, Object>> res = new BaseResponse<Map<String, Object>>();
		TeacherExample example = new TeacherExample();
		example.createCriteria().andTeacherGroupIdEqualTo(tgId).andIsLeaderEqualTo(false);
		List<Teacher> teacherList = tmapper.selectByExample(example);
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("teacherList", teacherList);
		res.setData(map);
		return res;
	}

	/**
	 * 查询除了教研组副组长外的教师列表
	 */
	@Override
	public BaseResponse<Map<String, Object>> selectTgLeaderTwo(Long tgId) {
		BaseResponse<Map<String, Object>> res = new BaseResponse<Map<String, Object>>();
		TeacherExample example = new TeacherExample();
		example.createCriteria().andTeacherGroupIdEqualTo(tgId).andIsLeaderTwoEqualTo(false);
		List<Teacher> teacherList = tmapper.selectByExample(example);
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("teacherList", teacherList);
		res.setData(map);
		return res;
	}

	/**
	 * 保存修改的教研组长
	 */
	@Override
	@Transactional("paikeTransactionManager")
	public BaseResponse<Map<String, Object>> saveLeader(Long tgId, Long tId) {
		BaseResponse<Map<String, Object>> res = new BaseResponse<Map<String, Object>>();
		
		TeacherExample example = new TeacherExample();
		example.createCriteria().andTeacherGroupIdEqualTo(tgId).andIsLeaderEqualTo(true);
		List<Teacher> list = tmapper.selectByExample(example);
		if (list.size() == 1 && list != null) {	 //原本有一个组长
			int i = 0;
			//先删除教师组长的标识以及在教研组表中的组长id和name
			for (Teacher teacher : list) {  
				teacher.setIsLeader(false);
				teacher.setUpdateTime(new Date());
				i += tmapper.updateByPrimaryKey(teacher);
				
				TeacherGroup teacherGroup = mapper.selectByPrimaryKey(tgId);
				teacherGroup.setTgLeader(null);
				teacherGroup.setTgLeaderId(null);
				i += mapper.updateByPrimaryKey(teacherGroup);
			}
			//在设置新的教研组长
			if (i == 2) {
				Teacher teacher = tmapper.selectByPrimaryKey(tId);
				TeacherGroup teacherGroup2 = mapper.selectByPrimaryKey(tgId);
				teacher.setIsLeader(true);
				teacher.setTeacherGroupName(teacherGroup2.getTgName());
				teacher.setUpdateTime(new Date());
				int j = tmapper.updateByPrimaryKey(teacher);
				
				
				if (j > 0) {
					TeacherGroup teacherGroup = mapper.selectByPrimaryKey(tgId);
					teacherGroup.setTgLeaderId(tId);
					teacherGroup.setTgLeader(teacher.getTeacherName());
					teacher.setUpdateTime(new Date());
					int k = mapper.updateByPrimaryKey(teacherGroup);
					
					if (k > 0) {
						WebUtils.Success(res, "修改成功!");
						return res;
					}else{
						throw new WebException(404,"修改失败!");
					}
				}else{
					throw new WebException(404,"修改失败!");
				}
			}else{
				throw new WebException(404,"修改失败!");
			}
		}else if(list.size() == 0){  //原本没有组长,直接指定
			//先更新教师信息
			Teacher teacher = tmapper.selectByPrimaryKey(tId);
			TeacherGroup teacherGroup = mapper.selectByPrimaryKey(tgId);
			teacher.setIsLeader(true);
			teacher.setTeacherGroupName(teacherGroup.getTgName());
			teacher.setUpdateTime(new Date());
			int j = tmapper.updateByPrimaryKey(teacher);
			//再更新教研组信息
			teacherGroup.setTgLeaderId(tId);
			teacherGroup.setTgLeader(teacher.getTeacherName());
			teacher.setUpdateTime(new Date());
			j += mapper.updateByPrimaryKey(teacherGroup);
			if (j == 2) {
				WebUtils.Success(res, "修改成功!");
				return res;
			}else{
				throw new WebException(404,"修改失败!");
			}
		}else{
			throw new WebException(404,"修改失败!");
		}
	}

	/**
	 * 保存修改的教研组副组长
	 */
	@Override
	@Transactional("paikeTransactionManager")
	public BaseResponse<Map<String, Object>> saveLeaderTwo(Long tgId, Long tId) {
		BaseResponse<Map<String, Object>> res = new BaseResponse<Map<String, Object>>();
		
		TeacherExample example = new TeacherExample();
		example.createCriteria().andTeacherGroupIdEqualTo(tgId).andIsLeaderTwoEqualTo(true);
		List<Teacher> list = tmapper.selectByExample(example);
		if (list.size() == 1 && list != null) { //原本有一个副组长.修改
			int i = 0;
			//先删除教师组长的标识以及在教研组表中的组长id和name
			for (Teacher teacher : list) {
				teacher.setIsLeaderTwo(false);
				teacher.setUpdateTime(new Date());
				i += tmapper.updateByPrimaryKey(teacher);
				
				TeacherGroup teacherGroup = mapper.selectByPrimaryKey(tgId);
				teacherGroup.setTgLeaderTwo(null);
				teacherGroup.setTgLeaderTwoId(null);
				i += mapper.updateByPrimaryKey(teacherGroup);
			}
			if (i == 2) {
				Teacher teacher = tmapper.selectByPrimaryKey(tId);
				TeacherGroup teacherGroup2 = mapper.selectByPrimaryKey(tgId);
				teacher.setIsLeaderTwo(true);
				teacher.setTeacherGroupName(teacherGroup2.getTgName());
				teacher.setUpdateTime(new Date());
				int j = tmapper.updateByPrimaryKey(teacher);
				
				if (j > 0) {
					TeacherGroup teacherGroup = mapper.selectByPrimaryKey(tgId);
					teacherGroup.setTgLeaderTwoId(tId);
					teacherGroup.setTgLeaderTwo(teacher.getTeacherName());
					teacher.setUpdateTime(new Date());
					int k = mapper.updateByPrimaryKey(teacherGroup);
					
					if (k > 0) {
						WebUtils.Success(res, "修改成功!");
						return res;
					}else{
						throw new WebException(404,"修改失败!");
					}
				}else{
					throw new WebException(404,"修改失败!");
				}
			}else{
				throw new WebException(404,"修改失败!");
			}
		}else if(list.size() == 0){  //原本没有副组长,直接指定
			
			
			
			//先更新教师信息
			Teacher teacher = tmapper.selectByPrimaryKey(tId);
			TeacherGroup teacherGroup = mapper.selectByPrimaryKey(tgId);
			teacher.setIsLeaderTwo(true);
			teacher.setTeacherGroupName(teacherGroup.getTgName());
			teacher.setUpdateTime(new Date());
			int j = tmapper.updateByPrimaryKey(teacher);
			//再更新教研组信息
			teacherGroup.setTgLeaderTwoId(tId);
			teacherGroup.setTgLeaderTwo(teacher.getTeacherName());
			teacher.setUpdateTime(new Date());
			j += mapper.updateByPrimaryKey(teacherGroup);
			
			
			
			if (j == 2) {
				WebUtils.Success(res, "修改成功!");
				return res;
			}else{
				throw new WebException(404,"修改失败!");
			}
		}else{
			throw new WebException(404,"修改失败!");
		}
	}

	/**
	 * 从教研组中删除教师
	 */
	@Override
	public BaseResponse<Map<String, Object>> delTeacherFromTg(Long tId) {
		BaseResponse<Map<String, Object>> res = new BaseResponse<Map<String, Object>>();
		Teacher teacher = tmapper.selectByPrimaryKey(tId);
		teacher.setIsLeader(false);
		teacher.setIsLeaderTwo(false);
		teacher.setTeacherGroupId(null);
		teacher.setTeacherGroupName(null);
		int i = tmapper.updateByPrimaryKey(teacher);
		if (i > 0) {
			WebUtils.Success(res, "删除成功!");
			return res;
		}else{
			WebUtils.Error(res, "删除失败!");
			return res;
		}
	}

	/**
	 * 批量删除教研组内选中的教师
	 */
	@Override
	@Transactional("paikeTransactionManager")
	public BaseResponse<Map<String, Object>> delMulti(Long[] tIds) {
		BaseResponse<Map<String, Object>> res = new BaseResponse<Map<String, Object>>();
		int i = 0;
		for (Long long1 : tIds) {
			Teacher teacher = tmapper.selectByPrimaryKey(long1);
			teacher.setIsLeader(false);
			teacher.setIsLeaderTwo(false);
			teacher.setTeacherGroupId(null);
			teacher.setTeacherGroupName(null);
			i += tmapper.updateByPrimaryKey(teacher);
		}
		if (i == tIds.length) {
			WebUtils.Success(res, "删除成功!");
			return res;
		}else{
			throw new WebException(404,"删除失败!");
		}
	}

	/**
	 * 编辑保存教研组的教师信息
	 */
	@Override
	public BaseResponse<Map<String, Object>> saveTeacher(TeacherVo vo, Long id) {
		BaseResponse<Map<String, Object>> res = new BaseResponse<Map<String, Object>>();
		//查询出对应教师
		Teacher teacher = tmapper.selectByPrimaryKey(id);
		if (teacher.getId() != null && teacher != null) {
			//修改教师的参数
			teacher.setTeacherName(vo.getTeacherName());
			teacher.setTeacherGender(vo.getTeacherGender());
			teacher.setTeacherNumber(vo.getTeacherNumber());
			teacher.setTeacherLevel(vo.getTeacherLevel());
			teacher.setUpdateTime(new Date());
			//更新教师
			int i = tmapper.updateByPrimaryKey(teacher);
			if (i > 0) {
				WebUtils.Success(res, "编辑成功!");
				return res;
			}else{
				WebUtils.Error(res, "编辑失败!");
				return res;
			}
		}else{
			WebUtils.Error(res, "编辑失败!");
			return res;
		}
	}

	/**
	 * 点击调整教研组,传输数据
	 * @author  梁建
	 * @Time   2018年3月21日上午11:13:33
	 * @return
	 */
	public List<TeacherGroup> toMove(Long tgId){
		TeacherGroupExample example = new TeacherGroupExample();
		example.createCriteria().andIdNotEqualTo(tgId);
		List<TeacherGroup> list = mapper.selectByExample(example);
		return list;
	}
	
	/**
	 * 批量调整教研组
	 */
	@Override
	@Transactional("paikeTransactionManager")
	public BaseResponse<Map<String, Object>> moveTeacherToTg(Long[] tIds, Long tgId) {
		BaseResponse<Map<String, Object>> res = new BaseResponse<Map<String, Object>>();
		Map<String,Object> map = new HashMap<String,Object>();
		int i = 0;
		for (Long tId : tIds) {
			Teacher teacher = tmapper.selectByPrimaryKey(tId);
			if (teacher.getIsLeader() == true) {
				TeacherGroup teacherGroup = mapper.selectByPrimaryKey(teacher.getTeacherGroupId());
				teacherGroup.setTgLeaderId(null);
				teacherGroup.setTgLeader(null);
				mapper.updateByPrimaryKey(teacherGroup);
			}
			if (teacher.getIsLeaderTwo() == true) {
				TeacherGroup teacherGroup = mapper.selectByPrimaryKey(teacher.getTeacherGroupId());
				teacherGroup.setTgLeaderTwoId(null);
				teacherGroup.setTgLeaderTwo(null);
				mapper.updateByPrimaryKey(teacherGroup);
			}
			teacher.setTeacherGroupId(tgId);
			teacher.setTeacherGroupName(mapper.selectByPrimaryKey(tgId).getTgName());
			teacher.setIsLeader(false);
			teacher.setIsLeaderTwo(false);
			i += tmapper.updateByPrimaryKey(teacher);
		}
		if (i == tIds.length) {
			WebUtils.Success(res, "调整成功!");
			return res;
		}else{
			throw new WebException(404,"调整失败!");
		}
	}

	/**
	 * 教研组内的搜索框模糊查询
	 */
	@Override
	public List<Teacher> searchTeacher(String search, Long tgId) {
		TeacherExample example = new TeacherExample();
		example.createCriteria().andTeacherGroupIdEqualTo(tgId).andTeacherNameLike("%"+search+"%");
		example.or().andTeacherGroupIdEqualTo(tgId).andTeacherNumberLike("%"+search+"%");
		List<Teacher> list = tmapper.selectByExample(example);
		
		return list;
	}
	
	
}
