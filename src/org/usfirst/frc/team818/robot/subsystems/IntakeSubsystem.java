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

	private TalonSRX intakeL;
	private VictorSPX intakeR;
	private boolean intakeEnabled;
	private DigitalInput cube;

	public IntakeSubsystem(int intakeMotorPorts[], int limitSwitchPortIntakeCube,
			boolean intakeEnabled) {

		this.intakeEnabled = intakeEnabled;

		if (intakeEnabled) {
			intakeL = new WPI_TalonSRX(intakeMotorPorts[0]);
			intakeR = new WPI_VictorSPX(intakeMotorPorts[1]);
			intakeR.setInverted(true);
			cube = new DigitalInput(limitSwitchPortIntakeCube);
		}
	}

	public void initDefaultCommand() {
	}

	public void intakeIn(double speed) {
		if (intakeEnabled) {
			intakeL.set(ControlMode.PercentOutput, -speed);
			intakeR.set(ControlMode.PercentOutput, -speed);
		}
	}

	public void intakeOut(double speed) {
		if (intakeEnabled) {
			intakeL.set(ControlMode.PercentOutput, speed);
			intakeR.set(ControlMode.PercentOutput, speed);
		}
	}

	public void intakeOff() {
		if (intakeEnabled) {
			intakeL.set(ControlMode.PercentOutput, 0);
			intakeR.set(ControlMode.PercentOutput, 0);
		}
	}

	public boolean hasCube() {
		if (intakeEnabled)
			return cube.get();
		else
			return false;
	}

}
