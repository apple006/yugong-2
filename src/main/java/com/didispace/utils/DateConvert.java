package com.didispace.utils;

import org.apache.commons.beanutils.Converter;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateConvert implements Converter {

	public <T extends Object> T convert(Class<T> class1, Object value) {
		// TODO Auto-generated method stub
		if (value == null) {
			return null;
		}
		if (value instanceof Date) {
			return (T) value;
		}
		if (value instanceof Long) {
			Long longValue = (Long) value;
			return (T) new Date(longValue.longValue());
		}
		if (value instanceof String) {
			String dateStr = (String) value;
			Date endTime = null;
			try {
				String regexp1 = "([0-9]{4})-([0-1][0-9])-([0-3][0-9])T([0-2][0-9]):([0-6][0-9]):([0-6][0-9])";
				String regexp2 = "([0-9]{4})-([0-1][0-9])-([0-3][0-9])(/t)([0-2][0-9]):([0-6][0-9]):([0-6][0-9])";
				String regexp3 = "([0-9]{4})-([0-1][0-9])-([0-3][0-9])";
				String regexp4 = "([0-9]{4})-([0-9])-([0-3][0-9])";
				String regexp5 = "([0-9]{4}[0-9]{2}[0-9]{2})";
				String regexp6 = "([0-9]{4}[0-9]{1}[0-9]{2})";
				if (dateStr.matches(regexp1)) {
					dateStr = dateStr.split("T")[0] + " " + dateStr.split("T")[1];
					DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					endTime = sdf.parse(dateStr);
					return (T) endTime;
				} else if (dateStr.matches(regexp2)) {
					DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					endTime = sdf.parse(dateStr);
					return (T)endTime;
				} else if (dateStr.matches(regexp3) || dateStr.matches(regexp4)) {
					DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
					endTime = sdf.parse(dateStr);
					return (T)endTime;
				}else if (dateStr.matches(regexp5) || dateStr.matches(regexp6)) {
					DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
					endTime = sdf.parse(dateStr);
					return (T)endTime;
				}  else {
					return (T)dateStr;
				}
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		return (T)value;
	}

}
