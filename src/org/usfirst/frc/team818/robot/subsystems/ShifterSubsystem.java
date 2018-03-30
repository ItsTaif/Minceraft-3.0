/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team818.robot.subsystems;

import org.usfirst.frc.team818.robot.commands.ShiftHighCommand;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

public class ShifterSubsystem extends Subsystem {
	
	//Solenoid gearShiftHigh, gearShiftLow;
	DoubleSolenoid gearShift;
	private boolean shifterEnabled;
	
	public ShifterSubsystem(int[] gearPorts, boolean shifterEnabled) {

		this.shifterEnabled = shifterEnabled;

		if (shifterEnabled) {
			gearShift = new DoubleSolenoid(13, gearPorts[0], gearPorts[1]);
		//	gearShiftHigh = new Solenoid(13, gearPorts[0]);
			//gearShiftLow = new Solenoid(13, gearPorts[1]);
		}
	}
	
	public void initDefaultCommand() {
		 setDefaultCommand(new ShiftHighCommand());
	}
	
	public void fire() {
		if (shifterEnabled) {
			if (gearShift.get() == DoubleSolenoid.Value.kForward) {
				gearShift.set(DoubleSolenoid.Value.kReverse);
			} else if (gearShift.get() == DoubleSolenoid.Value.kReverse) {
				gearShift.set(DoubleSolenoid.Value.kForward);
			}
		}
	}
	
	public void lowGear() {
		if (shifterEnabled) {
			gearShift.set(DoubleSolenoid.Value.kForward);
//			gearShiftHigh.set(true);
//			gearShiftLow.set(false);
		}
	}

	public void highGear() {
		if (shifterEnabled) {
			gearShift.set(DoubleSolenoid.Value.kReverse);
//			gearShiftHigh.set(false);
//			gearShiftLow.set(true);
		}
	}

	public void offGear() {
		if (shifterEnabled) {
			gearShift.set(DoubleSolenoid.Value.kOff);
//			gearShiftHigh.set(false);
//			gearShiftLow.set(false);
		}
	}
	
}
