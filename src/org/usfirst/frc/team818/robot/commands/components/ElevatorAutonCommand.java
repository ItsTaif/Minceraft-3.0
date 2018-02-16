package org.usfirst.frc.team818.robot.commands.components;

import org.usfirst.frc.team818.robot.Constants;
import org.usfirst.frc.team818.robot.commands.CommandBase;

public class ElevatorAutonCommand extends CommandBase {
  
    private double distanceBottom, distanceTarget;
    private String position;
	
	public ElevatorAutonCommand(String position) {
       	requires(elevator);
       	this.position = position;
    }

    protected void initialize() {
    	elevator.set(0);
    	distanceBottom = Constants.elevatorBottomPosition;
    	elevator.setSetpoint(distanceBottom);
    }

    protected void execute() {
    	
    	if(elevator.reachedBottom())
    		distanceBottom = elevator.getDistance();
		
		if(position.equals("Bottom"))
    		distanceTarget = distanceBottom;
    	else if(position.equals("Switch"))
    		distanceTarget = Constants.elevatorSwitchPosition;
    	else if(position.equals("Scale"))
    		distanceTarget = Constants.elevatorScalePosition;
    	
    	elevator.setSetpoint(distanceTarget);
    	elevator.set(elevator.getPIDOutputElevator());
	    	
    }

    protected boolean isFinished() {
    	if(position.equals("Bottom"))
    		return elevator.reachedBottom();
    	else if(position.equals("Switch"))
    		return elevator.getDistance() >= Constants.elevatorSwitchPosition;
        else if(position.equals("Scale"))
        	return elevator.getDistance() >= Constants.elevatorScalePosition;
        else return true;
    }

    protected void end() {
    	elevator.set(0);
    	elevator.disablePID();
    }

    protected void interrupted() {
    	elevator.set(0);
    	elevator.disablePID();
    }
}
