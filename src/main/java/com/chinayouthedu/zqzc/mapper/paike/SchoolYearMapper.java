package com.chinayouthedu.zqzc.mapper.paike;

import com.chinayouthedu.zqzc.entity.paike.SchoolYear;
import com.chinayouthedu.zqzc.entity.paike.SchoolYearExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SchoolYearMapper {
    long countByExample(SchoolYearExample example);

    int deleteByExample(SchoolYearExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SchoolYear record);

    int insertSelective(SchoolYear record);

    List<SchoolYear> selectByExample(SchoolYearExample example);

    SchoolYear selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SchoolYear record, @Param("example") SchoolYearExample example);

    int updateByExample(@Param("record") SchoolYear record, @Param("example") SchoolYearExample example);

    int updateByPrimaryKeySelective(SchoolYear record);

    int updateByPrimaryKey(SchoolYear record);
}