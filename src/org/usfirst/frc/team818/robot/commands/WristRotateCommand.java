/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team818.robot.commands;

public class WristRotateCommand extends CommandBase {
	public WristRotateCommand() {
		requires(wrist);
	}

	protected void initialize() {
		wrist.setWrist(0);
	}

	protected void execute() {
		wrist.setWrist(-oi.getGamepadLeftY() * 0.4);
		
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
