package org.usfirst.frc.team818.robot.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class ElevatorCommand extends CommandBase {
  
	int position;
	double speed;
	boolean triggeredCarrage, triggeredElevator;
	
	public ElevatorCommand() {
       	requires(elevator);
    }

    protected void initialize() {
    	elevator.set(0);
    	position = 0;
    	speed = 0;
    }

    protected void execute() {
    	
    	if(Math.abs(oi.getGamepadRightY()) > 0.1){
    		
    		if(elevator.reachedBottom() && oi.getGamepadRightY() < 0) speed = 0;
    		else if(elevator.reachedTop() && oi.getGamepadRightY() > 0) speed = 0;
    		else speed = oi.getGamepadRightY();
    		
    	}else {
    		
    		if(oi.getElevatorBottom()) {
    			
    			if(position > 0 && !elevator.reachedBottom()) {
    				
    				if(position == 1)
    					speed = -0.3;
    				else 
    					speed = -0.7;
    				
    			}else speed = 0;
    			
    		}else if(oi.getElevatorSwitch()) {
    			
    			if(position > 4) {
    				
    				speed = -0.7;
				
    			}if(position < 4) {

    				speed = 0.7;
				
    			}else speed = 0;
    			
    		}else if(oi.getElevatorScale()) {
    			
    			if(position < 8 && !elevator.reachedTop()) {
    				
    				if(position == 7)
    					speed = 0.3;
    				else 
    					speed = 0.7;
    				
    			}else speed = 0;
    			
    		}
    		
    	}
    	
    	if(speed > 0 && elevator.triggerCarrage() && !triggeredCarrage) {
    		position++;
    	}
    	if(speed > 0 && elevator.triggerElevator() && !triggeredCarrage) {
    		position++;
    	}
    	if(speed < 0 && elevator.triggerCarrage() && !triggeredElevator) {
    		position--;
    	}
    	if(speed < 0 && elevator.triggerElevator() && !triggeredElevator) {
    		position--;
    	}
    	
    	if(elevator.triggerCarrage())
    		triggeredCarrage = true;
    	else if(triggeredCarrage)
    		triggeredCarrage = false;
    	
    	if(elevator.triggerElevator())
        	triggeredElevator = true;
    	else if(triggeredElevator)
    		triggeredElevator = false;
    	    	
    	elevator.set(speed);

    	//SmartDashboard.putNumber("position", (double)position);
    	//SmartDashboard.putNumber("elevatorSpeed", speed);
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
