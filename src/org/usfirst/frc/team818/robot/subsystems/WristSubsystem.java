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
	private Encoder encoder;
	private PIDController intakeController;
	private DoublePIDOutput pidOutputWrist;
	
    private static final double[] INTAKE_PID_VALUES = { 0.05, 0, 0.1 };
	private static final double[] INTAKE_PID_RANGE = { -1, 1 };

	public WristSubsystem(int intakeWristMotorPort, int[] encoderPorts, boolean wristEnabled) {
	
		this.wristEnabled = wristEnabled;
		
		if (wristEnabled) {
			intakeWrist = new WPI_TalonSRX(intakeWristMotorPort);
			//encoder = new Encoder(encoderPorts[1], encoderPorts[2]);

			pidOutputWrist = new DoublePIDOutput();
			
	
			intakeController = new PIDController(INTAKE_PID_VALUES[0], INTAKE_PID_VALUES[1],
					INTAKE_PID_VALUES[2], encoder, pidOutputWrist);
			intakeController.setOutputRange(INTAKE_PID_RANGE[0], INTAKE_PID_RANGE[1]);
			intakeController.setInputRange(-Double.MAX_VALUE, Double.MAX_VALUE);
			intakeController.setAbsoluteTolerance(1);
			intakeController.setSetpoint(0);
			intakeController.setContinuous(false);
			
		}
	}

	public void initDefaultCommand() {
		setDefaultCommand(new WristRotateCommand());
	}
	
	public void enablePID() {
		intakeController.enable();
	}
	
	public void disablePID() {
		intakeController.disable();
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
    
    public void pidSetPoint(double setpoint) {
    	intakeController.setSetpoint(setpoint);
    }
    
    public double getPIDOutputWrist() {
		return (wristEnabled) ? pidOutputWrist.get() : 0;
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
