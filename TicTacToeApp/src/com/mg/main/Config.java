package com.mg.main;

import java.util.Properties;
 
public class Config
{
   Properties configFile;
   public Config()
   {
	configFile = new Properties();
	String propFileName = "config.properties";
	try {
	  configFile.
	  load(getClass().
			  getClassLoader().
	  getResourceAsStream(propFileName));
	}catch(Exception eta){
	    eta.printStackTrace();
	}
   }
 
   public String getProperty(String key)
   {
	String value = this.configFile.getProperty(key);
	return value;
   }

}
