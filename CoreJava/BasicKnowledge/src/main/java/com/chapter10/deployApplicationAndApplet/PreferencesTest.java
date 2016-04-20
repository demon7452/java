package com.chapter10.deployApplicationAndApplet;

import java.io.File;
import java.io.FileOutputStream;
import java.util.prefs.Preferences;

public class PreferencesTest {

	public static void main(String[] args) {
		Preferences fPreferences = Preferences.userRoot();
		Preferences node = fPreferences.node("/test2");
		fPreferences.put("A", "testA");
		fPreferences.putInt("one", 1);
		fPreferences.putBoolean("boolean", true);
		node.put("test", "test");
		
		File file = new File("src/main/resources/proferences.xml");
		try {
			FileOutputStream fileOutputStream = new FileOutputStream(file);
			fPreferences.exportSubtree(fileOutputStream);
		} catch (Exception e) {
			e.printStackTrace();
		}
		

	}

}
