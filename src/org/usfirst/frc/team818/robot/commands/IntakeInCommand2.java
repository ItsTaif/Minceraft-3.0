/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team818.robot.commands;

import edu.wpi.first.wpilibj.Timer;

public class IntakeInCommand2 extends CommandBase {
	Timer timer = new Timer();
	public IntakeInCommand2() {
		requires(intake);
	}

	protected void initialize() {
    	intake.intakeIn(0.0);
    	timer.start();
	}

	protected void execute() {
		intake.intakeIn(0.4);
	}

	protected boolean isFinished() {
		if (!intake.hasCube()) {
			timer.reset();
		}
		return timer.hasPeriodPassed(0.5);
	}

	protected void end() {
		intake.intakeOff();
	}

	protected void interrupted() {
		intake.intakeOff();
	}
}
