package com.chinayouthedu.zqzc.mapper.paike;

import com.chinayouthedu.zqzc.entity.paike.FunctionPermission;
import com.chinayouthedu.zqzc.entity.paike.FunctionPermissionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FunctionPermissionMapper {
    long countByExample(FunctionPermissionExample example);

    int deleteByExample(FunctionPermissionExample example);

    int deleteByPrimaryKey(Long id);

    int insert(FunctionPermission record);

    int insertSelective(FunctionPermission record);

    List<FunctionPermission> selectByExample(FunctionPermissionExample example);

    FunctionPermission selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") FunctionPermission record, @Param("example") FunctionPermissionExample example);

    int updateByExample(@Param("record") FunctionPermission record, @Param("example") FunctionPermissionExample example);

    int updateByPrimaryKeySelective(FunctionPermission record);

    int updateByPrimaryKey(FunctionPermission record);
}