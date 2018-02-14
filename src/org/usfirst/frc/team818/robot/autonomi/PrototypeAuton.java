package org.usfirst.frc.team818.robot.autonomi;

import java.util.LinkedList;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *ISSA PROTOYPE FAM DON'T RUN THIS JUST YET
 */
public class PrototypeAuton extends CommandGroup {

	String gameData;
	int target;
	double delay;
	private static LinkedList<Target> priority = new LinkedList<>();
	PriorityList autonPriority = new PriorityList();

	public PrototypeAuton() {

		gameData = DriverStation.getInstance().getGameSpecificMessage();

		priority = autonPriority.getPriority();
		
		target = 5;

		for (int i = 0; i < 4; i++) {
			if (target == 5) {
				switch (priority.get(i).targetNumber) {
				
					case 1: // leftSwitch
						if (gameData.charAt(1) == 'L')
							target = 1;
						break;
						
					case 2: // rightSwitch
						if (gameData.charAt(1) == 'R')
							target = 2;
						break;
						
					case 3: // leftScale
						if (gameData.charAt(0) == 'L')
							target = 3;
						break;
						
					case 4: // rightScale
						if (gameData.charAt(0) == 'R')
							target = 4;
						break;
						
					default:
						break;
						
				}
			}

		}

		switch (target) {
		case 1: //leftSwitch
			break;
		case 2: //rightSwitch
			break;
		case 3: //leftScale
			break;
		case 4: //rightScale
			break;
		case 5: addSequential(new DoNothing());
			break;

		}

	}
}
