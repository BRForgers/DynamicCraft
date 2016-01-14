package brazillianforgers.dynamiccraft.handler;

import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

import brazillianforgers.dynamiccraft.DynamicCraft;
import brazillianforgers.lib.IOHelper;

public class UpdateHandler {
	
	private static String currentVersion = "1.0";
	private static String newestVersion;
	public static String updateStatus = "NULL";
	
	private static void getNewestVersion() {
		try {
			newestVersion = IOHelper.getStringFromURL(new URL("https://raw.githubusercontent.com/TheBrazillianForgersTeam/DynamicCraft/master/updatedVersion.txt"));
		}catch (IOException e) {
			e.printStackTrace();
			DynamicCraft.logger.error("Could not connect to Registry Update!");
		}
	}
	
	public static void init() {
		getNewestVersion();
		
		if(newestVersion != null) {
			if(newestVersion.equalsIgnoreCase(currentVersion)) {
				updateStatus = "[Dynamic Craft] Ohh nice! The mod is updated!";
		        DynamicCraft.logger.info("Dynamic Craft is updated!");
			} else {
				updateStatus = "[Dynamic Craft] Oh... The mod is outdated! You are running version " + currentVersion + " and the latest available version is " + newestVersion;
		        DynamicCraft.logger.info("Dynamic Craft is outdated! You are running version: " + currentVersion + " and the latest available version is: " + newestVersion);
			}
		}else {
			updateStatus = "[DynamicCraft] Failed to connect to check if update is available!";
		    DynamicCraft.logger.info("Failed to connect to check if update is available!");
		}
	}
}
