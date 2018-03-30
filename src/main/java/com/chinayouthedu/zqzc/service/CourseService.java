package com.chinayouthedu.zqzc.service;

import java.util.List;
import java.util.Map;

import com.chinayouthedu.zqzc.config.core.BaseResponse;
import com.chinayouthedu.zqzc.entity.paike.Course;
import com.chinayouthedu.zqzc.entity.paike.DataDictionary;
import com.chinayouthedu.zqzc.entity.paike.Dictionary;
import com.chinayouthedu.zqzc.entity.vo.CourseTreeVo;
import com.chinayouthedu.zqzc.entity.vo.CourseVo;

/**
 * 课程管理
 * @Company 中青至诚教育咨询有限公司
 * @author 张超群
 * @Modifier
 * @time   2018年3月8日 下午2:54:54
 * @version 1.0
 */
public interface CourseService {

	/**
	 * 课程展示列表
	 * @author 张超群 
	 * @Time   2018年3月8日下午2:54:11
	 * @param pageNum	当前页
	 * @param pageSize	当前页记录条数
	 * @param gradeId	年级id
	 * @return
	 */
	BaseResponse<Map<String,Object>> getCourseListByGrade(int pageNum, int pageSize,long gradeId);
	
	/**
	 * 获取该年级下的所有课程
	 * @Time   2018年3月21日下午2:47:33
	 * @param gradeId	年级id
	 * @return
	 */
	BaseResponse<List<Course>> getGradeCourseList(long gradeId);

	/**
	 * 创建一个课程
	 * @author 张超群 
	 * @Time   2018年3月8日下午2:54:33
	 * @param CourseVo	课程表单对象
	 * @return
	 */
	BaseResponse<Map<String,Object>> createCourse(CourseVo courseVo);

	/**
	 * 编辑一个课程
	 * @author 张超群 
	 * @Time   2018年3月8日下午3:35:56
	 * @param courseVo	课程表单对象
	 * @return
	 */
	BaseResponse<Map<String, Object>> editCourse(CourseVo courseVo);

	/**
	 * 删除一个课程
	 * @author 张超群 
	 * @Time   2018年3月8日下午3:45:26
	 * @param id	课程id
	 * @return
	 */
	BaseResponse<Map<String, Object>> delCourse(long id);

	/**
	 * 年级课程管理
	 * @author 张超群 
	 * @Time   2018年3月8日下午3:51:30
	 * @param gradeId	年级id
	 * @return
	 */
	BaseResponse<Map<String, List<Dictionary>>> CourseManage(long gradeId);

	/**
	 * 年级课程管理保存
	 * @author 张超群 
	 * @Time   2018年3月16日下午4:47:38
	 * @param gradeId	年级id
	 * @param codes		课程编码
	 * @return
	 */
	BaseResponse<List<Course>> CourseManageSave(long gradeId,String[] codes);

	/**
	 * 获取课程树
	 * @author 张超群 
	 * @Time   2018年3月19日下午4:04:41
	 * @return
	 */
	BaseResponse<List<CourseTreeVo>> getCourseTree();

}
