package com.chinayouthedu.zqzc.config.cache;

import java.util.ArrayList;
import java.util.List;

import com.chinayouthedu.zqzc.common.utils.ObjectUtils;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;
import net.sf.ehcache.config.CacheConfiguration;
import net.sf.ehcache.config.CacheConfiguration.TransactionalMode;
import net.sf.ehcache.config.Configuration;
import net.sf.ehcache.config.DiskStoreConfiguration;
import net.sf.ehcache.store.MemoryStoreEvictionPolicy;
/**
 * 永久EHCache缓存管理器
 * @author 张超群 2017年9月8日下午4:08:32
 * @see
 */
public class ForeverEHCacheManager {
	private static CacheManager cacheManager = null;
	private static Cache cache = null;
	
	/**
	 * 初始化永久缓存管理器
	 * @author 张超群 2017年9月8日下午4:08:50
	 * @return
	 */
	public static CacheManager initCacheManager() {
		try {
			if (cacheManager == null) {
				Configuration configuration = new Configuration()
						.diskStore(new DiskStoreConfiguration().path("java.io.tmpdir"));//临时文件目录
				cacheManager = CacheManager.create(configuration);
				CacheConfiguration cacheConfiguration = new CacheConfiguration("forverCache", 10000)//maxElementsInMemory
					.maxEntriesLocalDisk(1000)//磁盘中最大缓存对象数0表示无穷大
					.eternal(true)//元素是否永久缓存
					.overflowToDisk(true)
					.diskSpoolBufferSizeMB(30)//这个参数设置DiskStore（磁盘缓存）的缓存区大小。默认是30MB。每个Cache都应该有自己的一个缓冲区。
					.memoryStoreEvictionPolicy(MemoryStoreEvictionPolicy.LFU)
					.transactionalMode(TransactionalMode.OFF);
				cache = new Cache(cacheConfiguration);
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
