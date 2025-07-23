package com.ctl.it.qa.Test_Four.tests;

import java.time.LocalDate;

import com.ctl.it.qa.Test_Four.tools.steps.eservices.BaseStep;

public interface AutomationConstants {

	String[] date=(LocalDate.now().toString()).split("-");
	public static final String randomNo=date[1]+date[2]+String.valueOf(Math.round(Math.random() * 100));
	public static  final String CONFIG_PATH=System.getProperty("user.dir")+"\\src\\test\\resources\\configFiles\\config.properties";
	public static String UNIQUE_UNI_Install=BaseStep.getPropertyValue(CONFIG_PATH,"UNI_INSTALL");
	public static String UNIQUE_EVC_Install=BaseStep.getPropertyValue(CONFIG_PATH,"EVC_INSTALL");
	public static String UNIQUE_EVCCOMBO_Install=BaseStep.getPropertyValue(CONFIG_PATH,"EVC_COMBO");
	public static String UNIQUE_OVC_Install=BaseStep.getPropertyValue(CONFIG_PATH,"OVC_INSTALL");
	public static String UNIQUE_UNI_Change=BaseStep.getPropertyValue(CONFIG_PATH,"UNI_CHANGE");
	public static String UNIQUE_UNI_HotCut_Change=BaseStep.getPropertyValue(CONFIG_PATH,"UNI_HOTCUTCHANGE");
	public static String UNIQUE_EVC_Change=BaseStep.getPropertyValue(CONFIG_PATH,"EVC_Change");
	
}
