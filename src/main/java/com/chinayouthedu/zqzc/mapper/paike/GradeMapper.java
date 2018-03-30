package com.chinayouthedu.zqzc.mapper.paike;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import com.chinayouthedu.zqzc.entity.paike.Grade;
import com.chinayouthedu.zqzc.entity.paike.GradeExample;

public interface GradeMapper {
    int countByExample(GradeExample example);

    int deleteByExample(GradeExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Grade record);

    int insertSelective(Grade record);

    List<Grade> selectByExample(GradeExample example);

    Grade selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Grade record, @Param("example") GradeExample example);

    int updateByExample(@Param("record") Grade record, @Param("example") GradeExample example);

    int updateByPrimaryKeySelective(Grade record);

    int updateByPrimaryKey(Grade record);
}