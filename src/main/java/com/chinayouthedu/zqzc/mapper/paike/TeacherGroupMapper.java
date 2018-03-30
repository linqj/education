package com.chinayouthedu.zqzc.mapper.paike;

import com.chinayouthedu.zqzc.entity.paike.TeacherGroup;
import com.chinayouthedu.zqzc.entity.paike.TeacherGroupExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TeacherGroupMapper {
    long countByExample(TeacherGroupExample example);

    int deleteByExample(TeacherGroupExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TeacherGroup record);

    int insertSelective(TeacherGroup record);

    List<TeacherGroup> selectByExample(TeacherGroupExample example);

    TeacherGroup selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TeacherGroup record, @Param("example") TeacherGroupExample example);

    int updateByExample(@Param("record") TeacherGroup record, @Param("example") TeacherGroupExample example);

    int updateByPrimaryKeySelective(TeacherGroup record);

    int updateByPrimaryKey(TeacherGroup record);
}