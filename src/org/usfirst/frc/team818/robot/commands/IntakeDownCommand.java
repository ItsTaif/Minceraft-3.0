/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team818.robot.commands;

public class IntakeDownCommand extends CommandBase {
	public IntakeDownCommand() {
		requires(intake);
	}

	protected void initialize() {
		intake.intakeVertOff();
	}

	protected void execute() {
    	intake.setIntakeVert(-0.3);
	}

	protected boolean isFinished() {
		return intake.intakeReachDown();
	}

	protected void end() {
		intake.intakeVertOff();
	}

	protected void interrupted() {
		intake.intakeVertOff();
	}
}
