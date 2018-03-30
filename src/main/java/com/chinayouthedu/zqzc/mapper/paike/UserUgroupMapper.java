package com.chinayouthedu.zqzc.mapper.paike;

import com.chinayouthedu.zqzc.entity.paike.UserUgroup;
import com.chinayouthedu.zqzc.entity.paike.UserUgroupExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserUgroupMapper {
    long countByExample(UserUgroupExample example);

    int deleteByExample(UserUgroupExample example);

    int deleteByPrimaryKey(Long id);

    int insert(UserUgroup record);

    int insertSelective(UserUgroup record);

    List<UserUgroup> selectByExample(UserUgroupExample example);

    UserUgroup selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") UserUgroup record, @Param("example") UserUgroupExample example);

    int updateByExample(@Param("record") UserUgroup record, @Param("example") UserUgroupExample example);

    int updateByPrimaryKeySelective(UserUgroup record);

    int updateByPrimaryKey(UserUgroup record);
}