package org.usfirst.frc.team818.robot.autonomi;

import org.usfirst.frc.team818.robot.Constants;
import org.usfirst.frc.team818.robot.commands.components.Drive4Distance;
import org.usfirst.frc.team818.robot.commands.components.ElevatorForTimeCommand;
import org.usfirst.frc.team818.robot.commands.components.IntakeOutForTimeCommand;
import org.usfirst.frc.team818.robot.utilities.GetGameData;
import org.usfirst.frc.team818.robot.utilities.RobotLog;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class SimpleSwitchRight extends CommandGroup {

	public SimpleSwitchRight() {

		RobotLog.putMessage("Running SimpleSwitchRight");
		
		addSequential(new Drive4Distance(140 - 2*Constants.robotHalfLength));
		try {
			if (GetGameData.getGameData().charAt(0) == 'R') {
				addSequential(new ElevatorForTimeCommand(1));
				addSequential(new IntakeOutForTimeCommand(0.5));
			}
		} catch (Exception e) {

			RobotLog.putMessage("SimpleSwitchRight did not work");
			
		}

	}
}
