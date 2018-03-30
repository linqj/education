package com.chinayouthedu.zqzc.common.core;

import java.util.UUID;

import com.google.common.base.Charsets;
import com.google.common.base.Objects;
import com.google.common.hash.Hashing;



public class PassWordUtils {

	/**
	 * 随机生成一个新的盐
	 * @return
	 */
	public static String newSalt() {
		return  UUID.randomUUID().toString().replaceAll("-", "").toLowerCase();
	}
	
	/**
	 * 通过未加密的密码和盐计算加密后的密码
	 * @param password 未加密的密码
	 * @param salt 盐
	 * @return
	 */
	public static String encryptPwd(String password,String salt) {
		return md5(md5(password)+salt);
	}

	/**
	 * 将字符串通过md5加密
	 * @param str
	 * @return
	 */
	private static String md5(String str){
		return Hashing.md5().newHasher().putString(str, Charsets.UTF_8).hash().toString();
	}


	/**
	 * 验证密码事都有效
	 * @param password 未加密的密码
	 * @param salt 盐
	 * @param encryptedPwd 加密后的密码
	 * @return
	 */
	public static boolean validate(String password, String salt,String encryptedPwd) {
		
		String encryptPwd = encryptPwd(password, salt);
		return Objects.equal(encryptPwd, encryptedPwd );
		
	}
	
}
