package com.chinayouthedu.zqzc.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestParam;

import com.chinayouthedu.zqzc.config.core.BaseResponse;
import com.chinayouthedu.zqzc.entity.paike.Teacher;
import com.chinayouthedu.zqzc.entity.paike.TeacherGroup;
import com.chinayouthedu.zqzc.entity.vo.TeacherGroupVo;
import com.chinayouthedu.zqzc.entity.vo.TeacherVo;

public interface TeacherGroupService {

	/**
	 * 查询出所有的教研组
	 * @author  梁建
	 * @Time   2018年3月12日下午5:00:51
	 * @param request
	 * @return
	 */
	BaseResponse<Map<String, Object>> selectAll(HttpServletRequest request);
	
	/**
	 * 根据教研组id删除对应的教研组
	 * @author  梁建
	 * @Time   2018年3月13日上午9:53:47
	 * @param tgId
	 * @return
	 */
	BaseResponse<Map<String, Object>> delTG(Long tgId);
	
	/**
	 * 根据id查询出对应的教研组
	 * @author  梁建
	 * @Time   2018年3月13日上午10:25:53
	 * @param tgId
	 * @return
	 */
	BaseResponse<Map<String, Object>> selectTgById(Long tgId);
	
	/**
	 * 新增教研组
	 * @author  梁建
	 * @Time   2018年3月13日下午3:44:17
	 * @param vo
	 * @return
	 */
	BaseResponse<Map<String, Object>> saveTG(TeacherGroupVo vo, Long[] courseIds);
	
	/**
	 * 更新教研组
	 * @author  梁建
	 * @Time   2018年3月13日下午3:46:10
	 * @param tgId
	 * @param vo
	 * @return
	 */
	BaseResponse<Map<String, Object>> updateTG(Long tgId, TeacherGroupVo vo, Long[] courseIds);
	
	/**
	 * 查询所有教研组列表,不分页 
	 * @author  梁建
	 * @Time   2018年3月23日下午5:45:30
	 * @return
	 */
	List<TeacherGroup> selectTg();
	
	/**
	 * 根据教研组id查询出该教研组所有成员(List)
	 * @author  梁建
	 * @Time   2018年3月16日下午2:33:51
	 * @param tgId
	 * @return
	 */
	BaseResponse<Map<String, Object>> selectTeacherByTgid(HttpServletRequest request, Long tgId, String search);
	
	/**
	 * 查询所有没加入教研组的教师列表(List)
	 * @author  梁建
	 * @Time   2018年3月16日下午2:43:46
	 * @return
	 */
	BaseResponse<Map<String, Object>> selectNotTg();
	
	/**
	 * 保存教师进入教研组
	 * @author  梁建
	 * @Time   2018年3月20日下午4:22:28
	 * @return
	 */
	BaseResponse<Map<String, Object>> saveTeacherToTg(Long[] tIds, Long tgId);
	
	/**
	 * 查询除了教研组长外的教师列表
	 * @author  梁建
	 * @Time   2018年3月19日下午2:01:57
	 * @return
	 */
	BaseResponse<Map<String, Object>> selectTgLeader(Long tgId);
	
	
	/**
	 * 查询除了教研组副组长外的教师列表
	 * @author  梁建
	 * @Time   2018年3月19日下午2:11:58
	 * @param tgId
	 * @return
	 */
	BaseResponse<Map<String, Object>> selectTgLeaderTwo(Long tgId);
	
	/**
	 * 保存修改的教研组长
	 * @author  梁建
	 * @Time   2018年3月19日下午2:23:33
	 * @param tgId
	 * @param tId
	 * @return
	 */
	BaseResponse<Map<String, Object>> saveLeader(Long tgId, Long tId);
	
	/**
	 * 保存修改的教研组副组长
	 * @author  梁建
	 * @Time   2018年3月20日上午10:32:40
	 * @param tgId
	 * @param tId
	 * @return
	 */
	BaseResponse<Map<String, Object>> saveLeaderTwo(Long tgId, Long tId);
	
	/**
	 * 从教研组中删除教师
	 * @author  梁建
	 * @Time   2018年3月20日下午2:02:03
	 * @param tId
	 * @return
	 */
	BaseResponse<Map<String, Object>> delTeacherFromTg(Long tId);
	
	/**
	 * 批量删除教研组内选中的教师
	 * @author  梁建
	 * @Time   2018年3月20日下午2:11:37
	 * @param tIds
	 * @return
	 */
	BaseResponse<Map<String, Object>> delMulti(Long[] tIds);
	
	/**
	 * 编辑保存教研组的教师信息
	 * @author  梁建
	 * @Time   2018年3月21日上午10:54:11
	 * @param vo
	 * @return
	 */
	BaseResponse<Map<String, Object>> saveTeacher(TeacherVo vo, Long id);
	
	/**
	 * 点击调整教研组,传输数据
	 * @author  梁建
	 * @Time   2018年3月21日上午11:13:33
	 * @return
	 */
	List<TeacherGroup> toMove(Long tgId);
	
	/**
	 * 批量调整教研组
	 * @author  梁建
	 * @Time   2018年3月21日上午11:09:35
	 * @param tIds
	 * @return
	 */
	BaseResponse<Map<String, Object>> moveTeacherToTg(Long[] tIds, Long tgId);
	
	/**
	 * 教研组内的搜索框模糊查询
	 * @author  梁建
	 * @Time   2018年3月22日下午4:48:14
	 * @param search
	 * @param tgId
	 * @return
	 */
	List<Teacher> searchTeacher(String search, Long tgId);
}
