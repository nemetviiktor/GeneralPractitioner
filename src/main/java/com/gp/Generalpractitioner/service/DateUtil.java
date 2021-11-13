package com.gp.Generalpractitioner.service;

import java.sql.Date;


public class DateUtil {
	
	public Date getCurrentDate() {
		return new Date(System.currentTimeMillis());
	}
	
}
