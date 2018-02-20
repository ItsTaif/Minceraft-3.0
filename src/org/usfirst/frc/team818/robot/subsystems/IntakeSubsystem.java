/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team818.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Subsystem;

public class IntakeSubsystem extends Subsystem {

	private TalonSRX intakeL, intakeR;
	private VictorSPX intakeArm;
	private boolean intakeEnabled;
	private DigitalInput cube, intakeLimitUp, intakeLimitDown;

	public IntakeSubsystem(int intakeLMotorPort, int intakeRMotorPort, int intakeArmMotorPort, int limitSwitchPortIntakeUp, int limitSwitchPortIntakeDown, int limitSwitchPortIntakeCube, boolean intakeEnabled) {
	
		this.intakeEnabled = intakeEnabled;

		if (intakeEnabled) {
			intakeL = new WPI_TalonSRX(intakeLMotorPort);
			intakeR = new WPI_TalonSRX(intakeRMotorPort);
			intakeArm = new WPI_VictorSPX(intakeArmMotorPort);
			cube = new DigitalInput(limitSwitchPortIntakeCube);
			intakeLimitUp = new DigitalInput(limitSwitchPortIntakeUp);
			intakeLimitDown = new DigitalInput(limitSwitchPortIntakeDown);
		}
	}

	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}
	
	public void intakeIn(double speed) {
		if (intakeEnabled) {
			intakeL.set(ControlMode.PercentOutput, speed);
			intakeR.set(ControlMode.PercentOutput, -speed);
		}
	}
	
	public void intakeOut(double speed) {
		if (intakeEnabled) {
			intakeL.set(ControlMode.PercentOutput, -speed);
			intakeR.set(ControlMode.PercentOutput, speed);
		}
	}
	
	public void intakeOff() {
		if (intakeEnabled) {
			intakeL.set(ControlMode.PercentOutput, 0);
			intakeR.set(ControlMode.PercentOutput, 0);
		}
	}
	
	public void intakeDown() {
    	if(intakeEnabled) {
    		intakeArm.set(ControlMode.PercentOutput, 0.5);
    	}
    }
    
    public void intakeUp() {
    	if(intakeEnabled) {
    		intakeArm.set(ControlMode.PercentOutput, -0.5);
    	}
    }
    
    public void intakeVertOff() {
    	if(intakeEnabled) {
    		intakeArm.set(ControlMode.PercentOutput, 0);
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
