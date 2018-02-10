/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team818.robot.commands;

import edu.wpi.first.wpilibj.Timer;

public class ClimberSpinCommand extends CommandBase {
	
	Timer timer = new Timer();
	double currentAverage;
	double[] storeCurrent = new double[8];
	boolean override = false;
	
	public ClimberSpinCommand() {
		requires(climber);
	}
	
	public ClimberSpinCommand(boolean override) {
    	requires(climber);
    	this.override = override;
    }
	
	protected void initialize() {
		climber.setForward();
		timer.start();
	}

	protected void execute() {
		if((timer.get() * 1000) % 100 == 0 ){
    		
    		for(int i = 0; i < storeCurrent.length; i++){
    			if(storeCurrent[i] == 0){
    				storeCurrent[i] = climber.getClimberCurrent();
    				break;                                  
    			} else if (i == 7){
    				for(int j = 0; j < storeCurrent.length - 1; j++){
    					storeCurrent[j] = storeCurrent[j + 1];
    				}
    				storeCurrent[i] = climber.getClimberCurrent();
    			}
    		}
    	}
		if(timer.get() > 1){
    		double currentSum = 0;
    		for(int i = 0; i < storeCurrent.length; i++){
    			currentSum = storeCurrent[i] + currentSum ; 
    		}
    		currentAverage = currentSum / storeCurrent.length;
    	}
	}

	protected boolean isFinished() {
		if (override) 
    		return false;
    	else 
    		return climber.getClimberCurrent() > currentAverage + 2;
	}

	protected void end() {
		climber.setOff();
	}

	protected void interrupted() {
		climber.setOff();
	}
}