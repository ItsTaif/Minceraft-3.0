/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team818.robot.commands.components;

import org.usfirst.frc.team818.robot.commands.CommandBase;

public class IntakeOutAutonCommand extends CommandBase {
	
	private double speed, time;
	
	public IntakeOutAutonCommand(double speed) {
		requires(intake);
		this.speed = speed;
		this.time = 3;
	}
	
	public IntakeOutAutonCommand(double speed, double time) {
		requires(intake);
		this.speed = speed;
		this.time = time;		
	}

	protected void initialize() {
    	intake.intakeOut(0.8);
	}

	protected void execute() {
		intake.intakeOut(0.8);
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
