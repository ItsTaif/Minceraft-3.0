package org.usfirst.frc.team818.robot.autonomi;

import org.usfirst.frc.team818.robot.commands.components.Drive4Distance;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class Baseline extends CommandGroup {

	public Baseline() {

		addSequential(new Drive4Distance(110));

	}
}
