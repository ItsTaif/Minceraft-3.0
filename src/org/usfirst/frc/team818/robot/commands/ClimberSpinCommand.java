/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team818.robot.commands;

import edu.wpi.first.wpilibj.DriverStation;

public class ClimberSpinCommand extends CommandBase {
	
	public ClimberSpinCommand() {
		requires(climber);
	}
	
	protected void initialize() {
		climber.setSpeed(0);
	}

	protected void execute() {
		try {
			if (DriverStation.getInstance().getMatchTime() <= 30) {
				climber.setSpeed(oi.getGamepadLeftY());
			}
		} catch (Exception e) {
			climber.setSpeed(oi.getGamepadLeftY());
		}
	}
	
	protected boolean isFinished() {
    	return false;
	}

	protected void end() {
		climber.setOff();
	}

	protected void interrupted() {
		climber.setOff();
	}
}