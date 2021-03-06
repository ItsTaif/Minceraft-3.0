/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team818.robot.commands;

public class DynamicBraking extends CommandBase {
	public DynamicBraking() {
		requires(drive);
	}

protected void initialize() {
		
		drive.setBoth(0);
		drive.resetBothEncoders();
		drive.enablePID("straight");
		drive.setDistanceSetpoint(0);
	}

	protected void execute() {
		drive.setBoth(drive.getPIDOutputLeft(), drive.getPIDOutputRight());		
	}

	protected boolean isFinished() {
		return false;
	}

	protected void end() {
		drive.setBoth(0);
		drive.disablePID();
	}

	protected void interrupted() {
		drive.setBoth(0);
		drive.disablePID();
	}
	
}
