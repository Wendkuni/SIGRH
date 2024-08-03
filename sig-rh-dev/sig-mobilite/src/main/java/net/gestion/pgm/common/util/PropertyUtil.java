package net.gestion.pgm.common.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyUtil {
	private static Properties config = new Properties();
	private static final String CONFIG="config.properties";
//	{
//		try {
//			config.load(new FileInputStream(CONFIG));
//		} catch (IOException e) {
//			//			e.printStackTrace();
//		}
//		
//	}
	
	{
		try {
		//	FileInputStream file;
			config.load(new FileInputStream(CONFIG));
		
			//file=new FileInputStream("./"+CONFIG);
		//	config.load(file);
		//	file.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	
   public static String getConfig(String property){
		return config.getProperty(property).trim();
	}

}
