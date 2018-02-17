package org.usfirst.frc.team818.robot.autonomi;

import java.util.LinkedList;

import org.usfirst.frc.team818.robot.Constants;
import org.usfirst.frc.team818.robot.commands.components.Drive4Distance;
import org.usfirst.frc.team818.robot.commands.components.ElevatorAutonCommand;
import org.usfirst.frc.team818.robot.commands.components.IntakeOutAutonCommand;
import org.usfirst.frc.team818.robot.commands.components.TurnAngle;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *ISSA PROTOYPE FAM DON'T RUN THIS JUST YET
 */
public class MidAuton extends CommandGroup {

	String gameData;
	int target;
	double delay;
	private static LinkedList<Target> priority = new LinkedList<>();
	PriorityList autonPriority = new PriorityList();

	public MidAuton() {

		gameData = DriverStation.getInstance().getGameSpecificMessage();
		
		priority = autonPriority.getPriority();
		
		delay = SmartDashboard.getNumber("Delay", 0);
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
			addSequential(new Drive4Distance(68.5 - Constants.robotHalfLength)); // move forward to gap between the power cube pile and the exchange zone
			addParallel(new ElevatorAutonCommand("Scale")); // move elevator to Scale position
			addSequential(new WaitCommand(0.25));
			addSequential(new TurnAngle(-90)); // 90 degree left turn
			addSequential(new Drive4Distance(132 + Constants.midPositionShift - Constants.robotHalfWidth)); // move forward to the left side of the field
			addSequential(new WaitCommand(0.25));
			addSequential(new TurnAngle(90)); // 90 degree right turn
			addSequential(new Drive4Distance(71.5)); // move forward next to Scale
			addSequential(new WaitCommand(0.25));
			addSequential(new TurnAngle(90)); // 90 degree right turn
			addSequential(new Drive4Distance(42 +  - Constants.robotHalfLength)); // move forward  to Scale
			addSequential(new IntakeOutAutonCommand(0.8, 2)); // drop power cube			
			break;
		case 2: //rightScale
			addSequential(new WaitCommand(delay));
			addSequential(new Drive4Distance(68.5 - Constants.robotHalfLength)); // move forward to gap between the power cube pile and the exchange zone
			addParallel(new ElevatorAutonCommand("Scale")); // move elevator to Scale position
			addSequential(new WaitCommand(0.25));
			addSequential(new TurnAngle(90)); // 90 degree right turn
			addSequential(new Drive4Distance(132 - Constants.midPositionShift - Constants.robotHalfWidth)); // move forward to the left side of the field
			addSequential(new WaitCommand(0.25));
			addSequential(new TurnAngle(-90)); // 90 degree left turn
			addSequential(new Drive4Distance(71.5)); // move forward next to Scale
			addSequential(new WaitCommand(0.25));
			addSequential(new TurnAngle(-90)); // 90 degree left turn
			addSequential(new Drive4Distance(42 - Constants.robotHalfLength)); // move forward  to Scale
			addSequential(new IntakeOutAutonCommand(0.8, 2)); // drop power cube		
			break;
		case 3: //leftSwitch
			addSequential(new WaitCommand(delay));
			addSequential(new Drive4Distance(68.5 - Constants.robotHalfLength)); // move forward to gap between the power cube pile and the exchange zone
			addParallel(new ElevatorAutonCommand("Switch")); // move elevator to Switch position
			addSequential(new WaitCommand(0.25));
			addSequential(new TurnAngle(-90)); // 90 degree left turn
			addSequential(new Drive4Distance(54 + Constants.midPositionShift - Constants.robotHalfWidth)); // move forward next to Switch
			addSequential(new WaitCommand(0.25));
			addSequential(new TurnAngle(90)); // 90 degree right turn
			addSequential(new Drive4Distance(71.5 - Constants.robotHalfLength)); // move forward to Switch
			addSequential(new IntakeOutAutonCommand(0.8, 2)); // drop power cube
			break;
		case 4: //rightSwitch
			addSequential(new WaitCommand(delay));
			addSequential(new Drive4Distance(68.5 - Constants.robotHalfLength)); // move forward to gap between the power cube pile and the exchange zone
			addParallel(new ElevatorAutonCommand("Switch")); // move elevator to Switch position
			addSequential(new WaitCommand(0.25));
			addSequential(new TurnAngle(90)); // 90 degree right turn
			addSequential(new Drive4Distance(54 - Constants.midPositionShift - Constants.robotHalfWidth)); // move forward next to Switch
			addSequential(new WaitCommand(0.25));
			addSequential(new TurnAngle(-90)); // 90 degree left turn
			addSequential(new Drive4Distance(71.5 - Constants.robotHalfLength)); // move forward to Switch
			addSequential(new IntakeOutAutonCommand(0.8, 2)); // drop power cube
			break;
		case 5: addSequential(new DoNothing());
			break;

		}

	}
}