
package com.chinayouthedu.zqzc.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.chinayouthedu.zqzc.config.core.BaseController;
import com.chinayouthedu.zqzc.config.core.BaseResponse;
import com.chinayouthedu.zqzc.entity.paike.Teacher;
import com.chinayouthedu.zqzc.entity.paike.TeacherGroup;
import com.chinayouthedu.zqzc.entity.vo.TeacherGroupVo;
import com.chinayouthedu.zqzc.entity.vo.TeacherVo;
import com.chinayouthedu.zqzc.service.TeacherGroupService;
import com.chinayouthedu.zqzc.service.TeacherService;

/**
 * 教研组管理  /  成员-教师成员管理-教研组
 *
 * @author 梁建
 * @version 1.0
 * @Company 中青至诚教育咨询有限公司
 * @Modifier
 * @time 2018年3月21日 下午3:36:16
 */
@RestController
@RequestMapping("/teachergroup")
public class TeacherGroupController extends BaseController {

    @Autowired
    private TeacherGroupService tgService;
    @Autowired
    private TeacherService tService;


    /**
     * 所有教研组列表
     *
     * @param request
     * @return
     * @author 梁建
     * @Time 2018年3月13日上午9:36:07
     */
    @RequestMapping("/list")
    public BaseResponse<Map<String, Object>> toList(HttpServletRequest request) {
        BaseResponse<Map<String, Object>> response = tgService.selectAll(request);
        return response;
    }


    /**
     * 根据教研组id删除对应的教研组
     *
     * @param tgId
     * @return
     * @author 梁建
     * @Time 2018年3月13日上午9:59:35
     */
    @DeleteMapping("/del/{tgId}")
    public BaseResponse<Map<String, Object>> delTeacherGroup(HttpServletRequest request,
                                                             @PathVariable(required = true) Long tgId) {
        BaseResponse<Map<String, Object>> response = tgService.delTG(tgId);
        return response;
    }


    /**
     * 添加教研组时传输参数(所有教师List)
     *
     * @return
     * @author 梁建
     * @Time 2018年3月13日上午10:28:25
     */
    @RequestMapping("/add")
    public List<Teacher> toAdd() {
        List<Teacher> teacherList = tService.selectAllTeacher();
        return teacherList;
    }

    /**
     * 编辑时传入选中对象
     *
     * @param tgId
     * @return
     * @author 梁建
     * @Time 2018年3月13日上午10:28:11
     */
    @RequestMapping("/edit")
    public BaseResponse<Map<String, Object>> edit(@RequestParam(required = false) Long tgId) {
        BaseResponse<Map<String, Object>> response = tgService.selectTgById(tgId);
        return response;
    }

    /**
     * 保存教研组
     *
     * @param tgid
     * @param vo
     * @return
     * @author 梁建
     * @Time 2018年3月13日下午3:52:48
     */
    @PostMapping("/save")
    public BaseResponse<Map<String, Object>> save(HttpServletRequest request, TeacherGroupVo vo,
                                                  @RequestParam(required = false) Long[] courseIds,
                                                  @RequestParam(required = false) Long tgid) {
        if (tgid == null) {  //教研组id为空,为新增
            BaseResponse<Map<String, Object>> response = tgService.saveTG(vo, courseIds);
            return response;
        } else {        //教研组id不为空,为编辑
            BaseResponse<Map<String, Object>> response = tgService.updateTG(tgid, vo, courseIds);
            return response;
        }
    }

    //-------------------------------------------以下为 成员-教师成员管理-教研组-----------------------------------------------------------------

    /**
     * 左侧教研组列表
     *
     * @param
     * @return
     * @author 梁建
     * @Time 2018年3月15日下午3:52:20
     */
    @RequestMapping("/tglist")
    public List<TeacherGroup> leftList() {
        List<TeacherGroup> list = tgService.selectTg();
        return list;
    }

    /**
     * 根据教研组id查询教研组成员
     *
     * @param request tgId : 教研组id
     * @return
     * @author 梁建
     * @Time 2018年3月15日下午3:52:46
     */
    @RequestMapping("/teacherlist")
    public BaseResponse<Map<String, Object>> teacherList(HttpServletRequest request,
                                                         @RequestParam(required = false) Long tgId,
                                                         @RequestParam(required = false) String search) {
        BaseResponse<Map<String, Object>> response = tgService.selectTeacherByTgid(request, tgId, search);
        return response;
    }

    /**
     * 教研组添加成员时传递数据
     *
     * @param request tgId : 教研组id
     * @return
     * @author 梁建
     * @Time 2018年3月16日下午2:32:21
     */
    @RequestMapping("/tgadd")
    public BaseResponse<Map<String, Object>> addTeacher(HttpServletRequest request) {
        BaseResponse<Map<String, Object>> response = tgService.selectNotTg();
        return response;

    }

