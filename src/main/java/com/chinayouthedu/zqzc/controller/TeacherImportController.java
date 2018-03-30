package com.chinayouthedu.zqzc.controller;

import com.alibaba.fastjson.JSON;
import com.chinayouthedu.zqzc.common.utils.FileUtil;
import com.chinayouthedu.zqzc.common.utils.myexcel.POIExcelUtil;
import com.chinayouthedu.zqzc.config.core.BaseController;
import com.chinayouthedu.zqzc.config.core.BaseResponse;
import com.chinayouthedu.zqzc.config.core.UpFileInfo;
import com.chinayouthedu.zqzc.entity.paike.Teacher;
import com.chinayouthedu.zqzc.entity.paike.TeacherGroup;
import com.chinayouthedu.zqzc.entity.paike.TeacherGroupExample;
import com.chinayouthedu.zqzc.entity.vo.StudentExcel;
import com.chinayouthedu.zqzc.entity.vo.TeacherExcel;
import com.chinayouthedu.zqzc.mapper.paike.TeacherGroupMapper;
import com.chinayouthedu.zqzc.service.TeacherGroupService;
import com.chinayouthedu.zqzc.service.TeacherImportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

/**
 * 教师导入
 *
 * @Description: No Description
 * @author: 梁建
 * @Time: 2018/3/28 15:14
 * @Version 1.0
 */

@RestController
@RequestMapping("teacherexcel")
public class TeacherImportController extends BaseController {

    @Autowired
    private TeacherGroupMapper tgMapper;
    @Autowired
    private TeacherImportService teacherImportService;

    /**
     * localhost/teacherexcel/down/teacher
     * 教师导入模版下载
     *
     * @param type
     * @param response
     */
    @RequestMapping(value = "/down/{type}", method = RequestMethod.GET)
    public void exportExcel(@PathVariable(required = true, value = "type") String type, HttpServletResponse response) {
        if ("teacher".equals(type)) {// 学生文件
            try {
                FileUtil.fileDownload(response, "D:/学生信息表.xls", "学生信息表.xls");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


    /**
     * localhost/teacherexcel/import/teacher
     *
     * @param type
     * @param file
     * @param request
     * @return
     */
    @RequestMapping(value = "/import/{type}", method = RequestMethod.POST)
    @ResponseBody
    public BaseResponse<Map<String, Object>> importExecl(@PathVariable(required = true, value = "type") String type, MultipartFile file) {

        /*if ("teacher".equals(type)) {// 学生文件
            UpFileInfo upInfo = FileUtil.fileUp(file, "/teacher");
            logger.info("单个:"+ JSON.toJSONString(upInfo));
//			List<UpFileInfo> upload = FileUtil.upload(request, "/student", false);
//			logger.info("批量:"+JSON.toJSONString(upload));

            try {
                POIExcelUtil<TeacherExcel> poiExcelUtil = new POIExcelUtil<TeacherExcel>(TeacherExcel.class);
                List<TeacherExcel> list = poiExcelUtil.importExcel(null,file);
                logger.info("错误信息:"+JSON.toJSON(poiExcelUtil.getError()));
                logger.info("读取信息:"+JSON.toJSON(list));
                Teacher teacher = new Teacher();
                for (TeacherExcel teacherExcel : list) {
                    String groupName = teacherExcel.getTeacherGroupName();
                    TeacherGroupExample example = new TeacherGroupExample();
                    example.createCriteria().andTgNameEqualTo(groupName);
                    List<TeacherGroup> teacherGroups = tgMapper.selectByExample(example);

                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }*/

        BaseResponse<Map<String, Object>> response = teacherImportService.importExecl(type, file);
        return response;
    }


}





