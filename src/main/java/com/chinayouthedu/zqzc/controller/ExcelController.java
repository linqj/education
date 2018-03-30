package com.chinayouthedu.zqzc.controller;

import com.alibaba.fastjson.JSON;
import com.chinayouthedu.zqzc.common.utils.FileUtil;
import com.chinayouthedu.zqzc.common.utils.myexcel.POIExcelUtil;
import com.chinayouthedu.zqzc.common.utils.myexcel.demo.TeacherEO;
import com.chinayouthedu.zqzc.config.core.BaseController;
import com.chinayouthedu.zqzc.config.core.UpFileInfo;
import com.chinayouthedu.zqzc.entity.vo.StudentExcel;
import io.swagger.annotations.Api;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Excel导出导入操作接口
 * 
 * @Company 中青至诚教育咨询有限公司
 * @author 张超群
 * @Modifier
 * @time 2018年3月24日 下午5:56:42
 * @version 1.0
 */
@Controller
@RequestMapping("/excel")
@Api(value = "Excel操作API", description = "Excel操作接口")
public class ExcelController extends BaseController {

	//--------------------------------------------------------------上传导入-------------------------------------------------------------------------
	@RequestMapping(value = "/import/{type}", method = RequestMethod.POST)
	@ResponseBody
	public String importExec(@PathVariable(required = true, value = "type") String type, MultipartFile file, HttpServletRequest request) {

		if ("student".equals(type)) {// 学生文件
			UpFileInfo upInfo = FileUtil.fileUp(file, "/student");
			logger.info("单个:"+JSON.toJSONString(upInfo));
//			List<UpFileInfo> upload = FileUtil.upload(request, "/student", false);
//			logger.info("批量:"+JSON.toJSONString(upload));
			try {
				POIExcelUtil<StudentExcel> poiExcelUtil = new POIExcelUtil<StudentExcel>(StudentExcel.class);
				List<StudentExcel> list = poiExcelUtil.importExcel(null,file);
				logger.info("错误信息:"+JSON.toJSON(poiExcelUtil.getError()));
				logger.info("读取信息:"+JSON.toJSON(list));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if ("teacher".equals(type)) {// 学生文件

		}
		return null;
	}
	//--------------------------------------------------------------下载导出-------------------------------------------------------------------------
	

	@RequestMapping(value = "/export/{type}", method = RequestMethod.GET)
	public void exportExcel(@PathVariable(required = true, value = "type") String type, HttpServletResponse response){
		if ("student".equals(type)) {// 学生文件
			try {
//				FileUtil.fileDownload(response,"/opt/file/upload/student/2018年3月23日技术部项目进度_1521978720611.docx","技术部项目进度.docx");
				List<TeacherEO> list = new ArrayList<>();
				TeacherEO vo = new TeacherEO();
				vo.setA("张超群");
				vo.setB(true);
				vo.setC(25);
				vo.setD(15010222109L);
				vo.setE(new BigDecimal("11112.22222"));
				vo.setF(2.20);
				vo.setG(1.2F);
				vo.setH(new Date());
				list.add(vo);
				TeacherEO vo2 = new TeacherEO();
				vo2.setA("李四");
				vo2.setB(false);
				vo2.setC(25);
				vo2.setD(15010222109L);
				vo2.setE(new BigDecimal("11112.22222"));
				vo2.setF(2.20);
				vo2.setG(1.2F);
				vo2.setH(new Date());
				list.add(vo2);
				POIExcelUtil<TeacherEO> util = new POIExcelUtil<TeacherEO>(TeacherEO.class);// 创建工具类.
				util.exportExcelToDownload(list, "教师信息", 65536, response);// 导出
				System.out.println("----执行完毕----------");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
