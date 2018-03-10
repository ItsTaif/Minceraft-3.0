/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team818.robot.commands;

import edu.wpi.first.wpilibj.Timer;

public class IntakeDownForTime extends CommandBase {
	Timer timer = new Timer();
	double time;
	public IntakeDownForTime(double time) {
		requires(intake);
		this.time = time;
	}

	protected void initialize() {
		intake.disablePID();
		intake.setIntakeVert(0);
		timer.reset();
		timer.start();
	}

	protected void execute() {
		intake.setIntakeVert(0.4);
		
	}

	protected boolean isFinished() {
		return timer.hasPeriodPassed(time);
	}

	protected void end() {
		intake.intakeVertOff();
	}

	protected void interrupted() {
		intake.intakeVertOff();
	}
}
