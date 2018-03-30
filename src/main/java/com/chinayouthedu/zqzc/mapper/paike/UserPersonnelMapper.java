package com.chinayouthedu.zqzc.mapper.paike;

import com.chinayouthedu.zqzc.entity.paike.UserPersonnel;
import com.chinayouthedu.zqzc.entity.paike.UserPersonnelExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserPersonnelMapper {
    long countByExample(UserPersonnelExample example);

    int deleteByExample(UserPersonnelExample example);

    int deleteByPrimaryKey(Long id);

    int insert(UserPersonnel record);

    int insertSelective(UserPersonnel record);

    List<UserPersonnel> selectByExample(UserPersonnelExample example);

    UserPersonnel selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") UserPersonnel record, @Param("example") UserPersonnelExample example);

    int updateByExample(@Param("record") UserPersonnel record, @Param("example") UserPersonnelExample example);

    int updateByPrimaryKeySelective(UserPersonnel record);

    int updateByPrimaryKey(UserPersonnel record);
}