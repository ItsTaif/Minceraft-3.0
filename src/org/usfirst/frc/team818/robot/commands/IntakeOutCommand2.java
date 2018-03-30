/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team818.robot.commands;

public class IntakeOutCommand2 extends CommandBase {
	public IntakeOutCommand2() {
		requires(intake);
	}

	protected void initialize() {
    	intake.intakeOut(0.0);
	}

	protected void execute() {
		intake.intakeOut(0.4);
	}

	protected boolean isFinished() {
		return false;
	}

	protected void end() {
		intake.intakeOff();
	}

	protected void interrupted() {
		intake.intakeOff();
	}
}
