package org.usfirst.frc.team818.robot.utilities;

import edu.wpi.first.wpilibj.DriverStation;

/**
 * Matthew P.
 * Team 818 The Steel Armadillos 
 * 
 * This class is used to display messages on the SmartDashboard for quick debugging
 * and has practical applications in testing. Integers, booleans, and other data
 * can be written to the SmartDashboard to identify whether or not the program is
 * behaving in the intended manner.
 * 
 */


public class GetGameData extends Thread{

	private static String data;
	
	public void run(){
		
		do {
			data = DriverStation.getInstance().getGameSpecificMessage();
		}while(data.isEmpty());
		

	}
	
	public static String getGameData() {
		return data;
	}
	
	
}
