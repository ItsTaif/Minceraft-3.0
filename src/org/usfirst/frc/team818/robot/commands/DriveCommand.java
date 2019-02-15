package org.usfirst.frc.team818.robot.commands;

import java.util.ArrayList;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class DriveCommand extends CommandBase {
	
	ArrayList<Double> accelVals = new ArrayList<Double>();
	 
  
    public DriveCommand() {
       	requires(drive);
    }

    protected void initialize() {
    	drive.setBoth(0);
    	drive.disablePID();
    	SmartDashboard.putString("DB/String 0", "running drive");
    }

    protected void execute() {
        //drive.setBoth(drive.getPIDOutputTCLeft()+oi.getLeftY()*0.8, drive.getPIDOutputTCRight()+oi.getRightY()*0.8);
    	drive.setBoth(oi.getLeftY(), oi.getRightY());
    	//accelVals.add(drive.getAccelY());
    	//if (accelVals.size() >= 4) accelVals.remove(0);
    	
    	SmartDashboard.putNumber("DB/Slider 0", drive.getCurrent());
    	
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
