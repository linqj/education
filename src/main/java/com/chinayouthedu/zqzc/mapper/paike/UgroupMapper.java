package com.chinayouthedu.zqzc.mapper.paike;

import com.chinayouthedu.zqzc.entity.paike.Ugroup;
import com.chinayouthedu.zqzc.entity.paike.UgroupExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UgroupMapper {
    long countByExample(UgroupExample example);

    int deleteByExample(UgroupExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Ugroup record);

    int insertSelective(Ugroup record);

    List<Ugroup> selectByExample(UgroupExample example);

    Ugroup selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Ugroup record, @Param("example") UgroupExample example);

    int updateByExample(@Param("record") Ugroup record, @Param("example") UgroupExample example);

    int updateByPrimaryKeySelective(Ugroup record);

    int updateByPrimaryKey(Ugroup record);
}