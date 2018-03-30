package com.chinayouthedu.zqzc.mapper.paike;

import com.chinayouthedu.zqzc.entity.paike.RoleUgroup;
import com.chinayouthedu.zqzc.entity.paike.RoleUgroupExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RoleUgroupMapper {
    long countByExample(RoleUgroupExample example);

    int deleteByExample(RoleUgroupExample example);

    int deleteByPrimaryKey(Long id);

    int insert(RoleUgroup record);

    int insertSelective(RoleUgroup record);

    List<RoleUgroup> selectByExample(RoleUgroupExample example);

    RoleUgroup selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") RoleUgroup record, @Param("example") RoleUgroupExample example);

    int updateByExample(@Param("record") RoleUgroup record, @Param("example") RoleUgroupExample example);

    int updateByPrimaryKeySelective(RoleUgroup record);

    int updateByPrimaryKey(RoleUgroup record);
}