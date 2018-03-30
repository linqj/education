package com.chinayouthedu.zqzc.mapper.paike;

import com.chinayouthedu.zqzc.entity.paike.TeacherTgroup;
import com.chinayouthedu.zqzc.entity.paike.TeacherTgroupExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TeacherTgroupMapper {
    long countByExample(TeacherTgroupExample example);

    int deleteByExample(TeacherTgroupExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TeacherTgroup record);

    int insertSelective(TeacherTgroup record);

    List<TeacherTgroup> selectByExample(TeacherTgroupExample example);

    TeacherTgroup selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TeacherTgroup record, @Param("example") TeacherTgroupExample example);

    int updateByExample(@Param("record") TeacherTgroup record, @Param("example") TeacherTgroupExample example);

    int updateByPrimaryKeySelective(TeacherTgroup record);

    int updateByPrimaryKey(TeacherTgroup record);
}