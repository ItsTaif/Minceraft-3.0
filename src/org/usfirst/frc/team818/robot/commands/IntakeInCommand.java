/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team818.robot.commands;

public class IntakeInCommand extends CommandBase {
	public IntakeInCommand() {
		requires(intake);
	}

	protected void initialize() {
    	if((((oi.getLeftY())+(oi.getRightY()))/2) > 0.1) {
    		intake.intakeIn(((oi.getLeftY())+(oi.getRightY()))/2);
    	} else {
    		intake.intakeIn(0.1);
    	}
	}

	protected void execute() {
		if((((oi.getLeftY())+(oi.getRightY()))/2) > 0.1) {
    		intake.intakeIn(((oi.getLeftY())+(oi.getRightY()))/2);
    	} else {
    		intake.intakeIn(0.1);
    	}
	}

	protected boolean isFinished() {
		return intake.hasCube();
	}

	protected void end() {
		intake.intakeOff();
	}

	protected void interrupted() {
		intake.intakeOff();
	}
}
