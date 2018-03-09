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
	
	Solenoid gearShiftHigh, gearShiftLow;
	private boolean shifterEnabled;
	
	public ShifterSubsystem(int[] gearPorts, boolean shifterEnabled) {

		this.shifterEnabled = shifterEnabled;

		if (shifterEnabled) {
			gearShiftHigh = new Solenoid(13, gearPorts[0]);
			gearShiftLow = new Solenoid(13, gearPorts[1]);
		}
	}
	
	public void initDefaultCommand() {
		// setDefaultCommand(new MySpecialCommand());
	}
	
	public void lowGear() {
		if (shifterEnabled) {
			gearShiftHigh.set(true);
			gearShiftLow.set(false);
		}
	}

	public void highGear() {
		if (shifterEnabled) {
			gearShiftHigh.set(false);
			gearShiftLow.set(true);
		}
	}

	public void offGear() {
		if (shifterEnabled) {
			gearShiftHigh.set(false);
			gearShiftLow.set(false);
		}
	}
	
}
