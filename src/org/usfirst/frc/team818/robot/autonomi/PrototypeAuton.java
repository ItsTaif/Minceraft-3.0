package org.usfirst.frc.team818.robot.autonomi;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *ISSA PROTOYPE FAM DON'T RUN THIS JUST YET
 */
public class PrototypeAuton extends CommandGroup {

	String gameData;
	int leftSwitch, rightSwitch, leftScale, rightScale, target;
	double delay;
	int priority[] = new int[4]; // = { leftSwitch, rightSwitch, leftScale, rightScale };

	public PrototypeAuton() {

		gameData = DriverStation.getInstance().getGameSpecificMessage();

		target = 5;

		leftSwitch = (int) SmartDashboard.getNumber("leftSwitch", 4);
		rightSwitch = (int) SmartDashboard.getNumber("rightSwitch", 4);
		leftScale = (int) SmartDashboard.getNumber("leftScale", 4);
		rightScale = (int) SmartDashboard.getNumber("rightScale", 4);
		delay = (int) SmartDashboard.getNumber("delay", 0);

		priority[leftSwitch - 1] = 1;
		priority[rightSwitch - 1] = 2;
		priority[leftScale - 1] = 3;
		priority[rightScale - 1] = 4;

		for (int i : priority) {
			if (target == 5) {
				switch (i) {
				case 1: // leftSwitch
					if (gameData.charAt(0) == 'L' && SmartDashboard.getBoolean("enableLeftSwitch", false))
						target = 1;
					break;
				case 2: // rightSwitch
					if (gameData.charAt(0) == 'R' && SmartDashboard.getBoolean("enableRightSwitch", false))
						target = 2;
					break;
				case 3: // leftScale
					if (gameData.charAt(1) == 'L' && SmartDashboard.getBoolean("enableLeftScale", false))
						target = 3;
					break;
				case 4: // rightScale
					if (gameData.charAt(1) == 'R' && SmartDashboard.getBoolean("enableRightScale", false))
						target = 4;
					break;
				default: break;
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
