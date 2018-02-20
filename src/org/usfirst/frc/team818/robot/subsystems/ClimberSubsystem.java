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
import edu.wpi.first.wpilibj.command.Subsystem;

public class ClimberSubsystem extends Subsystem {

	private TalonSRX cMotor;
	private DoubleSolenoid rPiston, dPiston; //pistons for releasing, detatching
	private boolean climberEnabled;

	public ClimberSubsystem(int climberMotorPort, int[] rClimberPistonPort, int[] dClimberPistonPort, boolean climberEnabled) {
	
		this.climberEnabled = climberEnabled;

		if (climberEnabled) {

			cMotor = new WPI_TalonSRX(climberMotorPort);
			rPiston = new DoubleSolenoid(rClimberPistonPort[0], rClimberPistonPort[1]);
			dPiston = new DoubleSolenoid(dClimberPistonPort[0], dClimberPistonPort[1]);

		}
	}

	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}
	
	public void rOpen() {
		if (climberEnabled) {
			rPiston.set(DoubleSolenoid.Value.kForward);
		}
	}

	public void rClose() {
		if (climberEnabled) {
			rPiston.set(DoubleSolenoid.Value.kReverse);
		}
	}

	public void rOff() {
		if (climberEnabled) {
			rPiston.set(DoubleSolenoid.Value.kOff);
		}
	}
	
	public void dOpen() {
		if (climberEnabled) {
			dPiston.set(DoubleSolenoid.Value.kForward);
		}
	}

	public void dClose() {
		if (climberEnabled) {
			dPiston.set(DoubleSolenoid.Value.kReverse);
		}
	}

	public void dOff() {
		if (climberEnabled) {
			dPiston.set(DoubleSolenoid.Value.kOff);
		}
	}

	public void setSpeed(double speed) {
		if (climberEnabled) {
			cMotor.set(ControlMode.PercentOutput, speed);
		}
	}

	public void setOff() {
		if (climberEnabled) {
			cMotor.set(ControlMode.PercentOutput, 0);
		}
	}

}
