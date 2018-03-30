package com.chinayouthedu.zqzc.mapper.paike;

import com.chinayouthedu.zqzc.entity.paike.TimeTables;
import com.chinayouthedu.zqzc.entity.paike.TimeTablesExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TimeTablesMapper {
    long countByExample(TimeTablesExample example);

    int deleteByExample(TimeTablesExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TimeTables record);

    int insertSelective(TimeTables record);

    List<TimeTables> selectByExample(TimeTablesExample example);

    TimeTables selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TimeTables record, @Param("example") TimeTablesExample example);

    int updateByExample(@Param("record") TimeTables record, @Param("example") TimeTablesExample example);

    int updateByPrimaryKeySelective(TimeTables record);

    int updateByPrimaryKey(TimeTables record);
}