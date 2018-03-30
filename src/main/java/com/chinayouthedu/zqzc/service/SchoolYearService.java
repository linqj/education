package com.chinayouthedu.zqzc.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.PathVariable;

import com.chinayouthedu.zqzc.config.core.BaseResponse;
import com.chinayouthedu.zqzc.entity.paike.SchoolYear;
import com.chinayouthedu.zqzc.entity.paike.SchoolYearExample;
import com.chinayouthedu.zqzc.entity.paike.Semester;
import com.chinayouthedu.zqzc.entity.vo.SchoolYearVo;

public interface SchoolYearService {

    long countByExample(SchoolYearExample example);

    int deleteByExample(SchoolYearExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SchoolYear record);

    int insertSelective(SchoolYear record);

    List<SchoolYear> selectByExample(SchoolYearExample example);

    SchoolYear selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SchoolYear record, @Param("example") SchoolYearExample example);

    int updateByExample(@Param("record") SchoolYear record, @Param("example") SchoolYearExample example);

    int updateByPrimaryKeySelective(SchoolYear record);

    int updateByPrimaryKey(SchoolYear record);
    /**  --------- */
    /**
     * 查询所有学年,返回List
     * @author  梁建
     * @Time   2018年3月7日上午9:24:32
     * @return
     */
    List<SchoolYear> selectAll();
    
    /**
     * 获取id学年下的所有学期
     * @author  梁建
     * @Time   2018年3月7日上午9:57:49
     * @param id
     * @return
     */
    List<Semester> selectBySyid(Long id);
    
    /***
     * 更新学年信息
     * @author  梁建
     * @Time   2018年3月8日上午11:07:28
     * @param vo 前台传递的业务对象
     * @param xnId 学年Id
     * @return
     */
    int updateSchoolYear(SchoolYearVo vo, Long xnId);
    
    /**
     * 进入学年学期列表 ,以及分页
     * @author  梁建
     * @Time   2018年3月26日下午3:37:15
     * @param request
     * @return
     */
    BaseResponse<Map<String, Object>> toList(HttpServletRequest request);
    
    /**
     * 学年学期父子List 不含分页
     * @author  梁建
     * @Time   2018年3月26日下午3:40:29
     * @return
     */
    List<SchoolYear> SchoolYearList();
    
    /**
     * 进入编辑学期页面
     * @author  梁建
     * @Time   2018年3月26日下午4:32:45
     * @param request
     * @return
     */
    BaseResponse<Map<String, Object>> toEdit(HttpServletRequest request);
    
    /**
     * 保存/编辑新的学年,学期
     * @author  梁建
     * @Time   2018年3月26日下午4:43:25
     * @param vo
     * @param request
     * @return
     */
    BaseResponse<Map<String, Object>> saveSemester(SchoolYearVo vo, HttpServletRequest request);
    
    /**
     * 删除学年及学期
     * @author  梁建
     * @Time   2018年3月26日下午4:46:56
     * @param xnid
     * @return
     */
    BaseResponse<Map<String, Object>> delSemester(Long xnid);
    
}
