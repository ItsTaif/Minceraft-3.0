/*----------------------------------------------------------------------------*/
	/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team818.robot.subsystems;

import org.usfirst.frc.team818.robot.commands.WristRotateCommand;
import org.usfirst.frc.team818.robot.utilities.DoublePIDOutput;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.command.Subsystem;

public class WristSubsystem extends Subsystem {

	private TalonSRX intakeWrist;
	private boolean wristEnabled;
	private DigitalInput cube, intakeLimitUp, intakeLimitDown;

	public WristSubsystem(int intakeWristMotorPort, int[] encoderPorts, boolean wristEnabled) {
	
		this.wristEnabled = wristEnabled;
		
		if (wristEnabled) {
			intakeWrist = new WPI_TalonSRX(intakeWristMotorPort);
			//encoder = new Encoder(encoderPorts[1], encoderPorts[2]);
			
		}
	}

	public void initDefaultCommand() {
		setDefaultCommand(new WristRotateCommand());
	}
	    
    public void stopWrist() {
    	if(wristEnabled) {
    		intakeWrist.set(ControlMode.PercentOutput, 0);
    	}
    }
    
    public void setWrist(double speed) {
    	if(wristEnabled) {
    		intakeWrist.set(ControlMode.PercentOutput, speed);;
    	}
    }
    
    public boolean hasCube(){
    	return cube.get();
   }
    
    public boolean intakeReachUp() {
    	return intakeLimitUp.get();
    }
    
    public boolean intakeReachDown() {
    	return intakeLimitDown.get();
    }
    
    public double getWristCurrent() {
    	return intakeWrist.getOutputCurrent();
    }

}
