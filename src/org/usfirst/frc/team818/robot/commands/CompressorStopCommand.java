/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team818.robot.commands;

public class CompressorStopCommand extends CommandBase {
	public CompressorStopCommand() {
		requires(compressor);
	}

	protected void initialize() {
    	compressor.stopCompressor();
	}

	protected void execute() {
    	compressor.stopCompressor();
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
