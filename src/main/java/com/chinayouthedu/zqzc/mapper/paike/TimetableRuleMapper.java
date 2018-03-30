package com.chinayouthedu.zqzc.mapper.paike;

import com.chinayouthedu.zqzc.entity.paike.TimetableRule;
import com.chinayouthedu.zqzc.entity.paike.TimetableRuleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TimetableRuleMapper {
    long countByExample(TimetableRuleExample example);

    int deleteByExample(TimetableRuleExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TimetableRule record);

    int insertSelective(TimetableRule record);

    List<TimetableRule> selectByExample(TimetableRuleExample example);

    TimetableRule selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TimetableRule record, @Param("example") TimetableRuleExample example);

    int updateByExample(@Param("record") TimetableRule record, @Param("example") TimetableRuleExample example);

    int updateByPrimaryKeySelective(TimetableRule record);

    int updateByPrimaryKey(TimetableRule record);
}