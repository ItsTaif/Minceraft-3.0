package org.usfirst.frc.team818.robot.commands.components;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class MidAutonSecondCube extends CommandGroup {

	public MidAutonSecondCube(boolean endOnLeft, int action) {
    	
    	if (endOnLeft) {
    		addSequential(new ElevatorAutonCommand("Bottom"));
    		addSequential(new Drive4Distance(-20));
    		addSequential(new TurnAngle(-90));
    		addSequential(new Drive4Distance(40));
    		addSequential(new TurnAngle(90));
    		addSequential(new Drive4Distance(40));
    		addSequential(new TurnAngle(90));
    		addSequential(new Drive4Distance(20));
    		addSequential(new TurnAngle(90));
    		addSequential(new Drive4Distance(10));
    		addParallel(new IntakeInAutonCommand(1.0, 2.0));
    		
    		switch(action) {
			case 1: 
				addSequential(new ElevatorAutonCommand("Switch"));
				addSequential(new Drive4Distance(5.0));
				addSequential(new IntakeOutAutonCommand(0.5));
				break;
			case 2:
				addSequential(new ElevatorAutonCommand("Scale"));
				addSequential(new Drive4Distance(-5.0));
				addSequential(new TurnAngle(180));
				addSequential(new Drive4Distance(10));
				addSequential(new IntakeOutAutonCommand(0.5));
				break;
			default: 
    			break;
    		}
    		
    		
    	} else {
    		addSequential(new ElevatorAutonCommand("Bottom"));
    		addSequential(new Drive4Distance(-20));
    		addSequential(new TurnAngle(90));
    		addSequential(new Drive4Distance(40));
    		addSequential(new TurnAngle(-90));
    		addSequential(new Drive4Distance(40));
    		addSequential(new TurnAngle(-90));
    		addSequential(new Drive4Distance(20));
    		addSequential(new TurnAngle(-90));
    		addSequential(new Drive4Distance(10));
    		addParallel(new IntakeInAutonCommand(1.0, 2.0));
    		
    		switch(action) {
			case 1: 
				addSequential(new ElevatorAutonCommand("Switch"));
				addSequential(new Drive4Distance(5.0));
				addSequential(new IntakeOutAutonCommand(0.5));
				break;
			case 2:
				addSequential(new ElevatorAutonCommand("Scale"));
				addSequential(new Drive4Distance(-5.0));
				addSequential(new TurnAngle(180));
				addSequential(new Drive4Distance(10));
				addSequential(new IntakeOutAutonCommand(0.5));
				break;
			default: 
    			break;
    		}
    	}
       
    }
}
