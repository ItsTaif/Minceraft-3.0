/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team818.robot.commands.components;

import org.usfirst.frc.team818.robot.commands.CommandBase;

public class WristRotateAutonCommand extends CommandBase {
	
	boolean buttonWasPressed;
	
	public WristRotateAutonCommand() {
		requires(wrist);
	}

	protected void initialize() {
		wrist.enablePID();
		wrist.setSetPoint(-100);
	}

	protected void execute() {
		
	}

	protected boolean isFinished() {
		return false;
	}

	protected void end() {
		wrist.setWrist(0);
	}

	protected void interrupted() {
		wrist.setWrist(0);
	}
}
