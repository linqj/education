package com.chinayouthedu.zqzc.mapper.paike;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.chinayouthedu.zqzc.entity.paike.Activity;
import com.chinayouthedu.zqzc.entity.paike.ActivityExample;

public interface ActivityMapper {
    int countByExample(ActivityExample example);

    int deleteByExample(ActivityExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Activity record);

    int insertSelective(Activity record);

    List<Activity> selectByExample(ActivityExample example);

    Activity selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Activity record, @Param("example") ActivityExample example);

    int updateByExample(@Param("record") Activity record, @Param("example") ActivityExample example);

    int updateByPrimaryKeySelective(Activity record);

    int updateByPrimaryKey(Activity record);
}