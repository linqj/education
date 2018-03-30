
package com.chinayouthedu.zqzc.service;

import com.chinayouthedu.zqzc.config.core.BaseResponse;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @Description: No Description
 * @author: 梁建
 * @Time: 2018/3/30 9:17
 * @Version 1.0
 */
public interface TeacherImportService {

    BaseResponse<Map<String, Object>> importExecl(String type, MultipartFile file);
}