    /**
     * 保存教师进入教研组
     *
     * @param tIds 选中的教师的id数组
     * @param tgId 教研组id
     * @return
     * @author 梁建
     * @Time 2018年3月20日下午6:01:46
     */
    @RequestMapping("/saveteachertotg")
    public BaseResponse<Map<String, Object>> saveTeacherToTg(@RequestParam(required = false) Long[] tIds,
                                                             @RequestParam(required = false) Long tgId) {
        BaseResponse<Map<String, Object>> response = tgService.saveTeacherToTg(tIds, tgId);
        return response;
    }


    /**
     * 修改教研组长
     *
     * @param tgId
     * @return
     * @author 梁建
     * @Time 2018年3月19日下午1:59:28
     */
    @RequestMapping("/editleader")
    public BaseResponse<Map<String, Object>> editLeader(HttpServletRequest request,
                                                        @RequestParam(required = false) Long tgId) {
        BaseResponse<Map<String, Object>> response = tgService.selectTgLeader(tgId);
        return response;
    }


    /**
     * 修改教研组副组长
     *
     * @param request
     * @return
     * @author 梁建
     * @Time 2018年3月19日下午2:17:23
     */
    @RequestMapping("/editleadertwo")
    public BaseResponse<Map<String, Object>> editLeaderTwo(HttpServletRequest request,
                                                           @RequestParam(required = false) Long tgId) {
        BaseResponse<Map<String, Object>> response = tgService.selectTgLeaderTwo(tgId);
        return response;
    }

    /**
     * 保存修改的教研组长
     *
     * @return
     * @author 梁建
     * @Time 2018年3月19日下午4:51:34
     */
    @RequestMapping("/saveleader")
    public BaseResponse<Map<String, Object>> saveLeader(HttpServletRequest request,
                                                        @RequestParam(required = false) Long tgId,
                                                        @RequestParam(required = false) Long tId) {
        BaseResponse<Map<String, Object>> response = tgService.saveLeader(tgId, tId);
        return response;
    }

    /**
     * 保存修改的教研组副组长
     *
     * @param request
     * @param tgId
     * @param tId
     * @return
     * @author 梁建
     * @Time 2018年3月20日上午11:19:03
     */
    @RequestMapping("/saveleadertwo")
    public BaseResponse<Map<String, Object>> saveLeaderTwo(HttpServletRequest request,
                                                           @RequestParam(required = false) Long tgId,
                                                           @RequestParam(required = false) Long tId) {
        BaseResponse<Map<String, Object>> response = tgService.saveLeaderTwo(tgId, tId);
        return response;
    }

    /**
     * 从教研组中删除教师
     *
     * @param tId
     * @return
     * @author 梁建
     * @Time 2018年3月20日下午2:06:46
     */
//	@RequestMapping("/delTeacher/{tId}")
    @DeleteMapping("/delteacher/{tId}")
    public BaseResponse<Map<String, Object>> delTeacherFromTg(@PathVariable(required = true) Long tId) {
        BaseResponse<Map<String, Object>> response = tgService.delTeacherFromTg(tId);
        return response;
    }

    /**
     * 批量删除教研组内选中的教师
     *
     * @return
     * @author 梁建
     * @Time 2018年3月20日下午2:08:40
     */
    @RequestMapping("/delmulti")
    public BaseResponse<Map<String, Object>> delMulti(@RequestParam(required = false) Long[] tIds) {
        BaseResponse<Map<String, Object>> response = tgService.delMulti(tIds);
        return response;
    }

    /**
     * 编辑保存教研组的教师信息
     *
     * @param id
     * @return
     * @author 梁建
     * @Time 2018年3月21日上午10:54:22
     */
    @RequestMapping("/saveteacher")
    public BaseResponse<Map<String, Object>> saveTeacher(TeacherVo vo,
                                                         @RequestParam(required = false) Long id) {
        BaseResponse<Map<String, Object>> response = tgService.saveTeacher(vo, id);
        return response;
    }

    /**
     * 点击调整教研组,传输数据
     *
     * @param tgId
     * @return
     * @author 梁建
     * @Time 2018年3月21日上午11:26:55
     */
    @RequestMapping("/tomove")
    public List<TeacherGroup> toMove(@RequestParam(required = false) Long tgId) {
        List<TeacherGroup> list = tgService.toMove(tgId);
        return list;
    }

    /**
     * 批量调整教研组
     *
     * @param tIds
     * @return
     * @author 梁建
     * @Time 2018年3月21日上午11:07:24
     */
    @RequestMapping("/move")
    public BaseResponse<Map<String, Object>> moveTeacherToTg(@RequestParam(required = false) Long[] tIds,
                                                             @RequestParam(required = false) Long tgId) {
        BaseResponse<Map<String, Object>> response = tgService.moveTeacherToTg(tIds, tgId);
        return response;
    }

    /**
     * 教研组内的搜索框模糊查询
     *
     * @param search
     * @param tgId
     * @return
     * @author 梁建
     * @Time 2018年3月22日下午4:47:41
     */
    @RequestMapping("/searchteacher")
    public List<Teacher> searchTeacher(@RequestParam(required = false) String search,
                                       @RequestParam(required = false) Long tgId) {
        List<Teacher> list = tgService.searchTeacher(search, tgId);
        return list;

    }
}

