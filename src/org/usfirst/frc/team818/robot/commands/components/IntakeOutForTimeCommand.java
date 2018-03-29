/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team818.robot.commands.components;

import org.usfirst.frc.team818.robot.commands.CommandBase;
import org.usfirst.frc.team818.robot.utilities.RobotLog;

import edu.wpi.first.wpilibj.Timer;

public class IntakeOutForTimeCommand extends CommandBase {
	Timer timer;
	double time;
	public IntakeOutForTimeCommand(double time) {
		requires(intake);
		timer = new Timer();
		this.time = time;
	}

	protected void initialize() {
		RobotLog.putMessage("Running IntakeOutForTimeCommand: " + time + " seconds");
    	intake.intakeOut(0.8);
    	timer.start();
	}

	protected void execute() {
			intake.intakeOut(0.8);
	}

	protected boolean isFinished() {
		return timer.hasPeriodPassed(time);
	}

	protected void end() {
		RobotLog.putMessage("Finished IntakeOutForTimeCommand: " + time + " seconds");
		intake.intakeOff();
	}

	protected void interrupted() {
		RobotLog.putMessage("Interrupted IntakeOutForTimeCommand: " + time + " seconds");
		intake.intakeOff();
	}
}
