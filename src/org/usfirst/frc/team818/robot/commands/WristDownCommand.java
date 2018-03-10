/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team818.robot.commands;

import edu.wpi.first.wpilibj.Timer;

public class WristDownCommand extends CommandBase {
	Timer timer;
	double time;
	public WristDownCommand(double time) {
		requires(wrist);
		timer = new Timer();
	}

	protected void initialize() {
		wrist.setWrist(0);
		timer.start();
	}

	protected void execute() {
		wrist.setWrist(0.5);
	}

	protected boolean isFinished() {
		return timer.hasPeriodPassed(time);
	}

	protected void end() {
		wrist.setWrist(0);
	}

	protected void interrupted() {
		wrist.setWrist(0);
	}
}
