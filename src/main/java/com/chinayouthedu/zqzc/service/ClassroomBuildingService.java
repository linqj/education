package com.chinayouthedu.zqzc.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.chinayouthedu.zqzc.config.core.BaseResponse;
import com.chinayouthedu.zqzc.entity.paike.ClassroomBuilding;
import com.chinayouthedu.zqzc.entity.paike.ClassroomBuildingExample;
import com.chinayouthedu.zqzc.entity.vo.ClassroomBuildingVo;

public interface ClassroomBuildingService {

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
    
    /***
     * 查询所有的教学楼List
     * @author  梁建
     * @Time   2018年3月9日下午4:01:09
     * @return
     */
    List<ClassroomBuilding> selectAll();
    
    /***
     * 更新教学楼
     * @author  梁建
     * @Time   2018年3月9日下午5:29:22
     * @param cbId
     * @param vo
     * @return
     */
    BaseResponse<Map<String, Object>> updateClassroomBuilding(Long cbId, ClassroomBuildingVo vo);

}
