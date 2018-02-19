/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team818.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.command.Subsystem;

public class ClimberSubsystem extends Subsystem {

	private TalonSRX cMotor;
	private int cMotorPort;
	private DoubleSolenoid piston;
	private PowerDistributionPanel pdp;
	private boolean climberEnabled;

	public ClimberSubsystem(int climberMotorPort, int[] climberPistonPort, boolean climberEnabled) {
	
		this.climberEnabled = climberEnabled;

		if (climberEnabled) {

			cMotor = new WPI_TalonSRX(climberMotorPort);
			piston = new DoubleSolenoid(climberPistonPort[0], climberPistonPort[1]);
			pdp = new PowerDistributionPanel();

		}

		cMotorPort = climberMotorPort;

	}

	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}
	
	public void open() {
		if (climberEnabled) {
			piston.set(DoubleSolenoid.Value.kForward);
		}
	}

	public void close() {
		if (climberEnabled) {
			piston.set(DoubleSolenoid.Value.kReverse);
		}
	}

	public void off() {
		if (climberEnabled) {
			piston.set(DoubleSolenoid.Value.kOff);
		}
	}

<<<<<<< HEAD
	public void start() {
=======
	public void setForward() {
>>>>>>> 6741f18bf254973e605257675392466ecc3a0414
		if (climberEnabled) {
			cMotor.set(ControlMode.PercentOutput, 1);
		}
	}

<<<<<<< HEAD
	public void reverse() {
=======
	public void setReverse() {
>>>>>>> 6741f18bf254973e605257675392466ecc3a0414
		if (climberEnabled) {
			cMotor.set(ControlMode.PercentOutput, -0.25);
		}
	}

<<<<<<< HEAD
	public void stop() {
=======
	public void setOff() {
>>>>>>> 6741f18bf254973e605257675392466ecc3a0414
		if (climberEnabled) {
			cMotor.set(ControlMode.PercentOutput, 0);
		}
	}
	
	public boolean getCurrent(){
		
		return true;
	}
	//This may need to be (and if not needed, should be) switched to CAN
	public double getClimberCurrent() {
		return (climberEnabled) ? Math.abs(pdp.getCurrent(cMotorPort)) : -1;
	}

	
}
