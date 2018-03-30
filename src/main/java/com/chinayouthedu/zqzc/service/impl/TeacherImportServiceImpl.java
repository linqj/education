package com.chinayouthedu.zqzc.service.impl;

import com.alibaba.fastjson.JSON;
import com.chinayouthedu.zqzc.common.core.WebUtils;
import com.chinayouthedu.zqzc.common.utils.FileUtil;
import com.chinayouthedu.zqzc.common.utils.myexcel.POIExcelUtil;
import com.chinayouthedu.zqzc.config.core.BaseResponse;
import com.chinayouthedu.zqzc.config.core.UpFileInfo;
import com.chinayouthedu.zqzc.config.exception.WebException;
import com.chinayouthedu.zqzc.entity.paike.Teacher;
import com.chinayouthedu.zqzc.entity.paike.TeacherGroup;
import com.chinayouthedu.zqzc.entity.paike.TeacherGroupExample;
import com.chinayouthedu.zqzc.entity.vo.TeacherExcel;
import com.chinayouthedu.zqzc.mapper.paike.TeacherGroupMapper;
import com.chinayouthedu.zqzc.mapper.paike.TeacherMapper;
import com.chinayouthedu.zqzc.service.TeacherGroupService;
import com.chinayouthedu.zqzc.service.TeacherImportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @Description: No Description
 * @author: 梁建
 * @Time: 2018/3/30 9:18
 * @Version 1.0
 */
@Service
public class TeacherImportServiceImpl implements TeacherImportService {

    @Autowired
    private TeacherGroupMapper tgMapper;
    @Autowired
    private TeacherGroupService tgService;
    @Autowired
    private TeacherMapper tmapper;

    /**
     * excel表导入
     *
     * @param type
     * @param file
     * @return
     */
    @Override
    @Transactional("paikeTransactionManager")
    public BaseResponse<Map<String, Object>> importExecl(String type, MultipartFile file) {
        BaseResponse<Map<String, Object>> res = new BaseResponse<>();

        if ("teacher".equals(type)) {// 教师信息文件
//            UpFileInfo upInfo = FileUtil.fileUp(file, "/teacher");
//            logger.info("单个:"+ JSON.toJSONString(upInfo));
//			List<UpFileInfo> upload = FileUtil.upload(request, "/student", false);
//			logger.info("批量:"+JSON.toJSONString(upload));

            try {
                POIExcelUtil<TeacherExcel> poiExcelUtil = new POIExcelUtil<TeacherExcel>(TeacherExcel.class);
                List<TeacherExcel> telist = poiExcelUtil.importExcel(null, file);
//                logger.info("错误信息:"+JSON.toJSON(poiExcelUtil.getError()));
//                logger.info("读取信息:"+JSON.toJSON(list));
                Teacher teacher = new Teacher();

                int insert = 0;
                int i = 0;
                for (TeacherExcel teacherExcel : telist) {
                    String groupName = teacherExcel.getTeacherGroupName();
                    TeacherGroupExample example = new TeacherGroupExample();
                    example.createCriteria().andTgNameEqualTo(groupName);
                    List<TeacherGroup> tglist = tgMapper.selectByExample(example);
                    if (tglist.size() == 0) {           //查询不到这个教研组,创建新的教研组
                        TeacherGroup teacherGroup = new TeacherGroup();
                        teacherGroup.setTgName(groupName);
                        teacherGroup.setCreateTime(new Date());
                        teacherGroup.setTgStartTime(new Date());
                        i += tgMapper.insert(teacherGroup);
                        if (i > 0 && teacherGroup.getId() != null) {   //插入成功
                            teacher.setCreateTime(new Date());
                            teacher.setTeacherName(teacherExcel.getTeacherName());
                            teacher.setTeacherGroupId(teacherGroup.getId());
                            teacher.setTeacherGroupName(groupName);
                            teacher.setIsLeader(false);
                            teacher.setIsLeaderTwo(false);
                            insert += tmapper.insert(teacher);
//                            if (j > 0) {
//                                WebUtils.Success(res, "导入成功!");
////                                return res;
//                            }else{
//                                throw new WebException(404,"导入失败!");
//                            }

                        } else {
                            throw new WebException(404, "创建新教研组时失败!");
                        }
                    } else {
                        Long id = tglist.get(0).getId();
                        String tgName = tglist.get(0).getTgName();

                        teacher.setCreateTime(new Date());
                        teacher.setTeacherName(teacherExcel.getTeacherName());
                        teacher.setTeacherGroupId(id);
                        teacher.setTeacherGroupName(tgName);
                        teacher.setIsLeader(false);
                        teacher.setIsLeaderTwo(false);
                        insert += tmapper.insert(teacher);

                        System.out.println("存在教研组" + tgName + "----id为:" + id);
                    }


                }

                System.out.println("一共插入了"+insert+"条教师数据");
                System.out.println("一共插入了"+i+"条教研组数据");
            } catch (Exception e) {
//                e.printStackTrace();
                throw new WebException(404, "创建新教研组时失败!");
            }
        }
        return res;
    }
}
