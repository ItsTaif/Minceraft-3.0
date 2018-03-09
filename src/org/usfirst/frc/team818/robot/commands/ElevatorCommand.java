package org.usfirst.frc.team818.robot.commands;

import org.usfirst.frc.team818.robot.Constants;
import org.usfirst.frc.team818.robot.utilities.MathUtil;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class ElevatorCommand extends CommandBase {
  
    Timer timer;
    double setPoint;
    boolean joystickToggle;
	
	public ElevatorCommand() {
       	requires(elevator);
    }

    protected void initialize() {
    	elevator.set(0);
    	elevator.setSetpoint(Constants.bottomVal);
    	elevator.enablePID();
    	timer = new Timer();
    	timer.start();
    	setPoint = 0;
    }

    protected void execute() {
    	
/*    	setPoint += oi.getGamepadRightY();
    	
    	elevator.setSetpoint(setPoint);
    	MathUtil.setLimits(setPoint, Constants.bottomVal, Constants.topVal);
    	elevator.set(elevator.getPIDOutputElevator());
*/    	if(timer.get() % 100 == 0) {
    		
    	elevator.getCurrent();
    	SmartDashboard.putString("RobotLog", "% " + oi.getGamepadRightY());
    	}

		if(Math.abs(oi.getGamepadRightY()) > 0.1){
	
			elevator.disablePID();
			joystickToggle = true;
	
			if(elevator.reachedBottom() && oi.getGamepadRightY() < 0) elevator.set(0);
			else if(elevator.reachedTop() && oi.getGamepadRightY() > 0) elevator.set(0);
			else elevator.set(oi.getGamepadRightY());
	
		}else {
			if(joystickToggle){
				elevator.enablePID();
				elevator.setSetpoint(elevator.getDistance());
				joystickToggle = false;
			}
	    	elevator.set(elevator.getPIDOutputElevator());
		}
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
