/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team818.robot.commands;

public class ClimberReleaseCommand extends CommandBase {
	public ClimberReleaseCommand() {
		requires(climber);
	}

	protected void initialize() {
    	climber.rOpen();
	}

	protected void execute() {
	}

	protected boolean isFinished() {
		return false;
	}

	protected void end() {
		climber.rOff();
	}

	protected void interrupted() {
		climber.rOff();
	}
}