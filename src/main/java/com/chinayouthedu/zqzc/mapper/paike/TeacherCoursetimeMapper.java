package com.chinayouthedu.zqzc.mapper.paike;

import com.chinayouthedu.zqzc.entity.paike.TeacherCoursetime;
import com.chinayouthedu.zqzc.entity.paike.TeacherCoursetimeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TeacherCoursetimeMapper {
    long countByExample(TeacherCoursetimeExample example);

    int deleteByExample(TeacherCoursetimeExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TeacherCoursetime record);

    int insertSelective(TeacherCoursetime record);

    List<TeacherCoursetime> selectByExample(TeacherCoursetimeExample example);

    TeacherCoursetime selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TeacherCoursetime record, @Param("example") TeacherCoursetimeExample example);

    int updateByExample(@Param("record") TeacherCoursetime record, @Param("example") TeacherCoursetimeExample example);

    int updateByPrimaryKeySelective(TeacherCoursetime record);

    int updateByPrimaryKey(TeacherCoursetime record);
}