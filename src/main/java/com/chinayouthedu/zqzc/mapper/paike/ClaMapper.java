package com.chinayouthedu.zqzc.mapper.paike;


import com.chinayouthedu.zqzc.entity.paike.Cla;
import com.chinayouthedu.zqzc.entity.paike.ClaExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ClaMapper {


    int countByExample(ClaExample example);

    int deleteByExample(ClaExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Cla record);

    int insertSelective(Cla record);

    List<Cla> selectByExample(ClaExample example);

    Cla selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Cla record, @Param("example") ClaExample example);

    int updateByExample(@Param("record") Cla record, @Param("example") ClaExample example);

    int updateByPrimaryKeySelective(Cla record);

    int updateByPrimaryKey(Cla record);
}