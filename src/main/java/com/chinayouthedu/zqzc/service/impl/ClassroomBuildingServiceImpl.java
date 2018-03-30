package com.chinayouthedu.zqzc.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chinayouthedu.zqzc.common.core.WebUtils;
import com.chinayouthedu.zqzc.config.core.BaseResponse;
import com.chinayouthedu.zqzc.entity.paike.ClassroomBuilding;
import com.chinayouthedu.zqzc.entity.paike.ClassroomBuildingExample;
import com.chinayouthedu.zqzc.entity.vo.ClassroomBuildingVo;
import com.chinayouthedu.zqzc.mapper.paike.ClassroomBuildingMapper;
import com.chinayouthedu.zqzc.service.ClassroomBuildingService;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class ClassroomBuildingServiceImpl implements ClassroomBuildingService {

	private Logger logger = LoggerFactory.getLogger(ClassroomBuildingServiceImpl.class);
	
	@Autowired
	private ClassroomBuildingMapper mapper;

	@Override
	public long countByExample(ClassroomBuildingExample example) {
		return mapper.countByExample(example);
	}

	@Override
	public int deleteByExample(ClassroomBuildingExample example) {
		return mapper.deleteByExample(example);
	}

	@Override
	public int deleteByPrimaryKey(Long id) {
		return mapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(ClassroomBuilding record) {
		return mapper.insert(record);
	}

	@Override
	public int insertSelective(ClassroomBuilding record) {
		return mapper.insertSelective(record);
	}

	@Override
	public List<ClassroomBuilding> selectByExample(ClassroomBuildingExample example) {
		return mapper.selectByExample(example);
	}

	@Override
	public ClassroomBuilding selectByPrimaryKey(Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateByExampleSelective(ClassroomBuilding record, ClassroomBuildingExample example) {
		return mapper.updateByExampleSelective(record, example);
	}

	@Override
	public int updateByExample(ClassroomBuilding record, ClassroomBuildingExample example) {
		return mapper.updateByExample(record, example);
	}

	@Override
	public int updateByPrimaryKeySelective(ClassroomBuilding record) {
		return mapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(ClassroomBuilding record) {
		return mapper.updateByPrimaryKey(record);
	}

	/***
	 * 查询所有的教学楼List
	 */
	@Override
	public List<ClassroomBuilding> selectAll() {
		ClassroomBuildingExample example = new ClassroomBuildingExample();
		List<ClassroomBuilding> list = mapper.selectByExample(example);
		return list;
	}

	/***
	 * 更新教学楼
	 */
	@Override
	public BaseResponse<Map<String, Object>> updateClassroomBuilding(Long cbId, ClassroomBuildingVo vo) {
		BaseResponse<Map<String,Object>> response = new BaseResponse<Map<String,Object>>();
		if (cbId != null) {
			ClassroomBuilding classroomBuilding = mapper.selectByPrimaryKey(cbId);
			BeanUtils.copyProperties(vo, classroomBuilding);
			classroomBuilding.setUpdateTime(new Date());
			int i = mapper.updateByPrimaryKey(classroomBuilding);
			if (i > 0) {
				WebUtils.Success(response, "编辑成功!");
				return response;
			}
		}
		WebUtils.Error(response, "编辑失败!");
		return response;
	}

	
	
}
