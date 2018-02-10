/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team818.robot.subsystems;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.command.Subsystem;

public class CompressorSubsystem extends Subsystem {
	
	Compressor compressor;
	
	private boolean compressorEnabled;
	
	public CompressorSubsystem(boolean compressorEnabled) {
		this.compressorEnabled = compressorEnabled;
		if (compressorEnabled)
			compressor = new Compressor();
	}
	
	public void initDefaultCommand() {
		// setDefaultCommand(new MySpecialCommand());
	}
	
	public void setCloseLoopControl(boolean compressorSwitch) {
		if (compressorEnabled) {
			compressor.setClosedLoopControl(compressorSwitch);
		}
	}

	public void startCompressor() {
		if (compressorEnabled) {
			compressor.start();
		}
	}

	public void stopCompressor() {
		if (compressorEnabled) {
			compressor.stop();
		}
	}

	public boolean getPressureSwitchValue() {
		if (compressorEnabled) {
			return compressor.getPressureSwitchValue();
		} else
			return false;
	}
	
}
