package org.usfirst.frc.team818.robot.commands;

import java.util.ArrayList;

public class DriveCommand extends CommandBase {
	
	ArrayList<Double> accelVals = new ArrayList<Double>();
	 
  
    public DriveCommand() {
       	requires(drive);
    }

    protected void initialize() {
    	drive.setBoth(0);
    }

    protected void execute() {
        //drive.setBoth(drive.getPIDOutputTCLeft()+oi.getLeftY()*0.8, drive.getPIDOutputTCRight()+oi.getRightY()*0.8);
    	drive.setBoth(oi.getLeftY(), oi.getRightY());
    	//accelVals.add(drive.getAccelY());
    	//if (accelVals.size() >= 4) accelVals.remove(0);
    	
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    	drive.setBoth(0);
    }

    protected void interrupted() {
    	drive.setBoth(0);
    }
}
