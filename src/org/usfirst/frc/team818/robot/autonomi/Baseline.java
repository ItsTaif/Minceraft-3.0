package org.usfirst.frc.team818.robot.autonomi;

import org.usfirst.frc.team818.robot.commands.components.Drive4Distance;
import org.usfirst.frc.team818.robot.utilities.RobotLog;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class Baseline extends CommandGroup {

	public Baseline() {
		
		RobotLog.putMessage("Running Baseline");
		addSequential(new Drive4Distance(300));

	}
}
