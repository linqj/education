package com.chinayouthedu.zqzc.common.utils.cye;

import org.apache.commons.lang3.StringUtils;

import com.google.common.base.Charsets;
import com.google.common.hash.Hashing;
import java.util.UUID;

public class CyeStringUtils {

	/**
	 * 是否包含排序信息 like updateTime desc return true
	 * 
	 * like updateTime return false
	 * 
	 * @param order
	 * @return
	 */
	public static boolean includeSortingConditions(String order) {
		if (StringUtils.isNotBlank(order)
				&& (order.trim().toLowerCase().contains(" desc") || order.trim().toLowerCase().contains(" asc"))) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * 计算密码和盐混合后的MD5哈希值
	 * @param password  密码
	 * @param salt      盐
	 * @return          MD5哈希值(小写)
	 */
	public static String md5pwd(String password,String salt){
		return md5(md5(password)+salt);
	}
	
	private static String md5(String str){
		return Hashing.md5().newHasher().putString(str, Charsets.UTF_8).hash().toString();
	}
	
	/**
	 * 获取一个随机的uuid
	 * @return
	 */
	public static String uuid(){
		return  UUID.randomUUID().toString().replaceAll("-", "").toLowerCase();
	}
	
	public static void main(String[] args) {
		for(int i=0;i<4;i++){
			String uuid = uuid();
			String pwd = md5pwd("123", uuid);
			System.out.println("uuid:"+uuid);
			System.out.println("pwd:"+pwd);
		}
	}
	
		
	
	

}
