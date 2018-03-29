package org.usfirst.frc.team818.robot.commands.components;

import org.usfirst.frc.team818.robot.Constants;
import org.usfirst.frc.team818.robot.commands.CommandBase;
import org.usfirst.frc.team818.robot.utilities.RobotLog;

public class ElevatorAutonCommand extends CommandBase {
  
    private double positionBottom, positionTarget;
    private String position;
	
	public ElevatorAutonCommand(String position) {
       	requires(elevator);
       	this.position = position;
    }

    protected void initialize() {
    	
    	RobotLog.putMessage("Running ElevatorAutonCommand to " + position + " position");
    	elevator.set(0);
    	positionBottom = Constants.elevatorBottomPosition;
    	elevator.setSetpoint(positionBottom);
    }

    protected void execute() {
		
		if(position.equals("Bottom"))
    		positionTarget = positionBottom;
    	else if(position.equals("Switch"))
    		positionTarget = Constants.elevatorSwitchPosition;
    	else if(position.equals("Scale"))
    		positionTarget = Constants.elevatorScalePosition;
    	
    	elevator.setSetpoint(positionTarget);
    	elevator.hold();
	    	
    }

    protected boolean isFinished() {
    	if(!Constants.elevatorEnabled)
    		return true;
    	if(position.equals("Bottom"))
    		return elevator.getPosition() <= Constants.elevatorBottomPosition + 10;
    	else if(position.equals("Switch"))
    		return elevator.getPosition() >= Constants.elevatorSwitchPosition - 10 || 
    			elevator.getPosition() <= Constants.elevatorSwitchPosition + 10;
        else if(position.equals("Scale"))
        	return elevator.getPosition() >= Constants.elevatorScalePosition - 10;
        else return true;
    }

    protected void end() {
    	RobotLog.putMessage("Finished ElevatorAutonCommand to " + position + " position");
    	elevator.set(0);
    }

    protected void interrupted() {
    	RobotLog.putMessage("Interrupted ElevatorAutonCommand to " + position + " position");
    	elevator.set(0);
    }
}
