/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team818.robot.commands;

public class IntakeRotateCommand extends CommandBase {
	public IntakeRotateCommand() {
		requires(intake);
	}

	protected void initialize() {
		intake.disablePID();
		intake.setIntakeVert(0);
	}

	protected void execute() {
		intake.setIntakeVert(-oi.getGamepadLeftY() * 0.4);
		
	}

	protected boolean isFinished() {
		return false;
	}

	protected void end() {
		intake.intakeVertOff();
	}

	protected void interrupted() {
		intake.intakeVertOff();
	}
}
