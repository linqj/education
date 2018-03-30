package com.chinayouthedu.zqzc.common.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class BirthUtils {

	public static int getAgeByBirthday(Date birthday) {
		Calendar cal = Calendar.getInstance();

		cal.setTime(new Date());
		if (cal.before(birthday)) {
			throw new IllegalArgumentException("The birthDay is before Now.It's unbelievable!");
		}

		int yearNow = cal.get(Calendar.YEAR);
		int monthNow = cal.get(Calendar.MONTH) + 1;
		int dayOfMonthNow = cal.get(Calendar.DAY_OF_MONTH);

		cal.setTime(birthday);
		int yearBirth = cal.get(Calendar.YEAR);
		int monthBirth = cal.get(Calendar.MONTH) + 1;
		int dayOfMonthBirth = cal.get(Calendar.DAY_OF_MONTH);

		int age = yearNow - yearBirth;

		Calendar now = Calendar.getInstance();
		now.setTime(new Date());// 当前时间
		if (monthNow <= monthBirth) {
			if (monthNow == monthBirth) {
				// monthNow==monthBirth
				if (dayOfMonthNow < dayOfMonthBirth) {
					age--;
				}
			} else {
				// monthNow>monthBirth
				age--;
			}
		}
		if (cal.after(now)) {// 如果传入的时间，在当前时间的后面，返回0岁
			age = 0;
		}
		return age;
	}

	// public static void main(String[] args) {
	// SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	// Date bithday;
	// try {
	// bithday = format.parse("2018-01-08 17:20:20");
	// int age = getAgeByBirthday(bithday);
	// System.out.println(age);
	// } catch (ParseException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }
	// }

}
