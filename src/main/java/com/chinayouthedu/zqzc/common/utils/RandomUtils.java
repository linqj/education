package com.chinayouthedu.zqzc.common.utils;

public class RandomUtils {
	/**
	 * 产生指定长度的随机数字组成的字符串
	 */
	public static String createNumberString(int length) {
		if (length < 1 || length > 9)
			throw new IllegalArgumentException();
		char randomChar[] = new char[length];
		for (int i = 0; i < length;) {
			double rand = Math.random() * 10D;
			int num = (int) (rand + 48D);
			if (num >= 48 && num <= 57) {
				randomChar[i] = (char) num;
				i++;
			}
		}
		return new String(randomChar);
	}

	/**
	 * 产生指定长度的随机数字 注意:由于int是有范围限制的, 因此传入的长度不能超过9位,并且如果是以0开头的话,前面的0会自动去除
	 */
	public static int createNumber(int length) {
		return Integer.parseInt(createNumberString(length));
	}

	/**
	 * 随机产生指定长度的大小写英文字母和数字
	 */
	public static String createString(int length) {
		if (length < 1)
			throw new IllegalArgumentException();
		char randomChar[] = new char[length];
		for (int i = 0; i < length;) {
			/*
			 * 产生随机数,由于大小写英文字母和数字中的最小ASCII码是48,最大的ASCII码是122,
			 * 该区间范围是74,因此这里设置了74D跟48D,保证随机数产生的数字都是在[48,122]区间内
			 */
			double rand = Math.random() * 74D;
			int num = (int) (rand + 48D);
			if (num >= 48 && num <= 57 || num >= 65 && num <= 90 || num >= 97 && num <= 122) {
				randomChar[i] = (char) num;
				i++;
			}
		}
		return new String(randomChar);
	}

	/**
	 * 产生随机数，并且对里面一些比较不好区分的字符进行替换 目前该方法只用于随机生成码
	 */
	public static String createObviousString(int length) {
		return createString(length).replace("I", "i").replace("l", "L").replace("O", "o").replace("0", "o");
	}

	public static void main(String args[]) {
		for (int i = 0; i < 100; i++) {
			System.out.println(RandomUtils.createNumber(9));
		}
		System.out.println((char) 57);
		System.out.println(createObviousString(4));
	}

}
