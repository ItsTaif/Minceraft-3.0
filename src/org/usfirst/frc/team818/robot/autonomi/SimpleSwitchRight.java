package org.usfirst.frc.team818.robot.autonomi;

import org.usfirst.frc.team818.robot.commands.ElevatorForTimeCommand;
import org.usfirst.frc.team818.robot.commands.IntakeDownForTime;
import org.usfirst.frc.team818.robot.commands.IntakeOutForTimeCommand;
import org.usfirst.frc.team818.robot.commands.components.Drive4Distance;
import org.usfirst.frc.team818.robot.utilities.GetGameData;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class SimpleSwitchRight extends CommandGroup {

	public SimpleSwitchRight() {

		addSequential(new Drive4Distance(32));
		if (GetGameData.getGameData().charAt(0) == 'R') {
			addSequential(new IntakeDownForTime(0.3));
			addSequential(new ElevatorForTimeCommand(1));
			addSequential(new IntakeOutForTimeCommand(1));
		}

	}
}