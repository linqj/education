package com.chinayouthedu.zqzc.common.utils.cye;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.lang3.StringUtils;

/**
 * 集合相关的工具类
 * @author wangzq
 *
 */
public class CyeCollectionUtils {

	/**
	 * 验证集合是否为空
	 * @param Collection集合
	 * 
	 * if null			return true
	 * if {}			return true
	 * if {null}		return true
	 * if {"java",null}		return false
	 * if {"hello","java"}	return false
	 * 
	 * @return
	 */
	public static boolean isBlank(final Collection collection){
		
		// 1.如果集合是空集合,返回true
		if(collection==null||collection.isEmpty()){
			return true;
		}
		
		// 2.如果集合中有数据不为null,返回false
		for (Object object : collection) {
			if(object!=null){
				return false;
			}
		}
		
		// 3.如果集合中所有数据都为null,返回true
		return true;
		
	}
	
	/**
	 * 验证集合是否不为空
	 * @param Collection集合
	 * 
	 * if null			return false
	 * if {}			return false
	 * if {null}		return false
	 * if {"java",null}		return true
	 * if {"hello","java"}	return true
	 * 
	 * @return
	 */
	public static boolean isNotBlank(final Collection collection){
		return !isBlank(collection);
	}

	/**
	 * 移除重复数据
	 * 如果存在null数据,null会被自动移除
	 * @param userIds
	 */
	public static <T> List<T> removeRepeat(final Collection<T> collection) {
		
		List<T> result = new ArrayList<T>();
		
		if(isBlank(collection)){
			return result;
		}
		
		collection.forEach(obj->{
			if(!result.contains(obj)){
				result.add(obj);
			}
		});
		
		result.remove(null);
		return result;
		
	}
	
	/**
	 * 将数组转成集合,数组内的元素类型必须和集合内的元素类型相同
	 * 不会返回null,集合中的数据经过了去null处理,也不可能是null
	 * 自动做了去重处理,返回的集合中不可能有重复数据,如果需要重复数据,请重写
	 * @param array
	 * @return
	 */
	public static <T> List<T> from(final T[] array ){
		// 1.新建结果集
		List<T> result = new ArrayList<T>();
		// 2.检查参数,然后将数组转成集合
		if(array!=null&&array.length>0){
			for(T t : array){
				if(t!=null&&!result.contains(t)){
					result.add(t);
				}
			}
		}
		// 4.返回结果集
		return result;
	}
	
	/**
	 * 功能：求两个集合的差集
	 * 说明：此方法不会对参数的数据有任何影响,返回数据可能有重复值或者null,如需处理需要手动处理
	 * 返回值：A-B的结果,返回值可能是空集合,但不可能是null
	 * @param A 减数
	 * @param B 被减数
	 * @return
	 */
	public static <T> List<T> reduce(final Collection<T> A,final Collection<T> B){
		List<T> result = new ArrayList<T>();
		result.addAll(A);
		result.removeAll(B);
		return result;
	}
	
	/**
	 * 功能：求两个集合的交集
	 * 说明：此方法不会对参数的数据有任何影响,返回数据可能有重复值或者null,如需处理需要手动处理
	 * 返回值：A∩B的结果,返回值可能是空集合,但不可能是null
	 * @param c1 减数
	 * @param c2 被减数
	 * @return
	 */
	public static <T> List<T> common(final Collection<T> A,final Collection<T> B){
		List<T> result = new ArrayList<T>();
		result.addAll(A);
		result.retainAll(B);
		return result;
	}
	
	/**
	 * 功能：求两个集合的并集
	 * 说明：此方法不会对参数的数据有任何影响,返回数据可能有重复值或者null,如需处理需要手动处理
	 * 返回值：A∪B的结果,返回值可能是空集合,但不可能是null
	 * @param 需要相加的集合,可以是null或者空集合,会自动处理
	 * @return
	 */
	public static <T> List<T> union(final Collection<T>...collections){
		List<T> result = new ArrayList<T>();
		if(collections!=null&&collections.length>0){
			for(Collection<T> c : collections){
				result.addAll(c);
			}
		}
		return result;
	}
	
	
	/**
	 * 从对象中抽取某个字段组成一个新的集合
	 * 自动完成了去除重复数据,去除null数据,自动转换成接收的集合的类型
	 * 返回的集合不可能是null,集合也不可能包含null参数
	 * 当从对象中取值的过程中出现异常或者强转不成功的情况发生,会跳过这个对象继续去下一个对象的值
	 * @param collection
	 * @return
	 */
	public static <T> List<T> from(final Collection<? extends Object> collection,String property){
		List<T> result = new ArrayList<T>();
		if(isNotBlank(collection)&&StringUtils.isNotBlank(property)){
			for (Object obj : collection) {
				try {
					T t = (T)PropertyUtils.getSimpleProperty(obj, property);
					if(t!=null&&!result.contains(t)){
						result.add(t);
					}
				} catch (Exception e) {
					continue;
				}
			}
		}
		return result;	
	}
	
	
//	public static <T> T getMax(final List<T> collection,final String property){
//		
//		if(isBlank(collection)){
//			return null;
//		}
//		
//		Collections.sort(collection, new Comparator<T>() {
//
//			@Override
//			public int compare(T var1, T var2) {
//				
//				return 0;
//			}
//			
//			
//			
//			
//		} );
//		
//		return null;
//		
//		
//	}
//	
	
}