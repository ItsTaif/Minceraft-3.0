/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team818.robot.commands;

import org.usfirst.frc.team818.robot.utilities.RobotLog;

public class ShiftHighCommand extends CommandBase {
	public ShiftHighCommand() {
		requires(shifter);
	}

	protected void initialize() {
		RobotLog.putMessage("HIGH GEAR");
			shifter.highGear();
		
	}

	protected void execute() {
    	
	}

	protected boolean isFinished() {
		return false;
	}

	protected void end() {
		shifter.offGear();
	}

	protected void interrupted() {
		shifter.offGear();
	}
}
