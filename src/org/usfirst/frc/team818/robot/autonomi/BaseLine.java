package org.usfirst.frc.team818.robot.autonomi;

import org.usfirst.frc.team818.robot.commands.components.Drive4Distance;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class BaseLine extends CommandGroup {

	public BaseLine() {

		addSequential(new Drive4Distance(90, 0.5));

	}
}