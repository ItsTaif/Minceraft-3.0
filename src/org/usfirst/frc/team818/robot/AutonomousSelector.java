package org.usfirst.frc.team818.robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc.team818.robot.autonomi.DoNothing;
import org.usfirst.frc.team818.robot.utilities.RobotLog;

/**
 * Matthew P.
 * Team 818 The Steel Armadillos
 * 
 * This class allows the driver to actively select autonomous modes to run
 * during the competition. The SmartDashboard can be modified to include
 * a variety of autonomi. For the code to run properly, the items indexed in
 * the String array "autonomi" must match their numbers on the SmartDashboard.
 * 
 * To modify the SmartDashboard, it is necessary to create a new SmartDashboard
 * project in LabView. There are other options for customizing the SmartDashboard,
 * but the simplest method is using LabView.
 *
 */

public class AutonomousSelector {

	public static final String[] autonomi = {"DoNothing", "Baseline", "LeftAuton", "MidAuton", "RightAuton"};
	
	public static Command getSelectedAutonomous(){
		
		int autoIndex;
		Command autonomous = new DoNothing();
		
		try{
			
			autoIndex = Integer.parseInt(SmartDashboard.getString("Autonomous", "DoNothing"));
			
		} catch (Exception exc){
			
			RobotLog.putMessage("Couldn't find the selected autonomous mode");
			RobotLog.putMessage(exc.getMessage());
			autoIndex = 0;
			
		}
		
		try{
			
			autonomous = (CommandGroup)Class.forName("org.usfirst.frc.team818.robot.autonomi." + autonomi[autoIndex]).newInstance();
			
		} catch (Exception e){
			
			RobotLog.putMessage("Could not run " + autonomous.toString());
			RobotLog.putMessage(e.getMessage());
			autonomous = new DoNothing();
			
		}
		
		return autonomous;
		
	}
	
}
