package com.chinayouthedu.zqzc.common.utils;

import com.chinayouthedu.zqzc.common.core.WebUtils;
import com.chinayouthedu.zqzc.config.core.BaseResponse;

public class SimpleResponseUtils {

    public static BaseResponse success(String reminder){
        BaseResponse response = new BaseResponse();
        WebUtils.Success(response, reminder);
        return response;
    }
    public static BaseResponse error(String reminder){
        BaseResponse response = new BaseResponse();
        WebUtils.Error(response, reminder);
        return response;
    }
}
