package com.chinayouthedu.zqzc.mapper.paike;

import com.chinayouthedu.zqzc.entity.paike.GradeClass;
import com.chinayouthedu.zqzc.entity.paike.GradeClassExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GradeClassMapper {
    long countByExample(GradeClassExample example);

    int deleteByExample(GradeClassExample example);

    int deleteByPrimaryKey(Long id);

    int insert(GradeClass record);

    int insertSelective(GradeClass record);

    List<GradeClass> selectByExample(GradeClassExample example);

    GradeClass selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") GradeClass record, @Param("example") GradeClassExample example);

    int updateByExample(@Param("record") GradeClass record, @Param("example") GradeClassExample example);

    int updateByPrimaryKeySelective(GradeClass record);

    int updateByPrimaryKey(GradeClass record);
}