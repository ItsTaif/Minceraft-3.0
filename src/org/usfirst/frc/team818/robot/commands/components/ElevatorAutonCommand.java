package org.usfirst.frc.team818.robot.commands.components;

import org.usfirst.frc.team818.robot.Constants;
import org.usfirst.frc.team818.robot.commands.CommandBase;

public class ElevatorAutonCommand extends CommandBase {
  
    private double speed;
    private String position;
    private int positionCurrent, positionTarget;
    private boolean triggeredCarrage, triggeredElevator;
	
	public ElevatorAutonCommand(String position) {
       	requires(elevator);
       	this.position = position;
    }

    protected void initialize() {
    	elevator.set(0);

    }

    protected void execute() {
    	
    	if(position.equals("Bottom") && !elevator.reachedBottom()) {
    		speed = -0.5;
    	}else if(position.equals("Switch")) {
    		
    		if(positionCurrent > 4) {
				
				speed = -0.7;
			
			}if(positionCurrent < 4) {

				speed = 0.7;
			
			}else speed = 0;
			
    	}else if(position.equals("Bottom") && !elevator.reachedBottom()) {
    		
    		if(positionCurrent < 8 && !elevator.reachedTop()) {
				
				if(positionCurrent == 7)
					speed = 0.3;
				else 
					speed = 0.7;
				
			}else speed = 0;
    		
    	}else
    		speed = 0;
    	
    	if(speed > 0 && elevator.triggerCarrage() && !triggeredCarrage) 
    		positionCurrent++; 
    	if(speed > 0 && elevator.triggerElevator() && !triggeredCarrage) 
    		positionCurrent++;    	
    	if(speed < 0 && elevator.triggerCarrage() && !triggeredElevator) 
    		positionCurrent--;    	
    	if(speed < 0 && elevator.triggerElevator() && !triggeredElevator) 
    		positionCurrent--;    	
    	
    	if(elevator.triggerCarrage())
    		triggeredCarrage = true;
    	else if(triggeredCarrage)
    		triggeredCarrage = false;
    	
    	if(elevator.triggerElevator())
        	triggeredElevator = true;
    	else if(triggeredElevator)
    		triggeredElevator = false;
    	    	
    	elevator.set(speed);
    		    	
    }

    protected boolean isFinished() {
    	
    	if(position.equals("Bottom")) {
    		return elevator.reachedBottom() || positionCurrent == 0;
    	}else if(position.equals("Scale")) {
    		return positionCurrent == 4;
    	}else if(position.equals("Switch")) {
    		return positionCurrent == 8;
    	}else 
    		return true;
    	
    }

    protected void end() {
    	elevator.set(0);
    }

    protected void interrupted() {
    	elevator.set(0);
    }
}
