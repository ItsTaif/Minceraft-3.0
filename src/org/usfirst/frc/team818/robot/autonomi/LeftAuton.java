package org.usfirst.frc.team818.robot.autonomi;

import java.util.LinkedList;

import org.usfirst.frc.team818.robot.commands.components.Drive4Distance;
import org.usfirst.frc.team818.robot.commands.components.ElevatorAutonCommand;
import org.usfirst.frc.team818.robot.commands.components.TurnAngle;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *ISSA PROTOYPE FAM DON'T RUN THIS JUST YET
 */
public class LeftAuton extends CommandGroup {

	String gameData;
	int target;
	double delay;
	private static LinkedList<Target> priority = new LinkedList<>();
	PriorityList autonPriority = new PriorityList();

	public LeftAuton() {

		gameData = DriverStation.getInstance().getGameSpecificMessage();
		
		priority = autonPriority.getPriority();
		
		delay = SmartDashboard.getNumber("delay", 0);
		target = 5;

		for (int i = 0; i < priority.size(); i++) {
			if (target == 5) {
				switch (priority.get(i).targetNumber) {
				
					case 1: // leftScale
						if (gameData.charAt(1) == 'L')
							target = 1;
						break;
						
					case 2: // rightScale
						if (gameData.charAt(1) == 'R')
							target = 2;
						break;
						
					case 3: // leftSwitch
						if (gameData.charAt(0) == 'L')
							target = 3;
						break;
						
					case 4: // rightSwitch
						if (gameData.charAt(0) == 'R')
							target = 4;
						break;
						
					default:
						break;
						
				}
			}

		}

		switch (target) {
		case 1: //left Scale
			addSequential(new WaitCommand(delay));
			addSequential(new Drive4Distance(204, 0.7));
			addParallel(new ElevatorAutonCommand("Scale"));
			addSequential(new WaitCommand(0.25));
			addSequential(new TurnAngle(90));
			addSequential(new Drive4Distance(42));
			addSequential(new WaitCommand(0.25));
			break;
		case 2: //rightScale
			break;
		case 3: //leftSwitch
			break;
		case 4: //rightSwitch
			break;
		case 5: addSequential(new DoNothing());
			break;

		}

	}
}
