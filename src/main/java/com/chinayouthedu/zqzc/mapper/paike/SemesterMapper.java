package com.chinayouthedu.zqzc.mapper.paike;

import com.chinayouthedu.zqzc.entity.paike.Semester;
import com.chinayouthedu.zqzc.entity.paike.SemesterExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SemesterMapper {
    long countByExample(SemesterExample example);

    int deleteByExample(SemesterExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Semester record);

    int insertSelective(Semester record);

    List<Semester> selectByExample(SemesterExample example);

    Semester selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Semester record, @Param("example") SemesterExample example);

    int updateByExample(@Param("record") Semester record, @Param("example") SemesterExample example);

    int updateByPrimaryKeySelective(Semester record);

    int updateByPrimaryKey(Semester record);
}