package org.usfirst.frc.team818.robot.autonomi;

import org.usfirst.frc.team818.robot.commands.ElevatorForTimeCommand;
import org.usfirst.frc.team818.robot.commands.IntakeDownForTime;
import org.usfirst.frc.team818.robot.commands.IntakeOutForTimeCommand;
import org.usfirst.frc.team818.robot.commands.components.Drive4Distance;
import org.usfirst.frc.team818.robot.utilities.GetGameData;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class SimpleSwitchLeft extends CommandGroup {

	public SimpleSwitchLeft() {

		addSequential(new Drive4Distance(32));
		try {
			if (GetGameData.getGameData().charAt(0) == 'L') {
				addSequential(new IntakeDownForTime(0.1));
				addSequential(new ElevatorForTimeCommand(1.2));
				addSequential(new IntakeOutForTimeCommand(0.5));
			}
		} catch (Exception e) {

		}
		

	}
}
