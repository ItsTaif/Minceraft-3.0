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
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.command.Subsystem;

public class IntakeSubsystem extends Subsystem {

	private TalonSRX intakeL;
	private VictorSPX intakeR;
	private boolean intakeEnabled;
	private DigitalInput cube, intakeLimitUp, intakeLimitDown;
	private Encoder encoder;
	private PIDController intakeController;
	private DoublePIDOutput pidOutputIntake;
	
    private static final double[] INTAKE_PID_VALUES = { 0.05, 0, 0.1 };
	private static final double[] INTAKE_PID_RANGE = { -1, 1 };

	public IntakeSubsystem(int intakeLMotorPort, int intakeRMotorPort, int limitSwitchPortIntakeCube, boolean intakeEnabled) {
	
		this.intakeEnabled = intakeEnabled;
		
		if (intakeEnabled) {
			intakeL = new WPI_TalonSRX(intakeLMotorPort);
			intakeR = new WPI_VictorSPX(intakeRMotorPort);
			cube = new DigitalInput(limitSwitchPortIntakeCube);
		}
	}

	public void initDefaultCommand() {
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
    
    public boolean hasCube(){
    	return cube.get();
   }
    
    public boolean intakeReachUp() {
    	return intakeLimitUp.get();
    }
    
    public boolean intakeReachDown() {
    	return intakeLimitDown.get();
    }

}
