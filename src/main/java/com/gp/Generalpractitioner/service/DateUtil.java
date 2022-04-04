package com.gp.Generalpractitioner.service;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;

public class DateUtil {

	public Date getCurrentDate() {
		return new Date(System.currentTimeMillis());
	}
	
	public String removeHyphenFromDate(Date date) {
		DateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd");
		String dateString = inputFormat.format(date);
		String replacedDate = dateString.replace("-", "");
		return replacedDate;
	}
	
	public String replaceHyphenDate(Date date) {
		DateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd");
		String dateString = inputFormat.format(date);
		String replacedDate = dateString.replace("-", ".");
		return replacedDate;
	}
	
	public static LocalDate addDaysSkippingWeekends(LocalDate date, int days) {
		LocalDate result = date;
		int addedDays = 0;
		while (addedDays < days) {
			result = result.plusDays(1);
			if (!(result.getDayOfWeek() == DayOfWeek.SATURDAY || result.getDayOfWeek() == DayOfWeek.SUNDAY)) {
				++addedDays;
			}
		}
		return result;
	}
}
