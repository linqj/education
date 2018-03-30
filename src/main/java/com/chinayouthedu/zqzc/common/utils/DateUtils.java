package com.chinayouthedu.zqzc.common.utils;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

public class DateUtils {

	public static String getNowTime() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdf.format(Calendar.getInstance().getTime());
	}

	public static String getTimeBeforeORAfter(int days) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Calendar c = Calendar.getInstance();
		c.add(5, days);
		return sdf.format(c.getTime());
	}

	public static Date toDate(String date, String pattern) {
		if (("" + date).equals("")) {
			return null;
		}
		if (pattern == null) {
			pattern = "yyyy-MM-dd";
		}

		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		Date newDate = null;
		try {
			newDate = sdf.parse(date);
		} catch (Exception var5) {
			var5.printStackTrace();
		}

		return newDate;
	}

	public static String toString(Date date, String pattern) {
		if (date == null) {
			return "";
		}
		if (pattern == null) {
			pattern = "yyyy-MM-dd";
		}

		String dateString = "";
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		try {
			dateString = sdf.format(date);
		} catch (Exception var5) {
			var5.printStackTrace();
		}

		return dateString;
	}

	public static Date getNowDate() {
		Date currentTime = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateString = formatter.format(currentTime);
		ParsePosition pos = new ParsePosition(8);
		Date currentTime_2 = formatter.parse(dateString, pos);
		return currentTime_2;
	}

	public static Date getNowDateShort() {
		Date currentTime = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		String dateString = formatter.format(currentTime);
		ParsePosition pos = new ParsePosition(8);
		Date currentTime_2 = formatter.parse(dateString, pos);
		return currentTime_2;
	}

	public static String getStringDate() {
		Date currentTime = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateString = formatter.format(currentTime);
		return dateString;
	}

	public static String getStringDateShort() {
		Date currentTime = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		String dateString = formatter.format(currentTime);
		return dateString;
	}

	public static String getTimeShort() {
		SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
		Date currentTime = new Date();
		String dateString = formatter.format(currentTime);
		return dateString;
	}

	public static Date strToDateLong(String strDate) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		ParsePosition pos = new ParsePosition(0);
		Date strtodate = formatter.parse(strDate, pos);
		return strtodate;
	}

	public static String dateToStrLong(Date dateDate) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateString = formatter.format(dateDate);
		return dateString;
	}

	public static String dateToStr(Date dateDate) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		String dateString = formatter.format(dateDate);
		return dateString;
	}

	public static String dateToStr(Date dateDate, String pattern) {
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		return sdf.format(dateDate);
	}

	public static Date strToDate(String strDate) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		ParsePosition pos = new ParsePosition(0);
		Date strtodate = formatter.parse(strDate, pos);
		return strtodate;
	}

	public static Date strToDate(String strDate, String patten) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		if ((patten != null) && (patten.length() > 0)) {
			formatter = new SimpleDateFormat(patten);
		}

		ParsePosition pos = new ParsePosition(0);
		Date strtodate = formatter.parse(strDate, pos);
		return strtodate;
	}

	public static Date getNow() {
		Date currentTime = new Date();
		return currentTime;
	}

	public static String getCurrentDateStr() {
		Date currentTime = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateString = formatter.format(currentTime);
		return dateString;
	}

	public static Date getLastDate(long day) {
		Date date = new Date();
		long date_3_hm = date.getTime() - 122400000L * day;
		Date date_3_hm_date = new Date(date_3_hm);
		return date_3_hm_date;
	}

	public static String getStringToday() {
		Date currentTime = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd HHmmss");
		String dateString = formatter.format(currentTime);
		return dateString;
	}

	public static String getStringTodayto() {
		Date currentTime = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
		String dateString = formatter.format(currentTime);
		return dateString;
	}

	public static String getHour() {
		Date currentTime = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateString = formatter.format(currentTime);
		String hour = dateString.substring(11, 13);
		return hour;
	}

	public static String getTime() {
		Date currentTime = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateString = formatter.format(currentTime);
		String min = dateString.substring(14, 16);
		return min;
	}

	public static String getUserDate(String sformat) {
		Date currentTime = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat(sformat);
		String dateString = formatter.format(currentTime);
		return dateString;
	}

	public static String getTwoHour(String st1, String st2) {
		String[] kk = null;
		String[] jj = null;
		kk = st1.split(":");
		jj = st2.split(":");
		if (Integer.parseInt(kk[0]) < Integer.parseInt(jj[0])) {
			return "0";
		}
		double y = Double.parseDouble(kk[0]) + Double.parseDouble(kk[1]) / 60.0D;
		double u = Double.parseDouble(jj[0]) + Double.parseDouble(jj[1]) / 60.0D;
		return y - u > 0.0D ? y - u + "" : "0";
	}

	public static String getTwoDay(String sj1, String sj2) {
		SimpleDateFormat myFormatter = new SimpleDateFormat("yyyy-MM-dd");
		long day = 0L;
		try {
			Date e = myFormatter.parse(sj1);
			Date mydate = myFormatter.parse(sj2);
			day = (e.getTime() - mydate.getTime()) / 86400000L;
		} catch (Exception var7) {
			var7.printStackTrace();
			return "";
		}

		return day + "";
	}

	public static String getPreTime(String sj1, String jj) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String mydate1 = "";
		try {
			Date e = format.parse(sj1);
			long Time = e.getTime() / 1000L + Integer.parseInt(jj) * 60;
			e.setTime(Time * 1000L);
			mydate1 = format.format(e);
		} catch (Exception var7) {
			var7.printStackTrace();
		}

		return mydate1;
	}

	public static String getNextDay(String nowdate, String delay) {
		try {
			SimpleDateFormat e = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String mdate = "";
			Date d = strToDate(nowdate);
			long myTime = d.getTime() / 1000L + Long.parseLong(delay) * 24L * 60L * 60L;
			d.setTime(myTime * 1000L);
			return e.format(d);
		} catch (Exception var7) {
			var7.printStackTrace();
		}
		return "";
	}

	public static String getNextDaytoSen(String statrdate, String delay) {
		try {
			SimpleDateFormat e = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String mdate = "";
			Date d = strToDate(statrdate, "yyyy-MM-dd HH:mm:ss");
			long myTime = d.getTime() / 1000L + Long.parseLong(delay) * 24L * 60L * 60L;
			d.setTime(myTime * 1000L);
			return e.format(d);
		} catch (Exception var7) {
			var7.printStackTrace();
		}
		return "";
	}

	public static boolean isLeapYear(String ddate) {
		Date d = strToDate(ddate);
		GregorianCalendar gc = (GregorianCalendar) Calendar.getInstance();
		gc.setTime(d);
		int year = gc.get(1);
		return year % 400 == 0;
	}

	public static String getEDate(String str) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		ParsePosition pos = new ParsePosition(0);
		Date strtodate = formatter.parse(str, pos);
		String j = strtodate.toString();
		String[] k = j.split(" ");
		return k[2] + k[1].toUpperCase() + k[5].substring(2, 4);
	}

	public static String getEndDateOfMonth(String dat) {
		String str = dat.substring(0, 8);
		String month = dat.substring(5, 7);
		int mon = Integer.parseInt(month);
		if ((mon != 1) && (mon != 3) && (mon != 5) && (mon != 7) && (mon != 8) && (mon != 10) && (mon != 12)) {
			if ((mon != 4) && (mon != 6) && (mon != 9) && (mon != 11)) {
				if (isLeapYear(dat))
					str = str + "29";
				else
					str = str + "28";
			} else
				str = str + "30";
		} else {
			str = str + "31";
		}

		return str;
	}

	public static boolean isSameWeekDates(Date date1, Date date2) {
		Calendar cal1 = Calendar.getInstance();
		Calendar cal2 = Calendar.getInstance();
		cal1.setTime(date1);
		cal2.setTime(date2);
		int subYear = cal1.get(1) - cal2.get(1);
		if (0 == subYear) {
			if (cal1.get(3) == cal2.get(3))
				return true;
		} else if ((1 == subYear) && (11 == cal2.get(2))) {
			if (cal1.get(3) == cal2.get(3))
				return true;
		} else if ((-1 == subYear) && (11 == cal1.get(2)) && (cal1.get(3) == cal2.get(3))) {
			return true;
		}

		return false;
	}

	public static String getSeqWeek() {
		Calendar c = Calendar.getInstance(Locale.CHINA);
		String week = Integer.toString(c.get(3));
		if (week.length() == 1) {
			week = "0" + week;
		}

		String year = Integer.toString(c.get(1));
		return year + week;
	}

	public static String getWeek(String sdate, String num) {
		Date dd = strToDate(sdate);
		Calendar c = Calendar.getInstance();
		c.setTime(dd);
		if (num.equals("1"))
			c.set(7, 2);
		else if (num.equals("2"))
			c.set(7, 3);
		else if (num.equals("3"))
			c.set(7, 4);
		else if (num.equals("4"))
			c.set(7, 5);
		else if (num.equals("5"))
			c.set(7, 6);
		else if (num.equals("6"))
			c.set(7, 7);
		else if (num.equals("0")) {
			c.set(7, 1);
		}

		return new SimpleDateFormat("yyyy-MM-dd").format(c.getTime());
	}

	public static String getWeek(String sdate) {
		Date date = strToDate(sdate);
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		return new SimpleDateFormat("EEEE").format(c.getTime());
	}

	public static String getWeekStr(String sdate) {
		String str = "";
		str = getWeek(sdate);
		if ("1".equals(str))
			str = "星期日";
		else if ("2".equals(str))
			str = "星期一";
		else if ("3".equals(str))
			str = "星期二";
		else if ("4".equals(str))
			str = "星期三";
		else if ("5".equals(str))
			str = "星期四";
		else if ("6".equals(str))
			str = "星期五";
		else if ("7".equals(str)) {
			str = "星期六";
		}

		return str;
	}

	public static long getDays(String date1, String date2) {
		if ((date1 != null) && (!date1.equals(""))) {
			if ((date2 != null) && (!date2.equals(""))) {
				SimpleDateFormat myFormatter = new SimpleDateFormat("yyyy-MM-dd");
				Date date = null;
				Date mydate = null;
				try {
					date = myFormatter.parse(date1);
					mydate = myFormatter.parse(date2);
				} catch (Exception var7) {
					var7.printStackTrace();
				}

				long day = (date.getTime() - mydate.getTime()) / 86400000L;
				return day;
			}
			return 0L;
		}

		return 0L;
	}

	public static String getNowMonth(String sdate) {
		sdate = sdate.substring(0, 8) + "01";
		Date date = strToDate(sdate);
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		int u = c.get(7);
		String newday = getNextDay(sdate, 1 - u + "");
		return newday;
	}

	public static long getDistinceMonth(String beforedate, String afterdate) throws ParseException {
		SimpleDateFormat d = new SimpleDateFormat("yyyy-MM-dd");
		long monthCount = 0L;
		try {
			Date e = d.parse(beforedate);
			Date d2 = d.parse(afterdate);
			monthCount = (getYear(d2) - getYear(e)) * 12 + getMonth(d2) - getMonth(e);
		} catch (ParseException var7) {
			var7.printStackTrace();
		}

		return monthCount;
	}

	public static long getDistinceDay(Date beforedate, Date afterdate) {
		long dayCount = 0L;
		dayCount = (beforedate.getTime() - afterdate.getTime()) / 86400000L;
		return dayCount;
	}

	public static long getDistinceDay(String beforedate, String afterdate) throws ParseException {
		SimpleDateFormat d = new SimpleDateFormat("yyyy-MM-dd");
		long dayCount = 0L;
		try {
			Date e = d.parse(beforedate);
			Date d2 = d.parse(afterdate);
			dayCount = (d2.getTime() - e.getTime()) / 86400000L;
		} catch (ParseException var7) {
			var7.printStackTrace();
		}

		return dayCount;
	}

	public static String disTime(Date date1, Date date2) {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return disTime(df.format(date1), df.format(date2));
	}

	public static int disDay(String date1, String date2) {
		int day = 0;
		try {
			SimpleDateFormat e = new SimpleDateFormat("yyyy-MM-dd");
			Date now = e.parse(date1);
			Date date = e.parse(date2);
			long l = now.getTime() - date.getTime();
			day = (int) (l / 86400000L);
		} catch (Exception var8) {
			var8.printStackTrace();
		}

		return day;
	}

	public static double disDateTime(String date1, String date2) {
		double la = 0.0D;
		try {
			SimpleDateFormat e = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date now = e.parse(date1);
			Date date = e.parse(date2);
			long l = now.getTime() - date.getTime();
			long day = l / 86400000L;
			long hour = l / 3600000L - day * 24L;
			double min = l / 60000L - day * 24L * 60L - hour * 60L;
			double s = l / 1000L - day * 24L * 60L * 60L - hour * 60L * 60L - min * 60.0D;
			la = day * 24L + hour + min / 60.0D + s / 3600.0D;
		} catch (Exception var17) {
			var17.printStackTrace();
		}

		return la;
	}

	public static String disTime(String date1, String date2) {
		StringBuffer sb = new StringBuffer();
		try {
			SimpleDateFormat e = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date now = e.parse(date1);
			Date date = e.parse(date2);
			long l = now.getTime() - date.getTime();
			long day = l / 86400000L;
			long hour = l / 3600000L - day * 24L;
			long min = l / 60000L - day * 24L * 60L - hour * 60L;
			if ((day <= 0L) && (hour <= 0L) && (min <= 0L)) {
				return "1";
			}

			if (day > 0L) {
				sb.append(day + "天");
			}

			if (hour > 0L) {
				sb.append(hour + "小时");
			}

			if (min > 0L)
				sb.append(min + "");
		} catch (Exception var14) {
			var14.printStackTrace();
		}

		return sb.toString();
	}

	public static Date getFirstDateOfMonth(Date d) {
		Calendar c = Calendar.getInstance();
		c.setTime(d);
		c.set(5, 1);
		c.set(11, 0);
		c.set(12, 0);
		c.set(13, 0);
		Date date = c.getTime();
		return date;
	}

	public static String formatDate(Date d, String pattern) {
		SimpleDateFormat sf = new SimpleDateFormat(pattern);
		return sf.format(d);
	}

	public static Date parseToDate(String sDate, String pattern) throws ParseException {
		SimpleDateFormat sf = new SimpleDateFormat(pattern);
		return sf.parse(sDate);
	}

	public static Date getMinTime(Date dt) {
		Date dt1 = null;
		try {
			dt1 = parseToDate(formatDate(dt, "yyyyMMdd"), "yyyyMMdd");
		} catch (ParseException var3) {
			var3.printStackTrace();
		}

		return dt1;
	}

	public static Date getMaxTime(Date dt) {
		Date dt1 = null;
		Calendar ca = Calendar.getInstance();
		ca.setTime(dt);
		ca.add(5, 1);
		dt1 = ca.getTime();
		dt1 = getMinTime(dt1);
		ca.setTime(dt1);
		ca.add(13, -1);
		dt1 = ca.getTime();
		return dt1;
	}

	public static Timestamp parseToTimestamp(Date date) {
		return new Timestamp(date.getTime());
	}

	public static String formatDate(Timestamp d, String pattern) {
		SimpleDateFormat sf = new SimpleDateFormat(pattern);
		return sf.format(d);
	}

	public static boolean isValidKey(String createKeyDate, long expire_time) {
		SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date now = new Date();
		try {
			Date e = dateformat.parse(createKeyDate);
			Date currentTime = dateformat.parse(dateformat.format(now));
			long time = (currentTime.getTime() - e.getTime()) / 1000L;
			return time > expire_time;
		} catch (ParseException var9) {
			var9.printStackTrace();
		}
		return false;
	}

	public static Date compareDateInNull(Date createDate, String absDays, String sourceDate2) {
		String loseReadyDateStr = getNextDay(formatDate(createDate, "yyyy-MM-dd HH:mm:ss"), absDays.toString());
		Date loseReadyDate = toDate(loseReadyDateStr, "yyyy-MM-dd HH:mm:ss");
		loseReadyDate = getMaxTime(loseReadyDate);
		if (("null".equals(sourceDate2)) && ("0".equals(absDays)))
			return getMaxTime(new Date());
		if ("null".equals(sourceDate2)) {
			return loseReadyDate;
		}

		if ("0".equals(absDays)) {
			Date sourceDate = getMaxTime(toDate(sourceDate2, "yyyy-MM-dd HH:mm:ss"));
			return sourceDate;
		}
		Date sourceDate = getMaxTime(toDate(sourceDate2, "yyyy-MM-dd HH:mm:ss"));
		return loseReadyDate.after(sourceDate) ? sourceDate : loseReadyDate;
	}

	public static boolean loseDate(Date loseDate) {
		Date nows = new Date();
		long hous = (nows.getTime() - loseDate.getTime()) / 1000L;
		return hous > 0L;
	}

	public static boolean betweenBeginAndEnd(Date paramDate, Date beginDate, Date endDate) {
		long bHous = (paramDate.getTime() - beginDate.getTime()) / 1000L;
		long eHous = (endDate.getTime() - paramDate.getTime()) / 1000L;
		return (bHous > 0L) && (eHous > 0L);
	}

	public static Date compareDate(Date createDate, String absDays, Date sourceDate2) {
		sourceDate2 = getMaxTime(sourceDate2);
		String loseReadyDateStr = getNextDay(formatDate(createDate, "yyyy-MM-dd HH:mm:ss"), absDays.toString());
		Date loseReadyDate = toDate(loseReadyDateStr, "yyyy-MM-dd HH:mm:ss");
		loseReadyDate = getMaxTime(loseReadyDate);
		return loseReadyDate.after(sourceDate2) ? sourceDate2 : loseReadyDate;
	}

	public static String formatTime(int day, String standFormat) {
		String date = null;
		Calendar c = Calendar.getInstance();
		c.add(5, day);
		SimpleDateFormat format = new SimpleDateFormat(standFormat);
		date = format.format(c.getTime());
		return date;
	}

	public static String getTimeBeforeORAfter(int days, String pattern) {
		if (pattern == null) {
			pattern = "yyyy-MM-dd HH:mm:ss";
		}

		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		Calendar c = Calendar.getInstance();
		c.add(5, days);
		return sdf.format(c.getTime());
	}

	public static boolean isAfterToday(String tocompareStr) throws ParseException {
		String pattern = "yyyy-MM-dd HH:mm:ss";
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		Date tocompareDate = sdf.parse(tocompareStr);
		return tocompareDate.after(Calendar.getInstance().getTime());
	}

	public static Long countDifSeconds(Timestamp t1, Timestamp t2) {
		return (t1 != null) && (t2 != null) ? Long.valueOf((t2.getTime() - t1.getTime()) / 1000L)
				: t1.compareTo(t2) >= 0 ? Long.valueOf((t1.getTime() - t2.getTime()) / 1000L) : Long.valueOf(0L);
	}

	public static int getDateOfMonth() {
		Calendar c = Calendar.getInstance();
		return c.get(5);
	}

	public static String getTimeBeforeOrAfterSenconds(Timestamp sourceTime, long seconds) {
		if (sourceTime != null) {
			long time = sourceTime.getTime() + seconds * 1000L;
			sourceTime.setTime(time);
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			return sdf.format(sourceTime);
		}
		return "";
	}

	public static String getTimeBeforeOrAfterMonth(int months, String pattern, Date sourceTime) {
		if (pattern == null) {
			pattern = "yyyy-MM-dd HH:mm:ss";
		}

		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		Calendar c = Calendar.getInstance();
		c.setTime(sourceTime);
		c.add(2, months);
		return sdf.format(c.getTime());
	}

	public static void main(String[] args) {
		Calendar lastDate = Calendar.getInstance();
		lastDate.add(2, -1);
		lastDate.add(5, 5);
		Date date = lastDate.getTime();
		long s = getDistinceDay(new Date(), date);
	}

	public static int getYear(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar.get(1);
	}

	public static int getMonth(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar.get(2);
	}

	public static int getMinute(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar.get(12);
	}

	public static int getSecond(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar.get(13);
	}

	public static String unicode2String(String unicode) {
		StringBuffer string = new StringBuffer();
		String[] hex = unicode.split("\\\\u");
		for (int i = 1; i < hex.length; i++) {
			int data = Integer.parseInt(hex[i], 16);

			string.append((char) data);
		}
		return string.toString();
	}

	public static String string2Unicode(String string) {
		StringBuffer unicode = new StringBuffer();
		for (int i = 0; i < string.length(); i++) {
			char c = string.charAt(i);

			unicode.append("\\u" + Integer.toHexString(c));
		}
		return unicode.toString();
	}

	// *************************************************************************************
	public final static String YYYY = "yyyy";
	public final static String MM = "MM";
	public final static String DD = "dd";
	public final static String YYYY_MM_DD = "yyyy-MM-dd";
	public final static String YYYY_MM = "yyyy-MM";
	public final static String HH_MM_SS = "HH:mm:ss";
	public final static String YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";
	public final static String YYYYMMDDHHMMSS = "yyyyMMddHHmmss";
	public static String yyyyMMdd_HHmmss = "yyyyMMdd HHmmss";
	public static String _yyyyMMdd_HHmmss = "yyyy/MM/dd HH/mm/ss";
	

	/**
	 * 默认把日期格式化成yyyy-mm-dd格式
	 */
	public static String format(Date date) {
		if (date == null) {
			return "";
		} else {
			return getFormatter(YYYY_MM_DD).format(date);
		}
	}

	/**
	 * 日期格式化
	 */
	public static String format(Date date, String pattern) {
		if (date == null) {
			return "";
		} else {
			return getFormatter(pattern).format(date);
		}
	}

	/**
	 * 把字符串日期默认转换为yyyy-mm-dd格式的Data对象
	 */
	public static Date format(String strDate) {
		Date date = null;
		if (strDate == "") {
			return null;
		} else {
			try {
				date = getFormatter(YYYY_MM_DD).parse(strDate);
			} catch (ParseException pex) {
				return null;
			}
		}
		return date;
	}

	/**
	 * 把字符串日期转换为f指定格式的Data对象
	 */
	public static Date format(String strDate, String format) {
		Date date = null;
		if (strDate == "") {
			return null;
		} else {
			try {
				date = getFormatter(format).parse(strDate);
			} catch (ParseException pex) {
				return null;
			}
		}
		return date;
	}

	/**
	 * 日期解析－将<code>String</code>类型的日期解析为<code>Date</code>型
	 */
	public static Date parse(String strDate, String pattern) throws ParseException {
		try {
			return getFormatter(pattern).parse(strDate);
		} catch (ParseException pe) {
			throw new ParseException("Method parse in Class DateUtils  err: parse strDate fail.", pe.getErrorOffset());
		}
	}

	/**
	 * 获取当前日期
	 */
	public static synchronized Date getCurrDate() {
		Calendar calendar = Calendar.getInstance();
		return calendar.getTime();
	}

	/**
	 * 获取当前日期
	 */
	public static String getCurrDateStr() {
		return format(getCurrDate(), YYYY_MM_DD);
	}

	public static String getCurrDateStr(String pattern) {
		return format(getCurrDate(), pattern);
	}

	/**
	 * 获取当前时间
	 */
	public static String getCurrTimeStr() {
		return format(getCurrDate(), HH_MM_SS);
	}

	/**
	 * 获取当前完整时间,样式: yyyy－MM－dd hh:mm:ss
	 */
	public static String getCurrDateTimeStr() {
		return format(getCurrDate(), YYYY_MM_DD_HH_MM_SS);
	}

	/**
	 * 获取当前年份 样式：yyyy
	 */
	public static String getYear() {
		return format(getCurrDate(), YYYY);
	}

	/**
	 * 获取当前月份：MM
	 */
	public static String getMonth() {
		return format(getCurrDate(), MM);
	}

	/**
	 * 获取当前日期天
	 */
	public static String getDay() {
		return format(getCurrDate(), DD);
	}

	/**
	 * 按给定日期样式判断给定字符串是否为合法日期数据
	 */
	public static boolean isDate(String strDate, String pattern) {
		try {
			parse(strDate, pattern);
			return true;
		} catch (ParseException pe) {
			return false;
		}
	}

	/**
	 * 判断给定字符串是否为特定格式年份（格式：yyyy）数据
	 */
	public static boolean isYYYY(String strDate) {
		try {
			parse(strDate, YYYY);
			return true;
		} catch (ParseException pe) {
			return false;
		}
	}

	public static boolean isYYYY_MM(String strDate) {
		try {
			parse(strDate, YYYY_MM);
			return true;
		} catch (ParseException pe) {
			return false;
		}
	}

	/**
	 * 判断给定字符串是否为特定格式的年月日（格式：yyyy-MM-dd）数据
	 */
	public static boolean isYYYY_MM_DD(String strDate) {
		try {
			parse(strDate, YYYY_MM_DD);
			return true;
		} catch (ParseException pe) {
			return false;
		}
	}

	/**
	 * 判断给定字符串是否为特定格式年月日时分秒（格式：yyyy-MM-dd HH:mm:ss）数据
	 * 
	 * @return true 如果是，否则返回false
	 */
	public static boolean isYYYY_MM_DD_HH_MM_SS(String strDate) {
		try {
			parse(strDate, YYYY_MM_DD_HH_MM_SS);
			return true;
		} catch (ParseException pe) {
			return false;
		}
	}

	/**
	 * 判断给定字符串是否为特定格式时分秒（格式：HH:mm:ss）数据
	 */
	public static boolean isHH_MM_SS(String strDate) {
		try {
			parse(strDate, HH_MM_SS);
			return true;
		} catch (ParseException pe) {
			return false;
		}
	}

	/**
	 * 判断给定字符串是否为特定格式时间（包括：时分秒hh:mm:ss）数据
	 */
	public static boolean isTime(String strTime) {
		try {
			parse(strTime, HH_MM_SS);
			return true;
		} catch (ParseException pe) {
			return false;
		}
	}

	/**
	 * 判断给定字符串是否为特定格式日期时间（包括：年月日时分秒 yyyy-MM-dd hh:mm:ss）数据
	 */
	public static boolean isDateTime(String strDateTime) {
		try {
			parse(strDateTime, YYYY_MM_DD_HH_MM_SS);
			return true;
		} catch (ParseException pe) {
			return false;
		}
	}

	/**
	 * 获取一个简单的日期格式化对象
	 */
	private static SimpleDateFormat getFormatter(String parttern) {
		return new SimpleDateFormat(parttern);
	}

	/**
	 * 获取给定日前的后intevalDay天的日期
	 * 
	 * @param refenceDate：给定日期（格式为：yyyy-MM-dd）
	 * @param intevalDays：间隔天数
	 * @return 计算后的日期
	 */
	public static String addDate(String refenceDate, int intevalDays) {
		try {
			return addDate(parse(refenceDate, YYYY_MM_DD), intevalDays);
		} catch (Exception ee) {
			return "";
		}
	}

	/**
	 * 获取给定日前的后intevalDay天的日期
	 * 
	 * @param refenceDate：
	 *            Date 给定日期
	 * @param intevalDays：int
	 *            间隔天数
	 * @return String 计算后的日期
	 */
	public static String addDate(Date refenceDate, int intevalDays) {
		try {
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(refenceDate);
			calendar.set(Calendar.DATE, calendar.get(Calendar.DATE) + intevalDays);
			return format(calendar.getTime(), YYYY_MM_DD);
		} catch (Exception ee) {
			return "";
		}
	}

	/*
	 * 计算间隔时间 Field: Calendar定义的变量值，例如：Calendar.MINUTE
	 */
	public static String addDate(Date refenceDate, int Field, int intevalVal) {
		try {
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(refenceDate);
			calendar.add(Field, intevalVal);
			return format(calendar.getTime(), YYYY_MM_DD_HH_MM_SS);
		} catch (Exception ee) {
			return "";
		}
	}

	public static String addDate(Date refenceDate, int Field, int intevalVal, String format) {
		try {
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(refenceDate);
			calendar.add(Field, intevalVal);
			return format(calendar.getTime(), format);
		} catch (Exception ee) {
			return "";
		}
	}

	public static long getIntevalDays(String startDate, String endDate) {
		try {
			return getIntevalDays(parse(startDate, YYYY_MM_DD), parse(endDate, YYYY_MM_DD));
		} catch (Exception ee) {
			return 0l;
		}
	}

	public static long getIntevalDays(Date startDate, Date endDate) {
		try {
			return (endDate.getTime() - startDate.getTime()) / (24 * 60 * 60 * 1000);
		} catch (Exception ee) {
			return 0l;
		}
	}

	/*
	 * 得到工作日数:除去星期6和星期天
	 */
	public static long getWorkDays(Date startDate, Date endDate) {
		try {
			if (startDate.compareTo(endDate) > 0)
				return 0;
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(startDate);
			int week = calendar.get(Calendar.DAY_OF_WEEK);
			int l = 24 * 3600 * 1000;
			long days = Math.abs(endDate.getTime() - startDate.getTime()) / l;
			long n = days % 7;
			if (n + week == 7 || week == 7) {
				n = (n - 1) > 0 ? n - 1 : 0;
			} else if (n + week > 7) {
				n = n - 2;
			}
			days = (days - days % 7) * 5 / 7 + n;
			return days;
		} catch (Exception ee) {
			return 0;
		}
	}

	/**
	 * 求当前日期和指定字符串日期的相差天数
	 */
	public static long getIntevalDaysToNow(String startDate) {
		try {
			// 当前时间
			Date currentDate = new Date();
			// 指定日期
			SimpleDateFormat myFormatter = new SimpleDateFormat("yyyy-MM-dd");
			java.util.Date theDate = myFormatter.parse(startDate);
			// 两个时间之间的天数
			long days = (currentDate.getTime() - theDate.getTime()) / (24 * 60 * 60 * 1000);
			return days;
		} catch (Exception ee) {
			return 0l;
		}
	}

	/*
	 * 得到当前日期
	 */
	public static String getCurrentDate(String parttern) {
		try {
			Date currentDate = new Date();// 当前时间
			SimpleDateFormat myFormatter = new SimpleDateFormat(parttern);
			return myFormatter.format(currentDate);
		} catch (Exception ee) {
			return "";
		}
	}

	public static String dateTimeToString(Date datetime) {
		GregorianCalendar calendar = new GregorianCalendar();
		calendar.setTime(datetime);
		String dateTime = calendar.get(Calendar.YEAR) + "" + (calendar.get(Calendar.MONTH) + 1 > 9 ? "" : "0")
				+ (calendar.get(Calendar.MONTH) + 1) + "" + (calendar.get(Calendar.DATE) > 9 ? "" : "0")
				+ calendar.get(Calendar.DATE) + "" + (calendar.get(Calendar.HOUR_OF_DAY) > 9 ? "" : "0")
				+ calendar.get(Calendar.HOUR_OF_DAY) + "" + (calendar.get(Calendar.MINUTE) > 9 ? "" : "0")
				+ calendar.get(Calendar.MINUTE) + "" + (calendar.get(Calendar.SECOND) > 9 ? "" : "0")
				+ calendar.get(Calendar.SECOND);
		return dateTime;
	}

	// public static void main(String[] args){
	// Calendar calendar = Calendar.getInstance();
	// Date date = new Date();// 当前时间
	// calendar.setTime(date);
	// calendar.add(Calendar.MONTH, -3);
	// SimpleDateFormat formater=new SimpleDateFormat("yyyy-MM-dd");
	// String str=formater.format(calendar.getTime());
	// System.out.println(str);
	// }
	
	
	
	/**
	 * 时分秒运算(暂不支持年月日和星期的计算)
	 * @Time   2018年3月20日下午2:43:03
	 * @param time		需要运算的时间字符串
	 * @param parttern	时间格式
	 * @param field		运算的时间类型	Calendar.HOUR 小时	Calendar.MINUTE 分钟	Calendar.SECOND 秒
	 * @param num		加的数量
	 * @param type		运算类型 true为加,false为减
	 * @return
	 */
	public static Date CalculationTime(String time,String parttern,int field,int num,boolean type){
		GregorianCalendar cal = new GregorianCalendar();
	    Date date = DateUtils.toDate(time, parttern);
	    cal.setTime(date);
	    if(!type){//-
	    	num = -num;
	    }
	    switch (field) {
        case Calendar.HOUR:
        	cal.add(Calendar.HOUR, num);  
            break;
        case Calendar.MINUTE:
        	cal.add(Calendar.MINUTE, num);  
            break;
        case Calendar.SECOND:
        	cal.add(Calendar.SECOND, num);  
            break;
	    }
	    Date result = cal.getTime();
		return result;
	}
	
}