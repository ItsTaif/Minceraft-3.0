/*----------------------------------------------------------------------------*/
	/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team818.robot.subsystems;

import org.usfirst.frc.team818.robot.commands.IntakeRotateCommand;
import org.usfirst.frc.team818.robot.utilities.DoublePIDOutput;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.command.Subsystem;

public class IntakeSubsystem extends Subsystem {

	private TalonSRX intakeL, intakeArm;
	private VictorSPX intakeR;
	private boolean intakeEnabled;
	private DigitalInput cube, intakeLimitUp, intakeLimitDown;
	private Encoder encoder;
	private PIDController intakeController;
	private DoublePIDOutput pidOutputIntake;
	
    private static final double[] INTAKE_PID_VALUES = { 0.05, 0, 0.1 };
	private static final double[] INTAKE_PID_RANGE = { -1, 1 };

	public IntakeSubsystem(int intakeLMotorPort, int intakeRMotorPort, int intakeArmMotorPort, int limitSwitchPortIntakeCube, boolean intakeEnabled) {
	
		this.intakeEnabled = intakeEnabled;
		
		if (intakeEnabled) {
			intakeL = new WPI_TalonSRX(intakeLMotorPort);
			intakeR = new WPI_VictorSPX(intakeRMotorPort);
			intakeArm = new WPI_TalonSRX(intakeArmMotorPort);
			encoder = new Encoder(4,5);
			cube = new DigitalInput(limitSwitchPortIntakeCube);
			//intakeLimitUp = new DigitalInput(limitSwitchPortIntakeUp);
			//intakeLimitDown = new DigitalInput(limitSwitchPortIntakeDown);

			pidOutputIntake = new DoublePIDOutput();
			
	
			intakeController = new PIDController(INTAKE_PID_VALUES[0], INTAKE_PID_VALUES[1],
					INTAKE_PID_VALUES[2], encoder, pidOutputIntake);
			intakeController.setOutputRange(INTAKE_PID_RANGE[0], INTAKE_PID_RANGE[1]);
			intakeController.setInputRange(-Double.MAX_VALUE, Double.MAX_VALUE);
			intakeController.setAbsoluteTolerance(1);
			intakeController.setSetpoint(0);
			intakeController.setContinuous(false);
			
		}
	}

	public void initDefaultCommand() {
		setDefaultCommand(new IntakeRotateCommand());
	}
	
	public void enablePID() {
		intakeController.enable();
	}
	
	public void disablePID() {
		intakeController.disable();
	}
	
	public void intakeIn(double speed) {
		if (intakeEnabled) {
			intakeL.set(ControlMode.PercentOutput, speed);
			intakeR.set(ControlMode.PercentOutput, speed);
		}
	}
	
	public void intakeOut(double speed) {
		if (intakeEnabled) {
			intakeL.set(ControlMode.PercentOutput, -speed);
			intakeR.set(ControlMode.PercentOutput, -speed);
		}
	}
	
	public void intakeOff() {
		if (intakeEnabled) {
			intakeL.set(ControlMode.PercentOutput, 0);
			intakeR.set(ControlMode.PercentOutput, 0);
		}
	}
    
    public void intakeVertOff() {
    	if(intakeEnabled) {
    		intakeArm.set(ControlMode.PercentOutput, 0);
    	}
    }
    
    public void setIntakeVert(double speed) {
    	if(intakeEnabled) {
    		intakeArm.set(ControlMode.PercentOutput, speed);;
    	}
    }
    
    public void pidSetPoint(double setpoint) {
    	intakeController.setSetpoint(setpoint);
    }
    
    public double getPIDOutputIntake() {
		return (intakeEnabled) ? pidOutputIntake.get() : 0;
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
    	return intakeArm.getOutputCurrent();
    }

}
