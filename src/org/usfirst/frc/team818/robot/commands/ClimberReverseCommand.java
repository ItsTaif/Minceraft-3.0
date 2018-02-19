/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team818.robot.commands;

public class ClimberReverseCommand extends CommandBase {
	public ClimberReverseCommand() {
		requires(climber);
	}

	protected void initialize() {
	}

	protected void execute() {
    	climber.setReverse();
	}

	protected boolean isFinished() {
		return false;
	}

	protected void end() {
		climber.setOff();
	}

	protected void interrupted() {
		climber.setOff();
	}
}