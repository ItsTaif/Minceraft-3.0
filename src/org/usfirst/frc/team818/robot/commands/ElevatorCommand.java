package org.usfirst.frc.team818.robot.commands;

import org.usfirst.frc.team818.robot.Constants;

public class ElevatorCommand extends CommandBase {
  
    private static double distanceBottom, distanceTarget;
    private static boolean joystickToggle;
	
	public ElevatorCommand() {
       	requires(elevator);
    }

    protected void initialize() {
    	elevator.set(0);
    	joystickToggle = false;
    	distanceBottom = Constants.elevatorBottomPosition;
    	elevator.setSetpoint(distanceBottom);
    	elevator.enablePID();
    }

    protected void execute() {
    	
    	elevator.set(oi.getGamepadRightY());
    	/*
    	if(elevator.reachedBottom())
    		distanceBottom = elevator.getDistance();
    	if(Math.abs(oi.getGamepadRightY()) > 0.1){
    		
    		elevator.disablePID();
    		joystickToggle = true;
    		
    		if(elevator.reachedBottom() && oi.getGamepadRightY() < 0) elevator.set(0);
    		else if(elevator.reachedTop() && oi.getGamepadRightY() > 0) elevator.set(0);
    		else elevator.set(oi.getGamepadRightY());
    		
    	}else {
    		if(joystickToggle){
    			elevator.enablePID();
    			distanceTarget = elevator.getDistance();
    			joystickToggle = false;
    		}
    		
    		if(oi.getElevatorBottom())
        		distanceTarget = distanceBottom;
        	else if(oi.getElevatorScale())
        		distanceTarget = Constants.elevatorSwitchPosition;
        	else if(oi.getElevatorSwitch())
        		distanceTarget = Constants.elevatorScalePosition;
        	
        	elevator.setSetpoint(distanceTarget);
	    	elevator.set(elevator.getPIDOutputElevator());
    	}
	    */

    }

    protected boolean isFinished() {
        return false;
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
