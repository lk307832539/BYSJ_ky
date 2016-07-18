package com.ky.until;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TimestampFormat {
	private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	public static Timestamp TimestampToDate(Date time) {
		String stime = sdf.format(time);
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		try {
			timestamp = Timestamp.valueOf(stime);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return timestamp;
	}

	public static Timestamp TimestampToString(String time) throws Exception  {
		DateFormat fmt =new SimpleDateFormat("yyyy-MM-dd");

		Date date = fmt.parse(time);
		Timestamp timestamp = TimestampToDate(date);
		return timestamp;
	}

	public static void main(String[] args) throws Exception {
		Date date = new Date();
		Timestamp timestamp = TimestampToDate(date);
		System.out.println(timestamp);

		String date1 = "2016-04-14";
		timestamp = TimestampToString(date1);
		System.out.println(timestamp);
	}
}
