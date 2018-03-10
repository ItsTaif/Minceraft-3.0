package org.usfirst.frc.team818.robot.autonomi;

import java.util.LinkedList;

import org.usfirst.frc.team818.robot.Constants;
import org.usfirst.frc.team818.robot.commands.IntakeDownCommand;
import org.usfirst.frc.team818.robot.commands.components.Drive4Distance;
import org.usfirst.frc.team818.robot.commands.components.ElevatorAutonCommand;
import org.usfirst.frc.team818.robot.commands.components.IntakeOutAutonCommand;
import org.usfirst.frc.team818.robot.commands.components.SideAutonPart2Scale;
import org.usfirst.frc.team818.robot.commands.components.SideAutonPart2Switch;
import org.usfirst.frc.team818.robot.commands.components.TurnAngle;
import org.usfirst.frc.team818.robot.utilities.GetGameData;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *ISSA PROTOYPE FAM DON'T RUN THIS JUST YET
 */
public class RightAuton extends CommandGroup {

	String gameData;
	int target;
	double delay;
	private static LinkedList<Target> priority = new LinkedList<>();
	PriorityList autonPriority = new PriorityList();

	public RightAuton() {

		gameData = GetGameData.getGameData();
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
			addSequential(new WaitCommand(delay)); // wait set amount of time
			addSequential(new IntakeDownCommand()); // moves intake down
			addSequential(new Drive4Distance(235.235 - Constants.robotHalfLength)); // move forward to gap between the platform and the Switch
			addParallel(new ElevatorAutonCommand("Scale")); // move elevator to Scale position
			addSequential(new WaitCommand(0.25));
			addSequential(new TurnAngle(-90)); // 90 degree left turn
			addSequential(new Drive4Distance(264 - Constants.robotHalfWidth)); // move forward to the left side of the field
			addSequential(new WaitCommand(0.25));
			addSequential(new TurnAngle(90)); // 90 degree right turn
			addSequential(new Drive4Distance(88.765)); // move forward next to Scale
			addSequential(new WaitCommand(0.25));
			addSequential(new TurnAngle(90)); // 90 degree right turn
			addSequential(new Drive4Distance(42 - Constants.robotHalfLength)); // move forward to Scale
			addSequential(new WaitCommand(0.25));
			addSequential(new IntakeOutAutonCommand(0.8, 2)); // drop power cube
			if(SmartDashboard.getBoolean("Second Scale", false)){
				addSequential(new SideAutonPart2Scale("left", "Scale"));
			}else if(SmartDashboard.getBoolean("Second Switch", false)){
				addSequential(new SideAutonPart2Scale("left", "Switch"));
			}
			break;
		case 2: //rightScale
			addSequential(new WaitCommand(delay)); // wait set amount of time
			addSequential(new IntakeDownCommand()); // moves intake down
			addSequential(new Drive4Distance(324 - Constants.robotHalfLength)); // move forward to middle of the field
			addParallel(new ElevatorAutonCommand("Scale")); // move elevator to Scale position
			addSequential(new WaitCommand(0.25));
			addSequential(new TurnAngle(-90)); // 90 degree left turn
			addSequential(new Drive4Distance(42 - Constants.robotHalfWidth - Constants.robotHalfLength)); // move forward to Scale
			addSequential(new WaitCommand(0.25));
			addSequential(new IntakeOutAutonCommand(0.8, 2)); // drop power cube
			if(SmartDashboard.getBoolean("Second Scale", false)){
				addSequential(new SideAutonPart2Scale("right", "Scale"));
			}else if(SmartDashboard.getBoolean("Second Switch", false)){
				addSequential(new SideAutonPart2Scale("right", "Switch"));
			}
			break;
		case 3: //leftSwitch
			addSequential(new WaitCommand(delay)); // wait set amount of time
			addSequential(new IntakeDownCommand()); // moves intake down
			addSequential(new Drive4Distance(235.235 - Constants.robotHalfLength)); // move forward to gap between the platform and the Switch
			addParallel(new ElevatorAutonCommand("Switch")); // move elevator to Switch position
			addSequential(new WaitCommand(0.25));
			addSequential(new TurnAngle(-90)); // 90 degree left turn
			addSequential(new Drive4Distance(264 - Constants.robotHalfWidth)); // move forward to the left side of the field
			addSequential(new WaitCommand(0.25));
			addSequential(new TurnAngle(-90)); // 90 degree left turn
			addSequential(new Drive4Distance(67.235)); // move forward next to Switch
			addSequential(new WaitCommand(0.25));
			addSequential(new TurnAngle(-90)); // 90 degree left turn
			addSequential(new Drive4Distance(55.25 - Constants.robotHalfLength)); // move forward to Switch
			addSequential(new WaitCommand(0.25));
			addSequential(new IntakeOutAutonCommand(0.8, 2)); // drop power cube
			if(SmartDashboard.getBoolean("Second Scale", false)){
				addSequential(new SideAutonPart2Switch("left", "Scale"));
			}else if(SmartDashboard.getBoolean("Second Switch", false)){
				addSequential(new SideAutonPart2Switch("left", "Switch"));
			}
			break;
		case 4: //rightSwitch
			addSequential(new WaitCommand(delay)); // wait set amount of time
			addSequential(new IntakeDownCommand()); // moves intake down
			addSequential(new Drive4Distance(168 - Constants.robotHalfLength)); // move forward next to Switch
			addParallel(new ElevatorAutonCommand("Switch")); // move elevator to Switch position
			addSequential(new WaitCommand(0.25));
			addSequential(new TurnAngle(-90)); // 90 degree left turn
			addSequential(new Drive4Distance(55.25 - Constants.robotHalfLength - Constants.robotHalfWidth)); // move forward to Switch
			addSequential(new WaitCommand(0.25));
			addSequential(new IntakeOutAutonCommand(0.8, 2)); // drop power cube
			if(SmartDashboard.getBoolean("Second Scale", false)){
				addSequential(new SideAutonPart2Switch("right", "Scale"));
			}else if(SmartDashboard.getBoolean("Second Switch", false)){
				addSequential(new SideAutonPart2Switch("right", "Switch"));
			}
			break;
		case 5: addSequential(new DoNothing());
			break;

		}

	}
}