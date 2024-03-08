package org.Page.Utils;

import java.io.FileInputStream;
import java.util.Properties;

public class configPropFile {
	public static Properties property;
	public static String projectpath = System.getProperty("user.dir");
	private static String configpath = projectpath + "/src/main/resources/config.properties";

	public static void getproperties() {
		try {

			property = new Properties();
			FileInputStream file = new FileInputStream(configpath);
			property.load(file);

		} catch (Exception e) {
			System.out.println("Exception error");
		}
	}
}
