package com.chinayouthedu.zqzc.config.cache;

import java.util.ArrayList;
import java.util.List;

import com.chinayouthedu.zqzc.common.utils.ObjectUtils;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;
/**
 * EHCache缓存管理器
 * @author 张超群 2017年9月8日下午4:08:32
 * @see
 */
public class EHCacheManager {
	private static CacheManager cacheManager = null;
	private static Cache cache = null;
	
	/**
	 * 初始化缓存管理器
	 * @author 张超群 2017年9月8日下午4:08:50
	 * @return
	 */
	public static CacheManager initCacheManager() {
		try {
			if (cacheManager == null) {
				cacheManager = CacheManager.create();
				/**
				 * 	(String name, int maxElementsInMemory, boolean overflowToDisk,
				 *  boolean eternal, long timeToLiveSeconds, long timeToIdleSeconds)
				 *  参数详解:
				 	name	Cache的唯一标识
					maxElementsInMemory	内存中最大缓存对象数
					overflowToDisk	配置此属性，当内存中Element数量达到maxElementsInMemory时，Ehcache将会Element写到磁盘中
					eternal	Element是否永久有效，一但设置了，timeout将不起作用
					timeToLiveSeconds	设置Element在失效前允许存活时间。最大时间介于创建时间和失效时间之间。仅当element不是永久有效时使用，默认是0.，也就是element存活时间无穷大
					timeToIdleSeconds	设置Element在失效前的允许闲置时间。仅当element不是永久有效时使用，可选属性，默认值是0，也就是可闲置时间无穷大
				 */
				cache = new Cache("objectCache", 10000, true, false, 3600L, 3600L);//默认LRU
				cacheManager.addCache(cache);
			}
		} catch (Exception var1) {
			var1.printStackTrace();
		}

		return cacheManager;
	}

	/**
	 * 获取所有的缓存key
	 * @author 张超群 
	 * @Time   2017年9月29日下午3:14:19
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static List<String> getAllKeys() {
		List<String> keys = cache.getKeys();
		return keys;
	}

	/**
	 * 根据key获取缓存的值
	 * @author 张超群 2017年9月8日下午4:09:02
	 * @param key
	 * @return
	 */
	public static Object get(String key) {
		try {
			if ((ObjectUtils.isNotNull(cache)) && (ObjectUtils.isNotNull(cache.get(key))))
				return cache.get(key).getObjectValue();
		} catch (Exception var2) {
			var2.printStackTrace();
		}

		return null;
	}

	/**
	 * 设置需要缓存的内容
	 * @author 张超群 2017年9月8日下午4:09:22
	 * @param key
	 * @param value
	 */
	public static void set(String key, Object value) {
		try {
			if (cache != null)
				cache.put(new Element(key, value));
		} catch (Exception var3) {
			var3.printStackTrace();
		}
	}

	/**
	 * 根据key删除缓存中的对象
	 * @author 张超群 2017年9月8日下午4:09:35
	 * @param key
	 * @return
	 */
	public static boolean remove(String key) {
		try {
			if (cache != null)
				return cache.remove(key);
		} catch (Exception var2) {
			var2.printStackTrace();
		}

		return false;
	}

	/**
	 * 删除所有的缓存对象
	 * @author 张超群 2017年9月8日下午4:09:47
	 * @return
	 */
	public static boolean removeAll() {
		try {
			if (cache != null)
				cache.removeAll();
		} catch (Exception var1) {
			var1.printStackTrace();
		}

		return false;
	}

	/**
	 * 设置缓存对象,并以创建时间为基准开始计算超时时长
	 * @author 张超群 2017年9月8日下午4:12:26
	 * @param key
	 * @param value
	 * @param exp	超时时长
	 */
	public static void set(String key, Object value, int exp) {
		try {
			if (cache != null) {
				Element e = new Element(key, value);
				e.setTimeToLive(exp);
				cache.put(e);
			}
		} catch (Exception var4) {
			var4.printStackTrace();
		}
	}
	
	/**
	 * 模糊查询key
	 * @author 张超群 2017年9月20日下午2:11:01
	 * @param subkey
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static List<String> LikeKeyQuery(String subkey){
		List<String> sub_keys = new ArrayList<String>();
		if(!"".equals(subkey) && subkey != null){
			List<String> allKeys = cache.getKeys();
			for (String key : allKeys) {
				if(key.contains(subkey)){
					sub_keys.add(key);
				}
			}
		}
		return sub_keys;
	}

	static {
		initCacheManager();
	}
}
