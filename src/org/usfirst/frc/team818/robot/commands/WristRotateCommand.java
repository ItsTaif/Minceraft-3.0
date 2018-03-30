/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team818.robot.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class WristRotateCommand extends CommandBase {
	
	boolean buttonWasPressed;
	
	public WristRotateCommand() {
		requires(wrist);
	}

	protected void initialize() {
		wrist.setWrist(0);
		wrist.resetEncoder();
		buttonWasPressed = false;
	}

	protected void execute() {
		SmartDashboard.putString("DB/String 5", "" + wrist.getEncoderVal());
		SmartDashboard.putString("DB/String 0", "" + wrist.getPIDOutput());
		if (Math.abs(oi.getGamepadLeftY()) > 0.1) {
			buttonWasPressed = false;
			wrist.disablePID();
			wrist.setWrist(oi.getGamepadLeftY() * 0.4);
		} else {
			if (oi.allPressed.get() || buttonWasPressed) {
				buttonWasPressed = true;
				wrist.enablePID();
				if (oi.up.get()) {
					wrist.setSetPoint(0);
				} else if (oi.mid.get()) {
					wrist.setSetPoint(-100);
				} else if (oi.flat.get()) {
					wrist.setSetPoint(-220);
				}
				wrist.setWrist(wrist.getPIDOutput());
			}
			
		}
		
	}

	protected boolean isFinished() {
		return false;
	}

	protected void end() {
		wrist.setWrist(0);
	}

	protected void interrupted() {
		wrist.setWrist(0);
	}
}
