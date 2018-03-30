package com.chinayouthedu.zqzc.mapper.paike;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.chinayouthedu.zqzc.entity.paike.StudentClass;
import com.chinayouthedu.zqzc.entity.paike.StudentClassExample;

public interface StudentClassMapper {
    int countByExample(StudentClassExample example);

    int deleteByExample(StudentClassExample example);

    int deleteByPrimaryKey(Long id);

    int insert(StudentClass record);

    int insertSelective(StudentClass record);

    List<StudentClass> selectByExample(StudentClassExample example);

    StudentClass selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") StudentClass record, @Param("example") StudentClassExample example);

    int updateByExample(@Param("record") StudentClass record, @Param("example") StudentClassExample example);

    int updateByPrimaryKeySelective(StudentClass record);

    int updateByPrimaryKey(StudentClass record);
}