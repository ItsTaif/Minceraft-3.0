package org.usfirst.frc.team818.robot.autonomi;

import org.usfirst.frc.team818.robot.commands.components.Drive4Distance;
import org.usfirst.frc.team818.robot.commands.components.IntakeOutAutonCommand;
import org.usfirst.frc.team818.robot.commands.components.TurnAngle;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class VaultAuton extends CommandGroup {

    public VaultAuton() {
    	
    	addSequential(new Drive4Distance(10.0));
    	addSequential(new TurnAngle(-20));
    	addSequential(new Drive4Distance(10.0));
    	addSequential(new TurnAngle(-70));
    	addSequential(new Drive4Distance(18.0));
    	addSequential(new IntakeOutAutonCommand(0.5, 2.0));
    	addSequential(new Drive4Distance(-10.0));
    	addSequential(new Drive4Distance(-10.0));
    	addSequential(new TurnAngle(90));
    	addSequential(new Drive4Distance(140.0));
    	addSequential(new TurnAngle(90));
    	addSequential(new Drive4Distance(200.0));
    	
    }
}
