package com.chinayouthedu.zqzc.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chinayouthedu.zqzc.common.core.WebUtils;
import com.chinayouthedu.zqzc.config.core.BaseResponse;
import com.chinayouthedu.zqzc.entity.paike.Classroom;
import com.chinayouthedu.zqzc.entity.paike.ClassroomExample;
import com.chinayouthedu.zqzc.entity.vo.ClassroomVo;
import com.chinayouthedu.zqzc.mapper.paike.ClassroomMapper;
import com.chinayouthedu.zqzc.service.ClassroomService;

@Service
public class ClassroomImpl implements ClassroomService {

	@Autowired
	private ClassroomMapper mapper;
	
	@Override
	public long countByExample(ClassroomExample example) {
		return mapper.countByExample(example);
	}

	@Override
	public int deleteByExample(ClassroomExample example) {
		return mapper.deleteByExample(example);
	}

	@Override
	public int deleteByPrimaryKey(Long id) {
		return mapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(Classroom record) {
		return mapper.insert(record);
	}

	@Override
	public int insertSelective(Classroom record) {
		return mapper.insertSelective(record);
	}

	@Override
	public List<Classroom> selectByExample(ClassroomExample example) {
		return mapper.selectByExample(example);
	}

	@Override
	public Classroom selectByPrimaryKey(Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateByExampleSelective(Classroom record, ClassroomExample example) {
		return mapper.updateByExampleSelective(record, example);
	}

	@Override
	public int updateByExample(Classroom record, ClassroomExample example) {
		return mapper.updateByExample(record, example);
	}

	@Override
	public int updateByPrimaryKeySelective(Classroom record) {
		return mapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(Classroom record) {
		return mapper.updateByPrimaryKey(record);
	}

	/***
	 * 根据教学楼id查出所有教室
	 */
	@Override
	public List<Classroom> selectClassroom(Long cbId) {
		ClassroomExample example = new ClassroomExample();
		example.createCriteria().andRoomBuildingIdEqualTo(cbId);
		List<Classroom> list = mapper.selectByExample(example);
		return list;
	}

	@Override
	public BaseResponse<Map<String, Object>> updateClassroom(Long crId, ClassroomVo vo) {
		BaseResponse<Map<String, Object>> response = new BaseResponse<Map<String, Object>>();
		if (crId != null) {
			Classroom classroom = mapper.selectByPrimaryKey(crId);
			BeanUtils.copyProperties(vo, classroom);
			classroom.setUpdateTime(new Date());
			int i = mapper.updateByPrimaryKey(classroom);
			if (i > 0) {
				WebUtils.Success(response, "编辑成功!");
				return response;
			}
		}
		WebUtils.Error(response, "编辑失败!");
		return response;
	}

}
