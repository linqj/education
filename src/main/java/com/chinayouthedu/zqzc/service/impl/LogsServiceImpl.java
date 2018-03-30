package com.chinayouthedu.zqzc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chinayouthedu.zqzc.config.core.BaseResponse;
import com.chinayouthedu.zqzc.entity.paike.Logs;
import com.chinayouthedu.zqzc.entity.paike.LogsExample;
import com.chinayouthedu.zqzc.mapper.paike.LogsMapper;
import com.chinayouthedu.zqzc.service.LogsService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * 日志管理
 * @Company 中青至诚教育咨询有限公司
 * @author 张超群
 * @Modifier
 * @time  2018年3月24日   下午7:42:51 
 * @version 1.0
 */
@Service
public class LogsServiceImpl implements LogsService {
	
	@Autowired
	private LogsMapper logs;

	/**
	 * 获取系统用户日常操作日志列表
	 */
	@Override
	public BaseResponse<PageInfo<Logs>> getUserOperationLogs(int pageNum, int pageSize) {
		BaseResponse<PageInfo<Logs>> response = new BaseResponse<PageInfo<Logs>>();
		PageHelper.startPage(pageNum, pageSize);
		LogsExample logsExample = new LogsExample();
		List<Logs> list = logs.selectByExample(logsExample);
		PageInfo<Logs> pageInfo = new PageInfo<Logs>(list);
		response.setData(pageInfo);
		return response;
	}

	/**
	 * 插入日志
	 */
	@Override
	public int createUserLogs(Logs userLog) {
		int insert = 0;
		if(userLog != null){
			insert = logs.insert(userLog);
		}
		return insert;
	}

}
