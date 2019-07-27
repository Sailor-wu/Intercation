package com.gds.log;

import java.net.URL;

import org.slf4j.ILoggerFactory;
import org.slf4j.LoggerFactory;
import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.joran.JoranConfigurator;


public class LogBack {
	
	public static void initLogBack() throws Exception{
		URL url = LogBack.class.getClassLoader().getResource("logback.xml");
		ILoggerFactory iLoggerFactory = LoggerFactory.getILoggerFactory();
		LoggerContext lc = (LoggerContext) iLoggerFactory;
		JoranConfigurator configurator = new JoranConfigurator();
		configurator.setContext(lc);
		lc.reset();
		configurator.doConfigure(url);
	}
}
