package com.chinayouthedu.zqzc.mapper.paike;

import com.chinayouthedu.zqzc.entity.paike.CoursePlan;
import com.chinayouthedu.zqzc.entity.paike.CoursePlanExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface CoursePlanMapper {
    long countByExample(CoursePlanExample example);

    int deleteByExample(CoursePlanExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CoursePlan record);

    int insertSelective(CoursePlan record);

    List<CoursePlan> selectByExample(CoursePlanExample example);

    CoursePlan selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CoursePlan record, @Param("example") CoursePlanExample example);

    int updateByExample(@Param("record") CoursePlan record, @Param("example") CoursePlanExample example);

    int updateByPrimaryKeySelective(CoursePlan record);

    int updateByPrimaryKey(CoursePlan record);

    List<CoursePlan> getCoursePlanList(@Param("map") Map<String,Long> map);

    int createCoursePlan(@Param("list") List<CoursePlan> list);

    List<CoursePlan> selectGradeBySchoolYearIdAndSemesterId(@Param("map") Map<String,Long> map);
}