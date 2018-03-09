/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team818.robot.commands;

public class CompressorCommand extends CommandBase {
	public CompressorCommand() {
		requires(compressor);
	}

	protected void initialize() {
		compressor.startCompressor();
	}

	protected void execute() {
		if (compressor.getPressureSwiValue())
			compressor.stopCompressor();
		else
			compressor.startCompressor();
	}

	protected boolean isFinished() {
		return false;
	}

	protected void end() {
		compressor.stopCompressor();
	}

	protected void interrupted() {
		compressor.stopCompressor();
	}
}
