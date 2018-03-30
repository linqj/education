package com.chinayouthedu.zqzc.mapper.paike;

import com.chinayouthedu.zqzc.entity.paike.CourseTgroup;
import com.chinayouthedu.zqzc.entity.paike.CourseTgroupExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CourseTgroupMapper {
    long countByExample(CourseTgroupExample example);

    int deleteByExample(CourseTgroupExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CourseTgroup record);

    int insertSelective(CourseTgroup record);

    List<CourseTgroup> selectByExample(CourseTgroupExample example);

    CourseTgroup selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CourseTgroup record, @Param("example") CourseTgroupExample example);

    int updateByExample(@Param("record") CourseTgroup record, @Param("example") CourseTgroupExample example);

    int updateByPrimaryKeySelective(CourseTgroup record);

    int updateByPrimaryKey(CourseTgroup record);
}