package com.chinayouthedu.zqzc.service;

import com.chinayouthedu.zqzc.config.core.BaseResponse;
import com.chinayouthedu.zqzc.entity.paike.Logs;
import com.github.pagehelper.PageInfo;

/**
 * 日志管理
 * @Company 中青至诚教育咨询有限公司
 * @author 张超群
 * @Modifier
 * @time  2018年3月24日   下午7:43:01 
 * @version 1.0
 */
public interface LogsService {

	/**
	 * 获取系统用户操作日志列表
	 * @author  张超群	2018年3月24日下午7:43:26
	 * @param pageNum	int	第几页
	 * @param pageSize	int	每页显示条数
	 * @return	json
	 */
	BaseResponse<PageInfo<Logs>> getUserOperationLogs(int pageNum, int pageSize);
	
	/**
	 * 插入日志
	 * @author  张超群	2018年3月24日下午7:54:42
	 * @param logs	日志对象
	 * @return	int
	 */
	int createUserLogs(Logs userLogs);

}
