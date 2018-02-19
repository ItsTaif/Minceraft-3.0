/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team818.robot.subsystems;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

public class ShifterSubsystem extends Subsystem {
	
	Solenoid gearShiftLeftHigh, gearShiftLeftLow, gearShiftRightHigh, gearShiftRightLow;
	private boolean shifterEnabled;
	
	public ShifterSubsystem(int[] gearLeftPorts, int[] gearRightPorts, boolean shifterEnabled) {

		this.shifterEnabled = shifterEnabled;

		if (shifterEnabled) {
			gearShiftLeftHigh = new Solenoid(gearLeftPorts[0]);
			gearShiftLeftLow = new Solenoid(gearLeftPorts[1]);
			gearShiftRightHigh = new Solenoid(gearRightPorts[0]);
			gearShiftRightLow = new Solenoid(gearRightPorts[1]);
		}
	}
	
	public void initDefaultCommand() {
		// setDefaultCommand(new MySpecialCommand());
	}
	
	public void lowGear() {
		if (shifterEnabled) {
			gearShiftLeftHigh.set(true);
			gearShiftLeftLow.set(false);
			gearShiftRightHigh.set(true);
			gearShiftRightLow.set(false);
		}
	}

	public void highGear() {
		if (shifterEnabled) {
			gearShiftLeftHigh.set(false);
			gearShiftLeftLow.set(true);
			gearShiftRightHigh.set(false);
			gearShiftRightLow.set(true);
		}
	}

	public void offGear() {
		if (shifterEnabled) {
			gearShiftLeftHigh.set(false);
			gearShiftLeftLow.set(false);
			gearShiftRightHigh.set(false);
			gearShiftRightLow.set(false);
		}
	}
	
}
