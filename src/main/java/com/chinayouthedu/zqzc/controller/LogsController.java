package com.chinayouthedu.zqzc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.chinayouthedu.zqzc.config.core.BaseController;
import com.chinayouthedu.zqzc.config.core.BaseResponse;
import com.chinayouthedu.zqzc.entity.paike.Logs;
import com.chinayouthedu.zqzc.service.LogsService;
import com.github.pagehelper.PageInfo;

/**
 * 日志管理
 * @Company 中青至诚教育咨询有限公司
 * @author 张超群
 * @Modifier
 * @time  2018年3月24日   下午7:43:09 
 * @version 1.0
 */
@RestController
@RequestMapping("/logs")
public class LogsController extends BaseController {
	
	@Autowired
	private LogsService logs;
	
	/**
	 * 获取系统用户的日常操作日志列表
	 * @author  张超群	2018年3月24日下午7:49:38
	 * @param pageNum	int	第几页
	 * @param pageSize	int	每页显示条数
	 * @return
	 */
	@GetMapping("/list")
	public BaseResponse<PageInfo<Logs>> showList(@RequestParam(value="pageNum",required=true,defaultValue="1") int pageNum,
			@RequestParam(value="pageSize",required=true,defaultValue="10") int pageSize){
		BaseResponse<PageInfo<Logs>> response = logs.getUserOperationLogs(pageNum, pageSize);
		return response;
	}

}
