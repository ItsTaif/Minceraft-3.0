package org.usfirst.frc.team818.robot.commands.components;

import org.usfirst.frc.team818.robot.Constants;
import org.usfirst.frc.team818.robot.autonomi.DoNothing;
import org.usfirst.frc.team818.robot.autonomi.PriorityList;
import org.usfirst.frc.team818.robot.commands.IntakeInCommand;
import org.usfirst.frc.team818.robot.utilities.GetGameData;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *ISSA PROTOYPE FAM DON'T RUN THIS JUST YET
 */
public class SideAutonPart2Switch extends CommandGroup {

	String gameData;
	int target, sideM;
	double delay;
	PriorityList autonPriority = new PriorityList();

	public SideAutonPart2Switch(String side, String targetPosition) {

		gameData = GetGameData.getGameData();;
		delay = SmartDashboard.getNumber("Delay", 0);
		
		if(side.equals("left")){
			if(gameData.charAt(1) == 'L')
				target = 1;
			else
				target = 2;
			if(targetPosition.equals("Switch"))
				target = 3;
			sideM = -1;
		}else{
			if(gameData.charAt(1) == 'R')
				target = 1;
			else
				target = 2;
			if(targetPosition.equals("Switch"))
				target = 3;
			sideM = 1;
		}
			
		addSequential(new Drive4Distance(-55.25 + Constants.robotHalfLength));
		addParallel(new ElevatorAutonCommand("Bottom"));
		addSequential(new WaitCommand(0.25));
		addSequential(new TurnAngle(90 * sideM));
		addSequential(new Drive4Distance(67.235));
		addSequential(new WaitCommand(0.25));
		addSequential(new TurnAngle(-90 * sideM));
		addSequential(new Drive4Distance(61.25));
		addSequential(new WaitCommand(0.25));
		addSequential(new TurnAngle(-90 * sideM));
		addSequential(new Drive4Distance(39.235 - Constants.robotHalfLength));
		addParallel(new IntakeInCommand());
		
		switch (target) {
		case 1: //same side Scale
			addSequential(new WaitCommand(0.25));
			addSequential(new Drive4Distance(-39.235 + Constants.robotHalfLength));
			addSequential(new WaitCommand(0.25));
			addSequential(new TurnAngle(90 * sideM));
			addSequential(new Drive4Distance(-61.25));
			addSequential(new WaitCommand(0.25));
			addSequential(new TurnAngle(90 * sideM));
			addSequential(new Drive4Distance(88.765)); // move forward next to Scale
			addSequential(new ElevatorAutonCommand("Scale"));
			addSequential(new WaitCommand(0.25));
			addSequential(new TurnAngle(-90 * sideM)); // 90 degree left turn
			addSequential(new Drive4Distance(42 - Constants.robotHalfLength)); // move forward to Scale
			addSequential(new WaitCommand(0.25));
			addSequential(new IntakeOutAutonCommand(0.8, 2)); // drop power cube
			break;
		case 2: //opposite side Scale
			addSequential(new WaitCommand(0.25));
			addSequential(new Drive4Distance(-39.235 + Constants.robotHalfLength));
			addSequential(new WaitCommand(0.25));
			addSequential(new TurnAngle(90 * sideM));
			addSequential(new Drive4Distance(147.5));
			addSequential(new WaitCommand(0.25));
			addSequential(new TurnAngle(90 * sideM));
			addSequential(new Drive4Distance(88.765)); // move forward next to Scale
			addSequential(new ElevatorAutonCommand("Scale"));
			addSequential(new WaitCommand(0.25));
			addSequential(new TurnAngle(90)); // 90 degree right turn
			addSequential(new Drive4Distance(42 - Constants.robotHalfLength)); // move forward to Scale
			addSequential(new WaitCommand(0.25));
			addSequential(new IntakeOutAutonCommand(0.8, 2)); // drop power cube
			break;
		case 3: //current switch
			addSequential(new ElevatorAutonCommand("Switch"));
			addSequential(new Drive4Distance(10));
			addSequential(new IntakeOutAutonCommand(.8, 2));
			break;
		case 4: addSequential(new DoNothing());
			break;

		}

	}
}