package com.chinayouthedu.zqzc.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.chinayouthedu.zqzc.entity.paike.Semester;
import com.chinayouthedu.zqzc.entity.paike.SemesterExample;
import com.chinayouthedu.zqzc.entity.vo.SchoolYearVo;

public interface SemesterService {

    long countByExample(SemesterExample example);

    int deleteByExample(SemesterExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Semester record);

    int insertSelective(Semester record);

    List<Semester> selectByExample(SemesterExample example);

    Semester selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Semester record, @Param("example") SemesterExample example);

    int updateByExample(@Param("record") Semester record, @Param("example") SemesterExample example);

    int updateByPrimaryKeySelective(Semester record);

    int updateByPrimaryKey(Semester record);
    
    /***
     * 学期学年中添加第一学期数据
     * @author  梁建
     * @Time   2018年3月8日上午11:10:56
     * @param syId 父级中的学年Id
     * @param vo 前台传递的业务对象
     * @return
     */
    int insertFirst(Long syId, SchoolYearVo vo);
    
    /***
     * 学期学年中添加第二学期数据
     * @author  梁建
     * @Time   2018年3月8日上午11:11:41
     * @param syId 父级中的学年Id
     * @param vo 前台传递的业务对象
     * @return
     */
    int insertLast(Long syId, SchoolYearVo vo);
    
    /***
     * 添加学年后再添加两个学期 ,加入事物
     * @author  梁建
     * @Time   2018年3月8日上午11:12:05
     * @param syId 父级中的学年Id
     * @param vo 前台传递的业务对象
     * @return
     */
    int insertAll(Long syId, SchoolYearVo vo);
    
    /***
     * 删除学期表中同一学年id下的所有学期
     * @author  梁建
     * @Time   2018年3月8日下午2:15:00
     * @param xnId 学年id
     * @return
     */
    int deleteFirstAndLast(Long xnId);
    
    /***
     * 更新学年下的所有学期.先删除在新建
     * @author  梁建
     * @Time   2018年3月8日下午2:47:54
     * @param syId
     * @param vo
     * @return
     */
    int updateFirstAndLast(Long syId, SchoolYearVo vo);
    
}
