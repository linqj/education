package com.chinayouthedu.zqzc.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chinayouthedu.zqzc.common.core.WebUtils;
import com.chinayouthedu.zqzc.config.core.BaseResponse;
import com.chinayouthedu.zqzc.entity.paike.Cla;
import com.chinayouthedu.zqzc.entity.paike.ClaExample;
import com.chinayouthedu.zqzc.entity.paike.Grade;
import com.chinayouthedu.zqzc.entity.paike.GradeClass;
import com.chinayouthedu.zqzc.entity.paike.GradeClassExample;
import com.chinayouthedu.zqzc.entity.paike.GradeExample;
import com.chinayouthedu.zqzc.entity.vo.GradeVo;
import com.chinayouthedu.zqzc.mapper.paike.ClaMapper;
import com.chinayouthedu.zqzc.mapper.paike.GradeClassMapper;
import com.chinayouthedu.zqzc.mapper.paike.GradeMapper;
import com.chinayouthedu.zqzc.service.ClassService;
import com.chinayouthedu.zqzc.service.GradeService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class GradeServiceImpl extends BaseServiceImpl implements GradeService {

	@Autowired
	private GradeMapper gradeMapper;

	@Autowired
	private GradeClassMapper gcMapper;

	@Autowired
	private ClassService classService;
	
	// 为了更高效的查询班级数据，减少数据库访问，引入Mapper进行条件查询
	@Autowired
	private ClaMapper classMapper;

	/**
	 * 通过年级ID查询年级下的所有的班级的ID的集合， !!!返回所有的班级，结果中可能有effective==false的班级存在
	 * 
	 * @param gradeId
	 *            年级ID
	 * @return
	 */
	private List<Long> getClassIdsByGradeId(Long gradeId) {

		// 1.创建结果集
		List<Long> list = new ArrayList<Long>();

		// 2.数据库查询关联数据
		GradeClassExample example = new GradeClassExample();
		example.createCriteria().andGradeIdEqualTo(gradeId).andEffictiveEqualTo(true);
		List<GradeClass> gcs = gcMapper.selectByExample(example);
		// logger.info(gson.toJson(gcs));

		// 3.取关联数据的class_id加入结果集并返回
		List<Long> classIdList = new ArrayList<Long>();
		if (gcs != null) {
			gcs.forEach(gc -> {
				classIdList.add(gc.getClassId());
			});
		}
		// logger.info(gson.toJson(classIdList));
		;

		return classIdList;

	}

	public List<Cla> getClaListByGradeId(List<Long> gradeIdList) {
		List<Cla> result = new ArrayList<Cla>();
		if (gradeIdList != null && gradeIdList.size() > 0) {
			gradeIdList.forEach(cla -> result.addAll(getClaListByGradeId(gradeIdList)));
		}
		return result;
	}

	public List<Grade> getGrades() {
		GradeExample example = new GradeExample();
		example.createCriteria().andEffectiveEqualTo(true);
		return gradeMapper.selectByExample(example);
	}

	@Override
	public PageInfo<GradeVo> getGradeVoPageList(Integer pageNum, Integer pageSize) {

		// 1.创建GradeVo集合
		List<GradeVo> gradeVoList = new ArrayList<GradeVo>();

		// 2.分页查询出Grade对象的集合
		GradeExample example = new GradeExample();
		example.createCriteria().andEffectiveEqualTo(true);

		PageHelper.startPage(pageNum, pageSize);
		List<Grade> gradeList = gradeMapper.selectByExample(example);
		PageInfo gradePageInfo = new PageInfo<>(gradeList);

		// 3.将Grade转成GradeVo
		if (gradePageInfo != null && gradePageInfo.getList() != null && gradePageInfo.getList().size() > 0) {
			gradePageInfo.getList().forEach(g -> {

				Grade grade = (Grade) g;
				GradeVo gradeVo = new GradeVo();
				gradeVo.setGrade(grade);
				gradeVo.setClassList(classService.selectAllClassesByGradeId(grade.getId()));
				gradeVoList.add(gradeVo);

			});
		}

		// 4.组合成新的PageInfo对象
		gradePageInfo.setList(gradeVoList);

		// 5.返回PageInfo对象
		return (PageInfo<GradeVo>) gradePageInfo;

	}

	@Override
	public List<Grade> getAllEffectiveGrade() {

		GradeExample example = new GradeExample();
		example.createCriteria()
				.andEffectiveEqualTo(true);

		return gradeMapper.selectByExample(example);

	}

	@Override
	public BaseResponse<Map<String, Object>> save(Grade grade) {

		BaseResponse<Map<String, Object>> response = new BaseResponse<Map<String, Object>>();

		// 1.对象校验
		boolean objEffective = (grade != null && grade.getId() == null);
		if (objEffective) {
			Date createTime = new Date();
			grade.setCreateTime(createTime);
			grade.setUpdateTime(createTime);
			grade.setEffective(true);
			// 2.插入是否成功校验
			boolean insertSuccess = gradeMapper.insert(grade) > 0;
			if (insertSuccess) {
				WebUtils.Success(response, "保存成功!");
				return response;
			}
		}
		WebUtils.Error(response, "保存失败!");
		return response;
	}

	@Override
	public BaseResponse<Map<String, Object>> update(Grade grade) {

		BaseResponse<Map<String, Object>> response = new BaseResponse<Map<String, Object>>();
		if (grade == null || grade.getId() == null) {
			WebUtils.Error(response, "数据有误,更新失败");
			return response;
		}

		// 1.根据ID查询数据库中的对象
		Grade gradeInDB = gradeMapper.selectByPrimaryKey(grade.getId());

		// 2.对象是否有效(合法)校验
		boolean objEffective = (gradeInDB != null && gradeInDB.getEffective() == true);
		logger.info("objEffective=" + objEffective);

		if (objEffective) {
			if (StringUtils.isNotBlank(grade.getGradeName())) {
				gradeInDB.setGradeName(grade.getGradeName());
			}
			if (grade.getGradeTotalClassNum() != null) {
				gradeInDB.setGradeTotalClassNum(grade.getGradeTotalClassNum());
			}
			if (StringUtils.isNotBlank(grade.getGradeType())) {
				gradeInDB.setGradeType(grade.getGradeType());
			}
			if (StringUtils.isNotBlank(grade.getGradeName())) {
				gradeInDB.setGradeName(grade.getGradeName());
			}
			if (StringUtils.isNotBlank(grade.getGradeCode())) {
				gradeInDB.setGradeCode(grade.getGradeCode());
			}
			if (grade.getEndDate() != null) {
				gradeInDB.setEndDate(grade.getEndDate());
			}
			gradeInDB.setUpdateTime(new Date());
			// 2.更新是否成功校验
			boolean updateSuccess = gradeMapper.updateByPrimaryKey(gradeInDB) > 0;
			if (updateSuccess) {
				WebUtils.Success(response, "更新成功");
				return response;
			}
		} else {
			WebUtils.Error(response, "无此班级,更新失败！!");
			return response;
		}
		WebUtils.Error(response, "保存失败!");
		return response;
	}

	@Override
	public Grade selectByPrimaryKey(long gradeId) {
		return gradeMapper.selectByPrimaryKey(gradeId);
	}

	@Override
	public GradeVo selectGradeWithClassList(Long gradeId) {

		GradeVo gradeVo = new GradeVo();

		Grade grade = gradeMapper.selectByPrimaryKey(gradeId);
		if (grade == null || grade.getEffective() == false) {
			return null;
		}

		gradeVo.setGrade(grade);
		gradeVo.setClassList(classService.selectAllClassesByGradeId(gradeId));

		return gradeVo;

	}

	@Override
	public BaseResponse deleteGrade(Long gradeId) {

		BaseResponse response = new BaseResponse();

		if (gradeId != null) {
			Grade gradeInDB = gradeMapper.selectByPrimaryKey(gradeId);
			if (gradeInDB != null && gradeInDB.getEffective() == true) {
				gradeInDB.setEffective(false);
				gradeInDB.setUpdateTime(new Date());
				boolean updateSuccess = gradeMapper.updateByPrimaryKey(gradeInDB) > 0;
				if (updateSuccess) {
					WebUtils.Success(response, "年级删除成功");
					return response;
				}
			}
		}

		WebUtils.Error(response, "年级删除失败");
		return response;

	}

	@Override
	public List<GradeVo> selectAllGradeVo() {
		
		// 1.查出所有的年级对象allGrade
		GradeExample allGradeExample = new GradeExample();
		allGradeExample.createCriteria()
				.andEffectiveEqualTo(true);
		
		List<Grade> allGrade = gradeMapper.selectByExample(allGradeExample );
		
		// 2.查出所有匹配的班级对象allClass
		List<Long> allGradeId = new ArrayList<>();
		if(allGrade!=null&&allGrade.size()>0){
			allGrade.forEach(grade->{
				if(grade!=null&&grade.getId()!=null){
					allGradeId.add(grade.getId() );
				}
			});
		}
		
		List<Cla> allClass = new ArrayList<>();
		if(allGradeId.size()>0){
			ClaExample allClassExample = new ClaExample();
			allClassExample.createCriteria()
					.andEffictiveEqualTo(true)
					.andClassGradeIdIn(allGradeId );
			allClass = classMapper.selectByExample(allClassExample );
		}
		
		// 3.组装成GradeVo集合
		List<GradeVo > allGradeVo = new ArrayList<>();
		
		// 3.1.先将所有的班级转成<gradeId,List<Cla>>的Map形式
		Map<Long,List<Cla>> allClassMap = new HashMap<>();
		allClass.forEach(cla->{
			if(cla!=null){
				Long gradeId = cla.getClassGradeId();
				if(gradeId!=null){
					if(!allClassMap.containsKey(gradeId)){
						allClassMap.put(gradeId, new ArrayList<Cla>());
					}
					allClassMap.get(gradeId ).add(cla );
				}
			}
		});
		
		// 3.2.组装GradeVo
		if(allGrade!=null&&allGrade.size()>0){
			allGrade.forEach(grade->{
				GradeVo gradeVo = new GradeVo();
				gradeVo.setGrade(grade);
				gradeVo.setClassList(allClassMap.get(grade.getId() ));
				allGradeVo.add(gradeVo );
			});
		}
		
		// 4.返回结果
		return allGradeVo;
		
	}

}