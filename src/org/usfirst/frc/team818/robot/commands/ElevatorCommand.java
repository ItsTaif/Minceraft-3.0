package org.usfirst.frc.team818.robot.commands;

public class ElevatorCommand extends CommandBase {
  
    public ElevatorCommand() {
       	requires(elevator);
    }

    protected void initialize() {
    	elevator.set(0);
    }

    protected void execute() {
    	
    	
    	
    	
    	elevator.set(elevator.getPIDOutputElevator());
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    	elevator.set(0);
    }

    protected void interrupted() {
    	elevator.set(0);
    }
}
