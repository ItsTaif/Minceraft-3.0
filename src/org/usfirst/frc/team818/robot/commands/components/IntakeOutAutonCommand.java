/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team818.robot.commands.components;

import org.usfirst.frc.team818.robot.Constants;
import org.usfirst.frc.team818.robot.commands.CommandBase;
import org.usfirst.frc.team818.robot.utilities.RobotLog;

import edu.wpi.first.wpilibj.Timer;

public class IntakeOutAutonCommand extends CommandBase {
	
	Timer timer;
	
	private double speed, time;
	
	public IntakeOutAutonCommand(double speed) {
		requires(intake);
		timer = new Timer();
		this.speed = speed;
		this.time = 3;
	}
	
	public IntakeOutAutonCommand(double speed, double time) {
		requires(intake);
		timer = new Timer();
		this.speed = speed;
		this.time = time;		
	}

	protected void initialize() {
		RobotLog.putMessage("Running IntakeOutAutonCommand: " + time + " seconds, " + speed + " speed");
	}

	protected void execute() {
		intake.intakeOut(speed);
	}

	protected boolean isFinished() {
		if(!Constants.intakeEnabled)
			return true;
		else
			return timer.hasPeriodPassed(time);
	}

	protected void end() {
    	RobotLog.putMessage("Finished IntakeOutAutonCommand: " + time + " seconds, " + speed + " speed");
		intake.intakeOff();
	}

	protected void interrupted() {
		RobotLog.putMessage("Interrupted IntakeOutAutonCommand: " + time + " seconds, " + speed + " speed");
		intake.intakeOff();
	}
}
