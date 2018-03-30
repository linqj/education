package com.chinayouthedu.zqzc.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.chinayouthedu.zqzc.config.core.BaseResponse;
import com.chinayouthedu.zqzc.entity.paike.Classroom;
import com.chinayouthedu.zqzc.entity.paike.ClassroomExample;
import com.chinayouthedu.zqzc.entity.vo.ClassroomVo;

public interface ClassroomService {

    long countByExample(ClassroomExample example);

    int deleteByExample(ClassroomExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Classroom record);

    int insertSelective(Classroom record);

    List<Classroom> selectByExample(ClassroomExample example);

    Classroom selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Classroom record, @Param("example") ClassroomExample example);

    int updateByExample(@Param("record") Classroom record, @Param("example") ClassroomExample example);

    int updateByPrimaryKeySelective(Classroom record);

    int updateByPrimaryKey(Classroom record);
    
    /**
     * 根据教学楼id查出所有教室
     * @author  梁建
     * @Time   2018年3月12日上午10:40:41
     * @param cbId 教学楼id
     * @return
     */
    List<Classroom> selectClassroom(Long cbId);
    
    BaseResponse<Map<String, Object>> updateClassroom(Long crId, ClassroomVo vo);
    
}
