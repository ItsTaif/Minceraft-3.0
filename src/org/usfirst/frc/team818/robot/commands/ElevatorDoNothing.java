package org.usfirst.frc.team818.robot.commands;

import edu.wpi.first.wpilibj.Timer;

public class ElevatorDoNothing extends CommandBase {
  
    Timer timer;
    double setPoint, time;
    boolean joystickToggle;
	
	public ElevatorDoNothing(double time) {
       	requires(elevator);
       	this.time = time;
       	timer = new Timer();
    }

    protected void initialize() {
    	elevator.set(0);
    	timer.start();
    	setPoint = 0;
    	elevator.setSetpoint(elevator.getPosition());
    	
    }

    protected void execute() {
    	
/*    	setPoint += oi.getGamepadRightY();
    	
    	elevator.setSetpoint(setPoint);
    	MathUtil.setLimits(setPoint, Constants.bottomVal, Constants.topVal);
    	elevator.set(elevator.getPIDOutputElevator());
*/    	if(/*timer.get() % 100 == 0*/true) {
    		
    //	elevator.getCurrent();
    	//RobotLog.putMessage("% " + oi.getGamepadRightY());
		
		//elevator.set(0);
		
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
        return timer.hasPeriodPassed(time);
    }

    protected void end() {
    	elevator.set(0);
    }

    protected void interrupted() {
    	elevator.set(0);
    }
}
