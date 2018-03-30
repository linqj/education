package com.chinayouthedu.zqzc.mapper.paike;

import com.chinayouthedu.zqzc.entity.paike.ClassroomBuilding;
import com.chinayouthedu.zqzc.entity.paike.ClassroomBuildingExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ClassroomBuildingMapper {
    long countByExample(ClassroomBuildingExample example);

    int deleteByExample(ClassroomBuildingExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ClassroomBuilding record);

    int insertSelective(ClassroomBuilding record);

    List<ClassroomBuilding> selectByExample(ClassroomBuildingExample example);

    ClassroomBuilding selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ClassroomBuilding record, @Param("example") ClassroomBuildingExample example);

    int updateByExample(@Param("record") ClassroomBuilding record, @Param("example") ClassroomBuildingExample example);

    int updateByPrimaryKeySelective(ClassroomBuilding record);

    int updateByPrimaryKey(ClassroomBuilding record);
}