/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team818.robot.commands;

import java.util.LinkedList;

import edu.wpi.first.wpilibj.Timer;

public class ClimberSpinCommand extends CommandBase {
	
	Timer timer = new Timer();
	double currentAverage;
	//double[] storeCurrent = new double[8];
	private static LinkedList<Current> storeCurrent = new LinkedList<>();
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
		for(int i = 0; i < 8; i++){
			storeCurrent.add(new Current(0));
		}
	}

	protected void execute() {
		if((timer.get() * 1000) % 100 == 0 ){
    		
    		for(int i = 0; i < storeCurrent.size(); i++){
    			if(storeCurrent.get(i).current == 0){
    				storeCurrent.set(i, new Current(climber.getClimberCurrent()));
    				break;                                  
    			} else if (i == 7){
    				storeCurrent.removeFirst();
    				storeCurrent.add(new Current(climber.getClimberCurrent()));
    			}
    		}
    	}
		if(timer.get() > 1){
    		double currentSum = 0;
    		for(int i = 0; i < storeCurrent.size(); i++){
    			currentSum = storeCurrent.get(i).current + currentSum ; 
    		}
    		currentAverage = currentSum / storeCurrent.size();
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